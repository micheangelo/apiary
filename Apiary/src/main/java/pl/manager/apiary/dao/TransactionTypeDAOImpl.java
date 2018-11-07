package pl.manager.apiary.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.manager.apiary.model.TransactionType;

@Repository
@Transactional
public class TransactionTypeDAOImpl implements TransactionTypeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addTransactionType(TransactionType t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(t);
	}

	@Override
	public void updateTransactionType(TransactionType t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
	}

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionType> listTransactionTypes() {
		Session session = this.sessionFactory.getCurrentSession();
		List<TransactionType> transactionTypes = session.createQuery("from TransactionType").list();
		return transactionTypes;
	}

	@Override
	public TransactionType getTransactionTypeById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		TransactionType transactionType = (TransactionType) session.get(TransactionType.class, new Integer(id));
		return transactionType;
	}

	@Override
	public void removeTransactionType(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(this.getTransactionTypeById(id));
	}

}
