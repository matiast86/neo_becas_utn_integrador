package controllers;

import java.util.ArrayList;

import Datos.PronosticosDb;
import dao.DAO;
import dao.Impl.MysqlDaoImpl;

public class PronosticosController {

    public static void main(String[] args) {
        DAO dao = new MysqlDaoImpl();

        try {
            ArrayList<PronosticosDb> pronostico = dao.findAllPronosticos();

            // Print pronosticos
            System.out.println("Pronosticos:");
            for (PronosticosDb item : pronostico) {
                System.out.println(item.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }
    

}

