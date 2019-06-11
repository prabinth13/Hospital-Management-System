package hms;

import java.util.Objects;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
/**
 *
 * @author Suson
 */
public class Patient {
// instance variable

    private String name;
    private int age;
    private String sex;
    private String address;
    private String severity;
    private Doctor doctor;

    /**
     * This is the constructor of patient class
     *
     * @param name name of the patient
     * @param age age of the patient
     * @param sex sex of the patient
     * @param address address of the patient
     * @param severity severity of the patient
     * @param doctor doctor of the patient
     */
    public Patient(String name, int age, String sex, String address, String severity, Doctor doctor) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.severity = severity;
        this.doctor = doctor;
    }

    /**
     * Getter method which gets the name of the patient
     *
     * @return Name of the patient
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method which gets the name of the patient
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method which gets the age of the patient
     *
     * @return the age of the patient
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method which sets the new age of the patient
     *
     * @param age new age of the patient
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter method which gets the sex of the patient
     *
     * @return the sex of the patient
     */
    public String getSex() {
        return sex;
    }

    /**
     * Setter method which sets the new sex of the patient
     *
     * @param sex new sex to be set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Getter method which gets the address of the patient
     *
     * @return the address of the patient
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method which sets the new address of the patient
     *
     * @param address new address to be set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter method which gets the severity of the patient
     *
     * @return the severity of the patient
     */
    public String getSeverity() {
        return severity;
    }

    /**
     * Setter method which set the new severity of the patient
     *
     * @param severity new severity to be set
     */
    public void setSeverity(String severity) {
        this.severity = severity;
    }

    /**
     * Getter method which gets the doctor of the patient
     *
     * @return the doctor which is set to the patient
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Setter method which sets the new doctor for the patient
     *
     * @param doctor new doctor to be set
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * To string method which return the string literals for the patient object.
     *
     * @return the information about patient
     */
    @Override
    public String toString() {
        return "Patient{" + "name=" + name + ", age=" + age + ", sex=" + sex + ", address=" + address + ", severity=" + severity + ", doctor=" + doctor + '}';
    }

    /**
     * Hashcode method generates unique hashcode for each object to make unique
     * objects
     *
     * @return the unique hashcode for the object
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + this.age;
        hash = 37 * hash + Objects.hashCode(this.sex);
        hash = 37 * hash + Objects.hashCode(this.address);
        hash = 37 * hash + Objects.hashCode(this.severity);
        hash = 37 * hash + Objects.hashCode(this.doctor);
        return hash;
    }

    /**
     * Equals method compares the two different objects wether the objects
     *
     * @param obj that is to be compared
     * @return returns wether that object is same or not.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.sex, other.sex)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.severity, other.severity)) {
            return false;
        }
        if (!Objects.equals(this.doctor, other.doctor)) {
            return false;
        }

        return true;
    }

}
