package com.thecafeprogrammer.java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


public class FileProcessor implements FileOutput {

	public FileProcessor()
	{
		
	}
	
	@Override
	public void writeFile(BufferedReader br) 
	{
		try
		{
			PrintWriter writer = new PrintWriter("out.txt", "UTF-8");
			String line;
			while ((line = br.readLine()) != null){
				writer.println(line);
			}
			br.close();
			writer.close();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
