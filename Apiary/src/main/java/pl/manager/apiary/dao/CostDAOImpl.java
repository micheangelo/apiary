package pl.manager.apiary.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.manager.apiary.model.Cost;

@Repository
public class CostDAOImpl implements CostDAO {

	private static final Logger logger = LoggerFactory.getLogger(CostDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addCost(Cost c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Cost saved successfully, Cost details=" + c);
	}

	@Override
	public void updateCost(Cost c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		logger.info("Cost updated successfully, Cost details=" + c);
	}

	@Override
	public List<Cost> listCosts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Cost> costsList = session.createQuery("from cost").list();
		for (Cost c : costsList) {
			logger.info("Cost List::" + c);
		}
		return costsList;
	}

	@Override
	public Cost getCost(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cost c = (Cost) session.load(Cost.class, new Integer(id));
		logger.info("Cost loaded successfully, Cost details=" + c);
		return c;
	}

	@Override
	public void deleteCost(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cost c = (Cost) session.load(Cost.class, new Integer(id));
		if (null != c) {
			session.delete(c);
		}
		logger.info("Cost deleted successfully, cost details=" + c);
	}

}
