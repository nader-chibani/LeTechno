package edu.letechno.session;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.letechno.entity.TrainerUniversity;
import edu.letechno.entity.University;
import edu.letechno.entity.User;

/**
 * Session Bean implementation class UniversitySession
 */
@Stateless
@SuppressWarnings("unchecked")
public class UniversitySession implements IUniversitySession{

    
	@PersistenceContext
	private EntityManager em;
   
    public UniversitySession() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void AddUniversity(University e, User usr) {
		em.persist(usr);
		em.persist(e);
	}

	@Override
	public void  DeleteUniversity(University e) {
		em.remove(e);
	}

	@Override
	public University UpdateUniversity(University updateduniversity) {
		University univ = em.find(University.class, updateduniversity.getUniId());
		 
		  univ.setDecription(updateduniversity.getDecription());
		  univ.setUniAdress(updateduniversity.getUniAdress());
		  univ.setUniName(updateduniversity.getUniName());
		  em.merge(univ);
		  return updateduniversity;
		  
	}

	@Override
	public List<University> getUniversitiesByTrainer(User trainer) {
		Query r = em.createQuery("select x from University x, TrainerUniversity T where T.userId =: aa and x.uniId=T.uniId ");
		r.setParameter("aa", trainer.getUserId());
		List<University> universities = (List<University>) r.getResultList();
		return universities;
	}
	
	@Override
	public void addTrainerToUniversity(User trainer, University university) {
		Date date = new Date();
		TrainerUniversity newtrainer = new TrainerUniversity(university, trainer, date);
		em.persist(newtrainer);
	}
	
	@Override
	public void deleteTrainerFromUniversity(User trainer, University university) {
		Query r = em.createQuery("select T from TrainerUniversity T where T.Trainer =:trainer and T.uniId=:university ");
		//Query r = em.createQuery("delete from TrainerUniversity where Trainer =:trainer and unId =:university");
		r.setParameter("trainer", trainer);
		r.setParameter("university", university);
		List<TrainerUniversity> trainers = (List<TrainerUniversity>) r.getResultList();
		if (trainers.size() > 0)
		for (int i=0; i < trainers.size() ; i++){
			em.remove(trainers.get(i));
		}
	}
	
	
	@Override
	public List<University> findUniversityByName(String searchedUniversity) {
		Query r = em.createQuery("select T from University T where T.uniName like :searchedUniversity ");
		//Query r = em.createQuery("delete from TrainerUniversity where Trainer =:trainer and unId =:university");
		r.setParameter("university", "%"+ searchedUniversity +"%");
		List<University> searchedUniversities = (List<University>) r.getResultList();
		return searchedUniversities;
	}

}
