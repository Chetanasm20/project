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
	
	//get items on user request
	@GetMapping("/items/{request}")
	public Optional<ItemBean> getOneItem(@PathVariable Object request)
	{
		return itembeanservice.getSpecificIdItem(request);
	}
	

	//add a item
	@PostMapping("/items")
	public List<ItemBean> addItem(@RequestBody ItemBean item )
	{
		return itembeanservice.addItem(item);
	}
	
	//update item
	@PutMapping("/items")
	public List<ItemBean> updateItem(@RequestBody ItemBean itembean)
	{
		return itembeanservice.updateItem(itembean);
	}
	
	
	
	//delete a item on user request(like all items or particular item)
	@DeleteMapping("/items{request}")
	public List<ItemBean> deleteById(@PathVariable int request)
	{
		return itembeanservice.deletebyId(request);
	}
	
	//count the all items
	@GetMapping("/count")
	public int getcount()
	{
		return (int)itembeanservice.getEntintyCount();
	}
	
	//get a all items of specified type
	@GetMapping("/items/getByitemType/{type}")
	public List<ItemBean> itemtype(@PathVariable String type)
	{
		return itembeanservice.getAllItemOfSameType(type);
	}
	
	//sort a specific type of Item on user request
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
	
	//get a item by its name
	@GetMapping("/items/getitembyname/{itemName}")
	public ItemBean getItemByName(@PathVariable String itemName)
	{
		return itembeanservice.getItemByItemName(itemName);
	}


	
}
