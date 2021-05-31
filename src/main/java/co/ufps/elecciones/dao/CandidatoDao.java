package co.ufps.elecciones.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import co.ufps.elecciones.model.Candidato;



public interface CandidatoDao {

	public void insert(Candidato candidato) throws SQLException;
	public Candidato select(Long id) throws SQLException;
	public ArrayList <Candidato> selectAll() throws SQLException;
	public void delet(Long id) throws SQLException;
	public void update(Candidato candidato) throws SQLException;
}
