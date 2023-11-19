package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dao.Impl.MysqlDaoImpl;
import trabajoPracticoCurso.Grupo7.Pronostico;

public class ResultadosController {
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DAO dao = (DAO) new MysqlDaoImpl();
        
        try {
            ArrayList<Resultado> resultado =  dao.findAllResultados();

            //guardo en la request algo!

            req.setAttribute("listado", resultado);

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
