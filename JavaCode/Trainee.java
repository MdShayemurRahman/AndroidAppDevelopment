public class Trainee extends Student{
    private String sEmployer;
    private float sSalary;
    public Trainee(String name, int age, String id, int credit, Address address, String employer, float salary) {
        super(name, age, id, credit);
        sEmployer = employer;
        sSalary = salary;
    }
    // getters and setters
    public void setsEmployer(String employer){  sEmployer = employer;   }
    public void setsSalary(float salary){  sSalary = salary;   }
    public String getsEmployer() {
        return sEmployer;
    }
    public float getsSalary() { return sSalary; }

    public void jobDesc() {
        System.out.println("Trainee within a company called " + sEmployer);
    }

    @Override
    public void printStudentData() {
        super.printStudentData();
        System.out.println("Employer: " + getsEmployer());
        System.out.println("Salary: " + getsSalary());
    }
}
