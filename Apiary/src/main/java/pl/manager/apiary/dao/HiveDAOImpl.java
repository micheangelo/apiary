package pl.manager.apiary.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.manager.apiary.model.Family;
import pl.manager.apiary.model.Family_;
import pl.manager.apiary.model.Hive;
import pl.manager.apiary.model.Hive_;

@Repository
public class HiveDAOImpl implements HiveDAO {

	private static final Logger logger = LoggerFactory.getLogger(TransactionDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addHive(Hive h) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(h);
		logger.info("Hive was added");
	}

	@Override
	@Transactional
	public void updateHive(Hive h) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(h);
		logger.info("Hive was updated");
	}

	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Hive> listHives() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Hive> hivesList = session.createQuery("from Hive").list();
		return hivesList;
	}

	@Override
	@Transactional(readOnly = true)
	public Hive getHive(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		// join fetch to load families
		Query q = session.createQuery("SELECT h FROM Hive h " + " LEFT JOIN FETCH " + " h.family f WHERE h.id=:id");
		q.setParameter("id", id);
		return (Hive) q.getSingleResult();
	}

	@Override
	@Transactional
	public void deleteHive(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Hive h = getHive(id);
		if (h != null)
			session.delete(h);
	}

	@Override
	@Transactional(readOnly = true)
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
	@Transactional(readOnly = true)
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
