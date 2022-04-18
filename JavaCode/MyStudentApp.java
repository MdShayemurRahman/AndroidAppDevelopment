import java.util.ArrayList; // import ArrayList

public class MyStudentApp {
	public static void main(String[] args) {
		// demonstrate how Address.java works inside student class.
		Student pekka = new Student("pekka", 12, "32222", 0, new Address("kuntokatu 3", "Tampere"));
		pekka.addCreditPoints(30);
		pekka.printStudentData();

		// demonstrate how trainee file extended!
		Trainee kane = new Trainee("Kane", 21, "2001041", 65, new Address("Yrttikatu 1", "Tampere"), "Nokia", 3200);
		kane.printStudentData();
		kane.jobDesc();

		// Using array in MyStudentApp
		ArrayList<Student>students = new ArrayList<>();
		students.add(new Student("Numayr", 7, "204101", 100));

		students.add(new Student("Taiyyeeb", 4, "204102", 100,
				new Address("vainamoisenkatu 11", "Tampere")));

		students.add(new Trainee("Aylaa", 2, "204103", 100,
				new Address("Yrttikatu 1", "Tampere"), "Nokia", 1200));

		students.add(new Trainee("Sami", 2, "204104", 130,
				new Address("Yrttikatu 1", "Tampere"), "Nokia", 1200));

		// how to add credit points to the third student..
		students.get(2).addCreditPoints(130); // adding Aylaa's credit to 130

		// how to change Taiyeeb's address..
		students.get(1).setAddress(new Address("Yrttikatu 1", "Tampere"));

		// how to add address for Numayr..
		students.get(0).setAddress(new Address("Yrttikatu 1", "Tampere"));

		// find aylaa is in the array List or not!
		String name = "Aylaa";
		int studentIndex = 0;
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getName().equals( name )) {
				System.out.println(name + " exist in the students list");
				students.get(i).addCreditPoints(150); // adding more credits to Aylaa..

			}
		}

		// print array data..
		for (Student S: students) {
			S.printStudentData();
		}



	}
}



