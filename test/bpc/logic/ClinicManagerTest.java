package bpc.logic; // Ensure this matches your test package

import bpc.logic.ClinicManager;
import bpc.model.Patient;
import bpc.model.Physiotherapist;
import bpc.model.Expertise;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the ClinicManager class.
 * Uses JUnit 4.
 * @author sharin
 */
public class ClinicManagerTest {

    private ClinicManager manager;

    public ClinicManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
         System.out.println("--- Setting Up Test Class (JUnit 4) ---");
    }

    @AfterClass
    public static void tearDownClass() {
         System.out.println("--- Tearing Down Test Class (JUnit 4) ---");
    }

    @Before
    public void setUp() {
        manager = new ClinicManager();
        // Explicitly load data before each test
        manager.resetAndLoadData();
        System.out.println("--- Running setUp() before test (JUnit 4) ---");
    }

    @After
    public void tearDown() {
        System.out.println("--- Running tearDown() after test ---");
        manager = null;
    }

    // --- Test Methods for addPatient ---

    @Test
    public void testAddPatient_Success() {
        System.out.println("Running testAddPatient_Success...");
        String name = "Test Patient One";
        String address = "1 Test Street, Testville";
        String phone = "01234567890";
        int initialPatientCount = manager.getAllPatients().size();

        boolean result = manager.addPatient(name, address, phone);

        assertTrue("addPatient should return true for a valid new patient.", result);

        List<Patient> updatedPatients = manager.getAllPatients();
        assertEquals("Patient list size should increase by 1.", initialPatientCount + 1, updatedPatients.size());

        Patient addedPatient = updatedPatients.stream()
                .filter(p -> p.getFullName().equals(name) && p.getContactPhone().equals(phone))
                .findFirst()
                .orElse(null);
        assertNotNull("The newly added patient should be found in the list.", addedPatient);
        assertEquals("Added patient's address should match input.", address, addedPatient.getHomeAddress());
        assertNotNull("Added patient should have a non-null ID.", addedPatient.getPatientId());
        System.out.println("testAddPatient_Success PASSED.");
    }

    @Test
    public void testAddPatient_DuplicatePhone() {
         System.out.println("Running testAddPatient_DuplicatePhone...");
        String name = "Duplicate Test Patient";
        String address = "123 Duplicate Lane";
        String duplicatePhone = "07911123456"; // Phone of Arjun Patel from sample data
        int initialPatientCount = manager.getAllPatients().size();

        boolean result = manager.addPatient(name, address, duplicatePhone);

        assertFalse("addPatient should return false for a duplicate phone number.", result);
        assertEquals("Patient list size should NOT increase for duplicate.", initialPatientCount, manager.getAllPatients().size());
         System.out.println("testAddPatient_DuplicatePhone PASSED.");
    }

    @Test
    public void testAddPatient_EmptyDetails() {
        System.out.println("Running testAddPatient_EmptyDetails...");
        int initialPatientCount = manager.getAllPatients().size();

        boolean resultEmptyName = manager.addPatient("", "Some Address", "9876543210");
        assertFalse("addPatient should return false for empty name.", resultEmptyName);
        assertEquals("Patient list size should not change for empty name.", initialPatientCount, manager.getAllPatients().size());

        boolean resultEmptyAddress = manager.addPatient("Valid Name", "", "9876543211");
        assertFalse("addPatient should return false for empty address.", resultEmptyAddress);
         assertEquals("Patient list size should not change for empty address.", initialPatientCount, manager.getAllPatients().size());

        boolean resultEmptyPhone = manager.addPatient("Valid Name", "Some Address", "");
        assertFalse("addPatient should return false for empty phone.", resultEmptyPhone);
         assertEquals("Patient list size should not change for empty phone.", initialPatientCount, manager.getAllPatients().size());

         System.out.println("testAddPatient_EmptyDetails PASSED.");
    }

    // --- Test Methods for removePatient ---
    @Test
    public void testRemovePatient_Success() {
        System.out.println("Running testRemovePatient_Success (Self-Contained)...");

        String testName = "PatientToRemove Test";
        String testAddress = "123 Removal Lane";
        String testPhone = "09998887776"; 
        boolean addResult = manager.addPatient(testName, testAddress, testPhone);
        assertTrue("Setup: Failed to add the test patient.", addResult);

        Patient addedPatient = manager.getAllPatients().stream()
                                    .filter(p -> p.getContactPhone().equals(testPhone))
                                    .findFirst()
                                    .orElse(null);
        assertNotNull("Setup: Could not find the newly added test patient.", addedPatient);
        String patientIdToRemove = addedPatient.getPatientId();
        System.out.println("  Test patient added with ID: " + patientIdToRemove);

        int patientCountBeforeRemoval = manager.getAllPatients().size();
        System.out.println("  Patient count before removal: " + patientCountBeforeRemoval);

        
        boolean removeResult = manager.removePatient(patientIdToRemove);
        System.out.println("  manager.removePatient returned: " + removeResult);
        assertTrue("removePatient should return true for the test patient.", removeResult);

        List<Patient> patientsAfterRemoval = manager.getAllPatients();
        int patientCountAfterRemoval = patientsAfterRemoval.size();
        System.out.println("  Patient count after removal: " + patientCountAfterRemoval);

        assertEquals("Patient list size should decrease by 1.", patientCountBeforeRemoval - 1, patientCountAfterRemoval);

        Patient patientAfter = patientsAfterRemoval.stream()
                                    .filter(p -> p.getPatientId().equalsIgnoreCase(patientIdToRemove))
                                    .findFirst().orElse(null);
        assertNull("Patient " + patientIdToRemove + " should no longer be in the list.", patientAfter);

        System.out.println("testRemovePatient_Success (Self-Contained) PASSED.");
    }
//    ----------wnd
    @Test
    public void testRemovePatient_NotFound() {
        System.out.println("Running testRemovePatient_NotFound...");
        String nonExistentId = "PT999";
        int initialPatientCount = manager.getAllPatients().size();

        boolean result = manager.removePatient(nonExistentId);

        assertFalse("removePatient should return false for a non-existent patient ID.", result);
        assertEquals("Patient list size should remain unchanged.", initialPatientCount, manager.getAllPatients().size());

        System.out.println("testRemovePatient_NotFound PASSED.");
    }

    // --- Test Methods for addPhysiotherapist ---

    @Test
    public void testAddPhysiotherapist_Success() {
        System.out.println("Running testAddPhysiotherapist_Success...");
        String name = "Dr. Test Physio";
        String address = "1 Test Clinic";
        String phone = "09876543210";
        List<String> expertise = Arrays.asList("Testing", "Debugging");
        int initialStaffCount = manager.getAllPhysiotherapists().size();

        boolean result = manager.addPhysiotherapist(name, address, phone, expertise);

        assertTrue("addPhysiotherapist should return true for valid input.", result);
        assertEquals("Staff list size should increase by 1.", initialStaffCount + 1, manager.getAllPhysiotherapists().size());

        Physiotherapist addedPhysio = manager.getAllPhysiotherapists().stream()
                                        .filter(p -> p.getStaffName().equals(name))
                                        .findFirst().orElse(null);
        assertNotNull("Added physiotherapist should be found.", addedPhysio);
        assertEquals("Address should match.", address, addedPhysio.getPracticeAddress());
        assertEquals("Phone should match.", phone, addedPhysio.getContactNumber());
        assertNotNull("Staff ID should not be null.", addedPhysio.getStaffId());
        assertEquals("Number of expertise areas should match.", expertise.size(), addedPhysio.getAreasOfExpertise().size());

        List<String> actualExpertiseNames = addedPhysio.getAreasOfExpertise().stream()
                                                .map(Expertise::getName)
                                                .collect(Collectors.toList());
        System.out.println("  Actual expertise for added physio: " + actualExpertiseNames);

        assertTrue("Should have Testing expertise.", addedPhysio.hasExpertise("Testing"));
        assertTrue("Should have Debugging expertise.", addedPhysio.hasExpertise("Debugging"));

        System.out.println("testAddPhysiotherapist_Success PASSED.");
    }

    @Test
    public void testAddPhysiotherapist_DuplicatePhone() {
        System.out.println("Running testAddPhysiotherapist_DuplicatePhone...");
        String name = "Another Physio";
        String address = "456 Test Ave";
        String duplicatePhone = "02081112233"; // Phone of Dr. Priya Sharma
        List<String> expertise = Arrays.asList("General");
        int initialStaffCount = manager.getAllPhysiotherapists().size();

        boolean result = manager.addPhysiotherapist(name, address, duplicatePhone, expertise);

        assertFalse("addPhysiotherapist should return false for duplicate phone.", result);
        assertEquals("Staff list size should not increase.", initialStaffCount, manager.getAllPhysiotherapists().size());

        System.out.println("testAddPhysiotherapist_DuplicatePhone PASSED.");
    }

    @Test
    public void testAddPhysiotherapist_MissingDetails() {
        System.out.println("Running testAddPhysiotherapist_MissingDetails...");
        List<String> expertise = Arrays.asList("Valid Expertise");
        int initialStaffCount = manager.getAllPhysiotherapists().size();

        assertFalse("Should fail with empty name.", manager.addPhysiotherapist("", "Addr", "Phone", expertise));
        assertEquals("Staff count unchanged.", initialStaffCount, manager.getAllPhysiotherapists().size());

        assertFalse("Should fail with empty address.", manager.addPhysiotherapist("Name", "", "Phone", expertise));
        assertEquals("Staff count unchanged.", initialStaffCount, manager.getAllPhysiotherapists().size());

        assertFalse("Should fail with empty phone.", manager.addPhysiotherapist("Name", "Addr", "", expertise));
        assertEquals("Staff count unchanged.", initialStaffCount, manager.getAllPhysiotherapists().size());

        System.out.println("testAddPhysiotherapist_MissingDetails PASSED.");
    }

     @Test
    public void testAddPhysiotherapist_NoExpertise() {
        System.out.println("Running testAddPhysiotherapist_NoExpertise...");
        int initialStaffCount = manager.getAllPhysiotherapists().size();

        assertFalse("Should fail with null expertise list.", manager.addPhysiotherapist("Name", "Addr", "Phone1", null));
        assertEquals("Staff count unchanged.", initialStaffCount, manager.getAllPhysiotherapists().size());

        assertFalse("Should fail with empty expertise list.", manager.addPhysiotherapist("Name", "Addr", "Phone2", new ArrayList<>()));
        assertEquals("Staff count unchanged.", initialStaffCount, manager.getAllPhysiotherapists().size());

        System.out.println("testAddPhysiotherapist_NoExpertise PASSED.");
    }

    // --- Test Methods for removePhysiotherapist ---

    @Test
    public void testRemovePhysiotherapist_Success() {
        System.out.println("Running testRemovePhysiotherapist_Success...");
        String physioIdToRemove = "PH02"; // Mr. Kenji Tanaka
        int initialStaffCount = manager.getAllPhysiotherapists().size();
        System.out.println("  Initial staff count: " + initialStaffCount);

        List<Physiotherapist> staffBefore = manager.getAllPhysiotherapists();
        String staffIdsBefore = staffBefore.stream().map(p -> p != null ? p.getStaffId() : "null").collect(Collectors.joining(", "));
        System.out.println("  Staff IDs before pre-check: [" + staffIdsBefore + "]");

        Physiotherapist physioBefore = staffBefore.stream()
                                        .filter(p -> p != null && p.getStaffId() != null && p.getStaffId().equalsIgnoreCase(physioIdToRemove))
                                        .findFirst().orElse(null);
        assertNotNull("Pre-check: Physio " + physioIdToRemove + " should exist.", physioBefore);
        System.out.println("  Pre-check passed: Physio " + physioIdToRemove + " exists.");

        boolean result = manager.removePhysiotherapist(physioIdToRemove);
        System.out.println("  manager.removePhysiotherapist returned: " + result);

        assertTrue("removePhysiotherapist should return true for existing staff.", result);

        List<Physiotherapist> staffAfterRemoval = manager.getAllPhysiotherapists();
        int finalStaffCount = staffAfterRemoval.size();
         System.out.println("  Final staff count: " + finalStaffCount);
         String remainingStaffIds = staffAfterRemoval.stream().map(p -> p != null ? p.getStaffId() : "null").collect(Collectors.joining(", "));
        System.out.println("  Remaining staff IDs: [" + remainingStaffIds + "]");

        assertEquals("Staff list size should decrease by 1.", initialStaffCount - 1, finalStaffCount);

        Physiotherapist physioAfter = staffAfterRemoval.stream()
                                        .filter(p -> p != null && p.getStaffId() != null && p.getStaffId().equalsIgnoreCase(physioIdToRemove))
                                        .findFirst().orElse(null);
        System.out.println("  Physio found after removal attempt: " + (physioAfter == null ? "null" : physioAfter.getStaffId()));
        assertNull("Physio " + physioIdToRemove + " should no longer be in the list.", physioAfter);

        System.out.println("testRemovePhysiotherapist_Success PASSED.");
    }

    @Test
    public void testRemovePhysiotherapist_NotFound() {
        System.out.println("Running testRemovePhysiotherapist_NotFound...");
        String nonExistentId = "PH999";
        int initialStaffCount = manager.getAllPhysiotherapists().size();

        boolean result = manager.removePhysiotherapist(nonExistentId);

        assertFalse("removePhysiotherapist should return false for non-existent ID.", result);
        assertEquals("Staff list size should remain unchanged.", initialStaffCount, manager.getAllPhysiotherapists().size());

        System.out.println("testRemovePhysiotherapist_NotFound PASSED.");
    }

}
