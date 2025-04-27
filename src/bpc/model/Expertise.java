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
public class Expertise {
private String expertiseAreaName;

    public Expertise(String name) {
        this.expertiseAreaName = (name != null) ? name.trim() : null;
    }
    public String getName() {
        return expertiseAreaName;
    }
    public void setName(String name) { 
        this.expertiseAreaName = (name != null) ? name.trim() : null;
    }

    @Override
    public boolean equals(Object o) {
         // Same object instance
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false; 
        Expertise expertise = (Expertise) o;
    
        return (expertiseAreaName != null) ? expertiseAreaName.equalsIgnoreCase(expertise.expertiseAreaName) : expertise.expertiseAreaName == null;
    }

    @Override
    public int hashCode() {
       
        return (expertiseAreaName != null) ? expertiseAreaName.toLowerCase().hashCode() : 0;
    }

    @Override
    public String toString() {
        return (expertiseAreaName != null) ? expertiseAreaName : "N/A";
    }
}