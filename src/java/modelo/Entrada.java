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
public class Entrada {
    int idEntrada;
    int idCelador;
    int idAprendiz;
    int idPortatil;
    String fechaE;
    String fechaS;
    int paginacion=10;

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getIdCelador() {
        return idCelador;
    }

    public void setIdCelador(int idCelador) {
        this.idCelador = idCelador;
    }

    public int getIdAprendiz() {
        return idAprendiz;
    }

    public void setIdAprendiz(int idAprendiz) {
        this.idAprendiz = idAprendiz;
    }

    public int getIdPortatil() {
        return idPortatil;
    }

    public void setIdPortatil(int idPortatil) {
        this.idPortatil = idPortatil;
    }

    public String getFechaE() {
        return fechaE;
    }

    public void setFechaE(String fechaE) {
        this.fechaE = fechaE;
    }

    public String getFechaS() {
        return fechaS;
    }

    public void setFechaS(String fechaS) {
        this.fechaS = fechaS;
    }
    
    public ArrayList listar (int pagina){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        ArrayList listaEntrada = new ArrayList();
        Entrada laEntrada;
        String listado = "SELECT * FROM "+this.getClass().getSimpleName()+" ORDER BY idEntrada";
        if (pagina<0) {
            int paginacionMax = pagina * this.paginacion;
            int paginacionMin = paginacionMax - this.paginacion;
            listado = "SELECT * FROM "+this.getClass().getSimpleName()+" ORDER BY idEntrada LIMIT "+paginacionMin+","+paginacionMax;
        }
        
        try {
            ResultSet rs = st.executeQuery(listado);
            while (rs.next()) {                
                laEntrada = new Entrada();
                laEntrada.setIdEntrada(rs.getInt("idEntrada"));
                laEntrada.setIdCelador(rs.getInt("idCelador"));
                laEntrada.setIdAprendiz(rs.getInt("idAprendiz"));
                laEntrada.setIdPortatil(rs.getInt("idPortatil"));
                laEntrada.setFechaE(rs.getString("fechaE"));
                laEntrada.setFechaS(rs.getString("fechaS"));
                listaEntrada.add(laEntrada);
                
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar Entrada:"+ex.getLocalizedMessage());
        }
        conexion.desconectar();
        return listaEntrada;
    }
    
    public void insertar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        String sql="INSERT INTO Entrada(idEntrada, idCelador, idAprendiz, idPortatil, fechaE, fechaS)"+" VALUES("+getIdEntrada()+","+getIdCelador()+","+getIdAprendiz()+","+getIdPortatil()+",NOW(),'"+getFechaS()+"')";
        try {
            System.out.println(sql);
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.err.println("Error al insertar Entrada: "+ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }
    
    public void modificar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("UPDATE Entrada SET idCelador="+getIdCelador()+", idAprendiz="+getIdAprendiz()+", idPortatil="+getIdPortatil()+", fechaE="+getFechaE()+", fechaS="+getFechaS()+" WHERE idEntrada="+getIdEntrada());
        } catch (SQLException ex) {
            System.err.println("Error al modificar Entrada:"+ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }
    
    public void eliminar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("DELETE FROM Entrada WHERE idEntrada ="+getIdEntrada());
        } catch (SQLException ex) {
            System.err.println("Error al eliminar Entrada:"+ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }
    
    public int cantidadPaginas(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        int cantidadDeBloques = 0;
        try{
            ResultSet rs = st.executeQuery("SELECT CEIL(COUNT(idEntrada)/"+this.paginacion+")AS cantidad FROM "+this.getClass().getSimpleName());
            if (rs.next()) {
                cantidadDeBloques = rs.getInt("cantidad");
            }
        } catch(SQLException ex){
            System.err.println("Error al obtener la cantidad de paginas Entrada"+ex.getLocalizedMessage());
        }
        return cantidadDeBloques;
    }
    
    public void salida(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("UPDATE Entrada set FechaS = now()");              
        } catch (SQLException ex) {
            System.err.println("Error al salir:"+ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }
    
    
}
