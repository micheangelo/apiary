package pl.manager.apiary.dao;

import java.util.List;

import pl.manager.apiary.model.Family;

public interface FamilyDAO {
	public void addFamily(Family f);

	public void updateFamily(Family f);

	public List<Family> listFamilies();

	public Family getFamilyById(int id);

	public void removeFamily(int id);
}
