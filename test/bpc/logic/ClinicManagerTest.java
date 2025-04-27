/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package bpc.logic;

import bpc.logic.ClinicManager;
import bpc.model.Patient;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sharin
 */
public class ClinicManagerTest {

    private ClinicManager manager;

    public ClinicManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("--- Set Up Test Class ---");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("--- Tear Down Test Class ---");
    }

    @Before
    public void setUp() {
        manager = new ClinicManager();
        System.out.println("--- Running setUp() before test ---");
    }

    @After
    public void tearDown() {
        System.out.println("--- Running tearDown() after test ---");
        manager = null;
    }

    @Test
    public void testAddPatient_Success() {
        System.out.println("Running testAddPatient_Success...");
        String name = "Test Patient One";
        String address = "1 Test Street, Testville";
        String phone = "01234567890";
        int initialPatientCount = manager.getAllPatients().size();

        boolean result = manager.addPatient(name, address, phone);

        assertTrue("addPatient should return true for valid input.", result);

        List<Patient> updatedPatients = manager.getAllPatients();
        assertEquals("Patient list size should increase by 1.", initialPatientCount + 1, updatedPatients.size());

        Patient addedPatient = updatedPatients.stream()
                .filter(p -> p.getFullName().equals(name) && p.getContactPhone().equals(phone))
                .findFirst()
                .orElse(null);
        assertNotNull("Newly added patient should be found.", addedPatient);
        assertEquals("Address should match.", address, addedPatient.getHomeAddress());
        assertNotNull("Patient ID should not be null.", addedPatient.getPatientId());

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

        assertFalse("addPatient should return false for duplicate phone.", result);
        assertEquals("Patient list size should not increase.", initialPatientCount, manager.getAllPatients().size());

        System.out.println("testAddPatient_DuplicatePhone PASSED.");
    }

    @Test
    public void testAddPatient_EmptyDetails() {
        System.out.println("Running testAddPatient_EmptyDetails...");
        int initialPatientCount = manager.getAllPatients().size();

        boolean resultEmptyName = manager.addPatient("", "Some Address", "9876543210");
        assertFalse("Should fail with empty name.", resultEmptyName);
        assertEquals(initialPatientCount, manager.getAllPatients().size());

        boolean resultEmptyAddress = manager.addPatient("Valid Name", "", "9876543211");
        assertFalse("Should fail with empty address.", resultEmptyAddress);
        assertEquals(initialPatientCount, manager.getAllPatients().size());

        boolean resultEmptyPhone = manager.addPatient("Valid Name", "Some Address", "");
        assertFalse("Should fail with empty phone.", resultEmptyPhone);
        assertEquals(initialPatientCount, manager.getAllPatients().size());

        System.out.println("testAddPatient_EmptyDetails PASSED.");
    }
}
