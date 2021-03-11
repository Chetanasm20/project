package com.cachetech.eshop.products;

import java.util.Comparator;

public class sortByName implements Comparator<Item> 
{

	

	@Override
	public int compare(Item o1, Item o2) {
		return o1.getItemName().compareTo(o2.getItemName());
	}

}
