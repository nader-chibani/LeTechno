package edu.letechno.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Question
 *
 */
@Entity

public class Question implements Serializable {

	@Id private int QstId;
	@ManyToOne
	@JoinColumn(name = "TestId")
	private Test test;
	private String question;
	private String indication;
	private static final long serialVersionUID = 1L;

	public Question() {
		super();
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getIndication() {
		return indication;
	}

	public void setIndication(String indication) {
		this.indication = indication;
	}
   
}
