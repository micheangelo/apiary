package pl.manager.apiary.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.manager.apiary.model.TransactionType;

@Repository
public class TransactionTypeDAOImpl implements TransactionTypeDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	@Transactional
	public void addTransactionType(TransactionType t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(t);
	}

	@Override
	@Transactional
	public void updateTransactionType(TransactionType t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
	}

	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<TransactionType> listTransactionTypes() {
		Session session = this.sessionFactory.getCurrentSession();
		List<TransactionType> transactionTypes = session.createQuery("from TransactionType").list();
		return transactionTypes;
	}

	@Override
	@Transactional(readOnly = true)
	public TransactionType getTransactionTypeById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		TransactionType transactionType = (TransactionType) session.get(TransactionType.class, new Integer(id));
		return transactionType;
	}

	@Override
	@Transactional
	public void removeTransactionType(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(this.getTransactionTypeById(id));
	}

}
