package pl.manager.apiary.dao;

import java.util.List;

import pl.manager.apiary.model.Cost;

public interface CostDAO {
	public void addCost(Cost c);
	public void updateCost(Cost c);
	public List<Cost> listCosts();
	public Cost getCost(int id);
	public void deleteCost(int id);
}
