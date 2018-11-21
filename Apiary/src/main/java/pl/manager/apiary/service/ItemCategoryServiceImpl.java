package pl.manager.apiary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.manager.apiary.dao.ItemCategoryDAO;
import pl.manager.apiary.model.ItemCategory;

public class ItemCategoryServiceImpl implements ItemCategoryService {

	private ItemCategoryDAO itemCategoryDAO;

	@Autowired
	public void setItemCategoryDAO(ItemCategoryDAO itemCategoryDAO) {
		this.itemCategoryDAO = itemCategoryDAO;
	}

	@Override
	public void addItemCategory(ItemCategory itemCategory) {
		this.itemCategoryDAO.addItemCategory(itemCategory);
	}

	@Override
	public void updateItemCategory(ItemCategory itemCategory) {
		this.itemCategoryDAO.updateItemCategory(itemCategory);
	}

	@Override
	public List<ItemCategory> listItemCategories() {
		return this.itemCategoryDAO.listItemCategories();
	}

	@Override
	public ItemCategory getItemCategoryById(int id) {		
		return this.itemCategoryDAO.getItemCategoryById(id);
	}

	@Override
	public void removeItemCategory(int id) {
		this.itemCategoryDAO.removeItemCategory(id);

	}

}
