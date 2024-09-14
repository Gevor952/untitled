package homework.medical_center;

import homework.medical_center.model.Doctor;
import homework.medical_center.model.Patient;
import homework.medical_center.storage.DoctorStorage;
import homework.medical_center.storage.PatientStorage;

import java.util.Scanner;

public class MedicalCenter implements MedicalCenterCommands
{
    static Scanner scanner = new Scanner(System.in);
    static DoctorStorage doctorStorage = new DoctorStorage();
    static PatientStorage patientStorage = new PatientStorage();

    public static void main(String[] args)
    {
        doctorStorage.add(new Doctor("001", "Ashot", "Tatevosyan",
                "ash@gmail.com", "+34777654987", "srtaban"));
        boolean isRun = true;

        while (isRun)
        {
            MedicalCenterCommands.printCommands();
            String command = scanner.nextLine();

            switch(command)
            {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_DOCTOR:
                    addDoctor();
                    break;
                case SEARCH_DOCTOR_BY_PROFESSION:
                    searchDoctorByProfession();
                    break;
                case DELETE_DOCTOR_BY_ID:
                    deleteDoctorById();
                    break;
                case CHANGE_DOCTOR:
                    changeDoctor();
                    break;
                case ADD_PATIENT:
                    addPatient();
                    break;
                case PRINT_ALL_PATIENTS_BY_DOCTOR:
                    printAllPatientsByDoctor();
                    break;
                case PRINT_ALL_PATENTS:
                    printAllPatients();
                    break;

            }
        }
    }

    private static void printAllPatients()
    {
        doctorStorage.printAllPatients();
    }

    private static void printAllPatientsByDoctor()
    {
        doctorStorage.print();
        System.out.println("Please input the doctor ID whose patients do you want to see");
        Doctor doctor = doctorStorage.getDoctorById(scanner.nextLine());
        if(doctor == null)
        {
            return;
        }
        doctor.printPatient();
    }

    private static void addPatient()
    {
        System.out.println("Please input the id of the patient");
        String id = scanner.nextLine();
        System.out.println("Please input the name of the patient");
        String name = scanner.next();
        System.out.println("Please input the surname of the patient");
        String surname = scanner.next();
        System.out.println("Please input the email of the patient");
        String email = scanner.next();
        System.out.println("Please input the phone number of the patient");
        String phone = scanner.next();
        doctorStorage.print();
        System.out.println("Please input the name of the doctor you wish to see");
        String doctorName = scanner.next();
        System.out.println("Please input the id of the doctor you wish to see");
        String doctorId = scanner.next();
        System.out.println("Please input register date time");
        String dateTime = scanner.next();
        Doctor doctor = doctorStorage.getDoctorById(doctorId);
        if(doctor != null)
        {
            doctor.addPatient(new Patient(id, name, surname, email, phone, doctorName, dateTime));
        }

    }

    private static void changeDoctor()
    {
        doctorStorage.print();
        System.out.println("Please input the doctor ID");
        String id = scanner.nextLine();
        Doctor doctor = doctorStorage.getDoctorById(id);
        if(doctor == null)
        {
            return;
        }
        System.out.println("Please input the doctor Name");
        String name = scanner.nextLine();
        System.out.println("Please input the doctor Surname");
        String surname = scanner.nextLine();
        System.out.println("Please input the doctor Email");
        String email = scanner.nextLine();
        System.out.println("Please input the doctor pone number");
        String pone = scanner.nextLine();
        System.out.println("Please input the doctor profession");
        String profession = scanner.nextLine();
        if(name != null && !name.isEmpty())
        {
            doctor.setName(name);
        }
        if(surname != null && !surname.isEmpty())
        {
            doctor.setSurname(surname);
        }
        if(email != null && !email.isEmpty())
        {
            doctor.setEmail(email);
        }
        if(pone != null && !pone.isEmpty())
        {
            doctor.setPhoneNumber(pone);
        }
        if(profession != null && !profession.isEmpty())
        {
            doctor.setProfession(profession);
        }
    }
    private static void deleteDoctorById()
    {
        doctorStorage.print();
        String doctorId = scanner.nextLine();
        Doctor doctor = doctorStorage.getDoctorById(doctorId);
        if(doctor != null)
        {
            doctorStorage.deleteDoctor(doctorId);
            System.out.println("Doctor deleted successfully");
        }
    }

    private static void searchDoctorByProfession()
    {
        System.out.println("Please input the profession of the doctor you want to search");
        doctorStorage.printDoctorByProfession(scanner.nextLine());
    }

    private static void addDoctor()
    {
        System.out.println("Please input the id of the doctor");
        String id = scanner.nextLine();
        System.out.println("Please input the name of the doctor");
        String name = scanner.next();
        System.out.println("Please input the surname of the doctor");
        String surname = scanner.next();
        System.out.println("Please input the email of the doctor");
        String email = scanner.next();
        System.out.println("Please input the phone number of the doctor");
        String phone = scanner.next();
        System.out.println("Please input the profession of the doctor");
        String profession = scanner.next();
        doctorStorage.add(new Doctor(id, name, surname, email, phone, profession));
    }
}
