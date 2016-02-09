package edu.letechno.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: University
 *
 */
@Entity

public class University implements Serializable {

	
	private int uniId;
	private String uniName;
	private String uniAdress;
	private String uniAdminId;
	
	private static final long serialVersionUID = 1L;

	public University() {
		super();
	}

	@Id
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

	public String getUniAdminId() {
		return uniAdminId;
	}

	public void setUniAdminId(String uniAdminId) {
		this.uniAdminId = uniAdminId;
	}
   
}
