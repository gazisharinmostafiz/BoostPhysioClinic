
# BoostPhysioClinic

Boost Physio Clinic (BPC) Booking System
What it does:

This project implements a desktop application (using Java Swing) to manage the appointment booking system for the Boost Physio Clinic. It allows clinic staff to:

Manage Personnel: Add, remove, and view details of both physiotherapists (including their areas of expertise) and patients. Each person has a unique ID, name, address, and phone number.
Manage Treatments: The system is pre-loaded with a schedule of available treatment slots offered by different physiotherapists over a set period (e.g., 4 weeks).
Handle Bookings:
Look up available treatment slots by searching either by a required area of expertise or by a specific physiotherapist's name.
Book available slots for registered patients, performing conflict checks to prevent double-booking of patients, rooms, or physiotherapists at the same time.
Change or cancel existing bookings before they occur.
Mark appointments as "attended" after the patient checks in.
Generate Reports: View lists of all patients, physiotherapists, and appointments. Generate specific reports, including a list of all appointments grouped by physiotherapist and a ranked list of physiotherapists based on the number of appointments they have attended.
Who it's for:

This system is primarily designed for the administrative staff or receptionists at the Boost Physio Clinic to manage patient records, staff details, treatment schedules, and appointment bookings efficiently.


## Authors

- [@gazisharinmostafiz](https://github.com/gazisharinmostafiz)


## Documentation

[Documentation](https://linktodocumentation)



Boost Physio Clinic (BPC) Booking System 
1. Project Overview

This project is a desktop application developed in Java using the Swing GUI toolkit. It serves as an appointment booking and management system for the Boost Physio Clinic. The system allows clinic staff to manage records for physiotherapists and patients, handle treatment scheduling, book appointments, update appointment statuses, and generate basic reports. The application uses an in-memory data structure (Java Lists) to store information, requiring no external database.

2. Features Implemented

Personnel Management:
Add new patients with unique IDs, name, address, and phone number.
Remove existing patients (cancels their future booked appointments).
Add new physiotherapists with unique IDs, name, address, phone number, and one or more areas of expertise.
Remove existing physiotherapists (cancels their future non-attended appointments and removes associated treatment slots).
View lists of all registered patients and physiotherapists with their details.
Appointment Booking:
Book appointments for registered patients.
Search for available future treatment slots based on:
Area of Expertise (displays available slots from all physios with that expertise).
Physiotherapist Name (displays available slots for the selected physio).
Displays available slots in a user-friendly list for selection.
Performs conflict checks to prevent double-booking a patient, physiotherapist, or room at the same date/time.
Appointment Management:
Change Appointment: Allows cancelling an existing booking with the intention of re-booking (user is prompted to use the "Book Appointment" feature again).
Cancel Appointment: Mark an existing 'booked' appointment as 'cancelled'. Cannot cancel past or already attended/cancelled appointments.
Attend Appointment: Mark a 'booked' appointment as 'attended'. Cannot attend future or already attended/cancelled appointments.
View All Appointments: Display a list of all bookings in the system, sorted by date/time.
Reporting:
Generate a consolidated report displayed in a pop-up window, containing:
A list of all treatment appointments grouped by physiotherapist (showing treatment name, patient name, time, status).
A ranked list of physiotherapists based on the number of appointments they have attended (descending order).
Data:
The system loads pre-defined sample data for physiotherapists, patients, expertise areas, treatment slots (over a 4-week period), and initial bookings upon startup.
3. Project Structure

The project follows a basic layered structure using Java packages:

bpc.model: Contains the data model classes representing the core entities:
Patient.java: Holds patient details (ID, name, address, phone).
Physiotherapist.java: Holds staff details (ID, name, address, phone, expertise list).
Expertise.java: Represents an area of expertise (e.g., "Physiotherapy").
Treatment.java: Represents a specific treatment slot (ID, name, date/time, assigned physio, room).
Booking.java: Represents a booked appointment (ID, patient, treatment, status).
bpc.logic: Contains the business logic and data management:
ClinicManager.java: Manages the lists of patients, staff, treatments, and bookings. Contains methods for adding/removing data, finding available slots, creating bookings, changing statuses, and loading sample data. It acts as the controller between the UI and the model.
bpc.ui: Contains the Graphical User Interface components:
ClinicMainWindow.java: The main application window (JFrame) containing buttons for all user actions. It interacts with the ClinicManager to perform operations and uses JOptionPane for user input and displaying information/reports.
bpc.logic.test (in Test Packages): Contains unit tests for the logic layer:
ClinicManagerTest.java: Uses JUnit (currently configured for JUnit 4) to test the functionality of methods within ClinicManager (e.g., adding/removing patients/physios).
4. How to Run

Open the project (BoostPhysioClinic) in Apache NetBeans IDE.
Ensure you have a compatible JDK installed and configured in NetBeans.
Ensure the necessary libraries (JUnit 4, Hamcrest) are added to the project's "Test Libraries" (Project Properties -> Libraries -> Compile Tests).
Set the Main Class:
Right-click the project name (BoostPhysioClinic).
Select Properties.
Go to the Run category.
Click Browse... next to "Main Class".
Select bpc.ui.ClinicMainWindow.
Click OK.
Run the Project: Click the "Run Project" button (green play icon) or press F6. The ClinicMainWindow GUI should appear.
5. Key Classes

ClinicMainWindow: The main entry point and user interface. Handles button clicks and uses JOptionPane for interaction. Delegates all logic to ClinicManager.
ClinicManager: The "brain" of the application. Holds all data lists and contains the methods that implement the core business logic (adding, removing, booking, searching, validating, status changes).
Model Classes (Patient, Physiotherapist, Treatment, Booking, Expertise): Simple data holders (POJOs - Plain Old Java Objects) with constructors, getters, setters (where appropriate), toString, equals, and hashCode methods.
ClinicManagerTest: Contains JUnit tests to verify the functionality of ClinicManager methods.
6. Testing

Unit tests using JUnit 4 are included in the bpc.logic.test package to verify core functionalities of the ClinicManager, such as adding and removing patients and physiotherapists, including handling edge cases like duplicates or missing information. These tests can be run from NetBeans by right-clicking the test file or the project and selecting "Test File" or "Test".

7. Future Improvements (Optional)

Implement more robust input validation in the UI layer.
Replace JOptionPane inputs with dedicated JDialog forms for better user experience, especially for booking.
Display lists (patients, physios, bookings) in JTable components within the main window or separate dialogs instead of JOptionPane.
Implement the "Change Appointment" feature more directly instead of just cancelling and asking the user to rebook.
Add functionality to create/edit Treatment slots via the UI.
Implement data persistence (saving/loading data to/from files) so information isn't lost when the application closes.
Refine the reporting features (e.g., filtering reports by date).
Add proper error handling and logging throughout the application.
Consider resetting static ID counters in model classes upon data reset (requires modifying model classes).
