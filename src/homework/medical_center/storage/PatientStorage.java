package homework.medical_center.storage;

import homework.medical_center.model.Patient;

public class PatientStorage
{
    private Patient[] patients = new Patient[10];
    private int size = 0;

    public void add(Patient Patient)
    {
        if(size == patients.length)
        {
            extendStorage();
        }
        patients[size++] = Patient;
    }

    private void extendStorage()
    {
        Patient[] temp = new Patient[size * 2];
        System.arraycopy(patients, 0, temp, 0, size);
        patients = temp;
    }

    public void print()
    {
        for (int i = 0; i < size; i++)
        {
            System.out.println(patients[i]);
        }
    }


    public Patient getPatientById(String id)
    {
        for (int i = 0; i < size; i++)
        {
            if (patients[i].getId().equals(id))
            {
                return patients[i];
            }
        }
        return null;
    }

    public void deletePatient(String id)
    {
        for(int i = 0; i < size; i++)
        {
            if(patients[i].getId().equals(id))
            {
                Patient[] temp = new Patient[(size - i) + 10];
                System.arraycopy(patients, i + 1, temp, 0, size );
                System.arraycopy(temp, 0, patients, i , size--);
            }
        }
    }


}
