package edu.letechno.session;

import java.util.List;

import javax.ejb.Remote;
import edu.letechno.entity.*;

@Remote
public interface IUniversitySession {

	public void AddUniversity(University e, User usr);
	public void DeleteUniversity(University e);
	public University UpdateUniversity(University e);
	public List<University> getUniversitiesByTrainer(User usr);
	void addTrainerToUniversity(User trainer, University university);
	void deleteTrainerFromUniversity(User trainer, University university);
	List<University> findUniversityByName(String searchedUniversity);
	
}
