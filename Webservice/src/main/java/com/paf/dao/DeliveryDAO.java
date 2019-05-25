package com.paf.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paf.model.Delivery;
import com.paf.repository.delivery.DeliveryRepository;


@Service
public class DeliveryDAO {
	@Autowired
	DeliveryRepository deliveryRepository;
	
	/*to save an delivery*/
	
	public Delivery save(Delivery delivery) {
		return deliveryRepository.save(delivery);
	}
	
	
	/* search all delivery*/
	
	public List<Delivery> findAll(){
		return deliveryRepository.findAll();
	}
	
	
	/*get an delivery by id*/
	public Delivery findOne(Long DeliverId) {
		return deliveryRepository.findOne(DeliverId);
	}
	
	
	/*delete an delivery*/
	
	public void delete(Delivery delivery) {
		deliveryRepository.delete(delivery);
	}

}
