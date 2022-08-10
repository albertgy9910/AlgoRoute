//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package VRPTW;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadIn {
	public int customerNr;
	public int capacity;
	public double[][] Graph;
	public Customer[] customers;

	public ReadIn() {
	}

	private double Distance(Customer C1, Customer C2) {
		return Math.sqrt((double)((C1.X - C2.X) * (C1.X - C2.X) + (C1.Y - C2.Y) * (C1.Y - C2.Y)));
	}

	public void Read(String fileName) {
		int j;
		try {
			Scanner in = new Scanner(new FileReader(fileName));
			in.next();
			this.customerNr = in.nextInt();
			this.capacity = in.nextInt();
			this.customers = new Customer[this.customerNr + 10];
			this.Graph = new double[this.customerNr + 10][this.customerNr + 10];

			for(j = 0; j < this.customerNr + 10; ++j) {
				this.customers[j] = new Customer();
			}

			for(j = 0; j <= this.customerNr; ++j) {
				this.customers[j].Number = in.nextInt();
				this.customers[j].X = in.nextInt();
				this.customers[j].Y = in.nextInt();
				this.customers[j].Demand = in.nextInt();
				this.customers[j].Begin = in.nextInt();
				this.customers[j].End = in.nextInt();
				this.customers[j].Service = in.nextInt();
			}

			in.close();
		} catch (FileNotFoundException var4) {
			System.out.println("File not found!");
			System.exit(-1);
		}

		for(int i = 0; i <= this.customerNr; ++i) {
			for(j = 0; j <= this.customerNr; ++j) {
				this.Graph[i][j] = this.Distance(this.customers[i], this.customers[j]);
			}
		}

	}
}
