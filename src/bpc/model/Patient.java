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
public class Patient {

    private static int nextPatientNumber = 1;
    private String patientId;
    private String fullName;
    private String homeAddress;
    private String contactPhone;

    public Patient(String name, String address, String phone) {
        this.patientId = String.format("P%02d", nextPatientNumber++);
        this.fullName = name;
        this.homeAddress = address;
        this.contactPhone = phone;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String toString() {

        return "Patient{"
                + "patientId='" + patientId + '\''
                + ", fullName='" + fullName + '\''
                + ", homeAddress='" + homeAddress + '\''
                + ", contactPhone='" + contactPhone + '\''
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
        Patient otherPatient = (Patient) o;
        return Objects.equals(patientId, otherPatient.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(patientId);
    }
}
