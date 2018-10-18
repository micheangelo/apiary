package pl.manager.apiary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hive")
public class Hive {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String identifier;
	private String material;
	@Column(name = "purchase_year")
	private int purchaseYear;
	@Column(name = "hive_type")
	private String hiveType;
	private String description;

	@OneToOne(mappedBy = "hive", fetch = FetchType.LAZY, optional = false)
	private Family family;

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getPurchaseYear() {
		return purchaseYear;
	}

	public void setPurchaseYear(int purchaseYear) {
		this.purchaseYear = purchaseYear;
	}

	public String getHiveType() {
		return hiveType;
	}

	public void setHiveType(String hiveType) {
		this.hiveType = hiveType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
