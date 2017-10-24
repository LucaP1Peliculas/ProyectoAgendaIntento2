package com.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="empleados")
public class Empleado implements Serializable{
	

    private static final long serialVersionUID = 144585071807476496L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id_empleados;
	
    private String codEmpleado;
    private int salario;
    private String  fechaAlta;
    
    
    @JoinColumn(name = "idDepartamento", referencedColumnName = "iddepartamento")
    @ManyToOne
    private Departamento departamentoId;
    
    
    @JoinColumn(name = "idCategoria", referencedColumnName = "idcategoria")
    @ManyToOne
    private Categoria categoriaId;


	public int getId_empleados() {
		return id_empleados;
	}


	public void setId_empleados(int id_empleados) {
		this.id_empleados = id_empleados;
	}


	public String getCodEmpleado() {
		return codEmpleado;
	}


	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}


	public int getSalario() {
		return salario;
	}


	public void setSalario(int salario) {
		this.salario = salario;
	}


	public String getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	public Departamento getDepartamentoId() {
		return departamentoId;
	}


	public void setDepartamentoId(Departamento departamentoId) {
		this.departamentoId = departamentoId;
	}


	public Categoria getCategoriaId() {
		return categoriaId;
	}


	public void setCategoriaId(Categoria categoriaId) {
		this.categoriaId = categoriaId;
	}

	
	public Empleado(){}
	
	
	public Empleado(int id_empleados,Departamento departamentoId, Categoria categoriaId){
		this.id_empleados = id_empleados;
		this.departamentoId = departamentoId;
		this.categoriaId = categoriaId;
	}
	
	
	public Empleado(int id_empleados, String codEmpleado, int salario, String fechaAlta, Departamento departamentoId,
			Categoria categoriaId) {
		super();
		this.id_empleados = id_empleados;
		this.codEmpleado = codEmpleado;
		this.salario = salario;
		this.fechaAlta = fechaAlta;
		this.departamentoId = departamentoId;
		this.categoriaId = categoriaId;
	}

    
    
    
}
