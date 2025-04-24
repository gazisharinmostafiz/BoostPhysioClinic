package bpc.logic;

import bpc.model.Patient;
import bpc.model.Physiotherapist;
import bpc.model.Booking;
import bpc.model.Expertise;
import bpc.model.Treatment;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author sharin
 */
public class ClinicManager {

    // --- Data Storage ---
    private List<Patient> registeredPatients = new ArrayList<>();
    private List<Physiotherapist> clinicStaff = new ArrayList<>();
    private List<Treatment> availableTreatments = new ArrayList<>();
    private List<Booking> appointmentSchedule = new ArrayList<>();

    // --- Constants ---
    private final int MAX_TREATMENT_ROOMS = 5; // Example room limit
    private static final DateTimeFormatter STANDARD_DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public ClinicManager() {
        loadInitialSampleData(); // Load data when the manager is created
    }

    private void loadInitialSampleData() {
        System.out.println("ClinicManager: Loading initial sample data...");

        // Expertise Areas
        Expertise expRehab = new Expertise("Rehabilitation");
        Expertise expOsteo = new Expertise("Osteopathy");
        Expertise expPhysio = new Expertise("Physiotherapy");
        Expertise expSports = new Expertise("Sports Injury");
        Expertise expAcupuncture = new Expertise("Acupuncture"); // Added example

        //  Create Physiotherapists 
        Physiotherapist physio1 = new Physiotherapist("Dr. Priya Sharma", "45 Cranbrook Road, Ilford, IG1 4PG", "02081112233");
        physio1.addExpertise(expRehab);
        physio1.addExpertise(expSports);

        Physiotherapist physio2 = new Physiotherapist("Mr. Kenji Tanaka", "12 Station Parade, Barking, IG11 8DN", "02082223344");
        physio2.addExpertise(expOsteo);
        physio2.addExpertise(expPhysio);

        Physiotherapist physio3 = new Physiotherapist("Ms. Fatima Ahmed", "3 Victoria Road, Romford, RM1 2JT", "01708333444");
        physio3.addExpertise(expPhysio);
        physio3.addExpertise(expAcupuncture);
        physio3.addExpertise(expRehab);

        Physiotherapist physio4 = new Physiotherapist("Mr. Wei Zhang", "9 Market Place, Stratford, London, E15 1DT", "02084445566");
        physio4.addExpertise(expSports);
        physio4.addExpertise(expOsteo);

        clinicStaff.add(physio1);
        clinicStaff.add(physio2);
        clinicStaff.add(physio3);
        clinicStaff.add(physio4);
        System.out.println(" -> Loaded " + clinicStaff.size() + " physiotherapists.");
        // 3. Create Patients 

        registeredPatients.add(new Patient("Arjun Patel", "150 High Road, Ilford, IG1 1LR", "07911123456")); // P01
        registeredPatients.add(new Patient("Mei Lin", "25 Green Lane, Dagenham, RM8 1UL", "07922234567")); // P02
        registeredPatients.add(new Patient("Samir Khan", "88 Ripple Road, Barking, IG11 7PG", "07933345678")); // P03
        registeredPatients.add(new Patient("Aisha Begum", "1 Park Avenue, East Ham, London, E6 3HA", "07944456789")); // P04
        registeredPatients.add(new Patient("Raj Singh", "41 Heathway, Dagenham, RM10 8NZ", "07955567890")); // P05
        registeredPatients.add(new Patient("Priya Devi", "10 South Street, Romford, RM1 1RB", "07966678901")); // P06
        registeredPatients.add(new Patient("Chen Wei", "55 Upton Lane, Forest Gate, London, E7 9PA", "07977789012")); // P07
        registeredPatients.add(new Patient("Anika Chowdhury", "29 Ilford Lane, Ilford, IG1 2SN", "07988890123")); // P08
        registeredPatients.add(new Patient("Haruto Ito", "17 Chapel Road, Ilford, IG1 2AF", "07999901234")); // P09
        registeredPatients.add(new Patient("Nadia Hussain", "34 Whalebone Lane South, Dagenham, RM8 1AP", "07900012345")); // P10

        System.out.println(" -> Loaded " + registeredPatients.size() + " patients.");
//      Treatments over a 4-week period 
        String datePrefix = "2025-06-";
// Week 1 (June 2nd - 8th)
        availableTreatments.add(new Treatment("Massage", datePrefix + "02 10:00", physio1, 1)); // Mon
        availableTreatments.add(new Treatment("Mobilisation of the spine and joints", datePrefix + "02 11:00", physio2, 2)); // Mon
        availableTreatments.add(new Treatment("Acupuncture", datePrefix + "03 14:00", physio3, 3)); // Tue
        availableTreatments.add(new Treatment("Neural mobilisation", datePrefix + "04 09:00", physio2, 2)); // Wed
        availableTreatments.add(new Treatment("Pool rehabilitation", datePrefix + "05 15:00", physio1, 4)); // Thu
        availableTreatments.add(new Treatment("Osteopathy Session", datePrefix + "06 10:00", physio4, 5)); // Fri

        // Week 2 (June 9th - 15th)
        availableTreatments.add(new Treatment("Massage", datePrefix + "09 10:00", physio1, 1)); // Mon
        availableTreatments.add(new Treatment("Acupuncture", datePrefix + "10 14:00", physio3, 3)); // Tue
        availableTreatments.add(new Treatment("Mobilisation of the spine and joints", datePrefix + "11 11:00", physio2, 2)); // Wed
        availableTreatments.add(new Treatment("Sports Injury Rehab", datePrefix + "12 16:00", physio4, 5)); // Thu
        availableTreatments.add(new Treatment("Neural mobilisation", datePrefix + "13 09:00", physio2, 2)); // Fri

        // Week 3 (June 16th - 22nd)
        availableTreatments.add(new Treatment("Pool rehabilitation", datePrefix + "16 15:00", physio1, 4)); // Mon
        availableTreatments.add(new Treatment("Acupuncture", datePrefix + "17 14:00", physio3, 3)); // Tue
        availableTreatments.add(new Treatment("Massage", datePrefix + "18 10:00", physio1, 1)); // Wed
        availableTreatments.add(new Treatment("Osteopathy Session", datePrefix + "19 11:00", physio4, 5)); // Thu
        availableTreatments.add(new Treatment("Mobilisation of the spine and joints", datePrefix + "20 11:00", physio2, 2)); // Fri

        // Week 4 (June 23rd - 29th)
        availableTreatments.add(new Treatment("Neural mobilisation", datePrefix + "23 09:00", physio2, 2)); // Mon
        availableTreatments.add(new Treatment("Acupuncture", datePrefix + "24 14:00", physio3, 3)); // Tue
        availableTreatments.add(new Treatment("Pool rehabilitation", datePrefix + "25 15:00", physio1, 4)); // Wed
        availableTreatments.add(new Treatment("Massage", datePrefix + "26 10:00", physio1, 1)); // Thu
        availableTreatments.add(new Treatment("Sports Injury Rehab", datePrefix + "27 16:00", physio4, 5)); // Fri

        System.out.println(" -> Loaded " + availableTreatments.size() + " available treatment slots.");

//    Sample Bookings 
        Patient p1 = registeredPatients.get(0);
        Patient p2 = registeredPatients.get(1);
        Patient p3 = registeredPatients.get(2);
        Patient p4 = registeredPatients.get(3);
        Patient p5 = registeredPatients.get(4);

        Treatment t1 = availableTreatments.get(0);
        Treatment t2 = availableTreatments.get(1);
        Treatment t3 = availableTreatments.get(2);
        Treatment t6 = availableTreatments.get(6);
        Treatment t7 = availableTreatments.get(7);
        Treatment t12 = availableTreatments.get(12);

        // Booking 1
        if (t1 != null && t1.getDateTime() != null) {
            Booking booking1 = new Booking(p1, t1);
            appointmentSchedule.add(booking1);
        }
        // Booking 2
        if (t2 != null && t2.getDateTime() != null) {
            Booking booking2 = new Booking(p2, t2);
            booking2.setStatus("attended");
            appointmentSchedule.add(booking2);
        }
        // Booking 3
        if (t3 != null && t3.getDateTime() != null) {
            Booking booking3 = new Booking(p3, t3);
            booking3.setStatus("cancelled");
            appointmentSchedule.add(booking3);
        }
        // Booking 4
        if (t6 != null && t6.getDateTime() != null) {
            Booking booking4 = new Booking(p4, t6);
            appointmentSchedule.add(booking4);
        }
        // Booking 5
        if (t7 != null && t7.getDateTime() != null) {
            Booking booking5 = new Booking(p5, t7);
            booking5.setStatus("attended");
            appointmentSchedule.add(booking5);
        }
        // Booking 6
        if (t12 != null && t12.getDateTime() != null) {
            Booking booking6 = new Booking(p1, t12);
            booking6.setStatus("attended");
            appointmentSchedule.add(booking6);
        }

        System.out.println(" -> Created " + appointmentSchedule.size() + " sample bookings.");
        System.out.println("ClinicManager: Sample data loading complete.");

    }
//     Patient Management

    public boolean addPatient(String fullName, String address, String phone) {
        // Basic validation
        if (fullName == null || fullName.trim().isEmpty()
                || address == null || address.trim().isEmpty()
                || phone == null || phone.trim().isEmpty()) {
            System.err.println("ClinicManager Error: Cannot add patient - required details are missing.");
            return false; // Indicate failure
        }

        // Optional: Check for duplicate patient (e.g., by phone number)
        String trimmedPhone = phone.trim();
        boolean phoneExists = registeredPatients.stream()
                .anyMatch(p -> p.getContactPhone().equals(trimmedPhone));
        if (phoneExists) {

            System.err.println("[MANAGER VALIDATION] Duplicate Error: A patient record with phone number '" + trimmedPhone + "' is already present.");
            // if failure due to duplicate return
            return false;
        }

        // Create Patient using constructor
        Patient newPatient = new Patient(fullName.trim(), address.trim(), trimmedPhone);
        // Use the renamed list
        registeredPatients.add(newPatient);
        //  success message
        System.out.println("[MANAGER INFO] New patient record created successfully: ID=" + newPatient.getPatientId() + ", Name=" + newPatient.getFullName()); // Log success
        return true; // Indicate success
    }

    public List<Patient> getAllPatients() {
        return new ArrayList<>(registeredPatients);
    }

    public List<Physiotherapist> getAllPhysiotherapists() {
        return new ArrayList<>(clinicStaff);
    }

    public boolean removePatient(String patientId) {
        System.out.println("ClinicManager: removePatient called for ID: " + patientId + " - Implementation needed!");
        return false;
    }
}
