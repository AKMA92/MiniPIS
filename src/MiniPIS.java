/*
 *  MiniPIS
 *  A playground for developing a simple Patient Information System (PIS)
 */

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;

class MiniPIS {

    static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    static ArrayList<Patient> patients = new ArrayList<Patient>();
    static ArrayList<Appointment> appointments = new ArrayList<Appointment>();

    private static void createData() {
        var doctor = new Doctor("Peter", "Müller");
        doctors.add(doctor);
        doctor = new Doctor("Susanne", "Keller", 80);
        doctor.setSpeciality(Speciality.PEDIA);
        doctors.add(doctor);    

        Patient patient1 = new Patient("Anna", "Müller");
        patient1.setHeight(1.70f);
        patient1.setWeight(65.0f);
        patient1.setBirthday(LocalDate.of(1995, 3, 15));
        patient1.setSex(Patient.Sex.FEMALE);
        patients.add(patient1);

        Patient patient2 = new Patient("Peter", "Meier");
        patient2.setHeight(1.82f);
        patient2.setWeight(85.0f);
        patient2.setBirthday(LocalDate.of(1985, 7, 20));
        patient2.setSex(Patient.Sex.MALE);
        patients.add(patient2);

        Appointment termin1 = new Appointment(
            doctors.get(0),
            patients.get(0),
            LocalDateTime.of(2026, 11, 10, 14, 30)
        );
        appointments.add(termin1);

        Appointment termin2 = new Appointment(
            doctors.get(1),
            patients.get(1),
            LocalDateTime.of(2026, 11, 11, 10, 0)
        );
        appointments.add(termin2);
        
    }

    private static void processData() {
        CSV.exportDoctors(doctors);
        CSV.exportPatients(patients);

        JSON.export(doctors, "doctors.json");
        JSON.exportPatients(patients, "patients.json");

        ArrayList<Doctor> importedDoctors = JSON.importDoctors("doctors.json");
        ArrayList<Patient> importedPatients = JSON.importPatients("patients.json");

        System.out.println("Importierte Ärzte: " + importedDoctors.size());
        System.out.println("Importierte Patienten: " + importedPatients.size());
    }

    private static void analyseData() {
        float totalWeekHours = 0.0f;
        System.out.println("# doctors: " + doctors.size());
        for(Doctor doc: doctors) {
            System.out.println(doc);
            totalWeekHours = totalWeekHours + doc.workingHoursPerWeek();
        }
        System.out.println();
        System.out.println("Total working hours per week: " + String.format("%.1f", totalWeekHours));

        // Durchschnitt der Patienten berechnen
        float totalWeight = 0;
        float totalHeight = 0;

        for (Patient patient : patients) {
            totalWeight += patient.getWeight();
            totalHeight += patient.getHeight();
        }

        if (patients.size() > 0) {
            float averageWeight = totalWeight / patients.size();
            float averageHeight = totalHeight / patients.size();

            System.out.println("Durchschnittsgewicht: " + averageWeight + " kg");
            System.out.println("Durchschnittsgrösse: " + averageHeight + " m");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to MiniPIS");
        System.out.println("==================");
        createData();
        processData();
        analyseData();
    }
}   
