package com.paf.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.paf.model.Seller;

import com.paf.dao.SellerDAO;

@RestController
public class SellerController {
	
	 private final SellerDAO sellerDAO;
	  
	  @Autowired
	  SellerController(SellerDAO sellerDAO) {
		    this.sellerDAO = sellerDAO;
	  }

		/* to save an sellers*/
		@PostMapping("/sellers")
		public Seller createSeller(@Valid @RequestBody Seller seller) {
			return sellerDAO.save(seller);
		}
		
		/*get all sellers*/
		@GetMapping("/sellers")
		public List<Seller> getAllSeller(){
			return sellerDAO.findAll();
		}

		/*get seller by sellerid*/
		@GetMapping("/sellers/{id}")
		public ResponseEntity<Seller> getSellerById(@PathVariable(value="id") Long sellerid){
			
			Seller seller= sellerDAO.findOne(sellerid);
			
			if(seller==null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(seller);
			
		}
		
		/*update an seller by sellerid*/
		@PutMapping("/sellers/{id}")
		public ResponseEntity<Seller> updateSeller(@PathVariable(value="id") Long sellerid,@Valid @RequestBody Seller sellerDetails){
			
			Seller seller=sellerDAO.findOne(sellerid);
			if(seller==null) {
				return ResponseEntity.notFound().build();
			}
			
			seller.setFname(sellerDetails.getFname());
			seller.setLname(sellerDetails.getLname());
			seller.setPhone(sellerDetails.getPhone());
			seller.setAddress(sellerDetails.getAddress());
			seller.setSellerStatus(sellerDetails.getSellerStatus());
			
			Seller updateSeller=sellerDAO.save(seller);
			return ResponseEntity.ok().body(updateSeller);
			
			
			
		}
		
		/*Delete an seller*/
		@DeleteMapping("/sellers/{id}")
		public ResponseEntity<Seller> deleteEmployee(@PathVariable(value="id") Long sellerid){
			
			Seller seller = sellerDAO.findOne(sellerid);
			if(seller==null) {
				return ResponseEntity.notFound().build();
			}
			sellerDAO.delete(seller);
			
			return ResponseEntity.ok().build();
			
			
		}

}
