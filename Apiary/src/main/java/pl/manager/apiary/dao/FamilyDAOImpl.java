package pl.manager.apiary.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.manager.apiary.model.Family;

@Repository
@Transactional
public class FamilyDAOImpl implements FamilyDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addFamily(Family f) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(f);
	}

	@Override
	public void updateFamily(Family f) {
		Session session = sessionFactory.getCurrentSession();
		session.update(f);
	}

	@Override
	public List<Family> listFamilies() {
		Session session = sessionFactory.getCurrentSession();
		List<Family> families = session.createQuery("from Family", Family.class).list();
		return families;
	}

	@Override
	public Family getFamilyById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Family f = session.load(Family.class, id);
		return f;
	}

	@Override
	public void removeFamily(int id) {
		Session session = sessionFactory.getCurrentSession();
		Family f = getFamilyById(id);
		if (f != null)
			session.delete(f);

	}

}
