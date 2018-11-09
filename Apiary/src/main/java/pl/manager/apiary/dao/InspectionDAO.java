package pl.manager.apiary.dao;

import java.util.List;

import pl.manager.apiary.model.Inspection;

public interface InspectionDAO {
	public void addInspection(Inspection i);

	public void updateInspection(Inspection i);

	public List<Inspection> listInspections();

	public Inspection getInspection(int id);

	public void deleteInspection(int id);

}
