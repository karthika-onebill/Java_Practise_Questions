import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class Candidate_Info {

	String c_name;
	int c_age;
	char c_gender;
	String c_jobrole;
	int c_exp;

	public Candidate_Info(String c_name, int c_age, char c_gender, String c_jobrole, int c_exp) {
		super();
		this.c_name = c_name;
		this.c_age = c_age;
		this.c_gender = c_gender;
		this.c_jobrole = c_jobrole;
		this.c_exp = c_exp;
	}

	@Override
	public String toString() {
		return "Candidate_Info [c_name=" + c_name + ", c_age=" + c_age + ", c_gender=" + c_gender + ", c_jobrole="
				+ c_jobrole + ", c_exp=" + c_exp + "]";
	}

}

class Candidate_Input {
	public void input(Set<Candidate_Info> obj, Scanner sc) {
		System.out.println("Enter name : ");
		String name = sc.next();
		System.out.println("Enter age : ");
		int age = sc.nextInt();
		System.out.println("Enter gender : (M|F)");
		char gen = sc.next().charAt(0);
		System.out.println("Enter Jobrole :");
		String jobrole = sc.next();
		System.out.println("Enter experience : ");
		int exp = sc.nextInt();
		obj.add(new Candidate_Info(name, age, gen, jobrole, exp));

	}
}

class Company_Info {
	String co_name;
	String co_type;
	String co_location;
	int co_package;
	String co_jobrole;
	int co_exp;

	public Company_Info(String co_name, String co_type, String co_location, int co_package, String co_jobrole,
			int co_exp) {
		super();
		this.co_name = co_name;
		this.co_type = co_type;
		this.co_location = co_location;
		this.co_package = co_package;
		this.co_jobrole = co_jobrole;
		this.co_exp = co_exp;
	}

	@Override
	public String toString() {
		return "Company_Info [co_name=" + co_name + ", co_type=" + co_type + ", co_location=" + co_location
				+ ", co_package=" + co_package + ", co_jobrole=" + co_jobrole + ", co_exp=" + co_exp + "]";
	}

}

class Company_Input {
	public void input(Set<Company_Info> obj, Scanner sc) {
		System.out.println("Enter company name : ");
		String cname = sc.nextLine();
		System.out.println("Enter company type : ");
		String ctype = sc.next();
		System.out.println("Enter company location : ");
		String clocation = sc.next();
		System.out.println("Enter the salary package : ");
		int csalary = sc.nextInt();
		System.out.println("Enter the Job role : ");
		String cjobrole = sc.next();
		System.out.println("Enter the experience needed for job : ");
		int cexp = sc.nextInt();
		obj.add(new Company_Info(cname, ctype, clocation, csalary, cjobrole, cexp));

	}
}

public class Main {

	public static void main(String[] args) {
		int exit = 1;

		Set<Candidate_Info> obj = new HashSet<Candidate_Info>();
		Set<Company_Info> obj1 = new HashSet<Company_Info>();
		int c_id = 1000;
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------------------------------------");
		System.out.println("\t\tWELCOME TO JOB PORTAL\t");

		System.out.println("---------------------------------------------------");
		while (exit != 0) {
			System.out.println(
					"1 : Job Seeker(Candidate)\n2 : Job Provider(Company)\n3 : Display Eligible CandidateList\n4 : Exit\n\nEnter the choice:");
			int ch = sc.nextInt();
			switch (ch) {
			case 1: // candidate
				c_id++;
				Candidate_Input in = new Candidate_Input();
				in.input(obj, sc);
				break;
			case 2: // company
				Company_Input inc = new Company_Input();
				inc.input(obj1, sc);
				break;
			case 3: // Display eligible candidates
				ArrayList<Candidate_Info> l1 = new ArrayList<Candidate_Info>(obj);
				ArrayList<Company_Info> l2 = new ArrayList<Company_Info>(obj1);
				for (int i = 0; i < l1.size(); i++) {
					String c = l1.get(i).c_jobrole;
					for (int j = 0; j < l2.size(); j++) {
						String co = l2.get(j).co_jobrole;
						if (c.equalsIgnoreCase(co)) {

							System.out.println("-------------------------------------------------");
							System.out.println("Candidate Name : " + l1.get(i).c_name);
							System.out.println("Candidate Age : " + l1.get(i).c_age);
							System.out.println("Candidate Gender : " + l1.get(i).c_gender);
							System.out.println("Candidate JobRole : " + l1.get(i).c_jobrole);
							System.out.println("Candidate Experience : " + l1.get(i).c_exp);
							System.out.println("Company Name : " + l2.get(j).co_name);
							System.out.println("Comapny Location : " + l2.get(j).co_location);
							System.out.println("-------------------------------------------------");
						} else {
							System.out.println("--------No one eligible----------------------");
						}
					}
				}

				break;
			case 4: // exit
				exit = 0;
				System.out.println("-------------thank you-----------------");
				break;
			default: // exception
			}
		}
	}

}
