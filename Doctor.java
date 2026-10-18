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

public class Doctor {
    private String firstName; // prename
    private String lastName; // surname, family name
    private int employmentLevel; // in percent
    private Speciality speciality = Speciality.GP;

    private static final int WEEKLYWORKINGHOURS = 42;

    public Doctor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName; 
        employmentLevel = 100;
    }

    public Doctor(String firstName, String lastName, int employment) {
        this.firstName = firstName;
        this.lastName = lastName; 
        this.employmentLevel = employment;
    }

    public String getFirstName() {
        return firstName; 
    }

    public void setFirstName(String prename) {
        this.firstName = prename;
    }

    public String getLastName() {
        return lastName; 
    }

    public void setLasttName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployment() {
        return employmentLevel;
    }

    public String fullName() {
        return firstName + " " + lastName;
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
        if (employmentLevel >= 100) {
            return true;
        }else {
            return false;
        }
    }

    public float workingHoursPerWeek() {
        return (float)employmentLevel / 100.0f * (float)WEEKLYWORKINGHOURS;
    }
}   
