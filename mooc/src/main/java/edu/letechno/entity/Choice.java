package edu.letechno.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Choice
 *
 */
@Entity

public class Choice implements Serializable {

	@Id private int ChoiceId;
	@ManyToOne
	@JoinColumn(name = "QstId")
	private Question question;
	private String Choice;
	private static final long serialVersionUID = 1L;

	public Choice() {
		super();
	}

	public Choice(int choiceId, Question question, String choice) {
		ChoiceId = choiceId;
		this.question = question;
		Choice = choice;
	}

	public int getChoiceId() {
		return ChoiceId;
	}

	public void setChoiceId(int choiceId) {
		ChoiceId = choiceId;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getChoice() {
		return Choice;
	}

	public void setChoice(String choice) {
		Choice = choice;
	}

	   
}
