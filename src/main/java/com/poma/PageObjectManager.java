package com.poma;

import com.base.BaseClass;
import com.pom.LoginPage;

public class PageObjectManager extends BaseClass{

	private LoginPage lp;
	
	public LoginPage getLp() {
		if(lp==null) {
			lp = new LoginPage(driver);
		}
		
		return lp;
	}

	
}
