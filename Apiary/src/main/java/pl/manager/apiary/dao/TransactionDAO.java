package pl.manager.apiary.dao;

import java.util.List;

import pl.manager.apiary.model.Transaction;

public interface TransactionDAO {
	public void addTransaction(Transaction c);
	public void updateTransaction(Transaction c);
	public List<Transaction> listTransactions();
	public Transaction getTransactions(int id);
	public void deleteTransaction(int id);
}
