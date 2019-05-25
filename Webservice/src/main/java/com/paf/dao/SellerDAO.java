package com.paf.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paf.model.Seller;
import com.paf.repository.seller.SellerRepository;

@Service
public class SellerDAO {

	@Autowired
	SellerRepository sellerRepository;
	
/*to save an seller*/
	
	public Seller save(Seller seller) {
		return sellerRepository.save(seller);
	}
	
	
	/* search all seller*/
	
	public List<Seller> findAll(){
		return sellerRepository.findAll();
	}
	
	
	/*get an seller by id*/
	public Seller findOne(Long sellerid) {
		return sellerRepository.findOne(sellerid);
	}
	
	
	/*delete an seller*/
	
	public void delete(Seller seller) {
		sellerRepository.delete(seller);
	}
}
