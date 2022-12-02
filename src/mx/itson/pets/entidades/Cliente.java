/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.pets.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.pets.persistencia.Conexion;

/**
 *
 * @author Angel
 */
public class Cliente {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    private int id;
    private String nombre;
    private String celular;
    private String domicilio;
    private String nombreMascota;
    private String raza;
    private String servicio;
    private String costo;

    public static List<Cliente> obtener() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT id, nombre, celular, domicilio, nombreMascota, raza, servicio, costo FROM cliente");

            while (resultSet.next()) {
                Cliente c = new Cliente();
                c.setId(resultSet.getInt(1));
                c.setNombre(resultSet.getString(2));
                c.setCelular(resultSet.getString(3));
                c.setDomicilio(resultSet.getString(4));
                c.setNombreMascota(resultSet.getString(5));
                c.setRaza(resultSet.getString(6));
                c.setServicio(resultSet.getString(7));
                c.setCosto(resultSet.getString(8));
                

                clientes.add(c);
            }
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return clientes;
    }
    
    public static boolean guardar(String nombre, String celular, String domicilio, String nombreMascota, String raza, String servicio, String costo) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO cliente (nombre, celular, domicilio, nombreMascota, raza, servicio, costo) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, celular);
            statement.setString(3, domicilio);
            statement.setString(4, nombreMascota);
            statement.setString(5, raza);
            statement.setString(6, servicio);
            statement.setString(7, costo);
            
            statement.execute();
            
            resultado = statement.getUpdateCount() == 1;
            
            
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
    
    
    
    
    
    
    
    
    
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the nombreMascota
     */
    public String getNombreMascota() {
        return nombreMascota;
    }

    /**
     * @param nombreMascota the nombreMascota to set
     */
    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    /**
     * @return the raza
     */
    public String getRaza() {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * @return the servicio
     */
    public String getServicio() {
        return servicio;
    }

    /**
     * @param servicio the servicio to set
     */
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    /**
     * @return the costo
     */
    public String getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(String costo) {
        this.costo = costo;
    }
    
    
    
    
    
    
}
