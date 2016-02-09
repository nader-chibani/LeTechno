package edu.letechno.session;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.letechno.entity.University;
import edu.letechno.entity.User;

/**
 * Session Bean implementation class UniversitySession
 */
@Stateless
@LocalBean
public class UniversitySession implements IUniversitySession{

    
	@PersistenceContext
	private EntityManager em;
	public University university;
   
    public UniversitySession() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public University AddUniversity(University e) {
		em.persist(e);
		return e;
	}

	@Override
	public void  DeleteUniversity(University e) {
		em.remove(e);
	}

	@Override
	public University UpdateUniversity(University e) {
		return e;
	}

}
