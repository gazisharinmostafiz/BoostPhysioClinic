/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bpc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 *
 * @author sharin
 */
public class Physiotherapist {

    private static int nextStaffNumber = 1;
    public static void resetIdCounter() {
        nextStaffNumber = 1;
    }
    private String staffId;         
    private String staffName;       
    private String practiceAddress;
    private String contactNumber;   
    private List<Expertise> areasOfExpertise = new ArrayList<>();

    public Physiotherapist(String name, String address, String phone) {
        this.staffId = String.format("PH%02d", nextStaffNumber++);
        this.staffName = name;
        this.practiceAddress = address;
        this.contactNumber = phone;
        // No
    }

    public String getStaffId() { 
        return staffId;
    }

    public String getStaffName() { 
        return staffName;
    }

    public String getPracticeAddress() { 
        return practiceAddress;
    }

    public String getContactNumber() { 
        return contactNumber;
    }

    public List<Expertise> getAreasOfExpertise() { 
        return new ArrayList<>(areasOfExpertise);
    }

  
    public void setStaffName(String staffName) { 
        this.staffName = staffName;
    }

    public void setPracticeAddress(String practiceAddress) { 
        this.practiceAddress = practiceAddress;
    }

    public void setContactNumber(String contactNumber) { 
        this.contactNumber = contactNumber;
    }

    public void addExpertise(Expertise expertise) {
        
        if (expertise != null && !this.areasOfExpertise.contains(expertise)) {
            this.areasOfExpertise.add(expertise);
        }
    }

public boolean hasExpertise(String expertiseName) {
        if (expertiseName == null || expertiseName.trim().isEmpty()) {
            return false;
        }
        String lowerCaseName = expertiseName.trim().toLowerCase();
        // Corrected comparison to be case-insensitive and added null check
        return areasOfExpertise.stream()
                .anyMatch(e -> e.getName() != null && e.getName().equalsIgnoreCase(lowerCaseName));
    }

    // --- toString Method ---
    @Override
    public String toString() {
       
        return "Physiotherapist{"
                + "staffId='" + staffId + '\''
                + ", staffName='" + staffName + '\''
                + ", practiceAddress='" + practiceAddress + '\''
                + ", contactNumber='" + contactNumber + '\''
                + ", areasOfExpertise=" + areasOfExpertise
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
        Physiotherapist that = (Physiotherapist) o;
       
        return Objects.equals(staffId, that.staffId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(staffId);
    }
}
