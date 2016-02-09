package edu.letechno.session;

import javax.ejb.Remote;
import edu.letechno.entity.*;

@Remote
public interface IUniversitySession {

	public University AddUniversity(University e);
	public void DeleteUniversity(University e);
	public University UpdateUniversity(University e);
	
}
