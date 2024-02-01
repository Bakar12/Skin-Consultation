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
public class Doctor extends Person {

    public String medicalLicenceNumber;
    public String specialisation;
   
    public Doctor() {
        name = "";
        surname = "";
        mobileNumber = "";
        dob = "";
        medicalLicenceNumber = "";
        specialisation = "";
    }

    public Doctor(String n, String s, String m, String date, String mLN, String sP) {
        name = n;
        surname = s;
        mobileNumber = m;
        dob = date;
        medicalLicenceNumber = mLN;
        specialisation = sP;
    }

    //methods
    public void setSpecialisation(String s) {
        this.specialisation = s;
    }

    public void setMedicalLicenceNumber(String mln) {
        this.medicalLicenceNumber = mln;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public String getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }

    @Override
    public String toString() {
        return "Doctors name: " + name + " " + surname + "\nDoctor mobile number: " + mobileNumber + "\nDate of birth " + dob + "\nSpecialisation: " + specialisation + "\nMedical Licence Number: " + medicalLicenceNumber;

    }
}
