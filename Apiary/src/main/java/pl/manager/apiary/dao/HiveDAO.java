package pl.manager.apiary.dao;

import java.util.List;

import pl.manager.apiary.model.Hive;

public interface HiveDAO {
	public void addHive(Hive h);

	public void updateHive(Hive h);

	public List<Hive> listHives();

	public Hive getHive(int id);

	public void deleteHive(int id);
}
