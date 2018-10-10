package pl.manager.apiary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.manager.apiary.dao.TransactionDAO;
import pl.manager.apiary.model.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDAO transactionDAO;

	public void setTransactionDAO(TransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;
	}

	@Override
	public void addTransaction(Transaction t) {
		this.transactionDAO.addTransaction(t);
	}

	@Override
	public void updateTransaction(Transaction t) {
		this.transactionDAO.updateTransaction(t);
	}

	@Override
	public List<Transaction> listTransactions() {
		return this.transactionDAO.listTransactions();
	}

	@Override
	public Transaction getTransactionById(int id) {
		return this.transactionDAO.getTransactions(id);
	}

	@Override
	public void removeTransaction(int id) {	
		this.transactionDAO.deleteTransaction(id);
	}

}
