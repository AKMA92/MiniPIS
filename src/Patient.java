import java.time.LocalDate;
import java.time.Period;

public class Patient extends Person {
    private float height;
    private float weight;
    private LocalDate birthday;
    private Sex sex;
    
    public enum Sex {
        MALE,
        FEMALE,
        DIVERSE,
        UNKNOWN
    }


    public Patient(String firstName, String lastName) {
    super(firstName, lastName);
    }

    public float getHeight(){
        return height;
    }

    public void setHeight(float height){
        this.height = height;
    }

    public float getWeight(){
        return weight;
    }

    public void setWeight(float weight){
        this.weight = weight;
    }

    public LocalDate getBirthday(){
        return birthday;
    }

    public void setBirthday(LocalDate birthday){
        this.birthday = birthday;
    }

    public int getAge() {
        if (birthday == null) {
            throw new IllegalStateException("Geburtsdatum fehlt");
        }

        Period alter = Period.between(birthday, LocalDate.now());
        return alter.getYears();
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }    
}