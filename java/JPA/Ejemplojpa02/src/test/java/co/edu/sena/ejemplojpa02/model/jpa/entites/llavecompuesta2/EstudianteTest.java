package co.edu.sena.ejemplojpa02.model.jpa.entites.llavecompuesta2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class EstudianteTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1Insert(){
        EstudiantePk pk = new EstudiantePk();
        pk.setTipoDocumento("CC");
        pk.setNumeroDocumento("123456");
        Estudiante e1 = new Estudiante();
        e1.setEstudiantePk(pk);
        e1.setNombres("pedrito");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("odpPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(e1);
        em.getTransaction().commit();

    }

}