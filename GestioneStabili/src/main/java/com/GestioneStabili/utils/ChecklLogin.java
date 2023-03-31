package com.GestioneStabili.utils;

import jakarta.servlet.http.HttpServletRequest;

public class ChecklLogin {
	

	
	public static boolean checkAdminLog(HttpServletRequest request){
		if(request.getSession().getAttribute("admin") != null)
			return true;
		return false;
	}
	
	
	public static boolean checkUserLog(HttpServletRequest request){
		if(request.getSession().getAttribute("user") != null)
			return true;
		return false;
	}
}
