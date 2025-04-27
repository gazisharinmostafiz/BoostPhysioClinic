/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bpc.model;

import java.util.Objects;

/**
 *
 * @author sharin
 */
public class Booking {

    private static int nextBookingRef = 1;

    public static void resetIdCounter() {
        nextBookingRef = 1;
    }
    private String bookingId;
    private Patient bookedPatient;
    private Treatment bookedTreatment;
    private String appointmentStatus;

    public Booking(Patient patient, Treatment treatment) {
        this.bookingId = String.format("SL%02d", nextBookingRef++);
        this.bookedPatient = patient;
        this.bookedTreatment = treatment;
        this.appointmentStatus = "booked";
    }

    public String getBookingId() {
        return bookingId;
    }

    public Patient getPatient() {
        return bookedPatient;
    }

    public Treatment getTreatment() {
        return bookedTreatment;
    }

    public String getStatus() {
        return appointmentStatus;
    }

    public void setStatus(String status) {
        if ("booked".equalsIgnoreCase(status) || "cancelled".equalsIgnoreCase(status) || "attended".equalsIgnoreCase(status)) {
            this.appointmentStatus = status.toLowerCase();
        } else {
            System.err.println("Warning: Attempted to set invalid booking status: " + status + " for Booking ID: " + this.bookingId);
        }
    }

    public void setPatient(Patient bookedPatient) {
        this.bookedPatient = bookedPatient;
    }

    public void setTreatment(Treatment bookedTreatment) {
        this.bookedTreatment = bookedTreatment;
    }

    @Override
    public String toString() {
        String patientInfo = (bookedPatient != null) ? bookedPatient.getFullName() + " (ID:" + bookedPatient.getPatientId() + ")" : "N/A";
        String treatmentInfo = (bookedTreatment != null) ? bookedTreatment.getTreatmentName() + " on " + bookedTreatment.getDateTimeFormatted() + " (ID:" + bookedTreatment.getTreatmentId() + ")" : "N/A";

        return "Booking{"
                + "bookingId='" + bookingId + '\''
                + ", patient=" + patientInfo
                + ", treatment=" + treatmentInfo
                + ", status='" + appointmentStatus + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Booking booking = (Booking) o;
        return Objects.equals(bookingId, booking.bookingId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bookingId);
    }

}
