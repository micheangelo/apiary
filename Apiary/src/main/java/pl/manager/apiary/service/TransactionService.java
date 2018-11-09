package pl.manager.apiary.service;

import java.util.List;

import pl.manager.apiary.model.Transaction;

public interface TransactionService {
	public void addTransaction(Transaction t);
	public void updateTransaction(Transaction t);
	public List<Transaction> listTransactions();
	public Transaction getTransactionById(int id);
	public void removeTransaction(int id);
}
