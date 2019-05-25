package com.paf.controller;

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

import com.paf.model.Item;
import com.paf.dao.ItemDAO;

@RestController
public class ItemController {

  private final ItemDAO itemDAO;

  @Autowired
  ItemController(ItemDAO itemDAO) {
    this.itemDAO = itemDAO;
  }
  
	/* to save an item*/
	@PostMapping("/items")
	public Item createItem(@Valid @RequestBody Item item) {
		return itemDAO.save(item);
	}
	
	/*get all items*/
	@GetMapping("/items")
	public List<Item> getAllItems(){
		return itemDAO.findAll();
	}

	/*get item by itemid*/
	@GetMapping("/items/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable(value="id") Long itemid){
		
		Item item= itemDAO.findOne(itemid);
		
		if(item==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(item);
		
	}
	
	/*update an item by itemid*/
	@PutMapping("/items/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable(value="id") Long itemid,@Valid @RequestBody Item itemDetails){
		
		Item item=itemDAO.findOne(itemid);
		if(item==null) {
			return ResponseEntity.notFound().build();
		}
		
		item.setItemName(itemDetails.getItemName());
		item.setItemCategory(itemDetails.getItemCategory());
		item.setItemPrice(itemDetails.getItemPrice());
		item.setItemQuantity(itemDetails.getItemQuantity());
		item.setItemCreateAt(itemDetails.getItemCreateAt());
		
		Item updateItem=itemDAO.save(item);
		return ResponseEntity.ok().body(updateItem);
		
		
		
	}
	
	/*Delete an item*/
	@DeleteMapping("/items/{id}")
	public ResponseEntity<Item> deleteEmployee(@PathVariable(value="id") Long itemid){
		
		Item item = itemDAO.findOne(itemid);
		if(item==null) {
			return ResponseEntity.notFound().build();
		}
		itemDAO.delete(item);
		
		return ResponseEntity.ok().build();
		
		
	}

}
