package pl.manager.apiary.service;

import java.util.List;

import pl.manager.apiary.model.Transaction;

public interface TransactionService {
	public void addTransaction(Transaction p);
	public void updateTransaction(Transaction p);
	public List<Transaction> listTransactions();
	public Transaction getTransactionById(int id);
	public void removeTransaction(int id);
}
