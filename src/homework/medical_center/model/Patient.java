package homework.medical_center.model;

import java.util.Objects;

public class Patient extends Person
{
    String doctor;
    String registerDateTime;

    public Patient(String id, String name, String surname, String email, String phoneNumber,
                   String doctor, String registerDateTime)
    {
        super(id, name, surname, email, phoneNumber);
        this.doctor = doctor;
        this.registerDateTime = registerDateTime;
    }

    public Patient(){};

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;
        return Objects.equals(doctor, patient.doctor) && Objects.equals(registerDateTime, patient.registerDateTime)
                && Objects.equals(super.getId(), patient.getId()) && Objects.equals(super.getName(), patient.getName());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(doctor);
        result = 31 * result + Objects.hashCode(registerDateTime);
        return result;
    }



    @Override
    public String toString() {
        return "Patient{" +
                "doctor='" + doctor + '\'' +
                ", registerDateTime='" + registerDateTime + '\'' +
                "} " + super.toString();
    }

    public String getDoctor()
    {
        return doctor;
    }

    public void setDoctor(String doctor)
    {
        this.doctor = doctor;
    }
}
