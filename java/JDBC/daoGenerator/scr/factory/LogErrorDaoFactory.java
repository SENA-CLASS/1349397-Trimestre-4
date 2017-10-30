/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.model.dao.factory;

import java.sql.Connection;
import co.edu.sena.model.dao.dao.*;
import co.edu.sena.model.dao.jdbc.*;

public class LogErrorDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return LogErrorDao
	 */
	public static LogErrorDao create()
	{
		return new LogErrorDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return LogErrorDao
	 */
	public static LogErrorDao create(Connection conn)
	{
		return new LogErrorDaoImpl( conn );
	}

}