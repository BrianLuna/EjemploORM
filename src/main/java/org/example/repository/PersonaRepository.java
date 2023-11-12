package org.example.repository;

import org.example.domain.Persona;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class PersonaRepository {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void confirmarPersona(Persona nuevaPersona){
        session.beginTransaction();
        session.save(nuevaPersona);
        session.getTransaction().commit();
    }

    public void actualizarPersona(Persona persona) {
        session.beginTransaction();
        session.saveOrUpdate(persona);
        session.getTransaction().commit();
    }

    public void eliminarPersona(Persona persona) {
        session.beginTransaction();
        session.delete(persona);
        session.getTransaction().commit();
    }


    public List<Persona> obtenerTodasLasPersonas(){
        return session.createQuery("from Persona", Persona.class).list();
    }

    public List<Persona> obtenerPersonasPorDNI(Integer dni){
        return session
                .createQuery("from Persona where dni = :dni", Persona.class)
                .setParameter("dni", dni)
                .list();

    }

    public void eliminarPersonaPorDNI(Integer dni) {
        session.beginTransaction();
        session.createQuery("delete from Persona where dni = :dni")
                        .setParameter("dni", dni)
                                .executeUpdate();
        session.getTransaction().commit();
    }


    public void terminarConexion(){
        HibernateUtil.shutdown();
    }
}
