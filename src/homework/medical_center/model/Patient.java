package homework.medical_center.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Patient extends Person {
    String doctorID;
    SimpleDateFormat registerDateTime = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    Date date;


    public Patient(String id, String name, String surname, String email,
                   String phoneNumber, String doctorID, String registerDateTime) {
        super(id, name, surname, email, phoneNumber);
        this.doctorID = doctorID;
        try {
            this.date = this.registerDateTime.parse(registerDateTime);
        } catch (ParseException e) {
            System.out.println("Error");
        }

    }

    public Patient() {
    }

    ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;
        return Objects.equals(doctorID, patient.doctorID) && Objects.equals(registerDateTime, patient.registerDateTime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(doctorID);
        result = 31 * result + Objects.hashCode(registerDateTime);
        return result;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "doctorID='" + doctorID + '\'' +
                ", registerDateTime=" + date +
                "} " + super.toString();
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }


    public SimpleDateFormat getRegisterDateTime() {
        return registerDateTime;
    }

    public void setRegisterDateTime(SimpleDateFormat registerDateTime) {
        this.registerDateTime = registerDateTime;
    }

    public void printTime() {
        System.out.println(date);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
