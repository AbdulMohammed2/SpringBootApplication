package com.example.hello;

import org.springframework.beans.factory.annotation.Value;

public final class ClassicSingleton {
	   private static ClassicSingleton instance = null;
	   private ClassicSingleton(String prop) {
	      // Exists only to defeat instantiation.
		   System.out.println("My singleton class constructor"+prop); 
	   }
	   public static ClassicSingleton getInstance(String prop) {
	      if(instance == null) {
	         instance = new ClassicSingleton(prop);
	      }
	      return instance;
	   }
	   
	   //@Value("${mycustom}")
	   //private String prop;
	   
	   
	   
	   
	//public void initialize()
	   //{
		  // 
		//System.out.println("My singleton class constructor"+prop);
		//this.prop=prop;
	   //}
	}

