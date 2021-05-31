package co.ufps.elecciones.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ConexionPostgreSql {
	private Connection con = null;
	private static ConexionPostgreSql db;
	private PreparedStatement preparedStatement;
	
//	private static final String url= "jdbc:postgresql://postgres://mnjgxshj:Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV@queenie.db.elephantsql.com/mn\r\n"
//			+ "jgxshj:5432/";
 	private static final String url= "jdbc:postgresql://localhost:5432/";
	private static final String dbName = "mnjgxshj";
    private static final String driver = "org.postgresql.Driver";
    private static final String userName = "mnjgxshj";
    private static final String password = "Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";
    
    public ConexionPostgreSql() {
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(url+dbName,userName,password);
		} catch (SQLException e) {
				e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
    
    public void cerrarConexion() {
    	try {
    		con.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public static ConexionPostgreSql getConexion() {
    	if (db == null) {
    		db = new ConexionPostgreSql();
    		System.out.println("si hay conexion a postgreSQL " + db.toString());
    	}
    	
    	return db;
    }
    
    public ResultSet query() throws SQLException {
    	ResultSet res = preparedStatement.executeQuery();
    	return res;
    }
    
    public int execute() throws SQLException {
    	int result = preparedStatement.executeUpdate();
    	return result;
    }
    
    public Connection getCon() {
    	return (Connection) this.con;
    }
    
    public PreparedStatement setPreparedStatement (String sql) throws SQLException {
    	this.preparedStatement = (PreparedStatement) con.prepareStatement(sql);
    	return this.preparedStatement;	
    }
    
    
}

