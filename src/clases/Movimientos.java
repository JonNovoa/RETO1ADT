/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDate;

/**
 *
 * @author somor
 */
public class Movimientos {
        
    private Integer id;
    private LocalDate fechaMovimiento;
    private Float cantidad; 
    private Float balance;
    private String descripcion;

    public Movimientos(Integer id, LocalDate fechaMovimiento, Float cantidad, Float balance, String descripcion) {
        this.id = id;
        this.fechaMovimiento = fechaMovimiento;
        this.cantidad = cantidad;
        this.balance = balance;
        this.descripcion = descripcion;
    }

    public Movimientos() {
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getFechaMovimiento() {
        return fechaMovimiento;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public Float getBalance() {
        return balance;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaMovimiento(LocalDate fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    public void setDatos(){
       this.id = utilidades.Utilidades.leerInt();
       this.fechaMovimiento = utilidades.Utilidades.leerFecha();
       this.cantidad = utilidades.Utilidades.leerFloat(); 
       this.balance = utilidades.Utilidades.leerFloat();
       this.descripcion = utilidades.Utilidades.introducirCadena();       
    }
    
    public void getDatos(){
        System.out.println("Id: " + this.id);
        System.out.println("Fecha de movimiento: "+this.fechaMovimiento);
        System.out.println("Cantidad: " + this.cantidad);
        System.out.println("Balance: " + this.balance);
        System.out.println("Descripcion: "+this.descripcion);
    }
    
}
