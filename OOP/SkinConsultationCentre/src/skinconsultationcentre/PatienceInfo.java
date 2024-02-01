/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skinconsultationcentre;

import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Abubakar Mukadam
 */
public class PatienceInfo extends JFrame {

    String nDecrypt = "";

    PatienceInfo() throws FileNotFoundException, IOException {

        ArrayList<String> appointment = new ArrayList<>();
        File file = new File("ConsultationList");
        Scanner inputFile;
        //Read each line in the file and put it in an arraylist 
        try {
            if (file.exists()) {
                inputFile = new Scanner(file);
                while (inputFile.hasNext()) {
                    String dName = inputFile.nextLine();
                    String pID = inputFile.nextLine();
                    String pName = inputFile.nextLine();
                    String pDOB = inputFile.nextLine();
                    String pNum = inputFile.nextLine();
                    String aD = inputFile.nextLine();
                    String cost = inputFile.nextLine();
                    String notes = inputFile.nextLine();
                    String aTime = inputFile.nextLine();
                    char[] chars = notes.toCharArray();
                    for (char c : chars) {
                        c -= 5;
                        nDecrypt += Character.toString(c);
                    }
                    appointment.add(dName);
                    appointment.add(pID);
                    appointment.add(pName);
                    appointment.add(pDOB);
                    appointment.add(pNum);
                    appointment.add(aD);
                    appointment.add(aTime);
                    appointment.add("Cost: £" + cost);
                    appointment.add("Notes: " + nDecrypt);
                    appointment.add("-----------------------------------------");
                    nDecrypt = "";

                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        //List all information in a gui
        JList<String> displayList = new JList<>(appointment.toArray(new String[0]));
        JScrollPane scrollPane = new JScrollPane(displayList);

        getContentPane().add(scrollPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }
}
