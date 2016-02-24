package edu.esprit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import edu.letechno.session.IUserSession;
import edu.esprit.locator.Locator;
import edu.letechno.entity.User;

public class afficherUsers extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] headers = { "id","Name", "Username", "Email", "Status" };
	List<User> universities = new ArrayList<>();

	public afficherUsers(String role) {
		IUserSession universitySession = (IUserSession) Locator.lookup("UserSession",IUserSession.class);

		universities = universitySession.getUserByRole(role);
	}

	public afficherUsers(List<User> universities) {
		super();
		this.universities = universities;
	}

	@Override
	public int getRowCount() {
		return universities.size();
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
			return universities.get(rowIndex).getUserId();
		case 1:
			return universities.get(rowIndex).getName();
		case 2:
			return universities.get(rowIndex).getUsername();
		case 3:
			return universities.get(rowIndex).getEmail();
		case 4:
			return universities.get(rowIndex).getStatus();
		default:
			return null;
		}
	}

}
