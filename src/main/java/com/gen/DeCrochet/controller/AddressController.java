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
	
	import com.gen.DeCrochet.model.Address;
	import com.gen.DeCrochet.model.User;
	import com.gen.DeCrochet.service.AddressService;
	import com.gen.DeCrochet.service.UserService;
	
	
	@RestController
	@RequestMapping(path="/DeCrochet")
	public class AddressController {
		
		
		@Autowired
		AddressService addressService;
		
		
		// Get
		
		@GetMapping(value = "/address")
		ResponseEntity<List<Address>> getAllProducts(){
			return new ResponseEntity<>(addressService.getAllAddress(),HttpStatus.OK);
		}
	
		// POST
		
		@PostMapping("/address/add")
		public Address createUser(@RequestBody Address user) {
			return addressService.createAddress(user);
		}
		
		// PUT
		
		@PutMapping("/address/{id}")
	    public Address updateUser(@PathVariable Long id, @RequestBody Address user) {
	        return addressService.updateAddress(id,user);
	    }
		
		// DELETE
		
		@DeleteMapping("/address/{id}")
		public void deleteUser(@PathVariable long id) {
			addressService.deleteAddress(id);
		}
	}
