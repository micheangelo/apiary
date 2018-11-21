package pl.manager.apiary.service;

import java.util.List;

import pl.manager.apiary.model.ItemCategory;

public interface ItemCategoryService {
	public void addItemCategory(ItemCategory itemCategory);
	public void updateItemCategory(ItemCategory itemCategory);
	public List<ItemCategory> listItemCategories();
	public ItemCategory getItemCategoryById(int id);
	public void removeItemCategory(int id);
}	
