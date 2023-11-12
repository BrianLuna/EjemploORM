package org.example.repository;

import org.example.domain.Persona;
import org.example.domain.Profesion;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProfesionRepository {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void confirmarProfesion(Profesion nuevaProfesion){
        session.beginTransaction();
        session.save(nuevaProfesion);
        session.getTransaction().commit();
    }

    public void actualizarProfesion(Profesion profesion) {
        session.beginTransaction();
        session.saveOrUpdate(profesion);
        session.getTransaction().commit();
    }

    public void eliminarProfesion(Profesion profesion) {
        session.beginTransaction();
        session.delete(profesion);
        session.getTransaction().commit();
    }


    public List<Profesion> obtenerTodasLasProfesiones(){
        return session.createQuery("from Profesion ", Profesion.class).list();
    }

    public void terminarConexion(){
        HibernateUtil.shutdown();
    }

}
