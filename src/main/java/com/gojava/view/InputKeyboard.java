package com.gojava.view;

import java.util.Scanner;

public class InputKeyboard {
	
	private static Scanner scanner;

	private InputKeyboard() {
	}

	public static Scanner scannerInput(){
		if ( null != scanner ){
			scanner = new Scanner(System.in);
		}
		return scanner;
	}
	
	public static void cloce(){
		scanner.close();
	}
}
