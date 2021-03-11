package com.cachetech.eshop.products;

import java.util.Comparator;

public class sortBySize implements Comparator<Item> 
{

	

	@Override
	public int compare(Item o1, Item o2) 
	{
		return o1.getSize()-o2.getSize();
	}

}
