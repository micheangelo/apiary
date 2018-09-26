package pl.manager.apiary.service;

import java.util.List;

import pl.manager.apiary.model.Cost;

public interface CostService {
	public void addCost(Cost p);
	public void updateCost(Cost p);
	public List<Cost> listCosts();
	public Cost getCostById(int id);
	public void removeCost(int id);
}
