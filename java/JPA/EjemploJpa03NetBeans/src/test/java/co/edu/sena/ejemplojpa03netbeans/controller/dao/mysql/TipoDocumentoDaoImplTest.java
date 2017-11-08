/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplojpa03netbeans.controller.dao.mysql;

import co.edu.sena.ejemplojpa03netbeans.controller.dao.TipoDocumentoDao;
import co.edu.sena.ejemplojpa03netbeans.controller.factory.TipoDocumentoFactory;
import co.edu.sena.ejemplojpa03netbeans.model.jpa.entities.TipoDocumento;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Enrique
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TipoDocumentoDaoImplTest {

    private TipoDocumento td;

    public TipoDocumentoDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        td = new TipoDocumento();
        td.setDocumento("NNNN");
        td.setDescripcion("NO lo conosco");
        td.setEstado(Boolean.TRUE);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        System.out.println("prueba de tipo de documento metodo insert");
        TipoDocumentoDao dao = TipoDocumentoFactory.create(TipoDocumento.class);
        if (dao.find(td.getDocumento()) == null) {
            dao.insert(td);
        } 
        assertEquals(dao.find(td.getDocumento()), td);
    }

    @Test
    public void test2find() {
        System.out.println("prueba de tipo de documento metodo find por llave primaria");
        TipoDocumentoDao dao = TipoDocumentoFactory.create(TipoDocumento.class);
        TipoDocumento tipoDocumentoConsultado = (TipoDocumento) dao.find(td.getDocumento());
        assertEquals(tipoDocumentoConsultado, td);
    }

    @Test
    public void test3update() {
        System.out.println("prueba de tipo de documento metodo update po llave primaria");
        TipoDocumentoDao dao = TipoDocumentoFactory.create(TipoDocumento.class);
        td.setDescripcion("si lo conozco");
        td.setEstado(Boolean.FALSE);
        dao.update(td);
        assertEquals(dao.find(td.getDocumento()), td);
    }
    
    @Test
    public void test3vUpdatePrimaryKey(){
        TipoDocumentoDao dao = TipoDocumentoFactory.create(TipoDocumento.class);
        int resultado= dao.updatePrimaryKey("JJJJ", td.getDocumento());
        assertEquals(resultado, 1);
    
    }

    @Test
    public void test4delete() {
        System.out.println("prueba de tipo de documento metodo delete para la llave");
        TipoDocumentoDao dao = TipoDocumentoFactory.create(TipoDocumento.class);
        td.setDocumento("JJJJ");
        dao.remove(td);
        assertEquals(dao.find(td.getDocumento()), null);

    }

    @Test
    public void test5FindAll() {
        System.out.println("prueba de tipo de documento metodo findall");
        TipoDocumentoDao dao = TipoDocumentoFactory.create(TipoDocumento.class);
        List<TipoDocumento> lista = dao.findAll();
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void test6FindDescripcion() {
        System.out.println("prueba de metodo findDescripcion del dao TipoDocumento");
        TipoDocumentoDao dao = TipoDocumentoFactory.create(TipoDocumento.class);
        List<TipoDocumento> lista = dao.findByDescripcion("Cédula de Ciudadanía");
        assertTrue(!lista.isEmpty());
        for (TipoDocumento tipoDocumento : lista) {
            assertEquals(tipoDocumento.getDescripcion(), "Cédula de Ciudadanía");
        }
    }
    
    @Test
    public void test6FindEstado() {
        System.out.println("prueba del metodo findEstado del dao TipoDocumentoDao");
        TipoDocumentoDao dao = TipoDocumentoFactory.create(TipoDocumento.class);
        List<TipoDocumento> lista = dao.findByEstado(true);
        assertTrue(!lista.isEmpty());
        for (TipoDocumento tipoDocumento : lista) {
            assertEquals(tipoDocumento.getEstado(), true);
        }
    }

    
    @Test
    public void test6FindLikeDescripcion() {
        System.out.println("prueba del metodo findLikeDescripcion del dao TipoDocumentoDao");
        TipoDocumentoDao dao = TipoDocumentoFactory.create(TipoDocumento.class);
        List<TipoDocumento> lista = dao.findByLikeDescripcion("%iden%");
        assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void test6FindLikeDocumento() {
        TipoDocumentoDao dao = TipoDocumentoFactory.create(TipoDocumento.class);
        List<TipoDocumento> lista = dao.findByLikeDocumento("C%");
        assertTrue(!lista.isEmpty());
    }
    
    @Test
    public void test6FindLikeEstado() {
        TipoDocumentoDao dao = TipoDocumentoFactory.create(TipoDocumento.class);
        List<TipoDocumento> lista = dao.findByLikeEstado("%1%");
        assertTrue(!lista.isEmpty());
    }
    
    
   
}
