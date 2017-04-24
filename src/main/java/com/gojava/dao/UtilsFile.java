package com.gojava.dao;

import java.io.File;
import java.io.IOException;

public class UtilsFile {
	
	
	private UtilsFile(){
	}
	
	public static File checkFile(String fileName){
		File file = new File(fileName);
		if(!file.isFile()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

}
