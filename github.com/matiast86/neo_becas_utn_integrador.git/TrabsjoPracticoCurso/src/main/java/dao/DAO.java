package dao;

import java.util.ArrayList;

import Datos.PronosticosDb;
import Datos.ResultadosDb;




public interface DAO {
	public ArrayList<ResultadosDb> findAllResultados() throws Exception;
	public ArrayList<PronosticosDb> findAllPronosticos() throws Exception;

}
