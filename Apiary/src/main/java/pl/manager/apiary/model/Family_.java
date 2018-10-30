package pl.manager.apiary.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Family.class)
public abstract class Family_ {
	public static volatile SingularAttribute<Family, Integer> id;
	public static volatile SingularAttribute<Family, String> race;
	public static volatile SingularAttribute<Family, String> queenOrigin;
	public static volatile SingularAttribute<Family, Integer> queenBirthYear;
	public static volatile SingularAttribute<Family, Hive> hive;

}
