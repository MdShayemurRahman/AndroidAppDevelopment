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

		// print array data..
		for (Student S: students) {
			S.printStudentData();
		}
	}
}



