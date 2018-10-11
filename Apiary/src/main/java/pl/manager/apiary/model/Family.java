package pl.manager.apiary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "family")
public class Family {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String race;
	private String queenOrigin;
	private int queenBirthYear;

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
