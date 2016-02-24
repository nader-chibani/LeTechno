package edu.esprit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import edu.letechno.session.ICategorySession;
import edu.esprit.locator.Locator;
import edu.letechno.entity.Category;

public class afficherCategories extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] headers = { "id","Category" };
	List<Category> categories = new ArrayList<>();

	public afficherCategories() {
		ICategorySession categorySession = (ICategorySession) Locator.lookup("CategorySession",
				ICategorySession.class);

		categories = categorySession.getCategories();
	}

	public afficherCategories(List<Category> categories) {
		super();
		this.categories = categories;
	}

	public afficherCategories(edu.letechno.entity.University findUniversityByName) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getRowCount() {
		return categories.size();
	}

	@Override
	public int getColumnCount() {
		return headers.length;
	}

	@Override
	public String getColumnName(int i) {
		return headers[i];
	}

	@Override
	public Object getValueAt(int rowIndex, int colmunIndex) {
		switch (colmunIndex) {
		case 0:
			return categories.get(rowIndex).getCategoryId();
		case 1:
			return categories.get(rowIndex).getCategoryName();
		default:
			return null;
		}
	}

}
