package homework.medical_center.model;

import homework.medical_center.Profession;
import homework.medical_center.TimeNotAllowedException;
import homework.medical_center.storage.PatientStorage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormat.parse(strDate);
        Date date1 =dateFormat1.parse(strDate);
        String[] strHour = (dateFormat.format(date)).split(":");
        String[] dateStr = dateFormat1.format(date1).split("-");
        int[] time = new int[5];
        time[0] = Integer.parseInt(dateStr[0]);
        time[1] = Integer.parseInt(dateStr[1]);
        time[2] = Integer.parseInt(dateStr[2]);
        time[3] = Integer.parseInt(strHour[0]);
        time[4] = Integer.parseInt(strHour[1]);
        for(int i = 0; i < patientStorage.getSize(); i++)
        {
            int[] time1 = patientStorage.getTimeByIndex(i);
            if(time[0] == time1[0] && time[1] == time1[1] && time[2] == time1[2])
            {
                if(time[3] == time1[3] && time[4] == time1[4])
                {
                    throw new TimeNotAllowedException();
                }
                else if(time[3] == time1[3])
                {
                    if(time[4] + 30 > time1[4])
                    {
                        throw new TimeNotAllowedException();
                    }
                    else if(time[4] - 30 > time1[4])
                    {
                        throw new TimeNotAllowedException();
                    }
                }
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
