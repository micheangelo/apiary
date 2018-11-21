package pl.manager.apiary.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.manager.apiary.model.ItemCategory;

public class ItemCategoryDAOImpl implements ItemCategoryDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addItemCategory(ItemCategory itemCategory) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(itemCategory);
	}

	@Override
	@Transactional
	public void updateItemCategory(ItemCategory itemCategory) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(itemCategory);
	}

	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<ItemCategory> listItemCategories() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ItemCategory> itemCategories = session.createQuery("from ItemCategory").list();
		return itemCategories;
	}

	@Override
	@Transactional(readOnly = true)
	public ItemCategory getItemCategoryById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ItemCategory itemCategory = session.load(ItemCategory.class, new Integer(id));
		return itemCategory;
	}

	@Override
	@Transactional
	public void removeItemCategory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(getItemCategoryById(id));
	}

}
