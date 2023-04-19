package test.dentistryspringwebapp.models;

public class Dentist {
    private int dentist_id;
    private String dentist_name;
    private String dentistry;
    private int experience;
    private String dentist_type;

    public int getDentist_id() {
        return dentist_id;
    }

    public void setDentist_id(int dentist_id) {
        this.dentist_id = dentist_id;
    }

    public String getDentist_name() {
        return dentist_name;
    }

    public void setDentist_name(String dentist_name) {
        this.dentist_name = dentist_name;
    }

    public String getDentistry() {
        return dentistry;
    }

    public void setDentistry(String dentistry) {
        this.dentistry = dentistry;
    }


    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getDentist_type() {
        return dentist_type;
    }

    public void setDentist_type(String dentist_type) {
        this.dentist_type = dentist_type;
    }

    public Dentist(int id, String dentist_name, String dentistry, int experience,
                   String dentist_type) {
        this.dentist_id = id;
        this.dentist_name = dentist_name;
        this.dentistry = dentistry;
        this.experience = experience;
        this.dentist_type = dentist_type;
    }
}
