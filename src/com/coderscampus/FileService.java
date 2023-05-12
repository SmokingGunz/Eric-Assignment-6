package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {

	public List<Sales> getData(String fileName) throws IOException {

		List<Sales> salesList = new ArrayList<>();

		BufferedReader fileReader = null;

		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			salesList = fileReader.lines()
								  .skip(1)
					              .map(line -> {
					            	  		String[] data = line.split(",");
//					            	  		String date = data[0];
//					            	  		String sale = data[1];
					            	  		return new Sales(data[0], data[1]);
					              			})
					              .collect(Collectors.toList());
//			String line = fileReader.readLine();
//			while ((line = fileReader.readLine()) != null) {
//				String[] data = line.split(",");
//				salesList.add(new Sales(data[0], data[1]));
//			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return salesList;
	}
}
