package test.dentistryspringwebapp.models;

public class ForthcomingAppointment {
    private int appointment_id;
    private String dentistry;
    private String dentist;
    private String appointment_day;
    private String appointment_time;
    private String patient;

    public int getId() {
        return appointment_id;
    }

    public void setId(int id) {
        this.appointment_id = id;
    }

    public String getDentistry() {
        return dentistry;
    }

    public void setDentistry(String dentistry) {
        this.dentistry = dentistry;
    }

    public String getDentist() {
        return dentist;
    }

    public void setDentist(String dentist) {
        this.dentist = dentist;
    }

    public String getAppointment_day() {
        return appointment_day;
    }

    public void setAppointment_day(String appointment_day) {
        this.appointment_day = appointment_day;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String getPatient() {return patient;}

    public void setPatient(String patient) {this.patient = patient;}

    public ForthcomingAppointment(int id, String dentistry, String dentist, String appointment_day,
                                  String appointment_time, String patient) {
        this.appointment_id = id;
        this.dentistry = dentistry;
        this.dentist = dentist;
        this.appointment_day = appointment_day;
        this.appointment_time = appointment_time;
        this.patient = patient;
    }
}
