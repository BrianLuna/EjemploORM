package org.example;

import org.example.domain.*;
import org.example.repository.ClubRepository;
import org.example.repository.CursoRepository;
import org.example.repository.PersonaRepository;
import org.example.repository.ProfesionRepository;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PersonaRepository repoPersona = new PersonaRepository();
        ProfesionRepository repoProfesion = new ProfesionRepository();
        ClubRepository repoClub = new ClubRepository();
        CursoRepository repoCurso = new CursoRepository();

        Persona persona = new Persona("Maria", "Antonieta", 13265151, Pais.ARGENTINA, LocalDate.of(1950, 12, 1));
        Persona persona2 = new Persona("asd", "asd", 345, Pais.AUSTRALIA, LocalDate.of(1970, 10, 25));
        Vendedor vendedor = new Vendedor(5000.0, 100.0);
        Ingeniero ingeniero = new Ingeniero(15000.0, 3000.0);
        repoProfesion.confirmarProfesion(vendedor); //
        repoProfesion.confirmarProfesion(ingeniero); //
        persona.setProfesion(vendedor);
        persona2.setProfesion(ingeniero);
        repoPersona.confirmarPersona(persona); //
        repoPersona.confirmarPersona(persona2); //
        persona.setNombre("Juana");
        persona.agregarHijo(persona2);
        repoPersona.actualizarPersona(persona); //
        persona.trabajar(10);
        vendedor.vender();
        vendedor.vender();
        vendedor.vender();
        persona.cobrar();
        Club club = new Club("Primer Club");
        repoClub.confirmarClub(club);
        persona.setClub(club);
        persona2.setClub(club);
        Curso curso1 = new Curso("Argentina Programa 1");
        Curso curso2 = new Curso("Argentina Programa 2");
        Curso curso3 = new Curso("Argentina Programa 3");
        persona.agregarCurso(curso1);
        persona.agregarCurso(curso2);
        persona.agregarCurso(curso3);
        persona2.agregarCurso(curso1);
        persona2.agregarCurso(curso2);
        repoCurso.confirmarCurso(curso1);
        repoCurso.confirmarCurso(curso2);
        repoCurso.confirmarCurso(curso3);
        repoProfesion.actualizarProfesion(vendedor); //
        repoPersona.actualizarPersona(persona); //
        repoPersona.actualizarPersona(persona2); //
        repoPersona.eliminarPersona(persona);


        repoCurso.terminarConexion();
        repoClub.terminarConexion();
        repoProfesion.terminarConexion();
        repoPersona.terminarConexion();
    }
}