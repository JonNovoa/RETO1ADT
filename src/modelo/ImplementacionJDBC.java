/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Cliente;
import clases.Cuenta;
import clases.Movimientos;
import clases.TipoCuenta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
    private Statement sta = null;
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
            stmt = null;
            rs = null;
        }
        if (stmt != null) {
            conex.close();
            stmt = null;
            rs = null;
        }

    }

    public void crearCliente(Cliente client) throws ClassNotFoundException, SQLException {

        this.openConnection();
        try {
            if (stmt == null) {

                stmt = conex.prepareStatement("insert into customer values (?,?,?,?,?,?,?,?,?,?)");
                conex.setAutoCommit(false);
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
                stmt.executeUpdate();

            }

        } catch (SQLException ex) {
            Logger.getLogger(ImplementacionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            this.closeConnection();
        }
    }

    public void consusltarCliente(Integer idCliente) throws ClassNotFoundException, SQLException {
        this.openConnection();
        Cliente client = new Cliente();

        try {
            String sentencia = "select * from customer where id=" + idCliente;
            stmt = conex.prepareStatement("select * from customer where id=?");
            stmt.setInt(1, idCliente);
            rs = stmt.executeQuery();
            client.setId(rs.getInt(1));
            client.setCity(rs.getString(2));
            client.setEmail(rs.getString(3));
            client.setFirtsName(rs.getString(4));
            client.setLastName(rs.getString(5));
            client.setMiddleIntial(rs.getString(6));
            client.setPhone(rs.getInt(7));
            client.setState(rs.getString(8));
            client.setStreet(rs.getString(9));
            client.setZip(rs.getInt(10));
            client.getDatos();

        } catch (SQLException ex) {
            Logger.getLogger(ImplementacionJDBC.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            this.closeConnection();
        }

    }

    public void consultarCuentaCliente(Integer idCuenta) throws ClassNotFoundException, SQLException {
        Cuenta cuent = new Cuenta();
        Enum tCuen = null;

        this.openConnection();
        try {

            stmt = conex.prepareStatement("select a.* from account as a where ca.accounts_id=?");
            stmt.setInt(1, idCuenta);
            rs = stmt.executeQuery();

            cuent.setId(rs.getInt(1));
            cuent.setBalance(rs.getFloat(2));
            cuent.setInicioBalance(rs.getFloat(3));
            LocalDate fecha = rs.getDate(4).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            cuent.setFechaInicioBalance(fecha);
            cuent.setCredito(rs.getFloat(5));
            cuent.setDescription(rs.getString(6));

            if (rs.getInt(7) == 0) {
                tCuen = TipoCuenta.CREDIT;

            } else {
                tCuen = TipoCuenta.STANDAR;
            }
            cuent.setTipoCuenta(tCuen);
        } catch (SQLException ex) {
            Logger.getLogger(ImplementacionJDBC.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            this.closeConnection();
        }
    }

    public void agregarCuenta(Integer idCuenta, Integer idCliente) throws ClassNotFoundException, SQLException {
        this.openConnection();

        try {

            stmt = conex.prepareStatement("insert into customer_account values(?,?)");
            stmt.setInt(1, idCliente);
            stmt.setInt(2, idCuenta);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ImplementacionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }

    }

    public void crearCuentaCliente(Cuenta cuent, String idCliente) throws ClassNotFoundException, SQLException {
        Date fecha;
        LocalDate currentLocalDate = LocalDate.now();
        ZoneId systemTimeZone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = currentLocalDate.atStartOfDay(systemTimeZone);
        fecha = (Date) Date.from(zonedDateTime.toInstant());
        this.openConnection();
        try {
            stmt = conex.prepareStatement("insert into account values (?,?,?,?,?,?,?)");
            stmt.setInt(1, cuent.getId());
            stmt.setString(2, cuent.getDescription());
            stmt.setFloat(3, cuent.getBalance());
            stmt.setFloat(4, cuent.getCredito());
            stmt.setFloat(5, cuent.getInicioBalance());
            stmt.setDate(6, fecha);
            //stmt.setInteger(7,num);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ImplementacionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }

    }

    public void consultarCuenta(Integer idCuenta) throws ClassNotFoundException, SQLException {
        this.openConnection();
                    Enum tCuen = null;

        Cuenta cuent = new Cuenta();
        try {
            stmt = conex.prepareStatement("select * from account where id=?");
            stmt.setInt(1, idCuenta);
            rs = stmt.executeQuery();
            cuent.setId(rs.getInt(1));
            cuent.setBalance(rs.getFloat(2));
            cuent.setInicioBalance(rs.getFloat(3));
            LocalDate fecha = rs.getDate(4).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            cuent.setFechaInicioBalance(fecha);
            cuent.setCredito(rs.getFloat(5));
            cuent.setDescription(rs.getString(6));
               if (rs.getInt(7) == 0) {
                tCuen = TipoCuenta.CREDIT;

            } else {
                tCuen = TipoCuenta.STANDAR;
            }
            cuent.setTipoCuenta(tCuen);
        } catch (SQLException ex) {
            Logger.getLogger(ImplementacionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }

    }

    public void realizarMovimiento(Integer idCuenta) {
        String sentencia = "select * from account where id=?";
        Movimientos mov = new Movimientos();
        boolean esta = false;
        try {
            stmt = conex.prepareStatement(sentencia);
            stmt.setInt(1, idCuenta);
            rs = stmt.executeQuery();

            conex.close();

        } catch (SQLException ex) {
            Logger.getLogger(ImplementacionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void consultarMovimiento(String idMovimiento, String idCuenta) {

    }

}
