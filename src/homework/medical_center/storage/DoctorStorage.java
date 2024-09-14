package homework.medical_center.storage;

import homework.medical_center.model.Doctor;

public class DoctorStorage
{
    private Doctor[] doctors = new Doctor[10];
    private int size = 0;

    public void add(Doctor Doctor)
    {
        if(size == doctors.length)
        {
            extendStorage();
        }
        doctors[size++] = Doctor;
    }

    private void extendStorage()
    {
        Doctor[] temp = new Doctor[size * 2];
        System.arraycopy(doctors, 0, temp, 0, size);
        doctors = temp;
    }

    public void print()
    {
        for (int i = 0; i < size; i++)
        {
            System.out.println(doctors[i]);
        }
    }


    public Doctor getDoctorById(String id)
    {
        for (int i = 0; i < size; i++)
        {
            if (doctors[i].getId().equals(id))
            {
                return doctors[i];
            }
        }
        return null;
    }

    public Doctor getDoctorByProfession(String id)
    {
        for (int i = 0; i < size; i++)
        {
            if (doctors[i].getProfession().equals(id))
            {
                return doctors[i];
            }
        }
        return null;
    }

    public void deleteDoctor(String id)
    {
        for(int i = 0; i < size; i++)
        {
            if(doctors[i].getId().equals(id))
            {
                Doctor[] temp = new Doctor[(size - i) + 10];
                System.arraycopy(doctors, i + 1, temp, 0, size );
                System.arraycopy(temp, 0, doctors, i , size--);
            }
        }
    }


    public void printDoctorByProfession(String profession)
    {
        for(int i = 0; i < size; i++)
        {
            if(doctors[i].getProfession().equals(profession))
            {
                System.out.println(doctors[i]);
            }
        }
    }

    public void printAllPatients()
    {
        for(int i = 0; i < size; i++)
        {
            doctors[i].printPatient();
        }
    }
}
