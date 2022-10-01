/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Cliente;
import clases.Cuenta;
import clases.Movimientos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.MiObjectOutputStream;
import utilidades.Utilidades;

/**
 *
 * @author somor
 */
public class ImplementacionFich implements InterfaceDAO {

    File cl = new File("Clientes.obj");

    @Override
    public void crearCliente(Cliente client) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        MiObjectOutputStream moos = null;
        Cliente c;

        int cont = Utilidades.calculoFichero(cl);

        Integer id = Utilidades.leerInt("introduce id de Customer");
        int encontrado;
        encontrado = buscarCod(id, cl);

        if (encontrado == 1) {
            if (cl.exists()) {
                try {
                    fos = new FileOutputStream(cl);
                    moos = new MiObjectOutputStream(fos);

                    c = client;                    
                    moos.writeObject(c);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        moos.close();
                        fos.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } else {
                try {
                    fos = new FileOutputStream(cl);
                    oos = new ObjectOutputStream(fos);

                    c = new Cliente();
                    c.setDatos(id);
                    oos.writeObject(c);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        oos.close();
                        fos.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        } else {
            System.out.println("Id repetido");
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarCliente(Integer idCliente) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Cliente c;
        int cont = Utilidades.calculoFichero(cl);
        int encontrado;
        if (cl.exists()) {
            Integer id = Utilidades.leerInt("introduce id de Customer");
            encontrado = buscarCod(id, cl);
            if (encontrado == 0) {
                try {
                    fis = new FileInputStream(cl);
                    ois = new ObjectInputStream(fis);

                    for (int i = 0; i < cont; i++) {
                        c = (Cliente) ois.readObject();
                        if (c.getId().equals(id)) {
                            c.getDatos();
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fis.close();
                        ois.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        } else {
            System.out.println("Crear fichero primero");
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarCuentaCliente(Integer idCliente, Integer idCuenta) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Cliente c ;
        int cont = Utilidades.calculoFichero(cl);
        int econtradocl;
        int econtradocu;
        if(cl.exists()){
            econtradocl = buscarCod(idCliente, cl);
            
            if(econtradocl == 0){
                try {
                    fis = new FileInputStream(cl);
                    ois = new ObjectInputStream(fis);
                    
                    for (int i = 0; i < cont; i++){
                        c = (Cliente) ois.readObject();
                        if(c.getId().equals(idCliente)){
                            c.buscarClCu();
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fis.close();
                        ois.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
                    
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarCuenta(Integer idDliente, Integer idCuenta) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        Cuenta cu = null;
        Cliente c;
        Integer encontradocl;
        Integer encontradocu;
        int cont = Utilidades.calculoFichero(cl);
        Integer idcl = Utilidades.leerInt("Introduce id de Cliente");
        encontradocl = buscarCod(idcl, cl);
        if (encontradocl == 1) {
            Integer idcuenta = Utilidades.leerInt("introduce id de Cuenta para agregar: ");
            encontradocu = buscarCod(idcuenta, cl);
                if(encontradocu == 1) {
                   try {
                    fis = new FileInputStream(cl);
                    ois = new ObjectInputStream(fis);
                    cu = (Cuenta) ois.readObject();
                    
                    for (int i = 0; i < cont; i++) {
                        c = (Cliente) ois.readObject();
                        if (c.getId().equals(idcl)) {
                            c.setCuenta(cu);
                        }
                    }
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                       try {
                           fis.close();
                           ois.close();
                       } catch (IOException ex) {
                           Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   }
                }
        }

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearCuentaCliente(Cuenta cuent, Integer idCliente) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        Cuenta cu;
        Cliente c;

        int cont = Utilidades.calculoFichero(cl);
        Integer idcl;
        Integer idcuenta = Utilidades.leerInt("introduce id de Cuenta");
        int encontrado;
        encontrado = buscarCod(idcuenta, cl);
        if (encontrado == 1) {
            try {
                fos = new FileOutputStream(cl);
                oos = new ObjectOutputStream(fos);

                fis = new FileInputStream(cl);
                ois = new ObjectInputStream(fis);

                cu = new Cuenta();
                cu.setDatos(idcuenta);
                oos.writeObject(cu);
                idcl = Utilidades.leerInt("Introducir id de cliente para asignar cuenta: ");

                encontrado = buscarCod(idcl, cl);
                if (encontrado == 0) {

                    for (int i = 0; i < cont; i++) {
                        c = (Cliente) ois.readObject();
                        if (c.getId().equals(idcl)) {
                            c.setCuenta(cu);
                        }
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    oos.close();
                    fos.close();
                    ois.close();
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            System.out.println("Id repetido");
        }

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarCuenta(Integer idCuenta) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Cuenta cu;
        Cliente c;
        int cont = Utilidades.calculoFichero(cl);
        int encontrado;
        if (cl.exists()) {
            Integer id = Utilidades.leerInt("Introduce id de Customer");
            encontrado = buscarCod(id, cl);
            if (encontrado == 0) {
                try {
                    fis = new FileInputStream(cl);
                    ois = new ObjectInputStream(fis);

                    for (int i = 0; i < cont; i++) {
                        c = (Cliente) ois.readObject();
                        if (c.getId().equals(id)) {
                            Integer idcu = Utilidades.leerInt("Introduce id cuenta");
                            c.buscarCuenta(idcu);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fis.close();
                        ois.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            System.out.println("Crear fichero primero");
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void realizarMovimiento(Movimientos mov, Integer idCuenta) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Cuenta cu;
        int cont = Utilidades.calculoFichero(cl);
        int encontrado;
        if (cl.exists()){
            encontrado = buscarCod(idCuenta, cl);
            if(encontrado==0){
                try {
                    fis = new FileInputStream(cl);
                    ois = new ObjectInputStream(fis);
                    
                    for (int i = 0; i < cont; i++) {
                        cu = (Cuenta) ois.readObject();
                        if (cu.getId().equals(idCuenta)){
                            cu.setMovimientoCu();
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    try {
                        fis.close();
                        ois.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarMovimiento(Integer idMoviento, Integer idCuenta) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Cuenta cu;
        int cont = Utilidades.calculoFichero(cl);
        int encontrado;
        if(cl.exists()){
            encontrado = buscarCod(idCuenta, cl);
            if(encontrado == 0){
                try {
                    fis = new FileInputStream(cl);
                    ois = new ObjectInputStream(fis);
                    
                    for (int i = 0; i < cont; i++) {
                        cu = (Cuenta) ois.readObject();
                        
                        if(cu.getId().equals(idCuenta)){
                            cu.getMovimientoCu(idMoviento);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int buscarCod(Integer id, File cl) {
        boolean encontrado = false;

        ObjectInputStream ois = null;
        FileInputStream fis = null;

        int cont = Utilidades.calculoFichero(cl);

        if (cont != 0) {
            try {
                fis = new FileInputStream(cl);
                ois = new ObjectInputStream(fis);

                Object aux = ois.readObject();

                while (aux != null) {
                    if (aux instanceof Cliente) {
                        if (((Cliente) aux).getId().equals(id)) {
                            encontrado = true;
                        }
                        aux = ois.readObject();
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fis.close();
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            System.out.println("Fichero vacio");
        }
        if (encontrado == true) {
            return 1;
        } else {
            return 0;
        }
    }

}
