package com.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "personas")
public class Persona implements Serializable {

    private static final long serialVersionUID = 144585071807476496L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idpersonas;
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;
    @Column(name = "apellido1", length = 25)
    private String apellido1;
    @Column(name = "apellido2", length = 25)
    private String apellido2;
    @Column(name = "dni", length = 25)
    private String dni;
    @Column(name = "fechaNacimiento", length = 25)
    private String fechaNacimiento;
    

    
      // @JoinColumn(name= "idEmpleado", referencedColumnName ="idempleados")
     // @OneToOne
    // private Empleado empleadoId;

    
    public int getIdpersonas() {
		return idpersonas;
	}


	public void setIdpersonas(int idpersonas) {
		this.idpersonas = idpersonas;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido1() {
		return apellido1;
	}


	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	public String getApellido2() {
		return apellido2;
	}


	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Persona() {
    }

   // -----------------constructor sin primary key y foreingkey
	
    public Persona( String nombre, String apellido1, String apellido2, String dni,
			String fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	}

    
    //---------------- constructor con todos los atributos

//	public Persona(int idpersonas, String nombre, String apellido1, String apellido2, String dni,
//			String fechaNacimiento, int idempleado) {
//		super();
//		this.idpersonas = idpersonas;
//		this.nombre = nombre;
//		this.apellido1 = apellido1;
//		this.apellido2 = apellido2;
//		this.dni = dni;
//		this.fechaNacimiento = fechaNacimiento;
//		this.idempleado = idempleado;
//	}

    
    
  //---------------- constructor sin idpersona
//    public Persona( String nombre, String apellido1, String apellido2, String dni,
//			String fechaNacimiento, int idempleado) {
//		super();
//		this.nombre = nombre;
//		this.apellido1 = apellido1;
//		this.apellido2 = apellido2;
//		this.dni = dni;
//		this.fechaNacimiento = fechaNacimiento;
//		this.idempleado=idempleado;
//	}

    
    
}