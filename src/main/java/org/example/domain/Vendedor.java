package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Vendedor extends Profesion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidadDeVentas = 0;
    private Double comisionPorVenta = 0.0;

    public Vendedor() {
    }
    public Vendedor(Double salarioPorHora, Double comisionPorVenta) {
        super(salarioPorHora);
        this.comisionPorVenta = comisionPorVenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidadDeVentas() {
        return cantidadDeVentas;
    }

    public void setCantidadDeVentas(Integer cantidadDeVentas) {
        this.cantidadDeVentas = cantidadDeVentas;
    }

    public Double getComisionPorVenta() {
        return comisionPorVenta;
    }

    public void setComisionPorVenta(Double comisionPorVenta) {
        this.comisionPorVenta = comisionPorVenta;
    }



    public void vender(){
        this.cantidadDeVentas++;
    }


    @Override
    protected Double plusPorProfesion() {
        Double plus = this.comisionPorVenta * this.cantidadDeVentas;
        this.cantidadDeVentas = 0;
        return plus;
    }
}
