package test.dentistryspringwebapp.models;

public class ForthcomingAppointment {
    private int appointment_id;
    private int dentistry_id;
    private String dentistry;
    private int dentist_id;
    private String dentist;
    private String appointment_day;
    private String appointment_time;
    private String patient;

    public int getId() {return appointment_id;}

    public void setId(int id) {this.appointment_id = id;}

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

    public int getAppointment_id() {return appointment_id;}

    public void setAppointment_id(int appointment_id) {this.appointment_id = appointment_id;}

    public int getDentistry_id() {return dentistry_id;}

    public void setDentistry_id(int dentistry_id) {this.dentistry_id = dentistry_id;}

    public int getDentist_id() {return dentist_id;}

    public void setDentist_id(int dentist_id) {this.dentist_id = dentist_id;}

    public ForthcomingAppointment(int appointment_id, int dentistry_id, String dentistry, int dentist_id,
                                  String dentist, String appointment_day, String appointment_time, String patient) {
        this.appointment_id = appointment_id;
        this.dentistry_id = dentistry_id;
        this.dentistry = dentistry;
        this.dentist_id = dentist_id;
        this.dentist = dentist;
        this.appointment_day = appointment_day;
        this.appointment_time = appointment_time;
        this.patient = patient;
    }

}
