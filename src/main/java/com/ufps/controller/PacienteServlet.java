package com.ufps.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ufps.dao.PacienteDao;
import com.ufps.entities.Paciente;





/**
 * Servlet implementation class PacienteServlet
 */
@WebServlet("/")
public class PacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DateTimeFormatter format;
	private PacienteDao pDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PacienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
    	this.format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.pDao = new PacienteDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch(action) {
			case"/NuevoPaciente": showPage(request, response, "pacientenew.jsp");
				break;
			case"/delete": eliminarPaciente(request, response);
				break;
			case"/edit": showEditForm(request, response);
				break;
			case"/insert": insertarPaciente(request, response);
				break;
			case"/update": actualizarPaciente(request, response);
				break;
			default:	listPacientes(request, response);
				break;
			}
		}catch(SQLException e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showPage(HttpServletRequest request, HttpServletResponse response, String pagina) 
			throws ServletException, IOException {
		 request.getRequestDispatcher(pagina).forward(request, response);
	}
	
	private void  showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Paciente p = pDao.find(id);
		request.setAttribute("p", p);
		request.getRequestDispatcher("pacientenew.jsp").forward(request, response);
	}
	
	private void actualizarPaciente(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		String fechanacimiento = request.getParameter("fechanacimiento");
		LocalDate fechana = LocalDate.parse(fechanacimiento, format);
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		int peso = Integer.parseInt(request.getParameter("peso"));
		int estatura = Integer.parseInt(request.getParameter("estatura"));
		
		Paciente p = new Paciente();
		p = pDao.find(id);
		p.setDocumento(documento);
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setEmail(email);
		p.setGenero(genero);
		p.setFechanacimiento(fechana);
		p.setTelefono(telefono);
		p.setDireccion(direccion);
		p.setPeso(peso);
		p.setEstatura(estatura);
		pDao.update(p);
		response.sendRedirect("PacienteList");
	}
	
	private void insertarPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		String fechanacimiento = request.getParameter("fechanacimiento");
		LocalDate fechana = LocalDate.parse(fechanacimiento, format);
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		int peso = Integer.parseInt(request.getParameter("peso"));
		int estatura = Integer.parseInt(request.getParameter("estatura"));

		pDao.insert(new Paciente(documento, nombre, apellido, email, genero, fechana, telefono, direccion, peso, estatura));
		response.sendRedirect("PacienteList");		
	}
	
	private void  eliminarPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Paciente p = pDao.find(id);
		pDao.delete(p);
		response.sendRedirect("PacienteList");
	}
	
	private void listPacientes(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, SQLException, IOException {
		List<Paciente> listP = new ArrayList<>();
		listP = pDao.list(); 
		request.setAttribute("listPaciente", listP);
		showPage(request, response,"pacientelist.jsp");

	}

}
