package org.example.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    @Column(unique = true)
    private Integer dni;
    @Enumerated(EnumType.STRING)
    public Pais paisDeNacimiento;
    private LocalDate fechaDeNacimiento;
    @OneToMany (cascade = CascadeType.ALL)
    private List<Persona> hijos = new ArrayList<>();
    private Double ahorros = 0.0;
    @OneToOne (cascade = CascadeType.ALL)
    private Profesion profesion;
    @ManyToOne
    private Club club;
    @ManyToMany
    private List<Curso> cursos = new ArrayList();

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }


    public List<Persona> getHijos() {
        return hijos;
    }

    public void setHijos(List<Persona> hijos) {
        this.hijos = hijos;
    }


    public Persona() {
    }

    ;

    public Persona(String nombre, String apellido, Integer dni, Pais paisDeNacimiento, LocalDate fechaDeNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.paisDeNacimiento = paisDeNacimiento;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getDni() {
        return dni;
    }

    public Double getAhorros() {
        return ahorros;
    }

    public void setAhorros(Double ahorros) {
        this.ahorros = ahorros;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Pais getPaisDeNacimiento() {
        return paisDeNacimiento;
    }

    public void setPaisDeNacimiento(Pais paisDeNacimiento) {
        this.paisDeNacimiento = paisDeNacimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public void agregarHijo(Persona nuevoHijo) {
        this.hijos.add(nuevoHijo);
    }


    public Profesion getProfesion() {
        if(this.profesion == null){
            throw new RuntimeException("La persona no tiene profesión");
        } else {
            return this.profesion;
        }
    }

    public void trabajar(Integer horas){
        this.profesion.agregarHorasTrabajadas(horas);
    }

    public void cobrar(){
        this.ahorros += this.profesion.calcularSueldo();
    }

    public void agregarCurso(Curso nuevoCurso){
        this.cursos.add(nuevoCurso);
    }

    @Override
    public String toString() {

        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", paisDeNacimiento=" + paisDeNacimiento +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", hijos=" + hijos +
                '}';
    }


}
