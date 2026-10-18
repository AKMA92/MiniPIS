/*
 *  MiniPIS
 *  A playground for developing a simple Patient Information System (PIS)
 */

import java.util.ArrayList;

class MiniPIS {

    static ArrayList<Doctor> doctors = new ArrayList<Doctor>();

    private static void createData() {
        var doctor = new Doctor("Peter", "Müller");
        doctors.add(doctor);
        doctor = new Doctor("Susanne", "Keller", 80);
        doctor.setSpeciality(Speciality.PEDIA);
        doctors.add(doctor);
    }

    private static void processData() {
        //TSV.export(doctors);
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
    }

    public static void main(String[] args) {
        System.out.println("Welcome to MiniPIS");
        System.out.println("==================");
        createData();
        processData();
        analyseData();
    }
}   
