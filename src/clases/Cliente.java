/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import clases.Cuenta;
import java.util.List;

/**
 *
 * @author somor
 */
public class Cliente {
    
    private Integer id;
    private String firtsName;
    private String lastName;
    private String middleIntial;
    private String street;
    private String city;
    private String state;
    private Integer zip;
    private Integer phone;
    private String email;
    private List<Cuenta> cuentas;

    public Cliente(Integer id, String firtsName, String lastName, String middleIntial, String street, String city, String state, Integer zip, Integer phone, String email, List<Cuenta> cuentas) {
        this.id = id;
        this.firtsName = firtsName;
        this.lastName = lastName;
        this.middleIntial = middleIntial;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.cuentas = cuentas;
    }

    public Cliente() {
    }

    public Integer getId() {
        return id;
    }

    public String getFirtsName() {
        return firtsName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleIntial() {
        return middleIntial;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Integer getZip() {
        return zip;
    }

    public Integer getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleIntial(String middleIntial) {
        this.middleIntial = middleIntial;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    
    
    
          
    
}
