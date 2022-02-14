public class Student {
    private String sName;
    private int sAge;
    private String sSID;
    private int sCredit;

    // default constructor..
    public Student() {
        sName = "No name given";
        sAge = 0;
        sSID = "null";
        sCredit = 0;
    }

    // constructor with 3 parameters.
    public Student(String name, int age, String id) {
        sName = name;
        sAge = age;
        sSID = id;
    }

    // setters
    public void setName(String name) {
        this.sName = name;
    }

    public void setAge(int age) {
        this.sAge = age;
    }

    public void setID(String id) {
        this.sSID = id;
    }

    public void setCredit(int credit) {
        this.sCredit = credit;
    }

    // getters
    public String getName() {
        return sName;
    }

    public int getAge() {
        return sAge;
    }

    public String getID() {
        return sSID;
    }

    public int getCredit() {
        return sCredit;
    }

     // add Credit point.
     public void addCreditPoints(int credit) {
        setCredit(credit);
    }

    // print function.
    public void printStudentData() {
        System.out.println("\nName: " + getName() + "\nAge: " + getAge() + "\nid: " + getID() + "\nCredit: " + getCredit());
    }   
}