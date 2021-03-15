package com.cachetech.products;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ItemBeanService 
{
	ArrayList<ItemBean> items=new ArrayList<ItemBean>();
	List<ItemBean> itemtype=new ArrayList<ItemBean>();
	
	
	@Autowired
	private repository repository;
	
	//get all items
	public List<ItemBean> getAllItems() 
	{
		
		return repository.findAll();
	}
	
	//add a item
	public List<ItemBean> addItem(ItemBean item) 
	{
		repository.save(item);
		return repository.findAll();
		
	}

	//get a item of specified id
	public Optional<ItemBean> getSpecificIdItem(Object request) 
	{
		
		return repository.findById((Integer) request);
	}

	//update item on id
	public List<ItemBean> updateItem(ItemBean itembean) 
	{
		
		ItemBean updateitem=repository.findById(itembean.getId()).orElse(null);
		
		updateitem.setItemName(itembean.getItemName());
		updateitem.setItemType(itembean.getItemType());
		updateitem.setPrice(itembean.getPrice());
		updateitem.setSize(itembean.getSize());
		repository.save(updateitem);
		return repository.findAll();
		
		
	}

	//delete all items
	public List<ItemBean> deleteAll() 
	{
		repository.deleteAll();
		return repository.findAll();
	}

	//delete a item 
	public List<ItemBean> deletebyId(int request) 
	{
		repository.deleteById(request);
		return repository.findAll();
	}

	//sort by price
	public void sortByPrice(int  request) 
	{
		repository.existsById(request);
	}

	//get all items of specified type
	public List<ItemBean> getAllItemOfSameType(String input) 
	{
		// TODO Auto-generated method stub
		return repository.findByItemType(input);
	}

	//count the all items
	public int getEntintyCount() 
	{
		// TODO Auto-generated method stub
		return (int) repository.count();
	}


	public List<ItemBean> sorting(Object input) 
	{
		if("price".equals(input))
		{
			return repository.findByOrderByPriceAsc();
		}
		if("itemName".equals(input))
		{
			return repository.findByOrderByItemNameAsc();
		}
		else
		{
			return repository.findByOrderBySizeAsc();
		}
	}


	public ItemBean getItemByItemName(String itemname) 
	{
		// TODO Auto-generated method stub
		return repository.findByItemName(itemname);
	}


	public List<ItemBean> sortOnSpeicificItemType(Object request1,Object request2) 
	{
		itemtype.clear();
		if("price".equals(request2))
		{
			 itemtype=	repository.findByItemType(request1);
			repository.saveAll(itemtype);
			return repository.findByOrderByPriceAsc();
					
		}
		
		if("itemName".equals(request2))
		{
			 itemtype=	repository.findByItemType(request1);
			repository.saveAll(itemtype);
			return repository.findByOrderByItemNameAsc();		
		}
		
		else
		{
			itemtype=	repository.findByItemType(request1);
			repository.saveAll(itemtype);
			return repository.findByOrderBySizeAsc();
		}
	}
	
	// add different way of sorting, this will reduce few lines 
	//this method will sort items based on their itemname
	public List<ItemBean> getAllItemsSort()
    {
	 Sort sortOrder = Sort.by("itemName"); 
	 
	 List<ItemBean> list = repository.findAll(sortOrder);
	return list;
    }

	
}
