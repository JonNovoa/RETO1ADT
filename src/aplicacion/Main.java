/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import clases.Cliente;
import clases.Cuenta;
import clases.Movimientos;
import clases.TipoCuenta;
import java.time.LocalDate;
import java.time.LocalDateTime;
import modelo.ImplementacionFich;
import modelo.ImplementacionJDBC;
import modelo.InterfaceDAO;
import utilidades.Utilidades;

/**
 *
 * @author somor
 *
 *
 */
public class Main {

    public static void main(String[] args) {

        InterfaceDAO dao = null;
        int opc;
        String tipo = bdFile();

        if (tipo.equalsIgnoreCase("bd")) {
            dao = new ImplementacionJDBC();
        }
        if (tipo.equalsIgnoreCase("archivo")) {
            dao = new ImplementacionFich();

        }

        do {
            opc = menu();

            switch (opc) {
                case 1:

                    dao.crearCliente(crearCliente());
                    break;
                case 2:
                    dao.consultarCliente(idCliente());
                    break;

                case 3:
                    dao.consultarCuentaCliente(idCliente(), idCuenta());
                    break;
                case 4:
                    dao.agregarCuenta(idCliente(), idCuenta());
                    break;
                case 5:
                    dao.crearCuentaCliente(crearCuenta(), idCliente());
                    break;
                case 6:
                    dao.consultarCuenta(idCuenta());
                    break;
                case 7:
                    dao.realizarMovimiento(crearMovimiento(),idCuenta());
                    break;
                case 8:
                    dao.consultarMovimiento(idMovimiento(), idCuenta());
                    break;
                case 9:
                    System.out.println("EXIT");
                    break;
            }

        } while (opc != 9);
    }

    private static Movimientos crearMovimiento() {
        
        String descripcion="";
        Movimientos movi = new Movimientos();

        LocalDateTime fechaMovimiento = LocalDateTime.now();
        Float cantidad = Utilidades.leerFloat("CANTIDAD:");
        while(!descripcion.equalsIgnoreCase("depositar") && !descripcion.equalsIgnoreCase("pagar")){
        descripcion = Utilidades.introducirCadena("DESCRIPCION: DEPOSITAR O PAGAR");
        }
       

        movi.setFechaMovimiento(fechaMovimiento);
        movi.setCantidad(cantidad);
        movi.setDescripcion(descripcion);

        return movi;

    }

    private static Cuenta crearCuenta() {
        TipoCuenta tipoCuenta;
        Cuenta cuent = new Cuenta();

        String descripcion = Utilidades.introducirCadena("DESCRIPCION:");
        Float balance = Utilidades.leerFloat("BALANCE:");
        Float credito = Utilidades.leerFloat("CREDITO:");
        Float inicioBalanace = Utilidades.leerFloat("INICIO BALANCE:");
        LocalDate fechaInicioBalance = Utilidades.leerFecha("FECHA INICIO BALANCE:");

        String cuenta = Utilidades.introducirCadena("TIPO DE CUENTA: STANDAR O CREDIT");
        if (cuenta.equalsIgnoreCase("standar")) {
            tipoCuenta = TipoCuenta.STANDAR;
        } else {
            tipoCuenta = TipoCuenta.CREDIT;
        }
        cuent.setDescription(descripcion);
        cuent.setBalance(balance);
        cuent.setCredito(credito);
        cuent.setInicioBalance(inicioBalanace);
        cuent.setFechaInicioBalance(fechaInicioBalance);
        cuent.setTipoCuenta(tipoCuenta);
        return cuent;
    }

  
 
    private static Cliente crearCliente() {

       
        Cliente client = new Cliente();

        String city = Utilidades.introducirCadena("CIUDAD:");
        String email = Utilidades.introducirCadena("EMAIL:");
        String nombre = Utilidades.introducirCadena("NOMBRE:");
        String apellido = Utilidades.introducirCadena("APELLIDO;");
        String apellido2 = Utilidades.introducirCadena("SEGUNDO APELLIDO:");
        Integer telefono = Utilidades.leerInt("TELEFONO:");
        while (Math.floor(Math.log10(telefono)) != 7) {
            telefono = Utilidades.leerInt("TELEFONO, LONGITUD INCORRECTA:");
        }

        String pais = Utilidades.introducirCadena("PAIS:");
        String calle = Utilidades.introducirCadena("CALLE:");
        Integer zip = Utilidades.leerInt("ZIP:");

        client.setCity(city);
        client.setEmail(email);
        client.setFirtsName(nombre);
        client.setLastName(apellido);
        client.setMiddleIntial(apellido2);
        client.setPhone(telefono);
        client.setState(pais);
        client.setStreet(calle);
        client.setZip(zip);

        return client;
    }

    private static Integer idMovimiento() {
        Integer id = Utilidades.leerInt("Introduce el ID del movimiento");
        return id;
    }

    private static Integer idCuenta() {

        Integer id = Utilidades.leerInt("Introduce el ID de la cuenta");

        return id;
    }

    private static Integer idCliente() {

        Integer id = Utilidades.leerInt("Introduce el ID del cliente");

        return id;

    }

    private static String bdFile() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String salida;

        salida = Utilidades.introducirCadena("¿Quieres actuar sobre BD o Archivo?");

        if (salida.equalsIgnoreCase("bd")) {
            salida = " bd";
        }
        if (salida.equalsIgnoreCase("archivo")) {
            salida = "archivo";
        }

        return salida;

    }

    private static int menu() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        int opc;

        System.out.println("1 CREAR CLIENTE");
        System.out.println("2 CONSULTAR CLIENTE");
        System.out.println("3 CONSULTAR CUENTA CLIENTE");
        System.out.println("4 AGREGAR CUENTA");
        System.out.println("5 CREAR CUENTA CLIENTE");
        System.out.println("6 CONSULTAR CUENTA");
        System.out.println("7 REALIZAR MOVIMIENTO");
        System.out.println("8 CONSULTAR MOVIMIENTO");
        System.out.println("9 SALIR");
        opc = Utilidades.leerInt();

        return opc;
    }

}
