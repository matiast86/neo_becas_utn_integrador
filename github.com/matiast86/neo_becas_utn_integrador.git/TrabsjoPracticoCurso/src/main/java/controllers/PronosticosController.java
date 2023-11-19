package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Logica.PronosticosDb;
import dao.Impl.MysqlDaoImpl;
import dao.DAO;

public class PronosticosController {
	
   
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DAO dao = (DAO) new MysqlDaoImpl();
        
        try {
            ArrayList<PronosticosDb> pronostico =  dao.findAllPronosticos();

            //guardo en la request algo!

            req.setAttribute("listado", pronostico);

            //ahora anda a la vista listado.jsp
            req.getRequestDispatcher("listado.jsp").forward(req, resp);//interna!!!
        } catch (Exception e) {
            e.printStackTrace();

            req.setAttribute("listado", new ArrayList<>());
            req.getRequestDispatcher("listado.jsp").forward(req, resp);//interna!!!
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
