package edu.letechno.session;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import edu.letechno.entity.Courses;

/**
 * Session Bean implementation class CourseSession
 */
@Stateless
@LocalBean
public class CourseSession implements ICourseSession{

	@PersistenceContext
	private EntityManager em;

	
	public CourseSession() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int getCourseNumber() {
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Courses> getCoursesList(int owner) {
		
		List<Courses> CoursesList;
		Query r = null;
			if (owner == 0)
				if(UserSession.utilisateur.getRole().equals("admin"))
					r = em.createQuery("select x from courses x");
			else
				if (UserSession.utilisateur.getUserId() == owner)
					r = em.createQuery("select x from courses x where x.courseOwnerID =: owner ");
			
		    	r.setParameter("owner", owner);
		    	CoursesList = (List<Courses>) r.getResultList();	
		    	return CoursesList;
	}

	@Override
	public Courses AddCourse(Courses e) {
		if(UserSession.utilisateur.getRole().equals("trainer") && (UserSession.utilisateur != null))
			em.persist(e);
		else
			e = null;
		return e;
	}

	@Override
	public void DeleteCourse(Courses e) {
		em.remove(e);
		
	}

	@Override
	public void UpdateCourse(Courses e) {
		Courses Cours = em.find(Courses.class, e.getCourseId());
		 
		  em.getTransaction().begin();
		  Cours.setCourseDesc(e.getCourseDesc());
		  Cours.setCourseName(e.getCourseName());
		  em.getTransaction().commit();
	}

	@Override
	public Courses getCourseDetail(int CourseId) {
		Query r = em.createQuery("select x from courses x where courseid =: id ");
    	r.setParameter("id", CourseId);
    	Courses course = (Courses) r.getSingleResult();
		return course;
	}

}
