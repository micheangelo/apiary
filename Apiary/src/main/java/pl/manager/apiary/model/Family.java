package pl.manager.apiary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "family")
public class Family {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String race;
	@Column(name = "queen_origin")
	private String queenOrigin;
	@DateTimeFormat(pattern = "yyyy")
	@Column(name = "queen_birth_year")
	private int queenBirthYear;

	@OneToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "hive_id")
	private Hive hive;

	public Hive getHive() {
		return hive;
	}

	public void setHive(Hive hive) {
		this.hive = hive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getQueenOrigin() {
		return queenOrigin;
	}

	public void setQueenOrigin(String queenOrigin) {
		this.queenOrigin = queenOrigin;
	}

	public int getQueenBirthYear() {
		return queenBirthYear;
	}

	public void setQueenBirthYear(int queenBirthYear) {
		this.queenBirthYear = queenBirthYear;
	}

}
