package pl.manager.apiary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.manager.apiary.dao.CostDAO;
import pl.manager.apiary.model.Cost;

@Service
public class CostServiceImpl implements CostService {

	@Autowired
	private CostDAO costDAO;

	public void setCostDAO(CostDAO costDAO) {
		this.costDAO = costDAO;
	}

	@Override
	public void addCost(Cost c) {
		this.costDAO.addCost(c);
	}

	@Override
	public void updateCost(Cost c) {
		this.costDAO.updateCost(c);
	}

	@Override
	public List<Cost> listCosts() {
		return this.costDAO.listCosts();
	}

	@Override
	public Cost getCostById(int id) {
		return this.getCostById(id);
	}

	@Override
	public void removeCost(int id) {
		this.removeCost(id);
	}

}
