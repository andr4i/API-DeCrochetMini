package com.gen.DeCrochet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gen.DeCrochet.model.Address;
import com.gen.DeCrochet.model.Product;
import com.gen.DeCrochet.model.User;
import com.gen.DeCrochet.service.AddressService;
import com.gen.DeCrochet.service.ProductService;
import com.gen.DeCrochet.service.UserService;


@RestController
@RequestMapping(path="/DeCrochet")
public class Productcontroller {

//	@Autowired
	ProductService productService;
	
	
	
	@Autowired
	public Productcontroller(ProductService productService) {
		super();
		this.productService = productService;
	}

	//_____________________________________GET___________________________________
	
	@GetMapping(value = "/mensaje")
	ResponseEntity<String> mensaje(){
		return new ResponseEntity<>("DeCrochet, Hola !!", HttpStatus.OK);
	}
	
//	public String holamundo() {
//		return "Hola mundo";
//	}
	
	@GetMapping(value = "/products")
//	public List<Product> getAllProducts(){
//		return productService.getAllProducts();
//	}
	ResponseEntity<List<Product>> getAllProducts(){
		return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
	}
	
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
//	
//	@GetMapping("/user/{id}")
//	public User getUserById(@PathVariable Long id) {
//		return userService.getUserById(id);
//	}
//	
//	@GetMapping("/address/{id}")
//	public Address getAddressById(@PathVariable Long id) {
//		return addressService.getAddressById(id);
//	}
//	
//	//_____________________________________POST___________________________________
//	
	
	@PostMapping("/products/add")
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	
//	
//	//_____________________________________PUT___________________________________
//	
	@PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id,product);
    }
//	
//	@PutMapping("/{id}")
//    public User updateUser(@PathVariable Long id, @RequestBody User user) {
//        return userService.updateUser(id,user);
//    }
//	
//	@PutMapping("/{id}")
//    public Address updateProduct(@PathVariable Long id, @RequestBody Address address) {
//        return addressService.updateAddress(id,address);
//    }
//	
//	//_____________________________________DELETE___________________________________
//	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable long id) {
		productService.deleteProduct(id);
	}
//	
//	@DeleteMapping("/{id}")
//	public void deleteUser(@PathVariable long id) {
//		userService.deleteUser(id);
//	}
//	
//	@DeleteMapping("/{id}")
//	public void deleteAddress(@PathVariable long id) {
//		addressService.deleteAddress(id);
//	}
//	
	
}
