package org.example.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Profesion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer horasTrabajadas = 0;

    private Double salarioPorHora = 0.0;

    public Profesion(Double salarioPorHora) {
        this.salarioPorHora = salarioPorHora;
    }

    public Integer getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(Integer horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public Double getSalarioPorHora() {
        return salarioPorHora;
    }

    public void setSalarioPorHora(Double salarioPorHora) {
        this.salarioPorHora = salarioPorHora;
    }

    public Profesion() {
    }

    public Double calcularSueldo(){
        Double sueldo = this.horasTrabajadas * this.salarioPorHora + this.plusPorProfesion();
        this.horasTrabajadas = 0;
        return sueldo;
    }

    protected abstract Double plusPorProfesion();

    public void agregarHorasTrabajadas(Integer horas) {
        this.horasTrabajadas += horas;
    }
}
