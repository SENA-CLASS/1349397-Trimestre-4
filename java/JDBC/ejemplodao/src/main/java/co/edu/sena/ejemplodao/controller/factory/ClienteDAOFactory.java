package co.edu.sena.ejemplodao.controller.factory;

import co.edu.sena.ejemplodao.controller.dao.ClienteDAO;
import co.edu.sena.ejemplodao.controller.dao.mysql.MysqlClienteDAO;

public class ClienteDAOFactory {

    public static ClienteDAO create(){
        return new MysqlClienteDAO();

    }

}
