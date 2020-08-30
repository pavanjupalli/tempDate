package com.sapientPJP20.assignment.javafiles;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class OutputScanner {
	
	
	public static void writeAction(Action action) {
		String output = null;
		output = action.getInputOne()+","+action.getInputTwo()+","+action.getOperation()+","+action.getOutput()+","+action.getSessionId()+ "\n";
		Scanner scanner = null;
		FileOutputStream stream =null;
		try {
			stream = new FileOutputStream("E:\\courses\\jsp\\demo\\src\\main\\resources\\static\\file.csv",true);
			stream.write(output.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static List<Action> readAction() {
		FileInputStream istream =null;
		List<Action> actions = new ArrayList<>();
		try {
			istream = new FileInputStream("E:\\courses\\jsp\\demo\\src\\main\\resources\\static\\file.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner scanner =  new Scanner(istream);
		while(scanner.hasNextLine()) {
			String output = scanner.nextLine();
			String[] strings = output.split(",");
			Action action = new Action(strings[0],strings[1],strings[2],strings[3],strings[4]);
			actions.add(action);
		}
		
		try {
			istream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actions;
		

	}

}
