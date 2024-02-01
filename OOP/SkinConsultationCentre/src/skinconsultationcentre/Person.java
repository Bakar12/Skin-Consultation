package skinconsultationcentre;

/**
 *
 * @author Abubakar Mukadam
 */
public class Person {

    // instance variables
    public String name;
    public String surname;
    public String mobileNumber;
    public String dob;

    //constructors
    public Person() {
        name = "";
        surname = "";
        mobileNumber = "";
        dob = null;
    }

    public Person(String n, String s, String mNumber) {
        name = n;
        surname = s;
        mobileNumber = mNumber;
    }

    //methods
    public void setName(String n) {
        name = n;
    }

    public void setSurname(String s) {
        surname = s;
    }

    public void setDOB(String dob) {
        this.dob = dob;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;

    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDOB() {
        return dob;
    }

//    public String toString() {
//        return ("The name is " + name + " and the age is " + dob.getDate());
//    }
}
