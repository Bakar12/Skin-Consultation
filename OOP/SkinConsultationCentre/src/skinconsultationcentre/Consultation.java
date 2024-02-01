package skinconsultationcentre;

/**
 * @author Abubakar Mukadam
 */
public class Consultation {

    String doctorName;
    Patient patient;
    String date;
    int cost;
    String notes;
    String time;

    public Consultation(String doctorName, Patient patient, String date, int cost, String notes, String time) {
        this.doctorName = doctorName;
        this.patient = patient;
        this.date = date;
        this.cost = cost;
        this.notes = notes;
        this.time = time;
    }

    //methods
    public void setDoctor(String d) {
        this.doctorName = d;
    }

    public void setPatient(Patient p) {
        this.patient = p;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCost(int cost) {
        this.cost = cost;

    }

    public void setNotes(String n) {
        this.notes = n;

    }

    public void setTime(String t) {
        this.time = t;

    }

    public String getDoctor() {
        return doctorName;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDate() {
        return date;
    }

    public int getCost() {
        return cost;

    }

    public String getNotes() {
        return notes;

    }

    public String getTime() {
        return time;

    }
    
   
}
