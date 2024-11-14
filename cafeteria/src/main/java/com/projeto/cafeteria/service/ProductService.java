package com.projeto.cafeteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.cafeteria.entity.Product;
import com.projeto.cafeteria.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	@Autowired

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> buscaTodosProduct() {
		return productRepository.findAll();
	}

	public Product buscaProductId(Long id) {
		Optional<Product> Product = productRepository.findById(id);
		return Product.orElse(null);
	}

	public Product salvaProduct(Product product) {
		return productRepository.save(product);
	}

	public Product alterarProduct(Long id, Product alterarProduct) {
		Optional<Product> existeProduct = productRepository.findById(id);
		if (existeProduct.isPresent()) {
			alterarProduct.setId(id);
			return productRepository.save(alterarProduct);
		}
		return null;
	}

	public boolean apagarProduct(Long id) {
		Optional<Product> existeProduct = productRepository.findById(id);
		if (existeProduct.isPresent()) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
