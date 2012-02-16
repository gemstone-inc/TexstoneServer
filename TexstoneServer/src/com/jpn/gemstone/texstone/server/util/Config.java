package com.jpn.gemstone.texstone.server.util;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Config {
	   private static final String PROP_FILE="/config.properties";
	   
	   private static final Logger logger = Logger.getLogger(Config.class);
	   
	   public static String categoryImageDirectory;
	   
	   
	   
	   public static String apacheContextBase;
	   public static String apacheContextHttp;
 
	   
	   
	   private static void readPropertiesFile(){
	       try{
	  	     InputStream is = Config.class.getResourceAsStream(PROP_FILE);
		     Properties prop = new Properties();
	         prop.load(is);
	         apacheContextBase = prop.getProperty("apache.context.base");
	         apacheContextHttp = prop.getProperty("apache.context.http");
	         categoryImageDirectory = prop.getProperty("category.image.directory");
	         
	         is.close();
		  /* code to use values read from the file*/
	       }catch(Exception e){
	    	  logger.fatal("Failed to read from " + PROP_FILE + " file.", e);
	       }
	   }
	   
	   static {
		   readPropertiesFile();
	   }
}
