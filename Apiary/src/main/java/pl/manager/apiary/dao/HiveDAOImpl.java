package pl.manager.apiary.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.manager.apiary.model.Family;
import pl.manager.apiary.model.Family_;
import pl.manager.apiary.model.Hive;
import pl.manager.apiary.model.Hive_;

@Repository
@Transactional
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
		Family f = null;
		if(h.getFamily() != null)
			f = session.load(Family.class, new Integer(h.getFamily().getId()));
		else
			f = new Family();
		h.setFamily(f);
		return h;
	}

	@Override
	public void deleteHive(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Hive h = getHive(id);
		if (h != null)
			session.delete(h);
	}

	@Override
	public List<Hive> listFreeHives() {
		Session session = this.sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Hive> query = cb.createQuery(Hive.class);
		Root<Hive> root = query.from(Hive.class);
		query.select(root);

		Subquery<Family> subquery = query.subquery(Family.class);
		Root<Family> familyRoot = subquery.from(Family.class);
		subquery.select(familyRoot);

		Predicate p = cb.equal(familyRoot.get(Family_.hive), root);
		subquery.where(p);
		query.where(cb.not(cb.exists(subquery)));

		TypedQuery<Hive> hiveQuery = session.createQuery(query);

		return hiveQuery.getResultList();
	}

	@Override
	public List<Hive> listFreeAndCurrentHives(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Hive> query = cb.createQuery(Hive.class);
		Root<Hive> root = query.from(Hive.class);
		query.select(root);

		Subquery<Family> subquery = query.subquery(Family.class);
		Root<Family> familyRoot = subquery.from(Family.class);
		subquery.select(familyRoot);

		Predicate p = cb.equal(familyRoot.get(Family_.hive), root);
		subquery.where(p);

		query.where(cb.or(cb.not(cb.exists(subquery)), cb.equal(root.get(Hive_.id), id)));

		TypedQuery<Hive> hiveQuery = session.createQuery(query);

		return hiveQuery.getResultList();
	}

}
