/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bpc.ui; // Package declaration

// Imports will be added by NetBeans as you add components
import bpc.logic.ClinicManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 * Main JFrame for the Boost Physio Clinic application GUI.
 *
 * @author sharin
 */
public class ClinicMainWindow extends javax.swing.JFrame {

    /**
     * Creates new form ClinicMainWindow
     */
    private ClinicManager clinicManager;

    public ClinicMainWindow() {
        clinicManager = new ClinicManager();
        // MODIFICATION: Instantiate your logic manager here (once created)
        // clinicManager = new ClinicManager();
        // clinicManager.initializeSampleData(); // Load data when GUI starts

        // ** IMPORTANT: This method initializes components designed in the NetBeans GUI builder **
        initComponents();

        // --- Optional Customizations after initComponents() ---
        this.setTitle("Boost Physio Clinic System"); // Set the window title bar text
        this.setLocationRelativeTo(null); // Center the window on the screen on startup
        // MODIFICATION: Set a minimum size to prevent window from being too small
        this.setMinimumSize(new Dimension(400, 500)); // Adjust size as needed

        // MODIFICATION: Call helper method to add event handlers to buttons.
        setupActionListeners();
    }

    /**
     * MODIFICATION: Helper method to add event handlers to buttons.
     */
    private void setupActionListeners() {
        // --- Add Patient Button ---
        if (addPatientButton != null) {
            addPatientButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    addPatientButtonActionPerformed(evt);
                }
            });
        }

        // --- Remove Patient Button ---
        if (removePatientButton != null) {
            removePatientButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    removePatientButtonActionPerformed(evt);
                }
            });
        }

        // --- Add Physiotherapist Button ---
        if (addPhysioButton != null) {
            addPhysioButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    addPhysioButtonActionPerformed(evt);
                }
            });
        }

        // --- Remove Physiotherapist Button ---
        if (removePhysioButton != null) {
            removePhysioButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    removePhysioButtonActionPerformed(evt);
                }
            });
        }

        // --- Book Appointment Button ---
        if (bookAppointmentButton != null) {
            bookAppointmentButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bookAppointmentButtonActionPerformed(evt);
                }
            });
        }

        // --- Manage Booking Button ---
        if (manageBookingButton != null) {
            manageBookingButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    manageBookingButtonActionPerformed(evt);
                }
            });
        }

        // --- Attend Appointment Button ---
        if (attendAppointmentButton != null) {
            attendAppointmentButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    attendAppointmentButtonActionPerformed(evt);
                }
            });
        }

        // --- View Reports Button ---
        if (viewReportsButton != null) {
            viewReportsButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    viewReportsButtonActionPerformed(evt);
                }
            });
        }

        // --- Exit Button ---
        if (exitButton != null) {
            exitButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    exitButtonActionPerformed(evt);
                }
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *
     * NOTE: This code is generated by the NetBeans GUI Builder based on the
     * components you added in the Design view. Manually editing this block is
     * highly discouraged and may break the designer.
     *
     * **MODIFICATION:** This initComponents() method includes a more complete
     * GroupLayout setup. Ensure your Design view reflects this structure.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new JLabel();
        buttonPanel = new JPanel();
        addPatientButton = new JButton();
        removePatientButton = new JButton();
        addPhysioButton = new JButton();
        removePhysioButton = new JButton();
        bookAppointmentButton = new JButton();
        manageBookingButton = new JButton();
        attendAppointmentButton = new JButton();
        viewReportsButton = new JButton();
        exitButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Boost Physio Clinic");

        titleLabel.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("Boost Physio Clinic Management");

        buttonPanel.setBorder(BorderFactory.createEtchedBorder());

        addPatientButton.setText("Add Patient");

        removePatientButton.setText("Remove Patient");

        addPhysioButton.setText("Add Physiotherapist");

        removePhysioButton.setText("Remove Physiotherapist");

        bookAppointmentButton.setText("Book Appointment");

        manageBookingButton.setText("Change/Cancel Booking");

        attendAppointmentButton.setText("Attend Appointment");

        viewReportsButton.setText("View Reports");

        exitButton.setText("Exit");

        // --- Layout for the Button Panel ---
        // This defines how buttons are arranged *within* the panel
        GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap() // Padding inside the panel
                .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    // Make all buttons stretch to the panel width (or set preferred sizes)
                    .addComponent(addPatientButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removePatientButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addPhysioButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removePhysioButton, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE) // Example width
                    .addComponent(bookAppointmentButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageBookingButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(attendAppointmentButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewReportsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap()) // Padding inside the panel
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap() // Padding inside the panel
                .addComponent(addPatientButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED) // Space between buttons
                .addComponent(removePatientButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addPhysioButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removePhysioButton)
                .addGap(18, 18, 18) // Larger gap
                .addComponent(bookAppointmentButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageBookingButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(attendAppointmentButton)
                .addGap(18, 18, 18) // Larger gap
                .addComponent(viewReportsButton)
                // Use GroupLayout.DEFAULT_SIZE or a specific gap for spacing
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) // Push exit down
                .addComponent(exitButton)
                .addContainerGap()) // Padding inside the panel
        );

        // --- Layout for the Main JFrame Content Pane ---
        // This defines how the title label and button panel are arranged in the main window
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap() // Window padding
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    // Title label spans the width, centered (achieved by horizontal alignment on label)
                    .addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    // Center the button panel horizontally
                    .addGroup(layout.createSequentialGroup()
                        // Add gaps before and after the panel to center it
                        // Adjust the '100' values to control centering/width
                        .addGap(100, 100, Short.MAX_VALUE) // Flexible gap before
                        .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE) // Panel takes its preferred width
                        .addGap(100, 100, Short.MAX_VALUE)) // Flexible gap after
                 )
                .addContainerGap()) // Window padding
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap() // Window padding
                // Add the title label
                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE) // Give title fixed height
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED) // Space below title
                // Add the button panel, allowing it to grow vertically if needed
                .addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap()) // Window padding
        );

        // ** IMPORTANT: Call pack() AFTER setting up the layout and adding components **
        pack();
    }// </editor-fold>//GEN-END:initComponents

    // --- MODIFICATION: Add Event Handler Methods ---
    // These methods are called when the corresponding button is clicked.
    // You will fill these in later to interact with your ClinicManager
    // and potentially open other dialogs/windows.
//start here 
    private void addPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {

        System.out.println("Add Patient button clicked."); // For debugging

// Get Name by using JOptionPane
        String name = JOptionPane.showInputDialog(this, // Parent component
                "Enter Patient Name:", // Message
                "Add Patient - Step 1 of 3", // Title
                JOptionPane.PLAIN_MESSAGE); // Icon type

// Checking if the user cancelled
        if (name == null) {
            System.out.println("Add Patient cancelled by user (Name step).");
            return;
        }
        name = name.trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Patient Name cannot be empty.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

// Address using JOptionPane
        String address = JOptionPane.showInputDialog(this,
                "Enter Patient Address:",
                "Add Patient - Step 2 of 3",
                JOptionPane.PLAIN_MESSAGE);

        if (address == null) {
            System.out.println("Add Patient cancelled by user (Address step).");
            return;
        }
        address = address.trim();
        if (address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Patient Address cannot be empty.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

// Get Phone using JOptionPane
        String phone = JOptionPane.showInputDialog(this,
                "Enter Patient Phone Number:",
                "Add Patient - Step 3 of 3",
                JOptionPane.PLAIN_MESSAGE);

        if (phone == null) {
            System.out.println("Add Patient cancelled by user (Phone step).");
            return;
        }
        phone = phone.trim();
        if (phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Patient Phone Number cannot be empty.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

//  ClinicManager to add the patient
        if (clinicManager != null) {
            //  instance variable clinicManager
            boolean success = clinicManager.addPatient(name, address, phone);
            if (success) {
                JOptionPane.showMessageDialog(this,
                        "Patient '" + name + "' added successfully!",
                        "Patient Added",
                        JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Patient added via JOptionPane.");

            } else {
                JOptionPane.showMessageDialog(this,
                        "Failed to add patient (e.g., duplicate phone number).",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Error: Clinic Manager is not initialized.",
                    "System Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
//-----end here 

 private void removePatientButtonActionPerformed(java.awt.event.ActionEvent evt) {
    System.out.println("Remove Patient button clicked."); // For debugging

 
    String patientIdToRemove = JOptionPane.showInputDialog(this,
            "Enter the ID of the patient to remove (e.g., P01):",
            "Remove Patient",
            JOptionPane.QUESTION_MESSAGE);

    
    if (patientIdToRemove == null) {
        System.out.println("Remove patient cancelled by user.");
        return; 
    }
    patientIdToRemove = patientIdToRemove.trim();
    if (patientIdToRemove.isEmpty()) {
         JOptionPane.showMessageDialog(this,
                "Patient ID cannot be empty.",
                "Input Error",
                JOptionPane.WARNING_MESSAGE);
        return; 
    }

    int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to remove patient with ID '" + patientIdToRemove + "'?\n" +
            "This will also cancel all their future booked appointments.",
            "Confirm Removal",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);

    if (confirm != JOptionPane.YES_OPTION) {
        System.out.println("Patient removal cancelled by confirmation.");
        return; 
    }

   
    if (clinicManager != null) {
        boolean success = clinicManager.removePatient(patientIdToRemove);

        if (success) {
            JOptionPane.showMessageDialog(this,
                    "Patient with ID '" + patientIdToRemove + "' removed successfully.",
                    "Patient Removed",
                    JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Patient removal successful for ID: " + patientIdToRemove);
           
        } else {
            
            JOptionPane.showMessageDialog(this,
                    "Could not remove patient.\nPatient ID '" + patientIdToRemove + "' not found.",
                    "Removal Error",
                    JOptionPane.ERROR_MESSAGE);
             System.out.println("Patient removal failed for ID: " + patientIdToRemove);
        }
    } else {
         JOptionPane.showMessageDialog(this,
                "Critical Error: Clinic Manager is not available.",
                "System Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
 //end

    private void addPhysioButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Add Physio button clicked - Implement me!");
    }

    private void removePhysioButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Remove Physio button clicked - Implement me!");
    }

    private void bookAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Book Appointment button clicked - Implement me!");
    }

    private void manageBookingButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Manage Booking button clicked - Implement me!");
    }

    private void attendAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Attend Appointment button clicked - Implement me!");
    }

    private void viewReportsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("View Reports button clicked - Implement me!");
    }

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Exit button clicked. Closing application.");
        dispose(); // Close this window
        System.exit(0); // Terminate the application
        // }
    }

    /**
     * MODIFICATION: This main method starts the GUI application.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            // MODIFICATION: Use System Look and Feel for better OS integration (optional)
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            /* Original Nimbus Look and Feel code:
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }*/
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            // MODIFICATION: Use Logger for exceptions
            Logger.getLogger(ClinicMainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new ClinicMainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // MODIFICATION: These variables are declared here by NetBeans GUI builder
    private JButton addPatientButton;
    private JButton addPhysioButton;
    private JButton attendAppointmentButton;
    private JButton bookAppointmentButton;
    private JPanel buttonPanel;
    private JButton exitButton;
    private JButton manageBookingButton;
    private JButton removePatientButton;
    private JButton removePhysioButton;
    private JLabel titleLabel;
    private JButton viewReportsButton;
    // End of variables declaration//GEN-END:variables
}
