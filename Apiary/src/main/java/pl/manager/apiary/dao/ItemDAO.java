package pl.manager.apiary.dao;

import java.util.List;

import pl.manager.apiary.model.Item;

public interface ItemDAO {
	public void addItem(Item item);

	public void updateItem(Item item);

	public List<Item> listItems();

	public Item getItem(int id);

	public void deleteItem(int id);
}
