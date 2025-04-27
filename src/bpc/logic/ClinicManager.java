/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bpc.logic;

/**
 *
 * @author sharin
 */
import bpc.model.Booking;
import bpc.model.Expertise;
import bpc.model.Patient;
import bpc.model.Physiotherapist;
import bpc.model.Treatment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class ClinicManager {
    private List<Patient> registeredPatients = new ArrayList<>();
    private List<Physiotherapist> clinicStaff = new ArrayList<>();
    private List<Treatment> availableTreatments = new ArrayList<>();
    private List<Booking> appointmentSchedule = new ArrayList<>();
    private final int MAX_TREATMENT_ROOMS = 5;
    private static final DateTimeFormatter STANDARD_DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public ClinicManager() {
        loadInitialSampleData();
    }

    private void loadInitialSampleData() {
        System.out.println("ClinicManager: Loading initial sample data...");

        Expertise expRehab = new Expertise("Rehabilitation");
        Expertise expOsteo = new Expertise("Osteopathy");
        Expertise expPhysio = new Expertise("Physiotherapy");
        Expertise expSports = new Expertise("Sports Injury");
        Expertise expAcupuncture = new Expertise("Acupuncture");

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

        registeredPatients.add(new Patient("Arjun Patel", "150 High Road, Ilford, IG1 1LR", "07911123456"));
        registeredPatients.add(new Patient("Mei Lin", "25 Green Lane, Dagenham, RM8 1UL", "07922234567"));
        registeredPatients.add(new Patient("Samir Khan", "88 Ripple Road, Barking, IG11 7PG", "07933345678"));
        registeredPatients.add(new Patient("Aisha Begum", "1 Park Avenue, East Ham, London, E6 3HA", "07944456789"));
        registeredPatients.add(new Patient("Raj Singh", "41 Heathway, Dagenham, RM10 8NZ", "07955567890"));
        registeredPatients.add(new Patient("Priya Devi", "10 South Street, Romford, RM1 1RB", "07966678901"));
        registeredPatients.add(new Patient("Chen Wei", "55 Upton Lane, Forest Gate, London, E7 9PA", "07977789012"));
        registeredPatients.add(new Patient("Anika Chowdhury", "29 Ilford Lane, Ilford, IG1 2SN", "07988890123"));
        registeredPatients.add(new Patient("Haruto Ito", "17 Chapel Road, Ilford, IG1 2AF", "07999901234"));
        registeredPatients.add(new Patient("Nadia Hussain", "34 Whalebone Lane South, Dagenham, RM8 1AP", "07900012345"));
        System.out.println(" -> Loaded " + registeredPatients.size() + " patients.");

        String datePrefix = "2025-06-";
        availableTreatments.add(new Treatment("Massage", datePrefix + "02 10:00", physio1, 1));
        availableTreatments.add(new Treatment("Mobilisation of the spine and joints", datePrefix + "02 11:00", physio2, 2));
        availableTreatments.add(new Treatment("Acupuncture", datePrefix + "03 14:00", physio3, 3));
        availableTreatments.add(new Treatment("Neural mobilisation", datePrefix + "04 09:00", physio2, 2));
        availableTreatments.add(new Treatment("Pool rehabilitation", datePrefix + "05 15:00", physio1, 4));
        availableTreatments.add(new Treatment("Osteopathy Session", datePrefix + "06 10:00", physio4, 5));
        availableTreatments.add(new Treatment("Massage", datePrefix + "09 10:00", physio1, 1));
        availableTreatments.add(new Treatment("Acupuncture", datePrefix + "10 14:00", physio3, 3));
        availableTreatments.add(new Treatment("Mobilisation of the spine and joints", datePrefix + "11 11:00", physio2, 2));
        availableTreatments.add(new Treatment("Sports Injury Rehab", datePrefix + "12 16:00", physio4, 5));
        availableTreatments.add(new Treatment("Neural mobilisation", datePrefix + "13 09:00", physio2, 2));
        availableTreatments.add(new Treatment("Pool rehabilitation", datePrefix + "16 15:00", physio1, 4));
        availableTreatments.add(new Treatment("Acupuncture", datePrefix + "17 14:00", physio3, 3));
        availableTreatments.add(new Treatment("Massage", datePrefix + "18 10:00", physio1, 1));
        availableTreatments.add(new Treatment("Osteopathy Session", datePrefix + "19 11:00", physio4, 5));
        availableTreatments.add(new Treatment("Mobilisation of the spine and joints", datePrefix + "20 11:00", physio2, 2));
        availableTreatments.add(new Treatment("Neural mobilisation", datePrefix + "23 09:00", physio2, 2));
        availableTreatments.add(new Treatment("Acupuncture", datePrefix + "24 14:00", physio3, 3));
        availableTreatments.add(new Treatment("Pool rehabilitation", datePrefix + "25 15:00", physio1, 4));
        availableTreatments.add(new Treatment("Massage", datePrefix + "26 10:00", physio1, 1));
        availableTreatments.add(new Treatment("Sports Injury Rehab", datePrefix + "27 16:00", physio4, 5));
        System.out.println(" -> Loaded " + availableTreatments.size() + " available treatment slots.");

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
        if (t1 != null && t1.getDateTime() != null) { appointmentSchedule.add(new Booking(p1, t1)); }
        if (t2 != null && t2.getDateTime() != null) { Booking b2 = new Booking(p2, t2); b2.setStatus("attended"); appointmentSchedule.add(b2); }
        if (t3 != null && t3.getDateTime() != null) { Booking b3 = new Booking(p3, t3); b3.setStatus("cancelled"); appointmentSchedule.add(b3); }
        if (t6 != null && t6.getDateTime() != null) { appointmentSchedule.add(new Booking(p4, t6)); }
        if (t7 != null && t7.getDateTime() != null) { Booking b5 = new Booking(p5, t7); b5.setStatus("attended"); appointmentSchedule.add(b5); }
        if (t12 != null && t12.getDateTime() != null) { Booking b6 = new Booking(p1, t12); b6.setStatus("attended"); appointmentSchedule.add(b6); }
        System.out.println(" -> Created " + appointmentSchedule.size() + " sample bookings.");
        System.out.println("ClinicManager: Sample data loading complete.");
    }

    public boolean addPatient(String fullName, String address, String phone) {
        if (fullName == null || fullName.trim().isEmpty() || address == null || address.trim().isEmpty() || phone == null || phone.trim().isEmpty()) {
            System.err.println("ClinicManager Error: Cannot add patient - required details are missing.");
            return false;
        }
        String trimmedPhone = phone.trim();
        boolean phoneExists = registeredPatients.stream().anyMatch(p -> p.getContactPhone().equals(trimmedPhone));
        if (phoneExists) {
            System.err.println("[MANAGER VALIDATION] Duplicate Error: A patient record with phone number '" + trimmedPhone + "' is already present.");
            return false;
        }
        Patient newPatient = new Patient(fullName.trim(), address.trim(), trimmedPhone);
        registeredPatients.add(newPatient);
        System.out.println("[MANAGER INFO] New patient record created successfully: ID=" + newPatient.getPatientId() + ", Name=" + newPatient.getFullName());
        return true;
    }

    public boolean addPhysiotherapist(String name, String address, String phone, List<String> expertiseNames) {
        if (name == null || name.trim().isEmpty() || address == null || address.trim().isEmpty() || phone == null || phone.trim().isEmpty()) {
            System.err.println("[MANAGER VALIDATION] Error: Cannot add physiotherapist - required name, address, or phone are missing.");
            return false;
        }
        if (expertiseNames == null || expertiseNames.isEmpty()) {
            System.err.println("[MANAGER VALIDATION] Error: Cannot add physiotherapist - at least one expertise must be provided.");
            return false;
        }
        String trimmedPhone = phone.trim();
        boolean phoneExists = clinicStaff.stream().anyMatch(p -> p.getContactNumber().equals(trimmedPhone));
        if (phoneExists) {
            System.err.println("[MANAGER VALIDATION] Duplicate Error: A staff member with phone number '" + trimmedPhone + "' already exists.");
            return false;
        }
        Physiotherapist newPhysio = new Physiotherapist(name.trim(), address.trim(), trimmedPhone);
        Set<String> addedExpertise = new HashSet<>();
        for (String expName : expertiseNames) {
            if (expName != null && !expName.trim().isEmpty()) {
                String trimmedExpName = expName.trim();
                if (addedExpertise.add(trimmedExpName.toLowerCase())) {
                    newPhysio.addExpertise(new Expertise(trimmedExpName));
                    System.out.println("  -> Added expertise '" + trimmedExpName + "' to " + newPhysio.getStaffName());
                }
            }
        }
        clinicStaff.add(newPhysio);
        System.out.println("[MANAGER INFO] New physiotherapist record created successfully: ID=" + newPhysio.getStaffId() + ", Name=" + newPhysio.getStaffName());
        return true;
    }

    public List<Patient> getAllPatients() {
        return new ArrayList<>(registeredPatients);
    }
    public List<Physiotherapist> getAllPhysiotherapists() {
        return new ArrayList<>(clinicStaff);
    }
    public List<Booking> getAllBookings() {
        return new ArrayList<>(appointmentSchedule);
    }

public List<String> getUniqueExpertiseNames() {
    return clinicStaff.stream() 
            .flatMap(physio -> physio.getAreasOfExpertise().stream()) 
            .map(Expertise::getName) 
            .filter(Objects::nonNull) 
            .map(String::trim)
            .filter(name -> !name.isEmpty())
            .distinct()
            .sorted(String.CASE_INSENSITIVE_ORDER) 
            .collect(Collectors.toList()); 
}


public List<String> getPhysiotherapistDisplayList() {
    return clinicStaff.stream()
            .sorted(Comparator.comparing(Physiotherapist::getStaffName, String.CASE_INSENSITIVE_ORDER)) // Sort by name
            .map(p -> p.getStaffName() + " (" + p.getStaffId() + ")") // Format as "Name (ID)"
            .collect(Collectors.toList());
}


public String findPhysioNameFromDisplay(String displayName) {
    if (displayName == null || !displayName.contains(" (")) {
        return null;
    }
    
    String namePart = displayName.substring(0, displayName.lastIndexOf(" ("));
    
    return clinicStaff.stream()
            .filter(p -> p.getStaffName().equals(namePart))
            .map(Physiotherapist::getStaffName)
            .findFirst()
            .orElse(null); 
}

    public boolean removePatient(String patientId) {
        if (patientId == null || patientId.trim().isEmpty()) {
            System.err.println("[MANAGER VALIDATION] Error: Attempted to remove patient with null or empty ID.");
            return false;
        }
        String targetId = patientId.trim();
        Patient patientToRemove = registeredPatients.stream()
                .filter(p -> p.getPatientId().equalsIgnoreCase(targetId))
                .findFirst()
                .orElse(null);
        if (patientToRemove == null) {
            System.err.println("[MANAGER INFO] Patient with ID '" + targetId + "' not found for removal.");
            return false;
        }
        System.out.println("[MANAGER INFO] Found patient to remove: " + patientToRemove.getFullName() + " (ID: " + patientToRemove.getPatientId() + ")");
        int cancelledCount = 0;
        for (Booking booking : appointmentSchedule) {
            if (booking.getPatient() != null && booking.getPatient().equals(patientToRemove) && "booked".equals(booking.getStatus())) {
                booking.setStatus("cancelled");
                cancelledCount++;
                System.out.println("  -> Cancelled booking ID: " + booking.getBookingId());
            }
        }
        if (cancelledCount > 0) { System.out.println("[MANAGER INFO] Cancelled " + cancelledCount + " future booking(s) for patient " + patientToRemove.getPatientId() + "."); }
        else { System.out.println("[MANAGER INFO] No active future bookings found to cancel for patient " + patientToRemove.getPatientId() + "."); }
        boolean removed = registeredPatients.remove(patientToRemove);
        if (removed) { System.out.println("[MANAGER INFO] Patient record " + patientToRemove.getPatientId() + " removed successfully."); }
        else { System.err.println("[MANAGER ERROR] Failed to remove patient " + patientToRemove.getPatientId() + " from the list, although they were found initially."); }
        return removed;
    }
    public boolean removePhysiotherapist(String staffId) {
        if (staffId == null || staffId.trim().isEmpty()) {
            System.err.println("[MANAGER VALIDATION] Error: Attempted to remove physiotherapist with null or empty ID.");
            return false;
        }
        String targetId = staffId.trim();
        Physiotherapist physioToRemove = clinicStaff.stream()
                .filter(p -> p.getStaffId().equalsIgnoreCase(targetId))
                .findFirst()
                .orElse(null);
        if (physioToRemove == null) {
            System.err.println("[MANAGER INFO] Physiotherapist with ID '" + targetId + "' not found for removal.");
            return false;
        }
        System.out.println("[MANAGER INFO] Found physiotherapist to remove: " + physioToRemove.getStaffName() + " (ID: " + physioToRemove.getStaffId() + ")");
        List<Treatment> treatmentsToCancelOrRemove = new ArrayList<>();
        for (Treatment t : availableTreatments) {
            if (t.getPhysiotherapist() != null && t.getPhysiotherapist().equals(physioToRemove)) {
                boolean isAttended = appointmentSchedule.stream()
                        .anyMatch(b -> b.getTreatment() != null && b.getTreatment().equals(t) && "attended".equals(b.getStatus()));
                if (!isAttended) { treatmentsToCancelOrRemove.add(t); }
                else { System.out.println("  -> Keeping attended treatment: " + t.getTreatmentId() + " (" + t.getTreatmentName() + ")"); }
            }
        }
        int cancelledBookingsCount = 0;
        if (!treatmentsToCancelOrRemove.isEmpty()) {
            System.out.println("  -> Cancelling future/non-attended bookings associated with " + physioToRemove.getStaffName() + ":");
            for (Booking b : appointmentSchedule) {
                if (b.getTreatment() != null && treatmentsToCancelOrRemove.contains(b.getTreatment()) && "booked".equals(b.getStatus())) {
                    b.setStatus("cancelled");
                    cancelledBookingsCount++;
                    String patientName = (b.getPatient() != null) ? b.getPatient().getFullName() : "Unknown Patient";
                    System.out.println("    - Booking " + b.getBookingId() + " (Patient: " + patientName + ") cancelled.");
                }
            }
        }
        if (cancelledBookingsCount > 0) { System.out.println("[MANAGER INFO] Cancelled " + cancelledBookingsCount + " booking(s) associated with removed physiotherapist."); }
        else { System.out.println("[MANAGER INFO] No active bookings found to cancel for treatments associated with " + physioToRemove.getStaffId() + "."); }
        boolean treatmentsRemoved = availableTreatments.removeAll(treatmentsToCancelOrRemove);
        if (treatmentsRemoved && !treatmentsToCancelOrRemove.isEmpty()) { System.out.println("[MANAGER INFO] Removed " + treatmentsToCancelOrRemove.size() + " non-attended treatment slots associated with " + physioToRemove.getStaffId() + "."); }
        boolean staffRemoved = clinicStaff.remove(physioToRemove);
        if (staffRemoved) { System.out.println("[MANAGER INFO] Physiotherapist record " + physioToRemove.getStaffId() + " removed successfully."); }
        else { System.err.println("[MANAGER ERROR] Failed to remove physiotherapist " + physioToRemove.getStaffId() + " from the list, although they were found initially."); }
        return staffRemoved;
    }

    public List<Treatment> findAvailableTreatments(String searchBy, String criteria) {
        if (criteria == null || criteria.trim().isEmpty() || searchBy == null) {
            System.err.println("[MANAGER VALIDATION] Search criteria or type cannot be empty for finding treatments.");
            return new ArrayList<>();
        }
        String trimmedCriteria = criteria.trim().toLowerCase();
        LocalDateTime now = LocalDateTime.now();
        List<Treatment> potentialSlots = new ArrayList<>();

        if ("expertise".equalsIgnoreCase(searchBy)) {
            potentialSlots = availableTreatments.stream()
                    .filter(t -> t.getPhysiotherapist() != null && t.getPhysiotherapist().hasExpertise(trimmedCriteria))
                    .collect(Collectors.toList());
        } else if ("physioName".equalsIgnoreCase(searchBy)) {
            potentialSlots = availableTreatments.stream()
                    .filter(t -> t.getPhysiotherapist() != null && t.getPhysiotherapist().getStaffName().toLowerCase().contains(trimmedCriteria))
                    .collect(Collectors.toList());
        } else {
            System.err.println("[MANAGER ERROR] Invalid search type specified: " + searchBy);
            return new ArrayList<>();
        }

        List<Treatment> availableFutureSlots = potentialSlots.stream()
                .filter(t -> t.getDateTime() != null && t.getDateTime().isAfter(now))
                .filter(t -> !isTreatmentBooked(t))
                .sorted(Comparator.comparing(Treatment::getDateTime))
                .collect(Collectors.toList());

        System.out.println("[MANAGER INFO] Found " + availableFutureSlots.size() + " available slots matching criteria: " + searchBy + "='" + criteria + "'");
        return availableFutureSlots;
    }

    private boolean isTreatmentBooked(Treatment treatment) {
        if (treatment == null) return true;
        return appointmentSchedule.stream()
                .anyMatch(b -> b.getTreatment() != null && b.getTreatment().equals(treatment) && "booked".equals(b.getStatus()));
    }


    public Booking createBooking(String patientId, String treatmentId) {
        if (patientId == null || patientId.trim().isEmpty() || treatmentId == null || treatmentId.trim().isEmpty()) {
            System.err.println("[MANAGER VALIDATION] Patient ID or Treatment ID cannot be empty for booking.");
            return null;
        }

        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.err.println("[MANAGER ERROR] Booking failed: Patient with ID '" + patientId + "' not found.");
            return null;
        }

        Treatment treatment = findTreatmentById(treatmentId);
        if (treatment == null) {
            System.err.println("[MANAGER ERROR] Booking failed: Treatment with ID '" + treatmentId + "' not found.");
            return null;
        }
        if (treatment.getDateTime() == null || treatment.getDateTime().isBefore(LocalDateTime.now())) {
            System.err.println("[MANAGER ERROR] Booking failed: Treatment '" + treatmentId + "' is in the past or has an invalid date.");
            return null;
        }

        LocalDateTime bookingTime = treatment.getDateTime();
        int bookingRoom = treatment.getRoomNumber();
        Physiotherapist bookingPhysio = treatment.getPhysiotherapist();
        if (bookingPhysio == null) {
            System.err.println("[MANAGER ERROR] Booking failed: Treatment '" + treatmentId + "' has no assigned physiotherapist.");
            return null;
        }

        if (isTreatmentBooked(treatment)) {
            System.err.println("[MANAGER CONFLICT] Booking failed: Treatment slot " + treatmentId + " is already booked.");
            return null;
        }

        boolean patientTimeConflict = appointmentSchedule.stream()
                .anyMatch(b -> b.getPatient() != null && b.getPatient().equals(patient)
                        && b.getTreatment() != null && b.getTreatment().getDateTime() != null
                        && b.getTreatment().getDateTime().equals(bookingTime)
                        && "booked".equals(b.getStatus()));
        if (patientTimeConflict) {
            System.err.println("[MANAGER CONFLICT] Booking failed: Patient " + patient.getPatientId() + " already has an appointment at " + bookingTime.format(STANDARD_DATE_TIME_FORMAT));
            return null;
        }

        boolean roomTimeConflict = appointmentSchedule.stream()
                .anyMatch(b -> b.getTreatment() != null
                        && b.getTreatment().getRoomNumber() == bookingRoom
                        && b.getTreatment().getDateTime() != null
                        && b.getTreatment().getDateTime().equals(bookingTime)
                        && "booked".equals(b.getStatus()));
        if (roomTimeConflict) {
            System.err.println("[MANAGER CONFLICT] Booking failed: Room " + bookingRoom + " is already booked at " + bookingTime.format(STANDARD_DATE_TIME_FORMAT));
            return null;
        }

        boolean physioTimeConflict = appointmentSchedule.stream()
                .anyMatch(b -> b.getTreatment() != null && b.getTreatment().getPhysiotherapist() != null
                        && b.getTreatment().getPhysiotherapist().equals(bookingPhysio)
                        && b.getTreatment().getDateTime() != null
                        && b.getTreatment().getDateTime().equals(bookingTime)
                        && "booked".equals(b.getStatus()));
        if (physioTimeConflict) {
            System.err.println("[MANAGER CONFLICT] Booking failed: Physiotherapist " + bookingPhysio.getStaffName() + " is already booked at " + bookingTime.format(STANDARD_DATE_TIME_FORMAT));
            return null;
        }

        Booking newBooking = new Booking(patient, treatment);
        appointmentSchedule.add(newBooking);
        System.out.println("[MANAGER INFO] Booking created successfully: " + newBooking);
        return newBooking;
    }

    public Booking findBookingById(String bookingId) {
        if (bookingId == null || bookingId.trim().isEmpty()) {
            return null;
        }
        String targetId = bookingId.trim();
        return appointmentSchedule.stream()
                .filter(b -> b.getBookingId().equalsIgnoreCase(targetId))
                .findFirst()
                .orElse(null);
    }

    public boolean changeBookingStatus(String bookingId, String newStatus) {
        Booking booking = findBookingById(bookingId);
        if (booking == null) {
            System.err.println("[MANAGER ERROR] Cannot change status: Booking ID '" + bookingId + "' not found.");
            return false;
        }

        String currentStatus = booking.getStatus();
        String targetStatus = (newStatus != null) ? newStatus.trim().toLowerCase() : null;

        if (targetStatus == null || (!targetStatus.equals("cancelled") && !targetStatus.equals("attended"))) {
            System.err.println("[MANAGER VALIDATION] Invalid target status specified: '" + newStatus + "'. Must be 'cancelled' or 'attended'.");
            return false;
        }

        if (currentStatus.equals("cancelled") || currentStatus.equals("attended")) {
            System.err.println("[MANAGER INFO] Booking " + bookingId + " is already '" + currentStatus + "' and cannot be changed.");
            return false;
        }

        if (targetStatus.equals("cancelled")) {
            if (booking.getTreatment() != null && booking.getTreatment().getDateTime() != null &&
                    booking.getTreatment().getDateTime().isBefore(LocalDateTime.now())) {
                System.err.println("[MANAGER INFO] Cannot cancel booking " + bookingId + " because it is in the past.");
                return false;
            }
            booking.setStatus(targetStatus);
            System.out.println("[MANAGER INFO] Booking " + bookingId + " status changed to 'cancelled'.");
            return true;
        }

        if (targetStatus.equals("attended")) {
            if (booking.getTreatment() != null && booking.getTreatment().getDateTime() != null &&
                    booking.getTreatment().getDateTime().isAfter(LocalDateTime.now())) {
                System.err.println("[MANAGER INFO] Cannot mark booking " + bookingId + " as attended because it is still in the future.");
                return false;
            }
            booking.setStatus(targetStatus);
            System.out.println("[MANAGER INFO] Booking " + bookingId + " status changed to 'attended'.");
            return true;
        }

        return false;
    }

    private Patient findPatientById(String patientId) {
        if (patientId == null || patientId.trim().isEmpty()) return null;
        String targetId = patientId.trim();
        return registeredPatients.stream()
                .filter(p -> p.getPatientId().equalsIgnoreCase(targetId))
                .findFirst()
                .orElse(null);
    }

    private Treatment findTreatmentById(String treatmentId) {
        if (treatmentId == null || treatmentId.trim().isEmpty()) return null;
        String targetId = treatmentId.trim();
        return availableTreatments.stream()
                .filter(t -> t.getTreatmentId().equalsIgnoreCase(targetId))
                .findFirst()
                .orElse(null);
    }

}