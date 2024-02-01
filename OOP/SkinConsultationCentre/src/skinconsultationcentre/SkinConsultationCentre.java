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
public class SkinConsultationCentre {

    public static void main(String[] args) {
        SkinConsultationManager sys = new WestminsterSkinConsultationManager();
        boolean exit = false;
        while (!exit) {
            exit = sys.runMenu();
        }
    }
}
