package com.paf.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paf.model.Item;
import com.paf.repository.seller.ItemRepository;

@Service
public class ItemDAO {
	@Autowired
	ItemRepository itemRepository;
	
	/*to save an item*/
	
	public Item save(Item item) {
		return itemRepository.save(item);
	}
	
	
	/* search all items*/
	
	public List<Item> findAll(){
		return itemRepository.findAll();
	}
	
	
	/*get an item by id*/
	public Item findOne(Long itemid) {
		return itemRepository.findOne(itemid);
	}
	
	
	/*delete an item*/
	
	public void delete(Item item) {
		itemRepository.delete(item);
	}
}
