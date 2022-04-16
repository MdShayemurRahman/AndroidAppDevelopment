public class Address {
    private String sStreet;
    private String sCity;

    public Address(String street, String city) {
        sStreet = street;
        sCity = city;
    }

    // setter and getter.
    public void setStreet(String street) {
        sStreet = street;
    }
    public void setCity(String city) {
        sCity = city;
    }

    public String getStreet() {
        return sStreet;
    }
    public String getCity() {
        return sCity;
    }
    
    // print street and city
    public void printAddress() {
        System.out.println(getStreet() + ", " + getCity());

    }
}