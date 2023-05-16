/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 *
 * @author user
 */
@Entity
public class Patient {
    @Id
    private String nationId;
    private String code;
    private String firstName;
    private String lastName;
    private String gender;
    private String vaccine_Site;
    
    private LocalDate vaccination_Date;
    private String vaccination_Name;
    private String vaccine;

    public Patient() {
    }

    public Patient(String nationId) {
        this.nationId = nationId;
    }

    public Patient(String nationId, String code, String firstName, String lastName, String gender, String vaccine_Site, LocalDate vaccination_Date, String vaccination_Name, String vaccine) {
        this.nationId = nationId;
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.vaccine_Site = vaccine_Site;
        this.vaccination_Date = vaccination_Date;
        this.vaccination_Name = vaccination_Name;
        this.vaccine = vaccine;
    }

    public String getNationId() {
        return nationId;
    }

    public void setNationId(String nationId) {
        this.nationId = nationId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getVaccine_Site() {
        return vaccine_Site;
    }

    public void setVaccine_Site(String vaccine_Site) {
        this.vaccine_Site = vaccine_Site;
    }

    public LocalDate getVaccination_Date() {
        return vaccination_Date;
    }

    public void setVaccination_Date(LocalDate vaccination_Date) {
        this.vaccination_Date = vaccination_Date;
    }

    public String getVaccination_Name() {
        return vaccination_Name;
    }

    public void setVaccine_Name(String vaccine_Name) {
        this.vaccination_Name = vaccination_Name;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

 
    
}
