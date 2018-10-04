package pl.manager.apiary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.manager.apiary.dao.TransactionTypeDAO;
import pl.manager.apiary.model.TransactionType;

public class TransactionTypeServiceImpl implements TransactionTypeService {

	@Autowired
	private TransactionTypeDAO transactionTypeDAO;

	public void setTransactionTypeDAO(TransactionTypeDAO transactionTypeDAO) {
		this.transactionTypeDAO = transactionTypeDAO;
	}

	@Override
	public List<TransactionType> listTransactionTypes() {
		return transactionTypeDAO.listTransactionTypes();
	}

}
