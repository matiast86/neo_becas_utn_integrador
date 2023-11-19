package dao.Impl;

import dao.AdministradorDeConexiones;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import trabajoPracticoCurso.Grupo7.PronosticosDb;

public class MysqlDaoImpl {
	
    
    public ArrayList<PronosticosDb> findAllPartidos() throws Exception{
        //vamos a ver la clase que viene JDBC
        Connection connection = AdministradorDeConexiones.getConnection();//f5
        
        
        String sql = "select * from pronosticos";
        PreparedStatement pst = connection.prepareStatement(sql);
        
        ResultSet res =  pst.executeQuery();
        
        ArrayList<PronosticosDb> listado  = new ArrayList<>();
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
            
            
            
            listado.add(new PronosticosDb(apostador, ronda, equipo1, gana1, empata, gana2, equipo2));
        }

        return listado;
    }

}
