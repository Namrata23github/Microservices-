package com.example.msproduct.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.msproduct.entity.Product;

@Repository
public interface ProductRepositroy extends JpaRepository<Product, Long> {
	Optional<List<Product>> findByCategory(String category);

}
