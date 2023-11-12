package org.example.repository;
import org.example.domain.Curso;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CursoRepository {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void confirmarCurso(Curso nuevoCurso){
        session.beginTransaction();
        session.save(nuevoCurso);
        session.getTransaction().commit();
    }

    public void actualizarCurso(Curso actualizarCurso) {
        session.beginTransaction();
        session.saveOrUpdate(actualizarCurso);
        session.getTransaction().commit();
    }

    public void eliminarCurso(Curso curso) {
        session.beginTransaction();
        session.delete(curso);
        session.getTransaction().commit();
    }

    public List<Curso> obtenerTodasLosCursos(){
        return session.createQuery("from Curso ", Curso.class).list();
    }

    public void terminarConexion(){
        HibernateUtil.shutdown();
    }
}
