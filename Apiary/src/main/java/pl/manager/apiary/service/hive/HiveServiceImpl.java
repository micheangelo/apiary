package pl.manager.apiary.service.hive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.manager.apiary.dao.HiveDAO;
import pl.manager.apiary.model.Hive;

@Service
public class HiveServiceImpl implements HiveService {

	@Autowired
	private HiveDAO hiveDAO;

	public void setHiveDAO(HiveDAO hiveDAO) {
		this.hiveDAO = hiveDAO;
	}

	@Override
	public void addHive(Hive h) {
		this.hiveDAO.addHive(h);
	}

	@Override
	public void updateHive(Hive h) {
		this.hiveDAO.updateHive(h);
	}

	@Override
	public List<Hive> listHives() {
		return this.hiveDAO.listHives();
	}

	@Override
	public Hive getHiveById(int id) {
		return this.hiveDAO.getHive(id);
	}

	@Override
	public void removeHive(int id) {
		this.removeHive(id);
	}

}
