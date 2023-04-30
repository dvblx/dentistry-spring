package test.dentistryspringwebapp.models;

public class TimeTable {
    private int tt_id;
    private int dentistry_id;
    private String dentistry;
    private int dentist_id;
    private String dentist;
    private String day;
    private String admission_time;

    public int getTt_id() {
        return tt_id;
    }

    public void setTt_id(int tt_id) {this.tt_id = tt_id;}

    public String getDentist() {return dentist;}

    public void setDentist(String dentist) {this.dentist = dentist;}

    public String getDentistry() {return dentistry;}

    public void setDentistry(String dentistry) {this.dentistry = dentistry;}

    public String getDay() {return day;}

    public void setDay(String day) {this.day = day;}

    public String getAdmission_time() {return admission_time;}

    public void setAdmission_time(String admission_time) {this.admission_time = admission_time;}

    public int getDentistry_id() {return dentistry_id;}

    public void setDentistry_id(int dentistry_id) {this.dentistry_id = dentistry_id;}

    public int getDentist_id() {return dentist_id;}

    public void setDentist_id(int dentist_id) {this.dentist_id = dentist_id;}

    public TimeTable(int tt_id, int dentist_id, String dentist, int dentistry_id, String dentistry,  String day, String admission_time) {
        this.tt_id = tt_id;
        this.dentistry_id = dentistry_id;
        this.dentistry = dentistry;
        this.dentist_id = dentist_id;
        this.dentist = dentist;
        this.day = day;
        this.admission_time = admission_time;
    }
}
