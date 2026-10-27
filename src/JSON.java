
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSON {

    // Ärzte exportieren
    static void export(ArrayList<Doctor> doctors, String toFileName) {
        File jsonOutputFile = new File(toFileName);

        try (FileWriter fileWriter = new FileWriter(jsonOutputFile)) {
            JSONArray array = new JSONArray();

            for (Doctor doc : doctors) {
                JSONObject jsonObject = new JSONObject();

                jsonObject.put("prename", doc.getFirstName());
                jsonObject.put("surname", doc.getLastName());
                jsonObject.put("speciality", doc.getSpeciality().label);
                jsonObject.put("employment", doc.getEmployment());
                jsonObject.put("email", doc.getEmail());

                array.put(jsonObject);
            }

            fileWriter.write(array.toString(4));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Ärzte importieren
    static ArrayList<Doctor> importDoctors(String fromFileName) {
        ArrayList<Doctor> result = new ArrayList<Doctor>();
        Path filePath = Path.of(fromFileName);

        try {
            String content = Files.readString(filePath);
            JSONArray array = new JSONArray(content);

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);

                Doctor doctor = new Doctor(
                    obj.getString("prename"),
                    obj.getString("surname")
                );

                doctor.setEmployment(obj.getInt("employment"));

                String spec = obj.getString("speciality");

                for (Speciality s : Speciality.values()) {
                    if (spec.equals(s.label)) {
                        doctor.setSpeciality(s);
                    }
                }

                String email = obj.optString("email", "");

                if (!email.isEmpty()) {
                    doctor.setEmail(email);
                }

                result.add(doctor);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    // Patienten exportieren
    static void exportPatients(ArrayList<Patient> patients, String fileName) {
        File jsonOutputFile = new File(fileName);

        try (FileWriter fileWriter = new FileWriter(jsonOutputFile)) {
            JSONArray array = new JSONArray();

            for (Patient patient : patients) {
                JSONObject jsonObject = new JSONObject();

                jsonObject.put("firstName", patient.getFirstName());
                jsonObject.put("lastName", patient.getLastName());
                jsonObject.put("height", patient.getHeight());
                jsonObject.put("weight", patient.getWeight());
                jsonObject.put("birthday", patient.getBirthday() == null
                    ? JSONObject.NULL
                    : patient.getBirthday().toString());
                jsonObject.put("sex", patient.getSex() == null
                    ? JSONObject.NULL
                    : patient.getSex().name());

                array.put(jsonObject);
            }

            fileWriter.write(array.toString(4));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Patienten importieren
    static ArrayList<Patient> importPatients(String fileName) {
        ArrayList<Patient> result = new ArrayList<Patient>();
        Path filePath = Path.of(fileName);

        try {
            String content = Files.readString(filePath);
            JSONArray array = new JSONArray(content);

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);

                Patient patient = new Patient(
                    obj.getString("firstName"),
                    obj.getString("lastName")
                );

                patient.setHeight(obj.getFloat("height"));
                patient.setWeight(obj.getFloat("weight"));

                if (!obj.isNull("birthday")) {
                    patient.setBirthday(
                        LocalDate.parse(obj.getString("birthday"))
                    );
                }

                if (!obj.isNull("sex")) {
                    patient.setSex(
                        Patient.Sex.valueOf(obj.getString("sex"))
                    );
                }

                result.add(patient);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
