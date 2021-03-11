package com.cachetech.products;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repository extends JpaRepository<ItemBean, Integer>
{

	List<ItemBean> findByItemType(Object input);

	List<ItemBean> findByOrderByPriceAsc();

	ItemBean findByItemName(String itemname);

	List<ItemBean> findByOrderByItemNameAsc();

	List<ItemBean> findByOrderBySizeAsc();

	
	
	
}
