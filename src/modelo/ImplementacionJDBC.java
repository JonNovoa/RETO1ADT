/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Cliente;
import clases.Cuenta;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author somor
 */
public class ImplementacionJDBC {

    private Connection conex;
    private PreparedStatement stmt = null;
    private ResourceBundle archivoConfig;
    private String url;
    private String usuario;
    private String contraseña;
    private String driver;
    private Statement sql=null;
    private ResultSet rs;

    public ImplementacionJDBC() {
        this.archivoConfig = ResourceBundle.getBundle("modelo.config");
        this.url = archivoConfig.getString("Conn");
        this.usuario = archivoConfig.getString("BDUser");
        this.contraseña = archivoConfig.getString("BDPass");
        this.driver = archivoConfig.getString("Driver");

    }

    public void openConnection() throws ClassNotFoundException {
        try {
            Class.forName(driver);
            conex = DriverManager.getConnection(url, usuario, contraseña);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void closeConnection() throws SQLException {
        if (conex != null) {
            conex.close();
        }
        if (stmt != null) {
            conex.close();
        }

    }

    public void crearCliente(Cliente client) {
        try {
            if (stmt == null) {

                stmt = conex.prepareStatement("insert into customer values (?,?,?,?,?,?,?,?,?,?)");
                stmt.setInt(1, client.getId());
                stmt.setString(2, client.getFirtsName());
                stmt.setString(3, client.getLastName());
                stmt.setString(5, client.getMiddleIntial());
                stmt.setString(6, client.getStreet());
                stmt.setString(7, client.getCity());
                stmt.setString(8, client.getState());
                stmt.setInt(9, client.getZip());
                stmt.setInt(10, client.getPhone());
                stmt.setString(4, client.getEmail());
                stmt.execute();
                conex.close();

            }

        } catch (SQLException ex) {
            Logger.getLogger(ImplementacionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consusltarCliente(String idCliente) {
        try {
            String sentencia= "select * from customer where id="+idCliente;
            sql = conex.createStatement();
            rs = sql.executeQuery(sentencia);
           conex.close();

        } catch (SQLException ex) {
            Logger.getLogger(ImplementacionJDBC.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void consultarCuentaCliente(String idCliente, String idCuenta) {

        try {
            String sentencia="select * from account as a, customer as c  where a.id="+idCuenta+" and c.id="+idCliente;

            sql = conex.createStatement();
            rs = sql.executeQuery(sentencia);
conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ImplementacionJDBC.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void agregarCuenta(Cuenta cuent, String idCliente) {
        try {
            if (stmt == null) {

                stmt = conex.prepareStatement("insert into customer values (?,?,?,?,?,?,?,?,?,?)");

            }

        } catch (SQLException ex) {
            Logger.getLogger(ImplementacionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void crearCuentaCliente(Cuenta cuent, String idCliente) {

    }

    public void consultarCuenta(String idCuenta) {

    }

    public void realizarMovimiento(String idCuenta) {

    }

    public void consultarMovimiento(String idMovimiento, String idCuenta) {

    }

}
