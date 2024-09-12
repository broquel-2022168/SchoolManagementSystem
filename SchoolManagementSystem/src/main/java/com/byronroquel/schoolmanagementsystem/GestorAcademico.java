package com.byronroquel.schoolmanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class GestorAcademico implements ServiciosAcademicosI{
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<Curso> cursos = new ArrayList<>();
    private HashMap <Integer, ArrayList<Estudiante>> estudiantePorCurso = new HashMap<>();
    
    @Override
    public void matricularEstudiante(Estudiante estudiante){
        for (Estudiante e : estudiantes){
            if(e.getId() == estudiante.getId()){
                System.out.println("El estudiante con ID "+ estudiante.getId() +"ya está matriculado");
                return;
            }
        }
        estudiantes.add(estudiante);
        System.out.println("El estudiante se ha matriuclado "+ estudiante.getNombre() + estudiante.getApellido());
        
    }
    
    @Override
    public void agregarCurso(Curso curso){
        for (Curso c : cursos){
            if(c.getId() == curso.getId()){
                System.out.println("El curso con ID: "+curso.getId()+" Ya existe");
                return;
            }
        }
        cursos.add(curso);
        System.out.println("El curso "+curso.getNombre()+" se ha agregado");
    }
    
    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) {
        Curso curso = null;
        for (Curso c : cursos){
            if(c.getId() == idCurso){
                curso = c;
                break;
            }
        }
        if (curso == null){
            System.out.println("Este curso no existe");
            return;
        }
        
        ArrayList<Estudiante> estudiantesInscritos = estudiantePorCurso.getOrDefault(idCurso, new ArrayList<>()); 
        for (Estudiante e : estudiantesInscritos){
            if(e.getId() == estudiante.getId()){
                try {
                    throw new EstudianteYaInscritoException("El estudiante ya se ha inscrito");
                } catch (EstudianteYaInscritoException ex) {
                    Logger.getLogger(GestorAcademico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        estudiantesInscritos.add(estudiante);
        estudiantePorCurso.put(idCurso, estudiantesInscritos);
        System.out.println("Estudiante inscrito en el curso: "+curso.getNombre());
    }
    
    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso){
        if(!estudiantePorCurso.containsKey(idCurso)){
            System.out.println("El curso con ID: "+idCurso +"No existe");
            return;
        }
        ArrayList<Estudiante> estudiantesInscritos = estudiantePorCurso.get(idCurso);
        Estudiante estudianteAEliminar = null;
        for(Estudiante e: estudiantesInscritos){
            if (e.getId() == idEstudiante){
                estudianteAEliminar = e;
                break;
            }
        }
        
        if(estudianteAEliminar == null){
            try {
                throw new EstudianteNoInscritoEnCursoException("El estudainte no está inscrito en el curso");
            } catch (EstudianteNoInscritoEnCursoException ex) {
                Logger.getLogger(GestorAcademico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        estudiantesInscritos.remove(estudianteAEliminar);
        System.out.println("Estudiante desinscrito del curso con ID: "+idCurso);
    }
    
}
