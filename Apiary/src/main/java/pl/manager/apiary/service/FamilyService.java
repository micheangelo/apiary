package pl.manager.apiary.service;

import java.util.List;

import pl.manager.apiary.model.Family;

public interface FamilyService {
	public void addFamily(Family f);

	public void updateFamily(Family f);

	public List<Family> listFamilies();

	public Family getFamilyById(int id);

	public void removeFamily(int id);

}
