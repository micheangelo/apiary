package pl.manager.apiary.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.manager.apiary.model.Transaction;

@Repository
@Transactional
public class TransactionDAOImpl implements TransactionDAO {

	private static final Logger logger = LoggerFactory.getLogger(TransactionDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addTransaction(Transaction t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(t);
		logger.info("Transaction saved successfully, transaction details=" + t);
	}

	@Override
	public void updateTransaction(Transaction t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		logger.info("Transaction updated successfully, transaction details=" + t);
	}

	@Override
	@Transactional
	public List<Transaction> listTransactions() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Transaction> transactionsList = session.createQuery("from Transaction").list();
		for (Transaction c : transactionsList) {
			logger.info("Transaction List::" + c);
		}
		return transactionsList;
	}

	@Override
	public Transaction getTransactions(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction t = (Transaction) session.load(Transaction.class, new Integer(id));
		logger.info("Transaction loaded successfully, transaction details=" + t);
		return t;
	}

	@Override
	public void deleteTransaction(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction t = (Transaction) session.load(Transaction.class, new Integer(id));
		if (null != t) {
			session.delete(t);
		}
		logger.info("Transaction deleted successfully, transaction details=" + t);
	}

}
