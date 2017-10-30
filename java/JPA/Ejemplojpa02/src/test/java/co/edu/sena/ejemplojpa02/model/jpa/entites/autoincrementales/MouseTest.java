package co.edu.sena.ejemplojpa02.model.jpa.entites.autoincrementales;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class MouseTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void insertMouse(){


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("odpPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        for(int i= 1;i<=100000000;i++) {

            em.getTransaction().begin();
            Mouse m = new Mouse();
            m.setMarca("razor"+i);

            em.persist(m);
            em.getTransaction().commit();

        }



    }
}