/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skinconsultationcentre;

import java.util.ArrayList;

/**
 *
 * @author Abubakar Mukadam
 */
public interface SkinConsultationManager {

    public void addDoctor();
    public void deleteDoctor();
    public void doctorList();
    public void saveFile();
    public abstract boolean runMenu();
    public void loadFile();
    public void doctorTable();
    public void patienceInfo();
    public void patienceConsultation();

    
    
    
}
