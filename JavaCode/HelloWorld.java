public class HelloWorld {
	public static void main(String args[]) {
		Student sayem = new Student("Sayem", 21, "2004101");
		sayem.addCreditPoints(5);
		sayem.printStudentData();
		
		Student hanry = new Student("Hanry", 21, "2004120");
		hanry.printStudentData();
	}
}