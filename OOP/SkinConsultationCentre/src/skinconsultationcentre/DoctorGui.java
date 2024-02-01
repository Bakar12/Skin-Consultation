/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skinconsultationcentre;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author Abubakar Mukadam
 */
public class DoctorGui extends JFrame implements ActionListener {

    char[] noteEncry;

    JLabel cTitle, firstNameLabel, surnameLabel, mobileNumberLabel, eBirthDayLabel,
            bDayLabel, bMonthLabel, bYearLabel, selectDoctorLabel, AppointmentLabel,
            dayLabel, monthLabel, yearLabel, timeLabel, hourLabel, minLabel, l17,
            Fcost, Ocost, notesLabel, imageLabel;  //all labels for textField
    JTextField fNametf, sNametf, mNumbertf;   // others fields
    JButton submit, clear, yCostButton, nCostButton;  //buttons for signup and clear
    JComboBox<Integer> hourBox, minuteBox, dayBox, monthBox, yearBox, adayBox, amonthBox, ayearBox;
    JComboBox<String> dN;
    JTextArea notes;
    ArrayList<Consultation> consultationList = new ArrayList<>();
    LocalDate currentdate = LocalDate.now();
    int currentYear = currentdate.getYear();
    int currentMonth = currentdate.getMonthValue();
    int currentDay = currentdate.getDayOfMonth();
    int h = 8;
    int min = 0;
    int cost = 0;
    int q = 0;

    ArrayList<Doctor> list;
    ArrayList<Consultation> cList;
    String dName;
    Integer[] day = new Integer[31];
    Integer[] month = new Integer[12];
    Integer[] year = new Integer[currentYear - 1950];
    Integer[] aYear = new Integer[74];
    Integer[] aMonth = new Integer[13];
    Integer[] aDay = new Integer[32];
    String[] choices = {"", "", "", "", "", "", "", "", "", ""};
    Integer[] hour = new Integer[12];
    Integer[] minute = new Integer[2];

    DoctorGui(ArrayList<Doctor> doctorList) {

        list = doctorList;
        for (int i = 0; i < 31; i++) {
            day[i] = (i + 1);
        }
        for (int i = 0; i < 12; i++) {
            month[i] = (i + 1);
        }
        for (int i = 0; i < (currentYear - 1950); i++) {
            year[i] = 1950 + i;
        }
        for (int i = 0; i < 74; i++) {
            aYear[i] = currentYear + i;
        }
        for (int i = 0; i < 13 - currentMonth; i++) {
            aMonth[i] = currentMonth + i;
        }
        for (int i = 0; i < 32 - currentDay; i++) {
            aDay[i] = currentDay + i;
        }
        for (int i = 0; i < doctorList.size(); i++) {
            choices[i] = (doctorList.get(i).name + " " + doctorList.get(i).surname);
        }
        for (int i = 0; i < 2; i++) {
            minute[i] = (min);
            min = 30;
        }
        for (int i = 0; i < 12; i++) {
            hour[i] = (h);
            h = h + 1;
        }

        setVisible(true);
        setSize(1000, 1000);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Consultation");
        cTitle = new JLabel("Consultation Booked:");
        cTitle.setForeground(Color.blue);
        cTitle.setFont(new Font("Serif", Font.BOLD, 20));
        firstNameLabel = new JLabel("Firstname:");
        surnameLabel = new JLabel("Surname:");
        mobileNumberLabel = new JLabel("Mobile Numer:");
        eBirthDayLabel = new JLabel("Enter the Day of your Birth:");
        bDayLabel = new JLabel("Day:");
        bMonthLabel = new JLabel("Month:");
        bYearLabel = new JLabel("Year:");
        selectDoctorLabel = new JLabel("Select Doctor :");
        AppointmentLabel = new JLabel("Appointment Date:");
        dayLabel = new JLabel("Day:");
        monthLabel = new JLabel("Month:");
        yearLabel = new JLabel("Year:");
        timeLabel = new JLabel("Select Time:");
        hourLabel = new JLabel("Hour:");
        minLabel = new JLabel("Minute:");
        l17 = new JLabel("Is this your first time?");
        Fcost = new JLabel("£15 per hour");
        Ocost = new JLabel("£25 per hour");
        notesLabel = new JLabel("Notes: ");
        imageLabel = new JLabel("Upload Image: ");

        dayBox = new JComboBox<>(day);
        monthBox = new JComboBox<>(month);
        yearBox = new JComboBox<>(year);

        adayBox = new JComboBox<>(aDay);
        amonthBox = new JComboBox<>(aMonth);
        ayearBox = new JComboBox<>(aYear);

        hourBox = new JComboBox<>(hour);
        minuteBox = new JComboBox<>(minute);

        dN = new JComboBox<>(choices);
        notes = new JTextArea();
        fNametf = new JTextField();
        sNametf = new JTextField();
        mNumbertf = new JTextField();
   
     

        submit = new JButton("Submit");
        clear = new JButton("Clear");
        yCostButton = new JButton("Yes");
        nCostButton = new JButton("No");

        submit.addActionListener(this);
        clear.addActionListener(this);

        //Patience Name, Surname and Mobile Number Label
        cTitle.setBounds(80, 0, 400, 30);
        firstNameLabel.setBounds(80, 30, 200, 30);
        surnameLabel.setBounds(80, 80, 200, 30);
        mobileNumberLabel.setBounds(80, 130, 200, 30);

        //Patience Name, Surname and Mobile Number Text Field
        fNametf.setBounds(80, 55, 200, 30);
        sNametf.setBounds(80, 105, 200, 30);
        mNumbertf.setBounds(80, 155, 200, 30);

        //Patience date of birth Labels
        eBirthDayLabel.setBounds(80, 180, 200, 30);
        bDayLabel.setBounds(80, 200, 170, 30);
        bMonthLabel.setBounds(140, 200, 200, 30);
        bYearLabel.setBounds(200, 200, 200, 30);

        //Patience date of birth Combobox
        dayBox.setBounds(80, 225, 50, 30);
        monthBox.setBounds(140, 225, 50, 30);
        yearBox.setBounds(200, 225, 70, 30);

        //Select Doctor Label
        selectDoctorLabel.setBounds(80, 250, 400, 30);

        //Select Doctor ComboBox
        dN.setBounds(80, 280, 200, 30);

        //Patience Appointmnet date  Labels
        AppointmentLabel.setBounds(80, 310, 200, 30);
        dayLabel.setBounds(80, 340, 200, 30);
        monthLabel.setBounds(140, 340, 200, 30);
        yearLabel.setBounds(200, 340, 200, 30);

        //Patience date of birth Combobox
        adayBox.setBounds(80, 370, 50, 30);
        amonthBox.setBounds(140, 370, 50, 30);
        ayearBox.setBounds(200, 370, 70, 30);

        //Patience Appointmnet date  Labels
        timeLabel.setBounds(80, 400, 200, 30);
        hourLabel.setBounds(80, 415, 200, 30);
        minLabel.setBounds(140, 415, 200, 30);

        //Patience date of birth Combobox
        hourBox.setBounds(80, 445, 50, 30);
        minuteBox.setBounds(140, 445, 50, 30);

        l17.setBounds(80, 475, 200, 30);
        yCostButton.setBounds(80, 505, 60, 30);
        nCostButton.setBounds(150, 505, 60, 30);

        Fcost.setBounds(80, 530, 100, 30);
        Fcost.setVisible(false);
        Ocost.setBounds(80, 530, 100, 30);
        Ocost.setVisible(false);

        yCostButton.addActionListener(e -> {
            if (!Fcost.isVisible()) {
                Fcost.setVisible(true);
                Ocost.setVisible(false);
                cost = 15;
            }

        });

        nCostButton.addActionListener(e -> {
            if (!Ocost.isVisible()) {
                Ocost.setVisible(true);
                Fcost.setVisible(false);
                cost = 25;
            }
        });

        //Notes
        notesLabel.setBounds(300, 30, 200, 30);
        notes.setBounds(300, 60, 300, 490);
        notes.setLineWrap(true);
        notes.setWrapStyleWord(true);
        submit.setBounds(80, 560, 100, 30);
        clear.setBounds(190, 560, 100, 30);

        add(cTitle);
        add(firstNameLabel);
        add(fNametf);
        add(surnameLabel);
        add(sNametf);
        add(mobileNumberLabel);
        add(mNumbertf);
        add(mobileNumberLabel);
        add(eBirthDayLabel);
        add(bDayLabel);
        add(bMonthLabel);
        add(bYearLabel);
        add(dayBox);
        add(monthBox);
        add(yearBox);
        add(selectDoctorLabel);
        add(dN);
        add(AppointmentLabel);
        add(dayLabel);
        add(monthLabel);
        add(yearLabel);
        add(adayBox);
        add(amonthBox);
        add(ayearBox);
        add(timeLabel);
        add(hourLabel);
        add(minLabel);
        add(hourBox);
        add(minuteBox);
        add(notesLabel);
        add(notes);
        add(l17);
        add(yCostButton);
        add(nCostButton);
        add(Fcost);
        add(Ocost);

        add(submit);
        add(clear);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            JFrame msg = new JFrame();
            FileWriter fw;

            int bDay = (Integer) dayBox.getSelectedItem();
            int bMonth = (Integer) monthBox.getSelectedItem();
            int bYear = (Integer) yearBox.getSelectedItem();

            int aIntDay = (Integer) adayBox.getSelectedItem();
            int aIntMonth = (Integer) amonthBox.getSelectedItem();
            int aIntYear = (Integer) ayearBox.getSelectedItem();
            int aHour = (Integer) hourBox.getSelectedItem();
            int aMinute = (Integer) minuteBox.getSelectedItem();
            //Convert to String
            String firstName = fNametf.getText();
            String secondName = sNametf.getText();
            String mobileNumber = mNumbertf.getText();
            dName = (String) dN.getSelectedItem();
            String n = notes.getText();
            Date bDate = new Date(bDay, bMonth, bYear);
            String bD = bDate.toString();
            Date aDate = new Date(aIntDay, aIntMonth, aIntYear);
            String aD = aDate.toString();
            Time aT = new Time(aHour, aMinute);
            String t = aT.toString();
            //Validtion
         
            for (int i = 0; i < consultationList.size(); i++) {
                if (dName.equals(consultationList.get(i).doctorName) && (t.equals(consultationList.get(i).time)) && (aD.equals(consultationList.get(i).date))) {
                    String temp = dName;
                    do {
                        int index = new Random().nextInt(choices.length);
                        dName = "";
                        dName = choices[index];
                    } while (dName.equals(temp) || dName.equals(""));
                    JOptionPane.showMessageDialog(msg, "This Slot is booked you will automaticcally get a different doctor their name is " + dName);
                    consultationList.remove(consultationList.get(i));

                } else {
                    JOptionPane.showMessageDialog(msg, "All doctors booked at this time ");

                }
            }

            if ("".equals(firstName)) {
                JOptionPane.showMessageDialog(null, "Input First Name");
            } else if ("".equals(secondName)) {
                JOptionPane.showMessageDialog(null, "Input Surname");
            } else if (!mobileNumber.matches("[0-9]+") || mobileNumber.length() != 11 || "".equals(mobileNumber)) {
                JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
            } else if ("".equals(n)) {
                JOptionPane.showMessageDialog(null, "Input Notes");
            } else if (cost == 0) {
                JOptionPane.showMessageDialog(null, "Please Click Yes or No if this is your first time");
            } else if (dName.equals("")) {

            } else {
                Random rand = new Random();

                try {
                    String pId = "p" + String.valueOf(rand.nextInt(9000000) + 1000000);
                    Patient p = new Patient(firstName, secondName, mobileNumber, bD, pId);
                    Consultation con = new Consultation(dName, p, aD, cost, n, t);
                    consultationList.add(con);

                    for (int i = 0; i < consultationList.size(); i++) {
                        noteEncry = (consultationList.get(i).notes).toCharArray();
                    }

                    fw = new FileWriter("ConsultationList", true);
                    try ( Writer bw = new BufferedWriter(fw)) {
                        for (int i = 0; i < consultationList.size(); i++) {
                            bw.write("Doctors Name: " + consultationList.get(i).doctorName + System.getProperty("line.separator"));
                            bw.write(consultationList.get(i).patient + System.getProperty("line.separator"));
                            bw.write("Appointment Date: " + consultationList.get(i).date + System.getProperty("line.separator"));
                            bw.write(consultationList.get(i).cost + System.getProperty("line.separator"));
                            for (char c : noteEncry) {
                                c += 5;

                                bw.write(c);
                            }
                            bw.write(System.getProperty("line.separator") + "Appointment Time:" + consultationList.get(i).time + "\n");

                        }
                    }
                    fw.close();
                } catch (IOException ex) {
                }
            }

        } else {
            //Clear Form
            fNametf.setText("");
            sNametf.setText("");
            mNumbertf.setText("");
            notes.setText("");
            Fcost.setVisible(false);
            Ocost.setVisible(false);
            adayBox.setSelectedIndex(0);
            amonthBox.setSelectedIndex(0);
            ayearBox.setSelectedIndex(0);
            dayBox.setSelectedIndex(0);
            monthBox.setSelectedIndex(0);
            yearBox.setSelectedIndex(0);
            hourBox.setSelectedIndex(0);
            minuteBox.setSelectedIndex(0);
        }

    }
}
