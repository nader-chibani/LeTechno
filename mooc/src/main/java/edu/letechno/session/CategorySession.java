package edu.letechno.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.letechno.entity.Category;

/**
 * Session Bean implementation class CategorySession
 */
@Stateless
public class CategorySession implements ICategorySession{

	@PersistenceContext
	private EntityManager em;
	
	
    public CategorySession() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addCategory(Category newcategory) {
		em.persist(newcategory);
		
	}

	@Override
	public void deleteCategory(Category category) {
		em.remove(category);
		
	}

}
