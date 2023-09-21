/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author CGAO
 */
public class Celador {
    int idCelador;
    String nombre;
    String ident;
    int paginacion=10;

    public int getIdCelador() {
        return idCelador;
    }

    public void setIdCelador(int idCelador) {
        this.idCelador = idCelador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }
    
    public ArrayList listar (int pagina){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        ArrayList listaCeladores = new ArrayList();
        Celador laCelador;
        String listado = "SELECT * FROM "+this.getClass().getSimpleName()+" ORDER BY idCelador";
        if (pagina<0) {
            int paginacionMax = pagina * this.paginacion;
            int paginacionMin = paginacionMax - this.paginacion;
            listado = "SELECT * FROM "+this.getClass().getSimpleName()+" ORDER BY idCelador LIMIT "+paginacionMin+","+paginacionMax;
        }
        
        try {
            ResultSet rs = st.executeQuery(listado);
            while (rs.next()) {                
                laCelador = new Celador();
                laCelador.setIdCelador(rs.getInt("idCelador"));
                laCelador.setNombre(rs.getString("nombre"));
                laCelador.setIdent(rs.getString("ident"));
                listaCeladores.add(laCelador);
                
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar pelicula:"+ex.getLocalizedMessage());
        }
        conexion.desconectar();
        return listaCeladores;
    }
    
    public void insertar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("INSERT INTO Celador(idCelador, nombre, ident)"+" VALUES("+getIdCelador()+","+getNombre()+","+getIdent()+")");
        } catch (SQLException ex) {
            System.err.println("Error al insesrtar pelicula: "+ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }
    
    public void modificar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("UPDATE Celador SET nombre="+getNombre()+", ident="+getIdent()+" WHERE idCelador="+getIdCelador());
        } catch (SQLException ex) {
            System.err.println("Error al modificar pelicula:"+ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }
    
    public void eliminar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("DELETE FROM Celador WHERE idCelador ="+getIdCelador());
        } catch (SQLException ex) {
            System.err.println("Error al eliminar pelicula:"+ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }
    
    public int cantidadPaginas(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        int cantidadDeBloques = 0;
        try{
            ResultSet rs = st.executeQuery("SELECT CEIL(COUNT(idCelador)/"+this.paginacion+")AS cantidad FROM "+this.getClass().getSimpleName());
            if (rs.next()) {
                cantidadDeBloques = rs.getInt("cantidad");
            }
        } catch(SQLException ex){
            System.err.println("Error al obtener la cantidad de paginas pelicula"+ex.getLocalizedMessage());
        }
        return cantidadDeBloques;
    }
}
