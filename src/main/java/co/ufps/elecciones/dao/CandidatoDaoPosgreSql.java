package co.ufps.elecciones.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.ufps.elecciones.model.Candidato;
import co.ufps.elecciones.util.ConexionPostgreSql;


public class CandidatoDaoPosgreSql implements CandidatoDao{
	
private ConexionPostgreSql conexion;
	
	private static final String INSERT_CANDIDATO_SQL = "INSERT INTO public.candidato(\r\n"
			+ "	 documento, nombre, apellido, eleccion, numero)\r\n"
			+ "	VALUES ( ?, ?, ?, ?, ?);";
	private static final String DELETE_CANDIDATO_SQL = "DELETE FROM Candidato WHERE id = ?;";
	private static final String UPDATE_CANDIDATO_SQL = "UPDATE public.candidato\r\n"
			+ "	SET documento=?, nombre=?, apellido=?, eleccion=?, numero=?\r\n"
			+ "	WHERE id = ? ;";
	private static final String SELECT_CANDIDATO_BY_ID = "SELECT * FROM candidato WHERE id = ?;";
	private static final String SELECT_ALL_CANDIDATO = "SELECT * FROM candidato;";


	public CandidatoDaoPosgreSql() {
		this.conexion= ConexionPostgreSql.getConexion();
	}
	
	@Override
	public void insert(Candidato candidato) throws SQLException {
		try {
			PreparedStatement preStatement = (PreparedStatement)conexion.setPreparedStatement(INSERT_CANDIDATO_SQL);
			preStatement.setString(1, candidato.getDocumento());
			preStatement.setString(2, candidato.getNombre());
			preStatement.setString(3, candidato.getApellido());
			preStatement.setInt(4, candidato.getEleccion());
			preStatement.setInt(5, candidato.getNumero());
			conexion.execute();
			
		}catch (SQLException e) {}
		
	}

	@Override
	public Candidato select(Long id) throws SQLException {
		Candidato cand = null;
		try {
			PreparedStatement preStatement = (PreparedStatement)conexion.setPreparedStatement(SELECT_CANDIDATO_BY_ID);
			preStatement.setLong(1, id); 
			ResultSet rs = conexion.query();
			while(rs.next()){
				String documento = rs.getString("documento");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				Integer elec = rs.getInt("eleccion");
				Integer num = rs.getInt("numero");
				cand = new Candidato(documento, nombre, apellido,elec, num);
			}
		}catch (SQLException e) {}
		return cand;
		
	}

	@Override
	public ArrayList<Candidato> selectAll() throws SQLException {
		ArrayList <Candidato> Candidatos = new ArrayList<>();
		try {
			PreparedStatement preStatement = (PreparedStatement)conexion.setPreparedStatement(SELECT_ALL_CANDIDATO);
			ResultSet rs = conexion.query();
		
			while(rs.next()){
				Long id = rs.getLong("id");
				String documento = rs.getString("documento");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				Integer elec = rs.getInt("eleccion");
				Integer num = rs.getInt("numero");

				Candidatos.add(new Candidato(id, documento, nombre, apellido, elec, num) );
				
			}
		}catch (SQLException e) {}
		return Candidatos;
	}

	@Override
	public void delet(Long id) throws SQLException {
		try {
			PreparedStatement preStatement = (PreparedStatement)conexion.setPreparedStatement(DELETE_CANDIDATO_SQL);
			preStatement.setLong(1, id); 
			conexion.execute();
		}catch (SQLException e) {}
		
	}

	@Override
	public void update(Candidato candidato) throws SQLException {
		try {
			PreparedStatement preStatement = (PreparedStatement)conexion.setPreparedStatement(UPDATE_CANDIDATO_SQL);
			preStatement.setString(1, candidato.getDocumento());
			preStatement.setString(2, candidato.getNombre());
			preStatement.setString(3, candidato.getApellido());
			preStatement.setInt(4, candidato.getEleccion());
			preStatement.setInt(5, candidato.getNumero());

			conexion.execute();
			
		}catch (SQLException e) {}
		
	}

	
	
}
