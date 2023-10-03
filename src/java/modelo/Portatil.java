/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Portatil {
    int idPortatil;
    String marca;
    String codigo;
    int paginacion=10;

    public int getIdPortatil() {
        return idPortatil;
    }

    public void setIdPortatil(int idPortatil) {
        this.idPortatil = idPortatil;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public ArrayList listar (int pagina){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        ArrayList listaPortatil = new ArrayList();
        Portatil laPortatil;
        String listado = "SELECT * FROM "+this.getClass().getSimpleName()+" ORDER BY idPortatil";
        if (pagina<0) {
            int paginacionMax = pagina * this.paginacion;
            int paginacionMin = paginacionMax - this.paginacion;
            listado = "SELECT * FROM "+this.getClass().getSimpleName()+" ORDER BY idPortatil LIMIT "+paginacionMin+","+paginacionMax;
        }
        
        try {
            ResultSet rs = st.executeQuery(listado);
            while (rs.next()) {                
                laPortatil = new Portatil();
                laPortatil.setIdPortatil(rs.getInt("idPortatil"));
                laPortatil.setMarca(rs.getString("marca"));
                laPortatil.setCodigo(rs.getString("codigo"));
                listaPortatil.add(laPortatil);
                
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar Portatil:"+ex.getLocalizedMessage());
        }
        conexion.desconectar();
        return listaPortatil;
    }
    
    public void insertar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("INSERT INTO Portatil(idPortatil, marca, codigo)"+" VALUES("+getIdPortatil()+",'"+getMarca()+"','"+getCodigo()+"')");
        } catch (SQLException ex) {
            System.err.println("Error al insesrtar Portatil: "+ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }
    
    public void modificar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("UPDATE Portatil SET marca="+getMarca()+", codigo="+getCodigo()+" WHERE idPortatil="+getIdPortatil());
        } catch (SQLException ex) {
            System.err.println("Error al modificar Portatil:"+ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }
    
    public void eliminar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("DELETE FROM Portatil WHERE idPortatil ="+getIdPortatil());
        } catch (SQLException ex) {
            System.err.println("Error al eliminar Portatil:"+ex.getLocalizedMessage());
        }
        conexion.desconectar();
    }
    
    public int cantidadPaginas(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        int cantidadDeBloques = 0;
        try{
            ResultSet rs = st.executeQuery("SELECT CEIL(COUNT(idPortatil)/"+this.paginacion+")AS cantidad FROM "+this.getClass().getSimpleName());
            if (rs.next()) {
                cantidadDeBloques = rs.getInt("cantidad");
            }
        } catch(SQLException ex){
            System.err.println("Error al obtener la cantidad de paginas Portatil"+ex.getLocalizedMessage());
        }
        return cantidadDeBloques;
    }
}
