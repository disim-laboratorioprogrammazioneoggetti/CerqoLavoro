package it.univaq.disim.oop.cerqolavoro.business.impl.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import it.univaq.disim.oop.cerqolavoro.business.impl.file.FileData;
import it.univaq.disim.oop.cerqolavoro.domain.Worker;

public class Utility {
	
	public static String readPass(String profile, String password) throws IOException {
	//	FileData result = new FileData();
		String result = null;
		try {
			FileReader read = new FileReader(profile);
			String line = Files.readAllLines(Paths.get(profile)).get(0);	
			read.close();
			if (line.equals(password)) {
				result = "ok";
		    }
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
		
}
