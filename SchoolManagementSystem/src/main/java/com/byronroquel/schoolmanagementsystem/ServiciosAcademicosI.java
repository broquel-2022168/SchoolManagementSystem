package com.byronroquel.schoolmanagementsystem;

/**
 *
 * @author LENOVO
 */
public interface ServiciosAcademicosI {
    void matricularEstudiante(Estudiante estudiante);
    void agregarCurso(Curso curso);
    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso);
    void desinscribirEstudianteCurso(int estudiante, int idCurso);
}
