import java.time.LocalDateTime;

public class Appointment {

    private Doctor doctor;
    private Patient patient;
    private LocalDateTime dateTime;

    // Konstruktor
    public Appointment(Doctor doctor, Patient patient, LocalDateTime dateTime) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateTime = dateTime;
    }

    // Getter
    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}