package edu.letechno.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: University
 *
 */
@Entity

public class University implements Serializable {

	
	@Id @GeneratedValue private int uniId;
	private String uniName;
	private String uniAdress;
	private String Decription;
	@ManyToOne
	@JoinColumn(name="uniAdminId", referencedColumnName="userId")
	private User uniAdmin;
	
	private static final long serialVersionUID = 1L;

	public University() {
		super();
	}

	
	public String getDecription() {
		return Decription;
	}
	
	public void setDecription(String Decription) {
		this.Decription = Decription;
	}
	
	public University( String uniName, String uniAdress, String decription, User uniAdminId) {
		this.uniName = uniName;
		this.uniAdress = uniAdress;
		Decription = decription;
		this.uniAdmin = uniAdminId;
	}

	public void setid (int id){
		this.uniId = id;
	}

	public int getUniId() {
		return uniId;
	}

	public void setUniId(int uniId) {
		this.uniId = uniId;
	}

	public String getUniName() {
		return uniName;
	}

	public void setUniName(String uniName) {
		this.uniName = uniName;
	}

	public String getUniAdress() {
		return uniAdress;
	}

	public void setUniAdress(String uniAdress) {
		this.uniAdress = uniAdress;
	}

	public User getUniAdminId() {
		return uniAdmin;
	}

	public void setUniAdminId(User uniAdminId) {
		this.uniAdmin = uniAdminId;
	}
   
}
