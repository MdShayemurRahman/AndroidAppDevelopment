public class Student {
    private String sName;
    private int sAge;
    private String sSID;
    private int sCredit;
    private Address sAddress = null;

    // default constructor..
    public Student() {
        sName = "";
        sAge = 0;
        sSID = "xxxix";
        sCredit = 0;
    }

    // constructor with 3 parameters.
    public Student(String name, int age, String id, int credit) {
        sName = name;
        sAge = age;
        sSID = id;
        sCredit = credit;
    }

    public Student(String name, int age, String id, int credit, Address address) {
        sName = name;
        sAge = age;
        sSID = id;
        sCredit = credit;
        sAddress = address;
    }


    // setters
    public void setAddress(Address address) { this.sAddress = address; }
    public void setName(String name) { this.sName = name; }
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
    public Address getAddress() { return sAddress; }
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
        System.out.println(
                "\nName: " + getName() + "\nAge: " + getAge() 
                + "\nid: " + getID() + "\nCredit: " + getCredit());

        if(sAddress != null) {
            sAddress.printAddress();
        }

    }
}