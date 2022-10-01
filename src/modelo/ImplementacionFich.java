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
public class ImplementacionFich implements InterfaceDAO{
     public void crearCliente(Cliente client){
         System.out.println("fich");
     }

    @Override
    public void consultarCliente(String idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarCuentaCliente(String idCliente, String idCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarCuenta(Cuenta cuent, String idCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearCuentaCliente(Cuenta cuent, String idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarCuenta(String idCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void realizarMovimiento(String idCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarMovimiento(String idMoviento, String idCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
