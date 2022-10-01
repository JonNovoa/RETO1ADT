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
    public void consultarCliente(Integer idCliente);
    public void consultarCuentaCliente(Integer idCliente, Integer idCuenta);
    public void agregarCuenta(Cuenta cuent, Integer idCuenta);
    public void crearCuentaCliente(Cuenta cuent,Integer idCliente);
    public void consultarCuenta(Integer idCuenta);
    public void realizarMovimiento(Integer idCuenta);
    public void consultarMovimiento(Integer idMoviento,Integer idCuenta);
    
    
    
}
