package homework.medical_center.model;

import homework.medical_center.Profession;
import homework.medical_center.TimeNotAllowedException;
import homework.medical_center.storage.PatientStorage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Doctor extends Person
{
    private Profession profession;
    private PatientStorage patientStorage = new PatientStorage();

    public Doctor(String id, String name, String surname, String email, String phoneNumber, Profession profession)
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
        return profession == doctor.profession && Objects.equals(patientStorage, doctor.patientStorage);
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
                "profession=" + profession +
                ", patientStorage=" + patientStorage +
                "} " + super.toString();
    }

    public void addPatient(Patient patient)
    {
        patientStorage.add(patient);
    }


    public void printPatient()
    {
        patientStorage.print();
    }

    public void printTime()
    {
        patientStorage.printTimes();
    }

    public void searchTime(String strDate) throws ParseException, TimeNotAllowedException
    {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date date = sdf.parse(strDate);
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, 30);
        Date after = calendar.getTime();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, -30);
        Date before = calendar.getTime();
        for (int i = 0; i < patientStorage.getSize(); i++)
        {
            if(patientStorage.getTimeByIndex(i).before(after) && patientStorage.getTimeByIndex(i).after(before))
            {
                throw new TimeNotAllowedException();
            }
        }

    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }
}
