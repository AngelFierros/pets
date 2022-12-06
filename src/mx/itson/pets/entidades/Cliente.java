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
 * base de datos prueba 1
 * @author Angel
 */
public class Cliente {

    /**
     * @return the animal
     */
    public String getAnimal() {
        return animal;
    }

    /**
     * @param animal the animal to set
     */
    public void setAnimal(String animal) {
        this.animal = animal;
    }

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
    private String animal;

    public static List<Cliente> obtener(String filtro) {
        List<Cliente> clientes = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtener();
            PreparedStatement statement = conexion.prepareStatement("SELECT id, nombre, celular, domicilio, nombreMascota, animal, raza, servicio, costo FROM cliente WHERE nombre LIKE ?");
            statement.setString(1, "%" + filtro + "%");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Cliente c = new Cliente();
                c.setId(resultSet.getInt(1));
                c.setNombre(resultSet.getString(2));
                c.setCelular(resultSet.getString(3));
                c.setDomicilio(resultSet.getString(4));
                c.setNombreMascota(resultSet.getString(5));
                c.setAnimal(resultSet.getString(6));
                c.setRaza(resultSet.getString(7));
                c.setServicio(resultSet.getString(8));
                c.setCosto(resultSet.getString(9));
                

                clientes.add(c);
            }
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return clientes;
    }
    
    public static Cliente obtenerPorId(int id) {
        Cliente cliente = new Cliente();
        try {
            Connection conexion = Conexion.obtener();
            String query = "SELECT id, nombre, celular, domicilio, nombreMascota, animal, raza, servicio, costo FROM cliente WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                cliente.setId(resultSet.getInt(1));
                cliente.setNombre(resultSet.getString(2));
                cliente.setCelular(resultSet.getString(3));
                cliente.setDomicilio(resultSet.getString(4));
                cliente.setNombreMascota(resultSet.getString(5));
                cliente.setAnimal(resultSet.getString(6));
                cliente.setRaza(resultSet.getString(7));
                cliente.setServicio(resultSet.getString(8));
                cliente.setCosto(resultSet.getString(9));
                
                //statement.execute();
            }
            conexion.close();
        } catch (Exception e) {
            System.err.print("Error: " + e.getMessage());
        }
        return cliente;
    }
    
    public static boolean guardar(String nombre, String celular, String domicilio, String nombreMascota, String animal, String raza, String servicio, String costo) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO cliente (nombre, celular, domicilio, nombreMascota, animal, raza, servicio, costo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, celular);
            statement.setString(3, domicilio);
            statement.setString(4, nombreMascota);
            statement.setString(5, animal);
            statement.setString(6, raza);
            statement.setString(7, servicio);
            statement.setString(8, costo);
            
            statement.execute();
            
            resultado = statement.getUpdateCount() == 1;
            
            
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
    public static boolean eliminar(int id){
     boolean resultado = true;
        try{
        Connection conexion = Conexion.obtener();
        String consulta = "DELETE from cliente WHERE id = ?" ;
        PreparedStatement statement = conexion.prepareStatement(consulta);
        statement.setInt(1,id);
        statement.execute();
        resultado = statement.getUpdateCount() == 1;
        
        conexion.close();
        }catch(Exception ex){
        System.err.println("Ocurrio un error:" + ex.getMessage());
    }
    return resultado;
    }
    public static boolean editar (int id, String nombre, String celular, String domicilio, String nombreMascota, String animal, String raza, String servicio, String costo){
        boolean resultado = false;
        try{
        Connection conexion = Conexion.obtener();
        String query = "UPDATE cliente SET nombre=?, celular=?, domicilio=?, nombreMascota=?, animal=?, raza=?, servicio=? , costo=? WHERE id = ?" ;
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, nombre);
        statement.setString(2, celular);
        statement.setString(3, domicilio);
        statement.setString(4, nombreMascota);
        statement.setString(5, animal);
        statement.setString(6, raza);
        statement.setString(7, servicio);
        statement.setString(8, costo);
        statement.setInt(9,id);
        statement.execute();
        
        resultado = statement.getUpdateCount() == 1;
        conexion.close();
        }catch(Exception ex){
        System.err.println("Ocurrio un error:" + ex.getMessage());
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
