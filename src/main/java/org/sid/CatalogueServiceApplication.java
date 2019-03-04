package org.sid;

import org.sid.dao.CategoryRepository;
import org.sid.dao.ProductRepository;
import org.sid.model.Category;
import org.sid.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication
public class CatalogueServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogueServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CategoryRepository categoryRepository, ProductRepository productRepository){
		return args->{
			categoryRepository.deleteAll();
			Stream.of("c1 computer","c2 printer").forEach(c->{
				categoryRepository.save(new Category(c.split(" ")[0],c.split(" ")[1],new ArrayList<>()));
			});
			categoryRepository.findAll().forEach(System.out::println);

			productRepository.deleteAll();
			Category c1 = categoryRepository.findById("c1").get();
			Stream.of("p1","p2","p3","p4").forEach(name->{
				Product p1=productRepository.save(new Product(null,name,Math.random()*1000,c1));
				c1.getProducts().add(p1);
				categoryRepository.save(c1);
			});

			Category c2 = categoryRepository.findById("c2").get();
			Stream.of("p5","p6").forEach(name->{
				Product p=productRepository.save(new Product(null,name,Math.random()*1000,c2));
				c2.getProducts().add(p);
				categoryRepository.save(c2);
			});
			productRepository.findAll().forEach(System.out::println);

		};
	}

}

