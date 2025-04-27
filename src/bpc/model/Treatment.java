/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bpc.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

/**
 *
 * @author sharin
 */
public class Treatment {

    private static int nextTreatmentCode = 1;
    private static final DateTimeFormatter STANDARD_DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private String treatmentId;
    private String treatmentName;
    private LocalDateTime scheduledTime;
    private Physiotherapist assignedStaff;
    private int assignedRoom;

    public Treatment(String name, String dateTimeString, Physiotherapist physio, int roomNumber) {

        this.treatmentId = String.format("TREF%02d", nextTreatmentCode++);
        this.treatmentName = name;
        this.assignedStaff = physio;
        this.assignedRoom = roomNumber;

        try {

            if (dateTimeString != null && !dateTimeString.trim().isEmpty()) {

                this.scheduledTime = LocalDateTime.parse(dateTimeString.trim(), STANDARD_DATE_TIME_FORMAT);
            } else {

                System.err.println("Error: Date/time string was null or empty for treatment '" + name + "'.");
                this.scheduledTime = null;
            }
        } catch (DateTimeParseException e) {

            System.err.println("Error parsing date/time string for treatment '" + name + "': '" + dateTimeString + "'. Please use 'yyyy-MM-dd HH:mm' format. " + e.getMessage());

            this.scheduledTime = null;
        } catch (Exception e) {
            System.err.println("Unexpected error initializing treatment '" + name + "': " + e.getMessage());
            this.scheduledTime = null;
        }

    }

    // --- Getters ---
    public String getTreatmentId() {
        return treatmentId;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public LocalDateTime getDateTime() {
        return scheduledTime;
    }

    public String getDateTimeFormatted() {
        if (this.scheduledTime != null) {
            try {
                return this.scheduledTime.format(STANDARD_DATE_TIME_FORMAT);
            } catch (Exception e) {
                System.err.println("Error formatting date for treatment " + treatmentId + ": " + e.getMessage());
                return "Formatting Error";
            }
        } else {
            return "Invalid/Unset Date";
        }
    }

    public Physiotherapist getPhysiotherapist() {
        return assignedStaff;
    }

    public int getRoomNumber() {
        return assignedRoom;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public boolean setScheduledTimeFromString(String dateTimeString) {
        try {
            if (dateTimeString == null || dateTimeString.trim().isEmpty()) {
                System.err.println("Error setting date/time string for treatment '" + treatmentName + "': Input string was null or empty.");
                this.scheduledTime = null;
                return false;
            }
            this.scheduledTime = LocalDateTime.parse(dateTimeString.trim(), STANDARD_DATE_TIME_FORMAT);
            return true;
        } catch (DateTimeParseException e) {
            System.err.println("Error setting date/time string for treatment '" + treatmentName + "': '" + dateTimeString + "'. Use 'yyyy-MM-dd HH:mm'. " + e.getMessage());
            this.scheduledTime = null;
            return false;
        } catch (Exception e) {
            System.err.println("Unexpected error setting date/time from string for treatment '" + treatmentName + "': " + e.getMessage());
            this.scheduledTime = null;
            return false;
        }
    }

    public void setAssignedStaff(Physiotherapist assignedStaff) {
        this.assignedStaff = assignedStaff;
    }

    public void setAssignedRoom(int assignedRoom) {
        this.assignedRoom = assignedRoom;
    }

    @Override
    public String toString() {
        return "Treatment{"
                + "treatmentId='" + treatmentId + '\''
                + ", treatmentName='" + treatmentName + '\''
                + ", scheduledTime=" + getDateTimeFormatted()
                + ", assignedStaff=" + (assignedStaff != null ? assignedStaff.getStaffName() + " (ID:" + assignedStaff.getStaffId() + ")" : "N/A")
                + ", assignedRoom=" + assignedRoom
                + '}';
    }

    //equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Treatment treatment = (Treatment) o;
        return Objects.equals(treatmentId, treatment.treatmentId);
    }

    @Override
    public int hashCode() {

        return Objects.hashCode(treatmentId);
    }

}
