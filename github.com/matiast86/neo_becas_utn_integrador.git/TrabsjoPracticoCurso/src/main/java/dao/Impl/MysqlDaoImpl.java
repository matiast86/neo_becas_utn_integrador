package dao.Impl;

import dao.AdministradorDeConexiones;
import dao.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Datos.PronosticosDb;
import Datos.ResultadosDb;

public class MysqlDaoImpl implements DAO {
	
    
    public ArrayList<PronosticosDb> findAllPronosticos() throws Exception{
        //vamos a ver la clase que viene JDBC
        Connection connection = AdministradorDeConexiones.getConnection();//f5
        
        
        String sql = "select * from pronosticos";
        PreparedStatement pst = connection.prepareStatement(sql);
        
        ResultSet res =  pst.executeQuery();
        
        ArrayList<PronosticosDb> listadoPronosticos  = new ArrayList<>();
        //extraer los datos del res!
        while(res.next()) {
            //aca uds hace la magia
            String apostador = res.getString(1);
            int ronda = res.getInt(2);
            String equipo1 = res.getString(3);
            String gana1 = res.getString(4);
            String empata = res.getString(5);
            String gana2 = res.getString(6);
            String equipo2 = res.getString(7);
            
            
            
            listadoPronosticos.add(new PronosticosDb(apostador, ronda, equipo1, gana1, empata, gana2, equipo2));
        }

        return listadoPronosticos;
    }
    
    public ArrayList<ResultadosDb> findAllResultados() throws Exception{
        Connection connection = AdministradorDeConexiones.getConnection();//f5
        
        
        String sql = "select * from resultados";
        PreparedStatement pst = connection.prepareStatement(sql);
        
        ResultSet res =  pst.executeQuery();
        
        ArrayList<ResultadosDb> listadoResultados  = new ArrayList<>();

        while(res.next()) {

            int ronda = res.getInt(1);
            String equipo1 = res.getString(2);
            int cantGoles1 = res.getInt(3);
            int cantGoles2 = res.getInt(4);
            String equipo2 = res.getString(5);
            
            
            
            listadoResultados.add(new ResultadosDb(ronda, equipo1, cantGoles1, cantGoles2, equipo2));
        }

        return listadoResultados;
    }



}
