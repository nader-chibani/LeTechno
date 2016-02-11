package edu.letechno.session;

import javax.ejb.Remote;

import edu.letechno.entity.Category;

@Remote
public interface ICategorySession {
	public void addCategory(Category newcategory);
	public void deleteCategory(Category category);
}
