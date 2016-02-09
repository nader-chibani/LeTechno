package edu.letechno.session;

import java.util.List;
import javax.ejb.Remote;
import edu.letechno.entity.Courses;

@Remote
public interface ICourseSession {
	
	public int getCourseNumber();
	public List<Courses> getCoursesList(int owner);
	public Courses getCourseDetail(int CourseId);
	public Courses AddCourse(Courses e);
	public void DeleteCourse(Courses e);
	public void UpdateCourse(Courses e);
}
