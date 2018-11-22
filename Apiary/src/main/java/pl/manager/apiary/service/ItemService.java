package pl.manager.apiary.service;

import java.util.List;

import pl.manager.apiary.model.Item;

public interface ItemService {
	public void addItem(Item item);
	public void updateItem(Item item);
	public List<Item> listItems();
	public Item getItemById(int id);
	public void removeItem(int id);
}
