package com.byronroquel.schoolmanagementsystem;
/**
 *
 * @author LENOVO
 */
public class Estudiante extends Persona{
    private int id;
    private String fechaDeNacimiento;
    public String estado;

    public Estudiante(int id, String fechaDeNacimiento, String estado, String nombre, String apellido) {
        super(nombre, apellido);
        this.id = id;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.estado = estado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    
    public String getEstado(){
        return estado;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }
     
}
