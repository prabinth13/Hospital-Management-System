package hms;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.common.views.DocumentViewControllerImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Suson
 */
public class Configuration {

    //  static variable being initialized for accessing this all over the project
    // (not good practice)
    public static ArrayList<Doctor> doctorList = new ArrayList<>();
    public static ArrayList<Patient> patientList = new ArrayList<>();

    public Configuration() {
    }

    /**
     * This method finds the doctor by name and return that doctor
     *
     * @param name name of the doctor that is being searched
     * @return Doctor Returns found doctor
     */
    public Doctor findDoctorByName(String name) {
        // finds all the doctors by names as passed by parameter
        for (Doctor doctors : Configuration.doctorList) {
            if (doctors.getName().equals(name)) {
                return doctors;
            }
        }
        return null;
    }

    /**
     * This method is for loading the default values in the system. Temporarily
     * this acts as a database to the system.
     */
    public void loadDefaultDoctors() {
        if (Configuration.doctorList.isEmpty()) {
            Configuration.doctorList.add(new Doctor("Dr. Sheldon Cooper", "Bhaktapur", "Night", 10000));
            Configuration.doctorList.add(new Doctor("Dr. Amy Farrah Fowler", "Koteshor", "Morning", 12000));
            Configuration.doctorList.add(new Doctor("Dr. Leonard Hofstadter", "Kalanki", "Evening", 15000));
            Configuration.doctorList.add(new Doctor("Dr. Rajesh Koothrappali", "Kalimati", "Afternoon", 18000));
            Configuration.doctorList.add(new Doctor("Dr. Barry Kripke", "Maitighar", "Afternoon", 10500));
            Configuration.doctorList.add(new Doctor("Dr. Bernadette Wolowitz", "Putalisadak", "Night", 20000));
            Configuration.doctorList.add(new Doctor("Dr. Steven Strange", "Thapathali", "Evening", 1000));
            Configuration.doctorList.add(new Doctor("Dr. Who", "Kamal Pokhari", "Morning", 25000));
            Configuration.doctorList.add(new Doctor("Dr. Mel", "Sukedhara", "Evening", 2000));
            Configuration.doctorList.add(new Doctor("Dr. Moose", "Gausala", "Night", 15000));
            Configuration.doctorList.add(new Doctor("Dr. Dwite", "Kalopul", "Evening", 22000));
            Configuration.doctorList.add(new Doctor("Dr. Micheal", "Putalisadak", "Night", 10000));
        }
    }

    /**
     * This method is for loading the default values in the system. Temporarily
     * this acts as a database to the system.
     */
    public void loadDefaultPatient() {
        if (Configuration.patientList.isEmpty()) {
            Configuration.patientList.add(new Patient("Jim Halpert", 39, "Male", "Bhaktapur", "Low", findDoctorByName("Dr. Sheldon Cooper")));
            Configuration.patientList.add(new Patient("Jenna Fischer", 44, "Female", "Kamalpokhari", "High", findDoctorByName("Dr. Who")));
            Configuration.patientList.add(new Patient("Steve Carell", 56, "Male", "Kalanki", "Critical", findDoctorByName("Dr. Barry Kripke")));
            Configuration.patientList.add(new Patient("Rainn Wilson", 52, "Male", "Sukedhara", "Medium", findDoctorByName("Dr. Leonard Hofstadter")));
            Configuration.patientList.add(new Patient("Angela Kinsey", 47, "Female", "Bhaktapur", "Low", findDoctorByName("Dr. Rajesh Koothrappali")));
            Configuration.patientList.add(new Patient("Mindy Kaling", 39, "Female", "Pulchok", "High", findDoctorByName("Dr. Sheldon Cooper")));
            Configuration.patientList.add(new Patient("Ed Helms", 44, "Male", "Lalitpur", "Medium", findDoctorByName("Dr. Steven Strange")));
            Configuration.patientList.add(new Patient("Micheal Scott", 40, "Male", "Bhaisipati", "Low", findDoctorByName("Dr. Rajesh Koothrappali")));
            Configuration.patientList.add(new Patient("Pam Beesly", 14, "Female", "Sukedhara", "Medium", findDoctorByName("Dr. Barry Kripke")));
            Configuration.patientList.add(new Patient("Eddy Brock", 20, "Male", "Bhaktapur", "High", findDoctorByName("Dr. Who")));
            Configuration.patientList.add(new Patient("Jasmine Yasmin", 12, "Female", "Lalitpur", "Low", findDoctorByName("Dr. Sheldon Cooper")));
            Configuration.patientList.add(new Patient("Pradhan Shrestha", 22, "Female", "Bhaisipati", "Critical", findDoctorByName("Dr. Steven Strange")));

        }
    }

    /**
     * This method add the all the patient that is stored in the list to the
     * table which is being passed as a parameter.
     *
     * @param table reference to the table to which to add the patient
     */
    public void addPatientToTable(JTable table) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Patient patient : Configuration.patientList) {
            model.addRow(new Object[]{});
            int myRow = model.getRowCount() - 1;
            table.setValueAt(patient.getName(), myRow, 0);
            table.setValueAt(patient.getAge(), myRow, 1);
            table.setValueAt(patient.getSex(), myRow, 2);
            table.setValueAt(patient.getAddress(), myRow, 3);
            table.setValueAt(patient.getSeverity(), myRow, 4);
            table.setValueAt(patient.getDoctor().getName(), myRow, 5);

        }

    }

    /**
     * This method add the all the doctor that is stored in the list to the
     * table which is being passed as a parameter.
     *
     * @param table reference to the table to which to add the doctor
     */
    public void addDoctorToTable(JTable table) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Doctor doctor : Configuration.doctorList) {
            model.addRow(new Object[]{});
            int myRow = model.getRowCount() - 1;
            table.setValueAt(doctor.getName(), myRow, 0);
            table.setValueAt(doctor.getAddress(), myRow, 1);
            table.setValueAt(doctor.getShift(), myRow, 2);
            table.setValueAt(doctor.getSalary(), myRow, 3);

        }
    }

    /**
     * This method closes the frame after 500 milliseconds which is passed as a
     * parameter.
     *
     * @param frame Frame to be closed
     */
    public void closeFrameAfer(JFrame frame) {
        // this is for making so that this frame would close after half a second(500 ms) before main frame would close
        // simple fix that would flicker the screen while changing the tab.
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();

    }

    /**
     * This method changes the icon and the title of the frame passed as the
     * parameter.
     *
     * @param frame Frame to which to add icon and the title
     * @param title tile to be add to the frame
     */
    public void setIconAndTitle(JFrame frame, String title) {
        frame.setTitle("Hospital Management System - " + title); // setting the title of the frame
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/favicon.png"))); // setting the icon image
    }

    /**
     * This method adds all the doctors saved in the system to the combo-box
     * which will be passed as the parameter.
     *
     * @param box Combo-box to which doctors are to be added
     */
    public void selectDoctorForPatient(JComboBox box) {
        for (Doctor doctor : Configuration.doctorList) {
            box.addItem(doctor.getName());
        }

    }

    /**
     * This method shows the information of the doctor in systematic way with
     * the help of JOptionPane
     *
     * @param frame Frame to which acts as a parent to the JOptionPane
     * @param doc Doctor object of which information to be displayed
     */
    public void displayDoctor(JFrame frame, Doctor doc) {
        JOptionPane.showMessageDialog(frame, "Doctor Name : " + doc.getName()
                + "\nAddress : " + doc.getAddress()
                + "\nShift : " + doc.getShift()
                + "\nSalary : " + doc.getSalary(),
                doc.getName(), JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method adds the doctor to the temporary list according to which
     * keyword is being passed
     *
     * @param doc List of doctor form which doctors to be added.
     * @param keyword word according to which list will be created
     * @return String[] array which is a be a temporary list.
     */
    public String[] copyDocToTempList(ArrayList<Doctor> doc, String keyword) {
        String[] tempList = new String[doc.size()];
        int i = 0;
        if (keyword.equals("Name")) {
            for (Doctor docs : doc) {
                tempList[i] = docs.getName();
                i++;
            }
            return tempList;
        } else if (keyword.equals("Address")) {
            for (Doctor docs : doc) {
                tempList[i] = docs.getAddress();
                i++;
            }
            return tempList;
        } else if (keyword.equals("Shift")) {
            for (Doctor docs : doc) {
                tempList[i] = docs.getShift();
                i++;
            }
            return tempList;
        } else if (keyword.equals("Salary")) {
            for (Doctor docs : doc) {
                tempList[i] = Integer.toString(docs.getSalary());
                i++;
            }
            return tempList;
        }
        return tempList;
    }

    /**
     * This method adds the patient to the temporary list according to which
     * keyword is being passed
     *
     * @param patient List of patient form which patient to be added.
     * @param keyword word according to which list will be created
     * @return String[] array which is a be a temporary list.
     */
    public String[] copyPatientToTempList(ArrayList<Patient> patient, String keyword) {
        String[] tempList = new String[patient.size()];
        int i = 0;
        if (keyword.equals("Name")) {
            for (Patient patnt : patient) {
                tempList[i] = patnt.getName();
                i++;
            }
            return tempList;
        } else if (keyword.equals("Address")) {
            for (Patient patnt : patient) {
                tempList[i] = patnt.getAddress();
                i++;
            }
            return tempList;
        } else if (keyword.equals("Age")) {
            for (Patient patnt : patient) {
                tempList[i] = Integer.toString(patnt.getAge());
                i++;
            }
            return tempList;
        } else if (keyword.equals("Sex")) {
            for (Patient patnt : patient) {
                tempList[i] = patnt.getSex();
                i++;
            }
            return tempList;
        } else if (keyword.equals("Doctor")) {
            for (Patient patnt : patient) {
                tempList[i] = patnt.getDoctor().getName();
                i++;
            }
            return tempList;
        } else if (keyword.equals("Severity")) {
            for (Patient patnt : patient) {
                tempList[i] = patnt.getSeverity();
                i++;
            }
            return tempList;
        }

        return tempList;
    }

    /**
     * This method checks if there are any other similar details save on the
     * list
     *
     * @param keyword to check what is being search
     * @param searched to check on what field the search is happening
     * @return returns the number of similar details found
     */
    public int moreOnDoctorList(String keyword, String searched) {
        int count = 0;

        if (searched.equals("Name")) {
            for (Doctor doc : Configuration.doctorList) {
                if (doc.getName().equals(keyword)) {
                    count++;
                }
            }

        } else if (searched.equals("Address")) {
            for (Doctor doc : Configuration.doctorList) {
                if (doc.getAddress().equals(keyword)) {
                    count++;
                }

            }
        } else if (searched.equals("Shift")) {
            for (Doctor doc : Configuration.doctorList) {
                if (doc.getShift().equals(keyword)) {
                    count++;
                }

            }
        } else if (searched.equals("Salary")) {
            for (Doctor doc : Configuration.doctorList) {
                if (doc.getSalary() == Integer.parseInt(keyword)) {
                    count++;
                }

            }
        }
        if (count > 0) {
            return count - 1;
        } else {
            return 0;
        }

    }

    /**
     * This method checks if there are any other similar details save on the
     * list
     *
     * @param keyword to check what is being search
     * @param searched to check on what field the search is happening
     * @return returns the number of similar details found
     */
    public int moreOnPatientList(String keyword, String searched) {
        int count = 0;

        if (searched.equals("Name")) {
            for (Patient pat : Configuration.patientList) {
                if (pat.getName().equals(keyword)) {
                    count++;
                }
            }

        } else if (searched.equals("Sex")) {
            for (Patient pat : Configuration.patientList) {
                if (pat.getSex().equals(keyword)) {
                    count++;
                }

            }
        } else if (searched.equals("Address")) {
            for (Patient pat : Configuration.patientList) {
                if (pat.getAddress().equals(keyword)) {
                    count++;
                }

            }
        } else if (searched.equals("Age")) {
            for (Patient pat : Configuration.patientList) {
                if (pat.getAge() == Integer.parseInt(keyword)) {
                    count++;
                }

            }
        } else if (searched.equals("Severity")) {
            for (Patient pat : Configuration.patientList) {
                if (pat.getSeverity().equals(keyword)) {
                    count++;
                }

            }
        } else if (searched.equals("Doctor")) {
            for (Patient pat : Configuration.patientList) {
                if (pat.getDoctor().getName().equals(keyword)) {
                    count++;
                }

            }
        }
        if (count > 0) {
            return count - 1;
        } else {
            return 0;
        }

    }

    /**
     * This method displays the frame on which help PDF is going to be displayed
     *
     * @param frame The frame which acts as a parent the new sub-frame
     */
    public void DisplayHelpPDF(JFrame frame) {

        String filePath = "src/resource/test.pdf";
        // build a controller
        SwingController controller = new SwingController();
        SwingViewBuilder factory = new SwingViewBuilder(controller);

        JPanel viewerComponentPanel = factory.buildViewerPanel();

        controller.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                        controller.getDocumentViewController()));

        JFrame viewPdf = new JFrame();
        setIconAndTitle(viewPdf, "HELP GUIDE");

        viewPdf.setLocation(500, 75);
        viewPdf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //viewPdf.getContentPane().add(viewerComponentPanel);
        viewPdf.add(viewerComponentPanel);

        controller.openDocument(filePath);

        viewPdf.pack();
        viewPdf.setVisible(true);

    }

    /**
     * This method converts string array to int array
     *
     * @param strArray array which is being turned to int array
     * @return array which is converted from string array.
     */
    public int[] stringToIntArray(String[] strArray) {

        int[] intArray = new int[strArray.length];
        int i = 0;
        for (String str : strArray) {
            intArray[i] = Integer.valueOf(str);
            i++;
        }
        return intArray;

    }

    /**
     * This method converts int array to string array
     *
     * @param intArray array which is being turned to string array
     * @return array which is converted from int array.
     */
    public String[] intToStringArray(int[] intArray) {

        String[] strArray = new String[intArray.length];
        int i = 0;
        for (Integer num : intArray) {
            strArray[i] = Integer.toString(num);
            i++;
        }
        return strArray;

    }

    /**
     * this method capitalizes the first character of the word that is passed
     * into it.
     *
     * @param word that will have first character capitalized.
     * @return
     */
    public String capitalizeFirstLetter(String word) {

        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
