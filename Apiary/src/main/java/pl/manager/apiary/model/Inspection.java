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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "inspection")
public class Inspection {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "inspection_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date inspectionDate;
	@Column(name = "open_brood")
	private Boolean openedBrood;
	@Column(name = "closed_brood")
	private Boolean closedBrood;
	@Column(name = "queen_present")
	private Boolean queenPresent;
	@Column(name = "number_of_frames")
	private int numberOfFrames;
	@Column(name = "number_of_brood_frames")
	private int numberOfBroodFrames;
	@Column(name = "is_swarm_mood")
	private Boolean swarmMood;
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

	public Boolean getOpenedBrood() {
		return openedBrood;
	}

	public void setOpenedBrood(Boolean openedBrood) {
		this.openedBrood = openedBrood;
	}

	public Boolean getClosedBrood() {
		return closedBrood;
	}

	public void setClosedBrood(Boolean closedBrood) {
		this.closedBrood = closedBrood;
	}

	public Boolean getQueenPresent() {
		return queenPresent;
	}

	public void setQueenPresent(Boolean queenPresent) {
		this.queenPresent = queenPresent;
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

	public Boolean getSwarmMood() {
		return swarmMood;
	}

	public void setSwarmMood(Boolean swarmMood) {
		this.swarmMood = swarmMood;
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
