package homework.medical_center.model;

import homework.medical_center.storage.PatientStorage;

import java.util.Objects;

public class Doctor extends Person
{
    private String profession;
    private PatientStorage patientStorage = new PatientStorage();

    public Doctor(String id, String name, String surname, String email, String phoneNumber, String profession)
    {
        super(id, name, surname, email, phoneNumber);
        this.profession = profession;
    }

    public Doctor() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;
        return Objects.equals(profession, doctor.profession) && Objects.equals(patientStorage, doctor.patientStorage)
                && Objects.equals(super.getId(), doctor.getId()) && Objects.equals(super.getName(), doctor.getName());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(profession);
        result = 31 * result + Objects.hashCode(patientStorage);
        return result;
    }



    @Override
    public String toString() {
        return "Doctor{" +
                "profession='" + profession + '\'' +
                "} " + super.toString();
    }

    public String getProfession()
    {
        return profession;
    }

    public void setProfession(String profession)
    {
        this.profession = profession;
    }

    public void addPatient(Patient patient)
    {
        patientStorage.add(patient);
    }


    public void printPatient()
    {
        patientStorage.print();
    }
}
