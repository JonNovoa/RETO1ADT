/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Cliente;
import clases.Cuenta;

/**
 *
 * @author somor
 */
public interface InterfaceDAO {
    
   public void crearCliente(Cliente client);
    public void consultarCliente(String idCliente);
    public void consultarCuentaCliente(String idCliente, String idCuenta);
    public void agregarCuenta(Cuenta cuent, String idCuenta);
    public void crearCuentaCliente(Cuenta cuent,String idCliente);
    public void consultarCuenta(String idCuenta);
    public void realizarMovimiento(String idCuenta);
    public void consultarMovimiento(String idMoviento,String idCuenta);
    
    
    
}
