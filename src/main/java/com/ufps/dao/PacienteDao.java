package com.ufps.dao;

import com.ufps.entities.Paciente;
import com.ufps.util.Conexion;
import com.ufps.util.GenericDAO;



public class PacienteDao extends Conexion<Paciente> implements GenericDAO<Paciente>{
	
	public PacienteDao() {
		super(Paciente.class);
	}
	
	
}
