package edu.letechno.session;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.letechno.entity.*;

@Stateful
@SuppressWarnings("unchecked")
public class UserSession implements IUserSession{

	@PersistenceContext
	private EntityManager em;
	
	static User utilisateur;
	private Mail mail = new Mail();
   @Override
    public void CreateUser(User usr){
	   String code = mail.generetaCode();
	   System.out.println("je suis la");
	   usr.setStatus(code);
	   em.persist(usr);
	   if ((usr.getRole().equals("uniAdmin")) || (usr.getRole().equals("trainer")))
	   {}
	   String msg="Welcome to LeTechno to validate your account please copy paste this code to your account "+code+" Bests LeTechno Team.";
	   mail.sendMail(usr.getEmail(), msg , "Welcome To LeTechno");
    }
    
    @Override
    public User login(String login, String password){
        	
        	Query r = em.createQuery("select x from User x where x.username like :login and x.password like :password ");
        	r.setParameter("login", "%"+login+"%");
        	r.setParameter("password", "%"+password+"%");
        	User user = (User) r.getSingleResult();
        	utilisateur = null;
        	if (user.getUsername().equals(login)){
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

	@Override
	public List<User> getUserByNameAndRole(String name, String role) {
		
		Query r = em.createQuery("select x from User x where x.name LIKE :name and x.role LIKE :role "  );
    	r.setParameter("name","%"+ name +"%");
    	r.setParameter("role","%"+ role +"%");
    	List<User> user = (List<User>) r.getResultList();
    		return user;
	}

	@Override
	public List<User> getUserByRole(String role) {
		Query r = em.createQuery("select x from User x where x.role LIKE :role "  );
    	r.setParameter("role","%"+ role +"%");
    	List<User> user = (List<User>) r.getResultList();
    		return user;
	}

	@Override
	public String validate(User usrtovalidate, String Code) {
		Query r = em.createQuery("select x from User x where x.username LIKE :username ");
		r.setParameter("username","%"+ usrtovalidate.getUsername() +"%");
		User user = (User) r.getSingleResult();
		if((user.getStatus().equals(Code))){
			if((user.getRole().equalsIgnoreCase("committee"))||(user.getRole().equalsIgnoreCase("user"))||(user.getRole().equalsIgnoreCase("uniAdmin"))){
				user.setStatus("1");
				em.merge(user);
				//mail.sendMail(user.getEmail(), "Thanks for validating your account, welcome to LeTechno ;)", "Account Validated");
				return "1";	
			}else{
				user.setStatus("0");
				em.merge(user);
				//mail.sendMail(user.getEmail(), "Thanks for validating your account wait please now send us a copy of your CV attached to a mail and wait for a committee member approval for your account", "Account Validated");
				return "0";}
		}else
			return "2";
	}
	
	
	@Override
	public void validateByCommittee(User usertovalidate) {
		Query r = em.createQuery("select x from User x where x.username LIKE :username "  );
		r.setParameter("username","%"+ usertovalidate.getUsername() +"%");
		User user = (User) r.getSingleResult();
		if(user.getStatus().equals("0"))
			user.setStatus("1");
			em.merge(user);
	}
	
	@Override
	public void updateUser(User updateduser) {
		User user = em.find(User.class, updateduser.getUserId());
		 
		  user.setEmail(updateduser.getEmail());
		  user.setName(updateduser.getName());
		  user.setPassword(updateduser.getPassword());
		  em.merge(user);
		
	}
	
	public int getUserNumberByRole(String searchedrole){	
		Query r = em.createQuery( "SELECT COUNT(e) FROM Department d JOIN d.employees e GROUP BY d.name");
		r.setParameter("role","%"+ searchedrole +"%");
		int count =(int) r.getSingleResult();
		return count;
	}
}
