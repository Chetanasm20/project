package com.cachetech.products;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemBeanController 
{
	@Autowired
	private ItemBeanService itembeanservice;
	
	@GetMapping("/items")
	public List<ItemBean> getItems()
	{
		return itembeanservice.getAllItems();
	}
	
	@GetMapping("/items/{request}")
	public Optional<ItemBean> getOneItem(@PathVariable Object request)
	{
		return itembeanservice.getSpecificIdItem(request);
	}
	

	
	@PostMapping("/items")
	public List<ItemBean> addItem(@RequestBody ItemBean item )
	{
		return itembeanservice.addItem(item);
	}
	
	@PutMapping("/items")
	public List<ItemBean> updateItem(@RequestBody ItemBean itembean)
	{
		return itembeanservice.updateItem(itembean);
	}
	
	@DeleteMapping("/items")
	public List<ItemBean>  deleteAll()
	{
		return itembeanservice.deleteAll();
	}
	
	@DeleteMapping("/items{request}")
	public List<ItemBean> deleteById(@PathVariable int request)
	{
		return itembeanservice.deletebyId(request);
	}
	@GetMapping("/count")
	public int getcount()
	{
		return (int)itembeanservice.getEntintyCount();
	}
	
	@GetMapping("/items/getByitemType/{type}")
	public List<ItemBean> itemtype(@PathVariable String type)
	{
		return itembeanservice.getAllItemOfSameType(type);
	}
	
	
	@GetMapping("/items/sortAspecifictypeOfItemOnUserRequest/{request1}/{request2}")
	public List<ItemBean> sortOnspecificItemType(@PathVariable Object request1,@PathVariable Object request2)
	{
		return itembeanservice.sortOnSpeicificItemType(request1,request2);
	}
	
	//sort on user request
	@GetMapping("/items/sortingonuserrequest/{request}")
	public List<ItemBean> sortonrequest(@PathVariable Object request)
	{
		return itembeanservice.sorting(request);
	}
	
	@GetMapping("/items/getitembyname/{itemName}")
	public ItemBean getItemByName(@PathVariable String itemName)
	{
		return itembeanservice.getItemByItemName(itemName);
	}


	
}
