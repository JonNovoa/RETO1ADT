/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author somor
 */
public class Cuenta {
        
    private Integer id;
    private String description;
    private Float balance;
    private Float credito;
    private Float inicioBalance;
    private LocalDate fechaInicioBalance;
    private Enum tipoCuenta;
    private List <Movimientos>movimiento;

    public Cuenta(Integer id, String description, Float balance, Float credito, Float inicioBalance, LocalDate fechaInicioBalance, Enum tipoCuenta, List<Movimientos> movimiento) {
        this.id = id;
        this.description = description;
        this.balance = balance;
        this.credito = credito;
        this.inicioBalance = inicioBalance;
        this.fechaInicioBalance = fechaInicioBalance;
        this.tipoCuenta = tipoCuenta;
        this.movimiento = movimiento;
    }

    public Cuenta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public void setCredito(Float credito) {
        this.credito = credito;
    }

    public void setInicioBalance(Float inicioBalance) {
        this.inicioBalance = inicioBalance;
    }

    public void setFechaInicioBalance(LocalDate fechaInicioBalance) {
        this.fechaInicioBalance = fechaInicioBalance;
    }

    public void setTipoCuenta(Enum tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public void setMovimiento(List<Movimientos> movimiento) {
        this.movimiento = movimiento;
    }

    public String getDescription() {
        return description;
    }

    public Float getBalance() {
        return balance;
    }

    public Float getCredito() {
        return credito;
    }

    public Float getInicioBalance() {
        return inicioBalance;
    }

    public LocalDate getFechaInicioBalance() {
        return fechaInicioBalance;
    }

    public Enum getTipoCuenta() {
        return tipoCuenta;
    }

    public List<Movimientos> getMovimiento() {
        return movimiento;
    }
    
    public void setDatos(Integer id){
 
        this.id = id;
        this.description = utilidades.Utilidades.introducirCadena("Introducir descripcion: ");
        this.balance = utilidades.Utilidades.leerFloat("Introducir balance: ");
        this.credito = utilidades.Utilidades.leerFloat("Introducir credito: ");
        this.inicioBalance = utilidades.Utilidades.leerFloat("Introducir balance inicial:");
        this.fechaInicioBalance = utilidades.Utilidades.leerFecha("Introducir fecha: ");
        
     
    }
    
    public void getDatos(){
        System.out.println("Id: "+this.id);
        System.out.println("Descripcion: "+this.description);
        System.out.println("Balance: "+this.balance);
        System.out.println("Credito: "+this.credito);
        System.out.println("Inicio Blance: "+this.inicioBalance);
        System.out.println("Fecha Inicio Balance: "+this.fechaInicioBalance);
        for (int i = 0; i < movimiento.size(); i++) {
            System.out.println(movimiento.get(i));
        }
    }
    
    public void setMovimientoCu(){
        Movimientos mov = new Movimientos();
        mov.setDatos();
        this.movimiento.add(mov);
    }
    

    public void getMovimientoCu(Integer idMovimiento) {
         Movimientos mov;
        for (int i = 0; i < movimiento.size(); i++) {
            mov = movimiento.get(i);
            if(movimiento.get(i).equals(idMovimiento)){
                mov.getDatos();
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
