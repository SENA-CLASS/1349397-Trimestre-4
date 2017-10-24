package co.edu.sena.ejemplojpa02.model.jpa.entites.llavecompuesta;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class ClienteTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1InsertCliente(){
        Cliente2 c1 = new Cliente2();
        c1.setTipoDocumento("CC");
        c1.setNumeroDocumento("12345");
        c1.setNombres("juan");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("odpPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(c1);
        em.getTransaction().commit();


    }
}