package pl.manager.apiary.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.manager.apiary.model.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addItem(Item item) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(item);
	}

	@Override
	@Transactional
	public void updateItem(Item item) {
		Session session = sessionFactory.getCurrentSession();
		session.update(item);
	}

	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Item> listItems() {
		Session session = sessionFactory.getCurrentSession();
		List<Item> items = session.createQuery("from Item").list();
		return items;
	}

	@Override
	@Transactional(readOnly = true)
	public Item getItem(int id) {
		Session session = sessionFactory.getCurrentSession();
		Item item = session.load(Item.class, new Integer(id));
		if(item.getItemCategory() != null)
			item.setItemCategoryId(item.getItemCategory().getId());
		return item;
	}

	@Override
	@Transactional
	public void deleteItem(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getItem(id));
	}

}
