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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class DoctorTable extends JFrame {

    JTable docTable;
    DoctorTableModel tableModel;
    ArrayList<Doctor> list;

    // contructor
    public DoctorTable(ArrayList<Doctor> list) {
        this.list = list;
        tableModel = new DoctorTableModel(list);
        docTable = new JTable(tableModel);

        setBounds(10, 10, 700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        docTable.setAutoCreateRowSorter(true);

        //Renders the Table
        docTable.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            Color originalColor = null;

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (value == "Doctor") {
                    renderer.setBackground(Color.GREEN);
                } else {
                    renderer.setBackground(Color.WHITE);
                }

                return renderer;
            }
        });

        JScrollPane scrollPane = new JScrollPane(docTable);
        scrollPane.setPreferredSize(new Dimension(500, 500));

        JPanel panel = new JPanel();
        panel.add(scrollPane);
        add(panel, BorderLayout.CENTER);

    }
}
