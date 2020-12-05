package com.demo.coronavirus.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CasesHelper {
	
	private Object[][] googleArray;
	
	public Object[][] getGoogleArray() {
		return googleArray;
	}
	public void setGoogleArray(Object[][] googleArray) {
		this.googleArray = googleArray;
	}

	public void defineGoogleArray(List<Case> cases) 
    { 
		
		int googleArraySize = cases.size();
		final Object[][] formattedGoogleArray = new Object[googleArraySize][2];
		DateFormat formatter = new SimpleDateFormat("dd/MM/YY");
		formattedGoogleArray[0][0] = "{label: 'Date', type: 'string'}";
		formattedGoogleArray[0][1] = " {label: 'Cases', type: 'number'}";
		
		for(int i = 1; i < googleArraySize; i++) {
			Date dateToFormat = cases.get(i).getDate();
			formattedGoogleArray[i][0] = "'" + formatter.format(dateToFormat) + "'";		
			formattedGoogleArray[i][1] = cases.get(i).getCases();
		}
		
		googleArray = formattedGoogleArray;

    }

}
