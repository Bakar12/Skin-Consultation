package skinconsultationcentre;

import java.io.*;
import java.util.*;

/**
 *
 * @author Abubakar Mukadam
 */
public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    public ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
    Scanner input = new Scanner(System.in);
    String firstName, surName, mN, date, medicalLicenceNumber, specialisation;

    @Override
    //Add doctor details
    public void addDoctor() {
        if (doctorList.size() < 10) {
            System.out.println("Enter Firstname: ");
            firstName = input.next();
            //Turns first letter to capital
            firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
            System.out.println("Enter Surname: ");
            surName = input.next();
            surName = surName.substring(0, 1).toUpperCase() + surName.substring(1);
            System.out.println("Enter Mobile Number: ");
            mN = input.next();
            //Make sure all the inputs are number
            if (!mN.matches("[0-9]+") || mN.length() != 11) {
                System.out.println("Invalid number");
                addDoctor();
            } else {
                System.out.println("Please enter the day of your Birthday");
                int day = input.nextInt();
                System.out.println("Please enter the month of your Birthday");
                int month = input.nextInt();
                System.out.println("Please enter the year of your Birthday");
                int year = input.nextInt();
                Date Date = new Date(day, month, year);
                //Turns date to string 
                String d = Date.toString();
                System.out.println("Enter medical licence number: ");
                medicalLicenceNumber = input.next();
                if (!medicalLicenceNumber.matches("[0-9]+") || medicalLicenceNumber.length() != 7) {
                    System.out.println("Invalid medical licence number");
                    addDoctor();
                } else {
                    System.out.println("Enter specialisation: ");
                    specialisation = input.next();
                    Doctor dr = new Doctor(firstName, surName, mN, d, medicalLicenceNumber, specialisation);
                    doctorList.add(dr);
                    System.out.println("Doctor Added");
                }
            }
        } else {
            System.out.println("Doctor List is full ");
        }
    }

    //Delete Doctor Details
    @Override
    public void deleteDoctor() {
        System.out.println("Enter medical licence number: ");
        medicalLicenceNumber = input.next();
        for (int i = 0; i < doctorList.size(); i++) {
            if (medicalLicenceNumber.equals(doctorList.get(i).medicalLicenceNumber)) {
                doctorList.remove(doctorList.get(i));
                System.out.println("Doctor Deleted");
                System.out.println("Number of Doctors: "+doctorList.size());
            }
        }
    }

    //View Doctor List
    @Override
    public void doctorList() {
        Collections.sort(doctorList, Comparator.comparing(Doctor::getSurname));
        for (int i = 0; i < doctorList.size(); i++) {
            System.out.println(doctorList.get(i).toString() + "\n");
        }
    }

    @Override
    //Save Doctor Files
    public void saveFile() {
        try {
            //Clear Doctor List
            PrintWriter writer = new PrintWriter("DoctorList");
            writer.print("");
            writer.close();
            FileWriter fw = new FileWriter("DoctorList", true);
            Writer bw = new BufferedWriter(fw);
            for (int i = 0; i < doctorList.size(); i++) {
                bw.write(doctorList.get(i).name + System.getProperty("line.separator"));
                bw.write(doctorList.get(i).surname + System.getProperty("line.separator"));
                bw.write(doctorList.get(i).mobileNumber + System.getProperty("line.separator"));
                bw.write(doctorList.get(i).dob + System.getProperty("line.separator"));
                bw.write(doctorList.get(i).medicalLicenceNumber + System.getProperty("line.separator"));
                bw.write(doctorList.get(i).specialisation + System.getProperty("line.separator"));
            }
            System.out.println("Doctor List Saved");
            bw.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    @Override
    public boolean runMenu() {
        this.loadFile();
        boolean exit = false;
        String Option = null;
        while (!"Q".equals(Option)) {
            System.out.println("To add a new doctor press A");
            System.out.println("To delete doctor press D");
            System.out.println("To view doctor list press V");
            System.out.println("To save doctor list press S");
            System.out.println("Load Doctor Table T");
            System.out.println("Book Consultation C");
            System.out.println("Load Patience Info P");
            System.out.println("Q:Quit program");
            Option = input.next();

            switch (Option.toUpperCase()) {
                case "A" ->
                    this.addDoctor();
                case "D" ->
                    this.deleteDoctor();
                case "V" ->
                    this.doctorList();
                case "S" ->
                    this.saveFile();
                case "T" ->
                    this.doctorTable();
                case "C" ->
                    this.patienceConsultation();
                case "P" ->
                    this.patienceInfo();
                case "Q" ->
                    exit = true;
                default -> {
                }
            }
        }
        return exit;
    }

    @Override
    //Load File back into the arraylist
    public void loadFile() {
        File file = new File("DoctorList");
        Scanner inputFile;

        try {
            if (file.exists()) {
                inputFile = new Scanner(file);
                while (inputFile.hasNext()) {
                    firstName = inputFile.nextLine();
                    surName = inputFile.nextLine();
                    mN = inputFile.nextLine();
                    date = inputFile.nextLine();
                    medicalLicenceNumber = inputFile.nextLine();
                    specialisation = inputFile.nextLine();
                    Doctor dr = new Doctor(firstName, surName, mN, date, medicalLicenceNumber, specialisation);
                    doctorList.add(dr);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }

    @Override
    //Doctor Tables
    public void doctorTable() {
        DoctorTable table = new DoctorTable(doctorList);
        table.setVisible(true);
    }

    @Override
    //Book Consulation
    public void patienceConsultation() {
        DoctorGui doctorGui = new DoctorGui(doctorList);
    }

    @Override
    //View Patience Info
    public void patienceInfo() {

        try {
            PatienceInfo pI = new PatienceInfo();
        } catch (IOException ex) {
        }

    }
}
