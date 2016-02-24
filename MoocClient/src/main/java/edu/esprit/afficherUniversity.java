package edu.esprit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import edu.letechno.session.IUniversitySession;
import edu.esprit.locator.Locator;
import edu.letechno.entity.University;

public class afficherUniversity extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] headers = { "id","uniName", "uniAdress", "decription" };
	List<University> universities = new ArrayList<>();

	public afficherUniversity() {
		IUniversitySession universitySession = (IUniversitySession) Locator.lookup("UniversitySession",
				IUniversitySession.class);

		universities = universitySession.getAllUniversities();
	}

	public afficherUniversity(List<University> universities) {
		super();
		this.universities = universities;
	}

	public afficherUniversity(edu.letechno.entity.University findUniversityByName) {
		// TODO Auto-generated constructor stub
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
			return universities.get(rowIndex).getUniId();
		case 1:
			return universities.get(rowIndex).getUniName();
		case 2:
			return universities.get(rowIndex).getUniAdress();
		case 3:
			return universities.get(rowIndex).getUniAdress();
		default:
			return null;
		}
	}

}
