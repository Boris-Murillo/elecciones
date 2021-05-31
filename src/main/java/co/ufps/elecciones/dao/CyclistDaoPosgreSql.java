package co.ufps.elecciones.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.ufps.giro.model.Cyclist;
import co.ufps.giro.util.ConexionPostgreSql;

public class CyclistDaoPosgreSql implements CyclistDao {
	
private ConexionPostgreSql conexion;
	
	private static final String INSERT_CYCLIST_SQL = "INSERT INTO public.candidato(\r\n"
			+ "	 documento, nombre, apellido, eleccion, numero)\r\n"
			+ "	VALUES ( ?, ?, ?, ?, ?);";
	private static final String DELETE_CYCLIST_SQL = "DELETE FROM cyclist WHERE id = ?;";
	private static final String UPDATE_CCYCLIST_SQL = "UPDATE public.candidato\r\n"
			+ "	SET id=?, documento=?, nombre=?, apellido=?, eleccion=?, numero=?\r\n"
			+ "	WHERE id = ? ;";
	private static final String SELECT_CYCLIST_BY_ID = "SELECT * FROM cyclist WHERE id = ?;";
	private static final String SELECT_ALL_CYCLISTS = "SELECT * FROM cyclist;";


	public CyclistDaoPosgreSql() {
		this.conexion= ConexionPostgreSql.getConexion();
	}
	
	@Override
	public void insert(Cyclist Ciclista) throws SQLException {
		try {
			PreparedStatement preStatement = (PreparedStatement)conexion.setPreparedStatement(INSERT_CYCLIST_SQL);
			preStatement.setString(1, Ciclista.getNombre());
			preStatement.setString(2, Ciclista.getEmail());
			preStatement.setString(3, Ciclista.getPais());
			preStatement.setString(4, Ciclista.getTeam());
//			preStatement.setDate(5, (Date) Ciclista.getCumpleaños());
			conexion.execute();
			
		}catch (SQLException e) {}
		
	}

	@Override
	public Cyclist select(Long id) throws SQLException {
		Cyclist cycl = null;
		try {
			PreparedStatement preStatement = (PreparedStatement)conexion.setPreparedStatement(SELECT_CYCLIST_BY_ID);
			preStatement.setLong(1, id); 
			ResultSet rs = conexion.query();
			while(rs.next()){
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				String team = rs.getString("team");
				Date birthday = rs.getDate("birthday");
				cycl = new Cyclist(id,nombre,email,team,pais,birthday);
			}
		}catch (SQLException e) {}
		return cycl;
		
	}

	@Override
	public ArrayList<Cyclist> selectAll() throws SQLException {
		ArrayList <Cyclist> cyclists = new ArrayList<>();
		try {
			PreparedStatement preStatement = (PreparedStatement)conexion.setPreparedStatement(SELECT_ALL_CYCLISTS);
			ResultSet rs = conexion.query();
		
			while(rs.next()){
				Long id = rs.getLong("id");
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("country");
				String team = rs.getString("team");
//				Date birthday = rs.getDate("birthday");
				cyclists.add(new Cyclist(id,nombre,email,team,pais));
				
			}
		}catch (SQLException e) {}
		return cyclists;
	}

	@Override
	public void delet(Long id) throws SQLException {
		try {
			PreparedStatement preStatement = (PreparedStatement)conexion.setPreparedStatement(DELETE_CYCLIST_SQL);
			preStatement.setLong(1, id); 
			conexion.execute();
		}catch (SQLException e) {}
		
	}

	@Override
	public void update(Cyclist Ciclista) throws SQLException {
		try {
			PreparedStatement preStatement = (PreparedStatement)conexion.setPreparedStatement(UPDATE_CCYCLIST_SQL);
			preStatement.setString(1, Ciclista.getNombre());
			preStatement.setString(2, Ciclista.getEmail());
			preStatement.setString(3, Ciclista.getPais());
			preStatement.setString(4, Ciclista.getTeam());
//			preStatement.setDate(5, (Date) Ciclista.getCumpleaños());
			conexion.execute();
			
		}catch (SQLException e) {}
		
	}

	
	
}
