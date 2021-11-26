package com.example.backenddemo.controller

import com.example.backenddemo.model.Product
import com.example.backenddemo.repository.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class ProductController(private val productRepository: ProductRepository) {

    @GetMapping("/products")
    fun getAllProduct(): List<Product> =
        productRepository.findAll()


    @PostMapping("/products")
    fun createNewProduct(@Valid @RequestBody product: Product): Product =
        productRepository.save(product)


    @GetMapping("/products/{id}")
    fun getProductById(@PathVariable(value = "id") productId: Long): ResponseEntity<Product> {
        return productRepository.findById(productId).map { product ->
            ResponseEntity.ok(product)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/products/{id}")
    fun updateProductById(@PathVariable(value = "id") productId: Long,
                          @Valid @RequestBody newProduct: Product
    ): ResponseEntity<Product> {

        return productRepository.findById(productId).map { existingArticle ->
            val updatedProduct: Product = existingArticle
                .copy(
                    title = newProduct.title,
                    price = newProduct.price,
                    description = newProduct.description,
                    category = newProduct.category,
                    image = newProduct.image,
                )
            ResponseEntity.ok().body(productRepository.save(updatedProduct))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/products/{id}")
    fun deleteProductById(@PathVariable(value = "id") productId: Long): ResponseEntity<Void> {

        return productRepository.findById(productId).map { product  ->
            productRepository.delete(product)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }
}