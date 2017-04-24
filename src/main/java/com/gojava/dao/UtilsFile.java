package com.gojava.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashSet;
import java.util.Set;

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
	
	public static <T> void writeFile(String fileName, Set<T> values){
		try {
			FileOutputStream fos = new FileOutputStream(checkFile(fileName));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(values);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static <T> Set<T>  readFile(String fileName){
		try {
			Set<T> result = new LinkedHashSet<>();
			FileInputStream fis = new FileInputStream(checkFile(fileName));
			ObjectInputStream oin = new ObjectInputStream(fis);
			result = (Set<T>) oin.readObject();
			oin.close();
			return result;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
