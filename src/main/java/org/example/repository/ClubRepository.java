package org.example.repository;

import org.example.domain.Club;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ClubRepository {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void confirmarClub(Club nuevoClub){
        session.beginTransaction();
        session.save(nuevoClub);
        session.getTransaction().commit();
    }

    public void actualizarClub(Club actualizarClub) {
        session.beginTransaction();
        session.saveOrUpdate(actualizarClub);
        session.getTransaction().commit();
    }

    public void eliminarClub(Club club) {
        session.beginTransaction();
        session.delete(club);
        session.getTransaction().commit();
    }

    public List<Club> obtenerTodasLosClubes(){
        return session.createQuery("from Club ", Club.class).list();
    }

    public void terminarConexion(){
        HibernateUtil.shutdown();
    }
}
