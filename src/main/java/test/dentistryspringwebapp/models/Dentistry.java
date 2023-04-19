package test.dentistryspringwebapp.models;

public class Dentistry {
    private int dentistry_id;
    private String name;
    private String phone;
    private String head_of_clinic;
    private String address;
    private int foundation_year;
    private int customer_count;

    public int getDentistry_id() {
        return dentistry_id;
    }

    public void setDentistry_id(int dentistry_id) {
        this.dentistry_id = dentistry_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHead_of_clinic() {
        return head_of_clinic;
    }

    public void setHead_of_clinic(String head_of_clinic) {
        this.head_of_clinic = head_of_clinic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFoundation_year() {
        return foundation_year;
    }

    public void setFoundation_year(int foundation_year) {
        this.foundation_year = foundation_year;
    }

    public int getCustomer_count() {
        return customer_count;
    }

    public void setCustomer_count(int customer_count) {
        this.customer_count = customer_count;
    }


    public Dentistry(int id, String name, String phone, String head_of_clinic, String address,
                     int foundation_year, int customer_count) {
        this.dentistry_id = id;
        this.name = name;
        this.phone = phone;
        this.head_of_clinic = head_of_clinic;
        this.address = address;
        this.foundation_year = foundation_year;
        this.customer_count = customer_count;
    }
}

