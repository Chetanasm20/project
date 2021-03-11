package com.cachetech.eshop.products;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class ItemServices 
{
	private List<Item> items=new ArrayList<Item>();
	private List specificItemType=new ArrayList();
	
	//add all items
	public List addItem(Item item) 
	{
		if(validateItemPeoperties(item))
		{
			items.add(item);
		}
		return items;
	}
	
	//Item Inputs Validation
	private boolean validateItemPeoperties(Item item) 
	{
		if(item.getId()>=1 && item.getItemName()!=null && item.getItemName()!="" && item.getPrice()>=0 && item.getSize()>=1 && item.getItemType()!=null && item.getItemType()!="")
		{
			return true;
		}
		return false;
	
	}
	
	//ItemBucket inputs validation
	
	
	//get a item
	public List getItem() 
	{
		return items;
	}
	
	//get item based on specified properties
	public Item getSpecifiedItem(Object input) 
	{
		int temp=0;
		outer:for(int i=0;i<items.size();i++)
		{
			if((items.get(i).getId()+"").equals(input))
			{
				temp=i;
				break outer;
			}
			if ((items.get(i).getPrice()+"").equals(input))
			{
				temp=i;
				break outer;
			}
			if((items.get(i).getSize()+"").equals(input))
			{
				temp=i;
				break outer;
			}
			if((items.get(i).getItemName()).equals(input))
			{
				temp=i;
				break outer;
			}
			if((items.get(i).getItemType()).equals(input))
			{
				temp=i;
				break outer;
			}
				
		}
			return items.get(temp);
			
		}
		
		//get  items only of specified types
		public List getSpecifiedItemType(Object obj) 
		{
			specificItemType.clear();
			for(int i=0;i<items.size();i++)
			{
				if(items.get(i).getItemType().equals(obj))
				{
					specificItemType.add(items.get(i));
				}
			}
			return specificItemType;
		}
		
		//sort a items based on price
		public List sortItemsBasedOnPrice() 
		{
			Collections.sort(items,new sortByPrice());
			return items;
		}
		
		//sort a items based on itemname
		public List sortItemsBasedOnName() 
		{
			Collections.sort(items,new sortByName());
			return items;
		}
		
		//sort a items based on size
		public List sortItemsBasedOnSize() 
		{
			Collections.sort(items,new sortBySize());
			return items;
		}


	
	//Update Item 
	public List updateItem(Item item,Object input) 
	{
		outer:for(int i=0;i<items.size();i++)
		{
			if(((items.get(i).getId()+"").equals(input)) || ((items.get(i).getPrice()+"").equals(input)) || ((items.get(i).getSize()+"").equals(input)) || ((items.get(i).getSize()+"").equals(input)) || ((items.get(i).getItemName()+"").equals(input)) || ((items.get(i).getItemType()+"").equals(input)))
			{
				items.set(i, item);
				break outer;
			}
			
		}
		return items;
	}
	
	//to delete a item on specified items properties
	public List deleteItem(Object input) 
	{
		outer:for(int i=0;i<items.size();i++)
		{
			if(((items.get(i).getId()+"").equals(input)) || ((items.get(i).getPrice()+"").equals(input)) || ((items.get(i).getSize()+"").equals(input)) || ((items.get(i).getSize()+"").equals(input)) || ((items.get(i).getItemName()+"").equals(input)) || ((items.get(i).getItemType()+"").equals(input)))
			{
				items.remove(i);
				break outer;
			}
			
		}
		return items;

	}
	
	//to delete all items
	public List deleteAllItems() 
	{
		items.clear();
		return items;
	}

	//sort a speicific Type of item based on price
	public List sortSpeicificTypeItem(Object itemtype2,Object input) 
	{
		
		specificItemType.clear();
	 specificItemType=	getSpecifiedItemType(itemtype2);
	 		
	 		if ("price".equals(input))
			{
				Collections.sort(items,new sortByPrice());
				return specificItemType;
			}
			if("size".equals(input))
			{
				Collections.sort(items,new sortBySize());
			}
			else
			{
				Collections.sort(items,new sortByName());
				
			}
			return specificItemType;
			
				
		}
}
