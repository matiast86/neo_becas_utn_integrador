package dao;

import java.util.ArrayList;

import trabajoPracticoCurso.Grupo7.Partido;
import trabajoPracticoCurso.Grupo7.PronosticosDb;




public interface DAO {
	public ArrayList<Resultado> findAllResultados() throws Exception;
	public ArrayList<PronosticosDb> findAllPronosticos() throws Exception;

}
