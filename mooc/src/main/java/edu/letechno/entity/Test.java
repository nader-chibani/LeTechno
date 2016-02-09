package edu.letechno.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Test
 *
 */
@Entity

public class Test implements Serializable {

	
	@Id private int TestId;
	private String TestName;
	private String Type;
	private static final long serialVersionUID = 1L;

	public Test() {
		super();
	}   
	public int getTestId() {
		return this.TestId;
	}

	public void setTestId(int TestId) {
		this.TestId = TestId;
	}   
	public String getTestName() {
		return this.TestName;
	}

	public void setTestName(String TestName) {
		this.TestName = TestName;
	}   
	public String getType() {
		return this.Type;
	}

	public void setType(String Type) {
		this.Type = Type;
	}
   
}
