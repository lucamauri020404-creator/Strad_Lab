package com.stradlab.catalog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository repository;

    public DataLoader(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() > 0) return;

        repository.saveAll(List.of(
            new Product("Air Force 1", "Nike", "scarpe", new BigDecimal("119.99"), 25),
            new Product("Superstar", "Adidas", "scarpe", new BigDecimal("99.99"), 30),
            new Product("Tech Fleece Hoodie", "Nike", "felpe", new BigDecimal("109.99"), 15),
            new Product("Reverse Weave Hoodie", "Champion", "felpe", new BigDecimal("79.99"), 20),
            new Product("Classic Logo Tee", "Puma", "t-shirt", new BigDecimal("29.99"), 50),
            new Product("Shooter Tee", "Trapstar", "t-shirt", new BigDecimal("49.99"), 18),
            new Product("Shark Hoodie", "Bape", "felpe", new BigDecimal("249.99"), 6),
            new Product("Nuptse Jacket", "The North Face", "giacche", new BigDecimal("319.99"), 8),
            new Product("Tech Pants", "Under Armour", "pantaloni", new BigDecimal("64.99"), 22),
            new Product("Trefoil Cap", "Adidas", "cappelli", new BigDecimal("24.99"), 40)
        ));
    }
}
