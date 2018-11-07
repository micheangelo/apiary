package pl.manager.apiary.dao;

import java.util.List;

import pl.manager.apiary.model.TransactionType;

public interface TransactionTypeDAO {
	public void addTransactionType(TransactionType t);
	public void updateTransactionType(TransactionType t);
	public List<TransactionType> listTransactionTypes();
	public TransactionType getTransactionTypeById(int id);
	public void removeTransactionType(int id);
}
