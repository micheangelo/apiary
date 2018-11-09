package pl.manager.apiary.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inspection")
public class Inspection {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "inspection_date")
	private Date inspectionDate;
	@Column(name = "open_brood")
	private boolean hasOpenBrood;
	@Column(name = "closed_brood")
	private boolean hasClosedBrood;
	@Column(name = "queen_present")
	private boolean isQueenPresent;
	@Column(name = "number_of_frames")
	private int numberOfFrames;
	@Column(name = "number_of_brood_frames")
	private int numberOfBroodFrames;
	@Column(name = "is_swarm_mood")
	private boolean isSwarmMood;
	private double temperature;
	private String notes;
	private int status;	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hive_id")
	private Hive hive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(Date inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public boolean isHasOpenBrood() {
		return hasOpenBrood;
	}

	public void setHasOpenBrood(boolean hasOpenBrood) {
		this.hasOpenBrood = hasOpenBrood;
	}

	public boolean isHasClosedBrood() {
		return hasClosedBrood;
	}

	public void setHasClosedBrood(boolean hasClosedBrood) {
		this.hasClosedBrood = hasClosedBrood;
	}

	public boolean isQueenPresent() {
		return isQueenPresent;
	}

	public void setQueenPresent(boolean isQueenPresent) {
		this.isQueenPresent = isQueenPresent;
	}

	public int getNumberOfFrames() {
		return numberOfFrames;
	}

	public void setNumberOfFrames(int numberOfFrames) {
		this.numberOfFrames = numberOfFrames;
	}

	public int getNumberOfBroodFrames() {
		return numberOfBroodFrames;
	}

	public void setNumberOfBroodFrames(int numberOfBroodFrames) {
		this.numberOfBroodFrames = numberOfBroodFrames;
	}

	public boolean isSwarmMood() {
		return isSwarmMood;
	}

	public void setSwarmMood(boolean isSwarmMood) {
		this.isSwarmMood = isSwarmMood;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Hive getHive() {
		return hive;
	}

	public void setHive(Hive hive) {
		this.hive = hive;
	}

}
