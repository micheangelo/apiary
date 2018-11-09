package pl.manager.apiary.service;

import java.util.List;

import pl.manager.apiary.model.Hive;

public interface HiveService {
	public void addHive(Hive h);
	public void updateHive(Hive h);
	public List<Hive> listHives();
	public List<Hive> listFreeHives();
	public List<Hive> listFreeAndCurrentHives(int id);
	public Hive getHiveById(int id);
	public void removeHive(int id);
}
