package pl.manager.apiary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.manager.apiary.dao.InspectionDAO;
import pl.manager.apiary.model.Inspection;

@Service
public class InspectionServiceImpl implements InspectionService {

	@Autowired
	private InspectionDAO inspectionDAO;

	public void setInspectionDAO(InspectionDAO inspectionDAO) {
		this.inspectionDAO = inspectionDAO;
	}

	@Override
	public void addInspection(Inspection i) {
		this.inspectionDAO.addInspection(i);
	}

	@Override
	public void updateInspection(Inspection i) {
		this.inspectionDAO.updateInspection(i);
	}

	@Override
	public List<Inspection> listInspections() {
		return this.inspectionDAO.listInspections();
	}

	@Override
	public Inspection getInspectionById(int id) {
		return this.inspectionDAO.getInspection(id);
	}

	@Override
	public void removeInspection(int id) {
		this.inspectionDAO.deleteInspection(id);

	}

}
