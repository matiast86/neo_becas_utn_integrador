package controllers;

import java.util.ArrayList;

import Datos.ResultadosDb;
import dao.DAO;
import dao.Impl.MysqlDaoImpl;

public class ResultadosController {

    public static void main(String[] args) {
        DAO dao = new MysqlDaoImpl();

        try {
            ArrayList<ResultadosDb> resultado = dao.findAllResultados();

            // Print resultados
            System.out.println("Resultados:");
            for (ResultadosDb item : resultado) {
                System.out.println(item.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }
}

