package com.gen.DeCrochet.controller;

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

import com.gen.DeCrochet.model.Product;
import com.gen.DeCrochet.model.User;
import com.gen.DeCrochet.service.UserService;



@RestController
@RequestMapping(path="/DeCrochet")
public class UserController {

	
	
		@Autowired
		UserService userService;
		
		// Get
		
		@GetMapping(value = "/users")
//		public List<Product> getAllProducts(){
//			return productService.getAllProducts();
//		}
		ResponseEntity<List<User>> getAllProducts(){
			return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
		}
		
		@PostMapping(value = "/users/validate")
		public boolean uservalidate(@RequestBody User user) {
			boolean respuesta = false;
			if(userService.getUserById(user.getId())!=null) {
				respuesta = true;
			}
			return respuesta;
		}
	
		// POST
		
		@PostMapping("/users/add")
		public User createUser(@RequestBody User user) {
			return userService.createUser(user);
		}
		
		// PUT
		
		@PutMapping("/users/{id}")
	    public User updateUser(@PathVariable Long id, @RequestBody User user) {
	        return userService.updateUser(id,user);
	    }
		
		// DELETE
		
		@DeleteMapping("/users/{id}")
		public void deleteUser(@PathVariable long id) {
			userService.deleteUser(id);
		}
		
}
