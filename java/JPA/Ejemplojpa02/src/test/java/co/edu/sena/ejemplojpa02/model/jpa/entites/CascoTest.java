package co.edu.sena.ejemplojpa02.model.jpa.entites;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class CascoTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test2InsertCasco(){
        Casco  c2 = new Casco();
        c2.setMarca("escoprion");


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("odpPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(c2);
        em.getTransaction().commit();
    }
}