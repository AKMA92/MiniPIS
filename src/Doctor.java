//  Doctor

enum Speciality {
    GP("General Practitioner"),
    CARDIO("Cardiologist"),
    DERMA("Dermatologist"),
    GYNE("Gynecologist"),
    ONCO("Oncologist"),
    PEDIA("Pediatrician"),
    PSYCH("Psychiatrist"),
    RADIO("Radiologist");

    public final String label;

    private Speciality(String label) {
        this.label = label;
    }
}

public class Doctor extends Person {

    private int employment; // in percent
    private Speciality speciality = Speciality.GP;
    private String email;

    private static final int WEEKLYWORKINGHOURS = 42;

    public Doctor(String firstName, String lastName) {
        super(firstName, lastName);
        employment = 100;
    }

    public Doctor(String firstName, String lastName, int employment) {
        super(firstName, lastName);
        setEmployment(employment);
    }

        public int getEmployment() {
        return employment;
    }

    public void setEmployment(int employment){
        if (employment >= 10 && employment <= 100) {
            this.employment = employment;
        }
    }

    public Speciality getSpeciality() {
        return speciality; 
    }

    public void setSpeciality(Speciality spec) {
        this.speciality = spec;
    }

    @Override public String toString() {
        return fullName() + ", " + speciality.label; 
    }

    public boolean worksFullTime() {
        if (employment >= 100) {
            return true;
        }else {
            return false;
        }
    }

    public float workingHoursPerWeek() {
        return (float)employment / 100.0f * (float)WEEKLYWORKINGHOURS;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null &&
            email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")){
                this.email = email;
            }else{
                System.out.println("Ungültige E-Mail-Adresse");

            }
         
    }
}   
