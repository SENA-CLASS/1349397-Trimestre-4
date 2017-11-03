/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplojpa03netbeans.controller.dao.mysql;

import co.edu.sena.ejemplojpa03netbeans.controller.dao.ClienteDao;
import co.edu.sena.ejemplojpa03netbeans.controller.dao.TipoDocumentoDao;
import co.edu.sena.ejemplojpa03netbeans.controller.factory.ClienteFactory;
import co.edu.sena.ejemplojpa03netbeans.model.jpa.entities.Cliente;
import co.edu.sena.ejemplojpa03netbeans.model.jpa.entities.ClientePK;
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
public class ClienteDaoImplTest {

    private Cliente cliente;
    private ClientePK clientePK;
    
    public ClienteDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        
        cliente = new Cliente();
        cliente.setClientePK(new ClientePK("CC", "12345654321"));
        cliente.setPrimerNombre("juan");
        cliente.setSegundoNombre("david");
        cliente.setPrimerApellido("murcia");
        cliente.setSegundoApellido("misi");
        
        clientePK = new ClientePK("TI", "345345345");
        
        

    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1Insert() {
        ClienteDao dao = ClienteFactory.create(Cliente.class);
        dao.insert(cliente);
        Cliente clienteBaseDatos = (Cliente) dao.find(cliente.getClientePK());
        assertEquals(clienteBaseDatos, cliente);
    }
    
    @Test
    public void test2findpk(){
        ClienteDao dao = ClienteFactory.create(Cliente.class);
        Cliente cs =(Cliente)dao.find(cliente.getClientePK());
        assertEquals(cs, cliente);
    }
    
    @Test
    public void test3update(){
        // con este update no se puede cambiar la llave primaria
        ClienteDao dao = ClienteFactory.create(Cliente.class);
        cliente.setPrimerNombre("julian");
        dao.update(cliente);
        assertEquals(dao.find(cliente.getClientePK()), cliente);
    }
    
    @Test 
    public void test3update2PrimaryKey(){
        ClienteDao dao = ClienteFactory.create(Cliente.class);
        dao.updatePrimaryKey(clientePK, cliente.getClientePK());
        cliente.setClientePK(clientePK);
        assertEquals(dao.find(clientePK), cliente);
        
        
    
    }
    
    @Test
    public void test4Remove(){
        ClienteDao dao = ClienteFactory.create(Cliente.class);
        cliente.setClientePK(clientePK);
        dao.remove(cliente);
        assertEquals(dao.find(cliente.getClientePK()), null);
        
    }

}
