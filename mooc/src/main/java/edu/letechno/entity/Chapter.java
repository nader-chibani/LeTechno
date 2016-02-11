package edu.letechno.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Chapter
 *
 */
@Entity

public class Chapter implements Serializable {

	
	@Id @GeneratedValue private int ChapterId;
	
	@ManyToOne
	@JoinColumn(name="Course", referencedColumnName="CourseId")
	private Courses Course;
	
	private String videoUrl;
	private String Content;
	
	@ManyToOne
	@JoinColumn(name = "TestId", referencedColumnName="TestId")
	private Test test;
	private static final long serialVersionUID = 1L;

	public Chapter() {
		super();
	}   
	public int getChapterId() {
		return this.ChapterId;
	}

	public void setChapterId(int ChapterId) {
		this.ChapterId = ChapterId;
	}   
	public Courses getCourseId() {
		return this.Course;
	}

	public void setCourseId(Courses CourseId) {
		this.Course = CourseId;
	}   
	public String getVideoUrl() {
		return this.videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}   
	public String getContent() {
		return this.Content;
	}

	public void setContent(String Content) {
		this.Content = Content;
	}
   
}
