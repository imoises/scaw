package ar.edu.unlam.scaw.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;


public class Util {
	public static String encryptThisString(String input) { 
		try { 
			MessageDigest md = MessageDigest.getInstance("SHA-512");
		    md.update(input.getBytes());
		    byte byteData[] = md.digest();

		    String hashCodeBuffer = (new BASE64Encoder()).encode(byteData);
		    return hashCodeBuffer.toString();
		    
		} catch (NoSuchAlgorithmException e) { 
			throw new RuntimeException(e); 
		} 
	 } 
	public static void main(String[] args) {
		
		String pass = "1234";
		System.out.println(pass);
		String passHash = encryptThisString(pass);
		System.out.println(passHash);
		
		
		
	}
	 
}
