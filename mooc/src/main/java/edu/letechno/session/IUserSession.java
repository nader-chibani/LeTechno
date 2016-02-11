package edu.letechno.session;

import java.util.List;

import javax.ejb.Remote;

import edu.letechno.entity.User;

@Remote
public interface IUserSession {
	
	public void CreateUser(User usr);
	public void DropUser(User usr);
	public User login(String login, String password);
	public void logout();
	public User getUserById(int id);
	public List<User> getUserByNameAndRole(String name, String role);
	public List<User> getUserByRole(String role);
	public String validate(User usr, String code);
	public void updateUser(User usr) ;
	public void validateByCommittee(User usr);
	
}
