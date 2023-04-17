package com.ufps.entities;

import java.time.LocalDate;
import java.time.Period;

import com.ufps.entities.Paciente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "paciente")
@NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
public class Paciente {

	@Id
	@SequenceGenerator(name="pacienteid", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pacienteid")
	private Integer id;
	
	private String documento;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	private String genero;
	
	@Temporal(TemporalType.DATE)
	private LocalDate fechanacimiento; 
	
	private String telefono;
	
	private String direccion;
	
	private float peso;
	
	private float estatura;
	
	@Transient
	private int edad;
	
	public Paciente(String documento, String nombre, String apellido, String email, String genero, LocalDate fechanacimiento, String telefono, String direccion, float peso, float estatura) {
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.genero = genero;
		this.fechanacimiento = fechanacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.peso = peso;
		this.estatura = estatura;
	}
	
	public int getEdad() {
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechanacimiento, fechaActual);
		this.edad = periodo.getYears();
		return this.edad;
	}
}
