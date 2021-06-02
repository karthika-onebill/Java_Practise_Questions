package com.onebill.module1;

import java.util.Scanner;

class Display {

	public static void toDisplayScore(int c_ans, int n_attempts, String name, int w_ans) {
		// display
		String comments = "";
		if (c_ans == 5 && n_attempts == 5)
			comments = "Excellent";
		if (c_ans == 4)
			comments = "Very Good";
		if (c_ans == 3)
			comments = "Good";
		if (c_ans == 2 || c_ans == 1)
			comments = "Poor";
		if (c_ans == 0 || n_attempts == 0)
			comments = "Very Poor";
		int score = (c_ans * 100) / 5;
		System.out.println("\n\n-------------------------------------------------");
		System.out.println("\n\t\tThank you for partcipating\t\t");
		System.out.println("\n-----------------------------------------------------");
		System.out.println("\n Name\t:\t" + name);
		System.out.println("\n No of Qns attempt: " + n_attempts);
		System.out.println("\n No of Qns correct: " + c_ans);
		System.out.println("\n No of Qns wrong  : " + w_ans);
		
		System.out.println("--------------------------------------------------------");
		System.out.println("\n Your Total Score : " + score + " %"+"   "+comments);

		System.out.println("--------------------------------------------------------");
		if (score > 65) {
			System.out.println("---------->>> Congratulations!!!>>>>-------------");
			System.out.println("\t You are pormoted to next round!\t");
		}
		if (score <= 65) {
			System.out.println("---------->>> Oops!! Sorry!>>>>-------------");
			System.out.println("\t You are not pormoted to next round!\t");
		}

	}
}

public class Main {
	static Scanner sc = null;

	public static void main(String[] args) throws Throwable {
		// 20qns - 5options
		try {
			String name;
			String[] qns = new String[5];
			qns[0] = "What is color of carrot? ";
			qns[1] = "which place is called capital of India?";
			qns[2] = "who is our chief ministre?";
			qns[3] = "Who is our prime minister? ";
			qns[4] = "Which one is our national bird?";

			String[][] options = new String[5][];
			options[0] = new String[] { "White", "Orange", "Red", "Black", "Yellow" };
			options[1] = new String[] { "Mumbai", "Chennai", "Hydrabath", "Pakisthan", "Delhi" };
			options[2] = new String[] { "Mr.Edurappa", "Mr.M.K.Stalin", "Ms.Mumtha Banarji", "Ms.Jayalalitha" };
			options[3] = new String[] { "Mr.Modi", "Mrs.Gandhi", "Mr.Stalin", "Mr.Drump" };
			options[4] = new String[] { "Peacock", "Crow", "sparrow", "parrot" };

			int[] ans = new int[] { 2, 5, 2, 1, 1 };
			int[] skip = new int[] { -1, -1, -1, -1, -1 };
			int c_ans = 0;
			int w_ans = 0;
			int n_attempts = 0;
			sc = new Scanner(System.in);
			System.err.println("--------------APPTITUDE TEST------------------\n");
			System.out.println(" Enter your name : ");
			name = sc.next();
			for (int i = 0; i < 5; i++) {

				System.out.println("Qn : " + (i + 1) + " " + qns[i]);
				int j;
				for (j = 0; j < options[i].length; j++) {
					System.out.print((j + 1) + ") " + options[i][j] + "\t");
				}
				System.out.println("\n\n");
				System.out.println(" --->PRESS : 1- CONTINUE" + "  " + "2- SKIP<----\n");
				int ch = sc.nextInt();
				switch (ch) {
				case 1: // continue
					n_attempts++;
					System.out.println("Enter your options : ");
					int choice = sc.nextInt();
					if (choice == ans[i]) {
						c_ans++;
					} else {
						w_ans++;
					}
					break;
				case 2: // skip
					skip[i] = i;
					continue;
				default:
					try {
						i = i - 1;
						throw new Custom_Exception("Please Give valid choices!\n");

					} catch (Custom_Exception e) {
						System.err.println(e.getMessage());
					}
					break;
				}

			}
           if(n_attempts<5) {
			System.out.println("Do you want to answer skipping questions ?\n[0: YES\t1: NO] ");
			int skip_ch = sc.nextInt();
			switch (skip_ch) {
			case 0: // YES
				for (int i = 0; i < skip.length; i++) {
					if (skip[i] != -1) {

						System.out.println("Qn : " + (skip[i]) + " " + qns[skip[i]]);
						int j;
						for (j = 0; j < options[skip[i]].length; j++) {
							System.out.print((j + 1) + ") " + options[skip[i]][j] + "\t");
						}
						System.out.println("\n\n");
						System.out.println(" --->PRESS : 1- CONTINUE" + "  " + "2- SKIP<----\n");
						int ch = sc.nextInt();
						switch (ch) {
						case 1: // continue
							n_attempts++;
							System.out.println("Enter your options : ");
							int choice = sc.nextInt();
							if (choice == ans[i]) {
								c_ans++;
							} else {
								w_ans++;
							}
							break;
						case 2: // skip

							continue;

						}

					}
				}
				Display.toDisplayScore(c_ans, n_attempts, name, w_ans);
				break;
			case 1: // NO
				Display.toDisplayScore(c_ans, n_attempts, name, w_ans);

				break;

			}}
           else {
        	   Display.toDisplayScore(c_ans, n_attempts, name, w_ans);
           }
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (sc != null) {
				sc.close();
			}
			Main m = new Main();
			m.finalize();

		}
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("\n\n\n\n\n----------Application Closed--------------");
	}

}
