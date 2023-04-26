package test.dentistryspringwebapp.models;

public class Dentist {
    private int dentist_id;
    private String dentist_name;
    private int dentistry_id;
    private String dentistry;
    private int experience;
    private String dentist_type;
    private int dentist_type_id;

    public int getDentist_id() {return dentist_id;}

    public void setDentist_id(int dentist_id) {this.dentist_id = dentist_id;}

    public String getDentist_name() {return dentist_name;}

    public void setDentist_name(String dentist_name) {this.dentist_name = dentist_name;}

    public int getDentistry_id() {return dentistry_id;}

    public void setDentistry_id(int dentistry_id) {this.dentistry_id = dentistry_id;}


    public int getExperience() {return experience;}

    public void setExperience(int experience) {this.experience = experience;}

    public int getDentist_type_id() {return dentist_type_id;}

    public void setDentist_type_id(int dentist_type_id) {this.dentist_type_id = dentist_type_id;}

    public String getDentistry() {return dentistry;}

    public void setDentistry(String dentistry) {this.dentistry = dentistry;}

    public String getDentist_type() {return dentist_type;}

    public void setDentist_type(String dentist_type) {this.dentist_type = dentist_type;}

    public Dentist(int dentist_id, String dentist_name, int dentistry_id, String dentistry, int experience,
                   int dentist_type_id, String dentist_type) {
        this.dentist_id = dentist_id;
        this.dentist_name = dentist_name;
        this.dentistry_id = dentistry_id;
        this.dentistry = dentistry;
        this.experience = experience;
        this.dentist_type = dentist_type;
        this.dentist_type_id = dentist_type_id;
    }
}
