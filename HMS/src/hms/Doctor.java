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
public class Doctor {
// instance varibale

    private String name;
    private String address;
    private String shift;
    private int salary;

    /**
     * This is a constructor of doctor class
     *
     * @param name Name of the doctor
     * @param address Address of the doctor
     * @param shift Shift of the doctor
     * @param salary Salary of the doctor
     */
    public Doctor(String name, String address, String shift, int salary) {
        this.name = name;
        this.address = address;
        this.shift = shift;
        this.salary = salary;
    }

    /**
     * Getter method which gets the name of the doctor
     *
     * @return Name of the doctor
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method which sets the new name of the doctor
     *
     * @param name Name of the doctor to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method which gets the address of the doctor
     *
     * @return Address of the doctor
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method which sets the new address of the doctor
     *
     * @param address Address to be set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter method which returns the shift of the doctor
     *
     * @return Shift of the doctor
     */
    public String getShift() {
        return shift;
    }

    /**
     * Setter method which sets the new shift of the doctor
     *
     * @param shift New shift that should be set
     */
    public void setShift(String shift) {
        this.shift = shift;
    }

    /**
     * Getter method which gets the salary of the doctor.
     *
     * @return Salary of the doctor
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Setter method which sets the new salary of the doctor
     *
     * @param salary new salary of the doctor to be set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * To string method which shows the string representation of each doctor
     *
     * @return the formatted string of the doctor
     */
    @Override
    public String toString() {
        return "Doctor{" + "name=" + name + ", address=" + address + ", shift=" + shift + ", salary=" + salary + '}';
    }

    /**
     * Hash code method which generated unique hashcode of each elements which
     * differentiate objects from each other
     *
     * @return the uniquely generated hascode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.address);
        hash = 47 * hash + Objects.hashCode(this.shift);
        hash = 47 * hash + this.salary;
        return hash;
    }

    /**
     * Equals method which compares wether the passed object is same or not
     *
     * @param obj Object that is being compared
     * @return True or false wether that object is same or not
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
        final Doctor other = (Doctor) obj;
        if (this.salary != other.salary) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.shift, other.shift)) {
            return false;
        }
        return true;
    }

}
