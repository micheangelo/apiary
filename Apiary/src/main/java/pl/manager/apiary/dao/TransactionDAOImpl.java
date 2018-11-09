package pl.manager.apiary.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.manager.apiary.model.Transaction;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

	private static final Logger logger = LoggerFactory.getLogger(TransactionDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	@Transactional
	public void addTransaction(Transaction t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(t);
		logger.info("Transaction saved successfully, transaction details=" + t);
	}

	@Override
	@Transactional
	public void updateTransaction(Transaction t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		logger.info("Transaction updated successfully, transaction details=" + t);
	}

	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Transaction> listTransactions() {
		List<Transaction> transactions = new ArrayList<>();
		Session session = this.sessionFactory.getCurrentSession();
		List<Object[]> transactionsList = session.createQuery(
				"SELECT t, n.name AS type_name FROM Transaction t LEFT JOIN TransactionType n ON t.transactionType=n.id")
				.list();
		for (Object[] result : transactionsList) {
			Transaction t = (Transaction) result[0];
			t.setTypeName((String) result[1]);
			transactions.add(t);
		}
		return transactions;
	}

	@Override
	@Transactional(readOnly = true)
	public Transaction getTransactions(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction t = (Transaction) session.load(Transaction.class, new Integer(id));
		logger.info("Transaction loaded successfully, transaction details=" + t);
		return t;
	}

	@Override
	@Transactional
	public void deleteTransaction(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction t = (Transaction) session.load(Transaction.class, new Integer(id));
		if (null != t)
			session.delete(t);
		logger.info("Transaction deleted successfully, transaction details=" + t);
	}

}
