package test.dentistryspringwebapp.models;

public class PreviousAppointment {
    private int previous_appointment_id;
    private int dentistry_id;
    private String dentistry;
    private int dentist_id;
    private String dentist;
    private String appointment_day;
    private String appointment_time;
    private String patient;
    private String diagnosis;
    private int admission_price;

    public int getPrevious_appointment_id() {return previous_appointment_id;}

    public void setPrevious_appointment_id(int previous_appointment_id) {this.previous_appointment_id = previous_appointment_id;}

    public String getDentistry() {return dentistry;}

    public void setDentistry(String dentistry) {this.dentistry = dentistry;}

    public String getDentist() {return dentist;}

    public void setDentist(String dentist) {this.dentist = dentist;}

    public String getAppointment_day() {return appointment_day;}

    public void setAppointment_day(String appointment_day) {this.appointment_day = appointment_day;}

    public String getAppointment_time() {return appointment_time;}

    public void setAppointment_time(String appointment_time) {this.appointment_time = appointment_time;}

    public String getPatient() {return patient;}

    public void setPatient(String patient) {this.patient = patient;}

    public String getDiagnosis() {return diagnosis;}

    public void setDiagnosis(String diagnosis) {this.diagnosis = diagnosis;}

    public int getAdmission_price() {return admission_price;}

    public void setAdmission_price(int admission_price) {this.admission_price = admission_price;}

    public int getDentistry_id() {return dentistry_id;}

    public void setDentistry_id(int dentistry_id) {this.dentistry_id = dentistry_id;}

    public int getDentist_id() {return dentist_id;}

    public void setDentist_id(int dentist_id) {this.dentist_id = dentist_id;}

    public PreviousAppointment(int previous_appointment_id, int dentistry_id, String dentistry, int dentist_id,
                               String dentist, String appointment_day, String appointment_time, String patient,
                               String diagnosis, int admission_price) {
        this.previous_appointment_id = previous_appointment_id;
        this.dentistry_id = dentistry_id;
        this.dentistry = dentistry;
        this.dentist_id = dentist_id;
        this.dentist = dentist;
        this.appointment_day = appointment_day;
        this.appointment_time = appointment_time;
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.admission_price = admission_price;
    }
}
