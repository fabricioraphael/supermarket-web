package br.com.faber.util;

public class StringUtil {

	private StringUtil(){
	}
	//  java Session  --  servletFilter
	public static boolean isNotNull(Object arg){
		try {
			String s = (String) arg;
			
			if (s == null || s.trim().equals("")){
				return false;
			}
			return true;
			
		} catch (Exception e) {
			try {
				Integer i = (Integer) arg;
				
				if (i == null || i.toString().equals("")){
					return false;
				}
				return true;
			} catch (Exception e2) {
				System.out.println("\nDEU MERDA AQUI NO StringUtil!! try 2\n");
			}
			System.out.println("\nDEU MERDA AQUI NO StringUtil!! try 1\n");
			return false;
		}
	}
	
}
