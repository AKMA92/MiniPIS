import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CSV {

    public static void exportDoctors(ArrayList<Doctor> doctors) {

        try (PrintWriter writer = new PrintWriter("doctors.csv")) {

            writer.println("FirstName,LastName,Employment");

            for (Doctor doctor : doctors) {
                writer.println(
                    doctor.getFirstName() + "," +
                    doctor.getLastName() + "," +
                    doctor.getEmployment()
                );
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fehler beim CSV-Export");
        }
    }

    public static void exportPatients(ArrayList<Patient> patients) {

    try (PrintWriter writer = new PrintWriter("patients.csv")) {

        writer.println("FirstName,LastName,Height,Weight,Birthday,Age,Sex");

        for (Patient patient : patients) {
            writer.println(
                patient.getFirstName() + "," +
                patient.getLastName() + "," +
                patient.getHeight() + "," +
                patient.getWeight() + "," +
                patient.getBirthday() + "," +
                patient.getAge() + "," +
                patient.getSex()
            );
        }

    } catch (FileNotFoundException e) {
        System.out.println("Fehler beim Patienten-Export");
    }
}
}