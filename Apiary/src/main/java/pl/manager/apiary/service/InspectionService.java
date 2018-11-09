package pl.manager.apiary.service;

import java.util.List;

import pl.manager.apiary.model.Inspection;

public interface InspectionService {
	public void addInspection(Inspection i);
	public void updateInspection(Inspection i);
	public List<Inspection> listInspections();
	public Inspection getInspectionById(int id);
	public void removeInspection(int id);
}	
