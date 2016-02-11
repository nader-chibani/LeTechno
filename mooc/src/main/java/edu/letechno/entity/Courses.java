package edu.letechno.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Courses
 *
 */
@Entity

public class Courses implements Serializable {

	@Id @GeneratedValue private int CourseId;
	private String CourseName;
	@ManyToOne
	@JoinColumn(name="OwnerId", referencedColumnName="userId")
	private User  CourseOwnerID;
	private String CourseDesc;
	private double CoursePrice;
	private String CourseGoal;
	@ManyToOne
	@JoinColumn(name="UniversityId", referencedColumnName="uniId")
	private TrainerUniversity UniversityId;
	@ManyToOne
	@JoinColumn(name="categoryId", referencedColumnName="categoryId")
	private Category categoryId;
	
	private static final long serialVersionUID = 1L;

	public Courses() {
		super();
	}
	
	public Courses(int Id, String Name, User OwnerId, String Desc) {
		this.CourseId=Id;
		this.CourseName= Name;
		this.CourseOwnerID=OwnerId;
		this.CourseDesc= Desc;
	}

	
	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int courseId) {
		CourseId = courseId;
	}

	public User getCourseOwnerID() {
		return CourseOwnerID;
	}

	public void setCourseOwnerID(User courseOwnerID) {
		CourseOwnerID = courseOwnerID;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public String getCourseDesc() {
		return CourseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		CourseDesc = courseDesc;
	}
	/*****************************************/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CourseDesc == null) ? 0 : CourseDesc.hashCode());
		result = prime * result + CourseId;
		result = prime * result + ((CourseName == null) ? 0 : CourseName.hashCode());
		result = prime * result + CourseOwnerID.getUserId();
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Courses other = (Courses) obj;
		if (CourseDesc == null) {
			if (other.CourseDesc != null)
				return false;
		} else if (!CourseDesc.equals(other.CourseDesc))
			return false;
		if (CourseId != other.CourseId)
			return false;
		if (CourseName == null) {
			if (other.CourseName != null)
				return false;
		} else if (!CourseName.equals(other.CourseName))
			return false;
		if (CourseOwnerID != other.CourseOwnerID)
			return false;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		return true;
	}

	public String getCourseGoal() {
		return CourseGoal;
	}

	public void setCourseGoal(String courseGoal) {
		CourseGoal = courseGoal;
	}

	public double getCoursePrice() {
		return CoursePrice;
	}

	public void setCoursePrice(double coursePrice) {
		CoursePrice = coursePrice;
	}
   
}
