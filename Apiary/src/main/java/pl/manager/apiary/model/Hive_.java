package pl.manager.apiary.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Hive.class)
public abstract class Hive_ {
	public static volatile SingularAttribute<Hive, Integer> id;
	public static volatile SingularAttribute<Hive, String> identifier;
	public static volatile SingularAttribute<Hive, String> material;
	public static volatile SingularAttribute<Hive, Integer> purchaseYear;
	public static volatile SingularAttribute<Hive, String> hiveType;
	public static volatile SingularAttribute<Hive, String> description;
}
