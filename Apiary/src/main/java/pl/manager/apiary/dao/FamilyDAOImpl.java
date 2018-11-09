package pl.manager.apiary.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.manager.apiary.model.Family;

@Repository
public class FamilyDAOImpl implements FamilyDAO {

	private static final Logger logger = LoggerFactory.getLogger(FamilyDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addFamily(Family f) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(f);
	}

	@Override
	@Transactional
	public void updateFamily(Family f) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(f);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Family> listFamilies() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Family> families = session.createQuery("from Family", Family.class).list();
		return families;
	}

	@Override
	@Transactional(readOnly = true)
	public Family getFamilyById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Family f = (Family) session.load(Family.class, new Integer(id));
		logger.info("Family loaded successfully, family details=" + f);
		return f;
	}

	@Override
	@Transactional
	public void removeFamily(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Family f = getFamilyById(id);
		if (f != null)
			session.delete(f);

	}

}
