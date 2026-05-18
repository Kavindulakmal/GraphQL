package com.graphql.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryApplication {

//	@Autowired
//	private ProductRepository repository;
//
//	@PostConstruct
//	public void initDB(){
//		List<Product> products = Stream.of(
//				new Product(null, "Laptop", "Electronics", "1000", 10),
//				new Product(null, "Smartphone", "Electronics", "500", 20),
//				new Product(null, "Table", "Furniture", "200", 5),
//				new Product(null, "Chair", "Furniture", "100", 15)
//		).collect(Collectors.toList());
//		repository.saveAll(products);
//
//
//	}

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

}
