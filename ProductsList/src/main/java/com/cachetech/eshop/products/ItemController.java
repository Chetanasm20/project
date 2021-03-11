package com.cachetech.eshop.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class ItemController 
{
	@Autowired
	private ItemServices itemService;
	@Autowired
	//private ItemRepository itemrepository;
	
	//Create a item
	@PostMapping("/item")
	public List<Item> createItem(@RequestBody Item item)
	{
		
		 return itemService.addItem(item);
				 }
	
	@GetMapping("/item")
	public List getItem()
	{
		return itemService.getItem();
	}
	
	//search a item based on particular properties
	@GetMapping("/item/{request}")
	public Item getSpecificItem(@PathVariable Object request)
	{
		return itemService.getSpecifiedItem(request);
	}
		
	//get a items only a specified item type
	@GetMapping("/item/itemtype/{itemType1}")
	public List getItemTypes(@PathVariable Object itemType1)
	{
		return itemService.getSpecifiedItemType(itemType1);
	}
	
	//Sort a specific item
	@GetMapping("/item/sortSpecificType/{itemtype2}/{request2}")
	public List<Item> sortSpecificTypeOfitemOnRequest(@PathVariable Object itemtype2,@PathVariable Object request2)
	{
		return itemService.sortSpeicificTypeItem(itemtype2,request2);
	}
	//sort based on item price
	@GetMapping("/itemprice")
	public List<Item> sortOnprice()
	{
		return itemService.sortItemsBasedOnPrice();
	}
		
	//sort a item based on name
	@GetMapping("/itemName")
	public List sortOnName()
	{
		return itemService.sortItemsBasedOnName();
	}
		
	//sort a item based on size
	@GetMapping("/itemSize")
	public List sortOnSize()
	{
		return itemService.sortItemsBasedOnSize();
	}
		
		
	
	//update item on specified request
	@PutMapping("/item/{input}")
	public List<Item> updateItem(@RequestBody Item item, @PathVariable Object input)
	{
		return itemService.updateItem(item,input);
	}
	
	//delete specified item based on request
	@DeleteMapping("/item/{input}")
	public List<Item> deleteItem(@PathVariable Object input)
	{
		return itemService.deleteItem(input);
	}
	
	//delete All items
	@DeleteMapping("/item")
	public List deleteAll()
	{
		return itemService.deleteAllItems();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
