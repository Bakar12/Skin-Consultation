/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skinconsultationcentre;

/**
 *
 * @author Abubakar Mukadam
 */
public class Patient extends Person {

    private String patientId;

    public Patient() {
        name = "";
        surname = "";
        mobileNumber = "";
        patientId = "";
        dob = "";
    }

    public Patient(String n, String s, String m, String date, String id) {
        name = n;
        surname = s;
        mobileNumber = m;
        dob = date;
        patientId = id;

    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientId() {
        return patientId;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Patients ID: " + getPatientId() + "\nPatients name: " + getName() + " " + getSurname() + "\nPatients date of birth: " + getDOB() + "\nPatients Mobile Number: " + getMobileNumber();

    }
}
