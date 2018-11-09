package pl.manager.apiary.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.manager.apiary.model.Inspection;

@Repository
public class InspectionDAOImpl implements InspectionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addInspection(Inspection i) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(i);
	}

	@Override
	@Transactional
	public void updateInspection(Inspection i) {
		Session session = sessionFactory.getCurrentSession();
		session.update(i);
	}

	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Inspection> listInspections() {
		Session session = sessionFactory.getCurrentSession();
		List<Inspection> inspectionList  = session.createQuery("from Inspection").list();
		return inspectionList;
	}

	@Override
	@Transactional(readOnly = true)
	public Inspection getInspection(int id) {
		Session session = sessionFactory.getCurrentSession();
		Inspection i = (Inspection)session.load(Inspection.class, new Integer(id));
		return i;
	}

	@Override
	@Transactional
	public void deleteInspection(int id) {
		Session session = sessionFactory.getCurrentSession();
		Inspection i = getInspection(id);
		if (i != null)
			session.delete(i);
	}

}
