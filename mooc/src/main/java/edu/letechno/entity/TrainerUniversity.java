package edu.letechno.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TrainerUniversity
 *
 */
@Entity 
public class TrainerUniversity implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "uniId")
	private University uniId;
	@ManyToOne
	@JoinColumn(name = "userId")
	private User TrainerId;
	private Date AdhesionDate;
	private static final long serialVersionUID = 1L;

	
	public TrainerUniversity(University uniId, User trainerId, Date adhesionDate) {
		setUniId(uniId);
		TrainerId = trainerId;
		setAdhesionDate(adhesionDate);
	}
	public University getUniId() {
		return uniId;
	}
	public void setUniId(University uniId) {
		this.uniId = uniId;
	}
	public User getTrainerId() {
		return TrainerId;
	}
	public void setTrainerId(User trainerId) {
		TrainerId = trainerId;
	}
	public TrainerUniversity() {
		super();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	public Date getAdhesionDate() {
		return AdhesionDate;
	}
	public void setAdhesionDate(Date adhesionDate) {
		AdhesionDate = adhesionDate;
	}


	
   
}
