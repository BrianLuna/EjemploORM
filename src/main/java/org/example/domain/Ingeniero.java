package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Ingeniero extends Profesion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double bonoMensual = 0.0;

    public Ingeniero() {
    }

    public Ingeniero(Double salarioPorHora, Double bonoMensual) {
        super(salarioPorHora);
        this.bonoMensual = bonoMensual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBonoMensual() {
        return bonoMensual;
    }

    public void setBonoMensual(Double bonoMensual) {
        this.bonoMensual = bonoMensual;
    }

    @Override
    protected Double plusPorProfesion() {
        return this.bonoMensual;
    }
}
