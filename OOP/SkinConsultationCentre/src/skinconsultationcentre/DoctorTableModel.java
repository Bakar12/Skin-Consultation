/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skinconsultationcentre;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author abuba
 */
public class DoctorTableModel extends AbstractTableModel {

    public String[] columnNames = {"Firtname", "Surname", "Medical Licence Number", "Specialisation", "Date of Birth", "Mobile Number"};
    public ArrayList<Doctor> list;

    public DoctorTableModel(ArrayList<Doctor> doctorList) {
        list = doctorList;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        switch (columnIndex) {
            case 0 ->
                temp = list.get(rowIndex).getName();
            case 1 ->
                temp = list.get(rowIndex).getSurname();
            case 2 ->
                temp = list.get(rowIndex).getMedicalLicenceNumber();
            case 3 ->
                temp = list.get(rowIndex).getSpecialisation();
                case 4 ->
                temp = list.get(rowIndex).getDOB();
                case 5 ->
                temp = list.get(rowIndex).getMobileNumber();
            default -> {
            }
        }
        return temp;

    }

    //Show column names in JTable 
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Class getColumnClass(int col) {
        if (col == 2) {
            return Double.class;
        } else {
            return String.class;
        }
    }

}
