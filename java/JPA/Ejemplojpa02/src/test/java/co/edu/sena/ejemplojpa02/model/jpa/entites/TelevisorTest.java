package co.edu.sena.ejemplojpa02.model.jpa.entites;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class TelevisorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1Insert(){
        Televisor t1 = new Televisor();
        t1.setMarca("samsung");
        t1.setSerial("123456");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("odpPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(t1);
        em.getTransaction().commit();
    }


}