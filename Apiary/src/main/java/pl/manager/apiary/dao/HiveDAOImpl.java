package pl.manager.apiary.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pl.manager.apiary.model.Hive;

public class HiveDAOImpl implements HiveDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addHive(Hive h) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(h);
		logger.info("Hive was added");
	}

	@Override
	public void updateHive(Hive h) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(h);
		logger.info("Hive was updated");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hive> listHives() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Hive> hivesList = session.createQuery("from Hive").list();
		return hivesList;
	}

	@Override
	public Hive getHive(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Hive h = session.load(Hive.class, new Integer(id));
		return h;
	}

	@Override
	public void deleteHive(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Hive h = session.load(Hive.class, new Integer(id));
		if(h != null)
			session.delete(h);

	}

}
