package com.projeto.cafeteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.cafeteria.entity.Product;
import com.projeto.cafeteria.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> buscaProductControlId(@PathVariable Long id) {
		Product product = productService.buscaProductId(id);
		if (product != null) {
			return ResponseEntity.ok(product);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Product>> buscaTodosProductControl() {
		List<Product> Product = productService.buscaTodosProduct();
		return ResponseEntity.ok(Product);
	}

	@PostMapping("/")
	public ResponseEntity<Product> salvaProductControl(@RequestBody @Valid Product product) {
		Product salvaProduct = productService.salvaProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaProduct);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> alterarProductControl(@PathVariable Long id, @RequestBody @Valid Product product) {
		Product alterarProduct = productService.alterarProduct(id, product);
		if (alterarProduct != null) {
			return ResponseEntity.ok(product);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Product> apagaProductControl(@PathVariable Long id) {
		boolean apagar = productService.apagarProduct(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
