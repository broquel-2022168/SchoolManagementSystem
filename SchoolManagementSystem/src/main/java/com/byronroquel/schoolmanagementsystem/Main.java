package com.byronroquel.schoolmanagementsystem;

public class Main {
    public static void main(String[] args) {
        // Crear estudiantes y cursos
        Estudiante estudiante1 = new Estudiante(1, "Juan", "Pérez", "2000-01-01", "matriculado");
        Estudiante estudiante2 = new Estudiante(2, "María", "González", "1999-02-02", "matriculado");

        Curso curso1 = new Curso(1, "Matemáticas", "Curso de matemáticas básicas", 3, "1.0");

        // Crear gestor académico
        GestorAcademico gestor = new GestorAcademico();

        // Probar métodos
        gestor.matricularEstudiante(estudiante1);
        gestor.agregarCurso(curso1);
        gestor.inscribirEstudianteCurso(estudiante1, 1);
    }
}
