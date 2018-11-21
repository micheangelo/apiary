package pl.manager.apiary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.manager.apiary.dao.FamilyDAO;
import pl.manager.apiary.model.Family;

public class FamilyServiceImpl implements FamilyService {

	private FamilyDAO familyDAO;

	@Autowired
	public void setFamilyDAO(FamilyDAO familyDAO) {
		this.familyDAO = familyDAO;
	}

	@Override
	public void addFamily(Family f) {
		this.familyDAO.addFamily(f);
	}

	@Override
	public void updateFamily(Family f) {
		this.familyDAO.updateFamily(f);
	}

	@Override
	public List<Family> listFamilies() {
		return this.familyDAO.listFamilies();
	}

	@Override
	public Family getFamilyById(int id) {
		return this.familyDAO.getFamilyById(id);
	}

	@Override
	public void removeFamily(int id) {
		this.familyDAO.removeFamily(id);
	}

}
