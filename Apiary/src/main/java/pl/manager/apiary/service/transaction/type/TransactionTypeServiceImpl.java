package pl.manager.apiary.service.transaction.type;

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
	public void addTransactionType(TransactionType t) {
		this.transactionTypeDAO.addTransactionType(t);
	}
	
	@Override
	public void updateTransactionType(TransactionType t) {
		this.transactionTypeDAO.updateTransactionType(t);
	}

	@Override
	public List<TransactionType> listTransactionTypes() {
		return transactionTypeDAO.listTransactionTypes();
	}
	
	@Override
	public TransactionType getTransactionTypeById(int id) {
		return transactionTypeDAO.getTransactionTypeById(id);
	}
	
	@Override
	public void removeTransactionType(int id) {
		this.transactionTypeDAO.removeTransactionType(id);
	}

}
