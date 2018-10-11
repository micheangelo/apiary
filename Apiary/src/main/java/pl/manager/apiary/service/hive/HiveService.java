package pl.manager.apiary.service.hive;

import java.util.List;

import pl.manager.apiary.model.Hive;

public interface HiveService {
	public void addHive(Hive t);
	public void updateHive(Hive t);
	public List<Hive> listHives();
	public Hive getHiveById(int id);
	public void removeHive(int id);
}
