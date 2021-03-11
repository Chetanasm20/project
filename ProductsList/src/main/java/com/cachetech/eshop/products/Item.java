package com.cachetech.eshop.products;


import javax.persistence.Entity;

import org.springframework.data.annotation.Id;


public class Item 
{
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", price=" + price + ", size=" + size + ", itemType="
				+ itemType + "]";
	}
	
	private int id;
	private String itemName;
	private double price;
	private int size;
	private String itemType;
	
	public Item(int id, String itemName, double price, int size, String itemType) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.size = size;
		this.itemType = itemType;
	}

	public Item() 
	{
		super();
		
	}

		
	public int getSize() 
	{
		return size;
	}
  
	public void setSize(int size) 
	{
		this.size = size;
	}
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getItemName() 
	{
		return itemName;
	}

	public void setItemName(String itemName) 
	{
		this.itemName = itemName;
	}

	public double getPrice() 
	{
		return price;
	}

	public void setPrice(double price) 
	{
		this.price = price;
	}
	public String getItemType() 
	{
		return itemType;
	}
	public void setItemType(String itemType) 
	{
		this.itemType = itemType;
	}


}
