package co.ufps.elecciones.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ufps.elecciones.dao.CandidatoDaoPosgreSql;
import co.ufps.elecciones.model.Candidato;



/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/")
public class CandidatoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
    private CandidatoDaoPosgreSql candidatoDao;
	
	
    public CandidatoServlet() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
    	this.candidatoDao = new CandidatoDaoPosgreSql();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch(action) {
				case "/new":
					showNewForm(request,response);
					System.out.println("nuevo");
					break;
				case "/insert":
					insertCyclist(request,response);
					System.out.println("insertando");
					break;
				case "/delete":
					deletCyclist(request,response);
					break;
				case "/edit":
					System.out.println("editando");
					showEditForm(request,response);
					break;
				case "/update":
					System.out.println("editando000000 ");
					updateCyclist(request,response);
					break;
					default:
						listarCyclist(request,response);
						break;
			}
		}catch(SQLException e) {
			throw new ServletException(e); 
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidato.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertCyclist(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
		String doc = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apell = request.getParameter("apellido");
		String elec = request.getParameter("eleccion");
		String num = request.getParameter("numero");
		
		Candidato user = new Candidato(doc, nombre, apell, Integer.parseInt(elec), Integer.parseInt(num));
		candidatoDao.insert(user);	
		response.sendRedirect("list");	
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		long id = Long.parseLong(request.getParameter("id"));
		
		Candidato userAct = candidatoDao.select(id);
		request.setAttribute("Candidato",userAct);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidato.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void updateCyclist(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String doc = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apell = request.getParameter("apellido");
		String elec = request.getParameter("eleccion");
		String num = request.getParameter("numero");
		
		Candidato user = new Candidato(id,doc, nombre, apell, Integer.parseInt(elec), Integer.parseInt(num));
		
		candidatoDao.update(user);
		response.sendRedirect("list");			
	}
	
	private void deletCyclist(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		candidatoDao.delet(id);
		response.sendRedirect("list");			
	}
	
	private void listarCyclist(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		ArrayList<Candidato> listCandidatos = candidatoDao.selectAll();
		request.setAttribute("listCandidatos", listCandidatos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidatolist.jsp");
		dispatcher.forward(request, response);
	}

}
