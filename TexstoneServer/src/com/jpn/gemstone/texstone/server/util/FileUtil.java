package com.jpn.gemstone.texstone.server.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

public class FileUtil {
	
	public static final String BACK_SLASH = "/";
	
	
	//here we are deleting the file that is mentioned in the database.
	public static Pair<String, Long> moveFile(File srcFile, String fileExtension, String destDir) throws IOException{
		
		File storageDir = new File(Config.apacheContextBase+destDir);
        if(storageDir.exists() == false){
        	storageDir.mkdirs();
        }
        
        File destFile = new File(storageDir, "SAVED_AT_"+DateUtil.getTimeBasedFileName()+"."+fileExtension);
        
        
		FileUtils.copyFile(srcFile, destFile);
		//TODO check if there is any problem in deleting the srcFile?
		srcFile.delete();
		
		String filePath = destDir + BACK_SLASH + destFile.getName();
		Long fileSize = destFile.length();
		Pair<String, Long> ret = new Pair<String, Long>(filePath, fileSize);
		return ret;
	}
	
	
	//here we are deleting the file that is mentioned in the database as well as the source file
	public static Pair<String, Long> moveFile(String srcFilePath, String destPrevFilePath, String destDir) throws IOException{
		
		File srcFile = new File(Config.apacheContextBase+srcFilePath);
        
		File storageDir = new File(Config.apacheContextBase+destDir);
        if(storageDir.exists() == false){
        	storageDir.mkdirs();
        }
        
        File destFile = new File(storageDir, srcFile.getName());
        if(!StringUtils.isEmpty(destPrevFilePath)){
        	File rmFile = new File(Config.apacheContextBase+destPrevFilePath);
        	if(rmFile.exists()){
        		rmFile.delete();
        	}
        }
        
		FileUtils.copyFile(srcFile, destFile);
		srcFile.delete();
		
		String filePath = destDir + BACK_SLASH + destFile.getName();
		Long fileSize = destFile.length();
		Pair<String, Long> ret = new Pair<String, Long>(filePath, fileSize);
		return ret;
	}
	
	
	
	
	public static void deleteFile(String imagePath){
        if(!StringUtils.isEmpty(imagePath)){
        	File rmFile = new File(Config.apacheContextBase+imagePath);
        	if(rmFile.exists()){
        		rmFile.delete();
        	}
        }
	}
	
	
}
