package com.paf.repository.seller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paf.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {


}
