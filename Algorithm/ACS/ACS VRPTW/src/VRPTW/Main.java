package VRPTW;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Main {
	public static void main (String arg[]) throws IOException {

//		File f = new File("../out.txt");
//		f.createNewFile();
//		FileOutputStream fileOutputStream = new FileOutputStream(f);
//		PrintStream printStream = new PrintStream(fileOutputStream);
//		System.setOut(printStream);

		long begintime = System.nanoTime();	// ???????????
		
		Parameter parameter = new Parameter();
		ReadIn readIn = new ReadIn();
		readIn.Read("R101.txt");
		
		System.out.println("waiting for a while ... ...");
		AntColonySystem ACS = new AntColonySystem(parameter, readIn); 
		Solution bestSolution = ACS.ACS_Strategy();
		
		Print print = new Print(bestSolution, readIn);
		print.Output();
		print.CheckAns();
		
	    long endtime = System.nanoTime();
		double usedTime= (endtime - begintime)/(1e9);
		System.out.println();
		System.out.println("Total run time ??"+usedTime+"s");
	}
}
