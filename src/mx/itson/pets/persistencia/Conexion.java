/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.pets.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Esta clase contiene métodos para realizar una conexión con la base de datos establecida
 * @author Angel
 */
public class Conexion {
    
    public static Connection obtener(){
        Connection conexion =null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/veterinariadb?user=root&password=root");
        } catch (Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return conexion;
    }
    
}
