package com.thecafeprogrammer.java8;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter in a path for a text file.");
		String userInput;
		try {
			userInput = br.readLine();
			FileSelector selectFile = new FileSelector(userInput);
			FileManipulator streamFile = new FileManipulator();
			File temp = selectFile.getSelectedFile();
			String filePath = temp.getPath();
			streamFile.readFile(filePath);
			streamFile.readFileInReverse(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br.close();
		


	}

}
