package pl.manager.apiary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.manager.apiary.dao.ItemDAO;
import pl.manager.apiary.model.Item;

public class ItemServiceImpl implements ItemService {

	private ItemDAO itemDAO;

	@Autowired
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	@Override
	public void addItem(Item item) {
		this.itemDAO.addItem(item);
	}

	@Override
	public void updateItem(Item item) {
		this.itemDAO.updateItem(item);
	}

	@Override
	public List<Item> listItems() {
		return this.itemDAO.listItems();
	}

	@Override
	public Item getItemById(int id) {		
		return this.itemDAO.getItem(id);
	}

	@Override
	public void removeItem(int id) {
		this.itemDAO.deleteItem(id);

	}

}
