package edu.letechno.session;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.letechno.entity.*;

@Stateful
@LocalBean
public class UserSession implements IUserSession{

	@PersistenceContext
	private EntityManager em;
	
	static User utilisateur;
   @Override
    public void CreateUser(User usr){
    	em.persist(usr);
    }
    
    @Override
    public User login(String login, String password){
    	
    	Query r = em.createQuery("select x from user x where username =: login and password =: password ");
    	r.setParameter("login", login);
    	r.setParameter("password", password);
    	User user = (User) r.getSingleResult();
    	utilisateur = null;
    	if (user.getName().equals(login)){
    		utilisateur = user;
    	}
    	return utilisateur;
    }
    
    
    @Override
    public User getUserById(int id){
    	
    	Query r = em.createQuery("select x from user x where userid =: id ");
    	r.setParameter("id", id);
    	User user = (User) r.getSingleResult();
    		return user;
    }

	@Override
	public void DropUser(User usr) {
		em.remove(usr);
		
	}

	@Override
	public void logout() {
		utilisateur = null;
		
	}
    
    

}
