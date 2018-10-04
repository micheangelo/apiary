package pl.manager.apiary.dao;

import java.util.List;

import pl.manager.apiary.model.TransactionType;

public interface TransactionTypeDAO {
	public List<TransactionType> listTransactionTypes();
}
