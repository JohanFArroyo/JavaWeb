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
public class Aprendiz {
    int idAprendiz;
    String nombre;
    String ident;
    String ficha;
    int paginacion=10;

    public int getIdAprendiz() {
        return idAprendiz;
    }

    public void setIdAprendiz(int idAprendiz) {
        this.idAprendiz = idAprendiz;
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

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }
    
    public ArrayList listar (int pagina){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        ArrayList listaAprendiz = new ArrayList();
        Aprendiz laAprendiz;
        String listado = "SELECT * FROM "+this.getClass().getSimpleName()+" ORDER BY idAprendiz";
        if (pagina<0) {
            int paginacionMax = pagina * this.paginacion;
            int paginacionMin = paginacionMax - this.paginacion;
            listado = "SELECT * FROM "+this.getClass().getSimpleName()+" ORDER BY idAprendiz LIMIT "+paginacionMin+","+paginacionMax;
        }
        
        try {
            ResultSet rs = st.executeQuery(listado);
            while (rs.next()) {                
                laAprendiz = new Aprendiz();
                laAprendiz.setIdAprendiz(rs.getInt("idAprendiz"));
                laAprendiz.setNombre(rs.getString("nombre"));
                laAprendiz.setIdent(rs.getString("ident"));
                laAprendiz.setFicha(rs.getString("ficha"));
                listaAprendiz.add(laAprendiz);
                
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar Aprendiz:"+ex.getLocalizedMessage());
        }
        conexion.desconectar();
        return listaAprendiz;
    }
    
    public void insertar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("INSERT INTO Aprendiz(idAprendiz, nombre, ident, ficha)"+" VALUES("+getIdAprendiz()+",'"+getNombre()+"','"+getIdent()+"','"+getFicha()+"')");
        } catch (SQLException ex) {
            System.err.println("Error al insesrtar Aprendiz: "+ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }
    
    public void modificar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("UPDATE Aprendiz SET nombre="+getNombre()+", ident="+getIdent()+", ficha="+getFicha()+" WHERE idAprendiz="+getIdAprendiz());
        } catch (SQLException ex) {
            System.err.println("Error al modificar Aprendiz:"+ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }
    
    public void eliminar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("DELETE FROM Aprendiz WHERE idAprendiz ="+getIdAprendiz());
        } catch (SQLException ex) {
            System.err.println("Error al eliminar Aprendiz:"+ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }
    
    public int cantidadPaginas(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        int cantidadDeBloques = 0;
        try{
            ResultSet rs = st.executeQuery("SELECT CEIL(COUNT(idAprendiz)/"+this.paginacion+")AS cantidad FROM "+this.getClass().getSimpleName());
            if (rs.next()) {
                cantidadDeBloques = rs.getInt("cantidad");
            }
        } catch(SQLException ex){
            System.err.println("Error al obtener la cantidad de paginas Aprendiz"+ex.getLocalizedMessage());
        }
        return cantidadDeBloques;
    }
}
