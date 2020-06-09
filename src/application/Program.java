package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		String pathIn = "C:\\Estudos\\ws-eclipse\\exercicio183\\data\\in.txt";
		File sourceFile = new File(pathIn);
		String pathOut = sourceFile.getParent() + "\\out";

		boolean success = new File(pathOut).mkdir();
		String targetFile = pathOut + "\\summary.csv";

		List<Product> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
			String line = br.readLine();
			while (line != null) {
				String[] record = line.split(",");
				list.add(new Product(record[0], Double.parseDouble(record[1]), Integer.parseInt(record[2])));
				line = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile, false))) {
				for (Product record : list) {
					bw.write(record.toString());
					bw.newLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("End of Execution");

	}
}
