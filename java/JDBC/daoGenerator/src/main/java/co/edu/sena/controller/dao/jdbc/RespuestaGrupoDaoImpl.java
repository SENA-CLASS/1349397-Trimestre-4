/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.controller.dao.jdbc;

import co.edu.sena.controller.dao.*;
import co.edu.sena.controller.factory.*;
import java.util.Date;
import co.edu.sena.model.dao.dto.*;
import co.edu.sena.controller.dao.exceptions.*;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class RespuestaGrupoDaoImpl extends AbstractDAO implements RespuestaGrupoDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT ficha, grupo_codigo, lista_chequeo, id_item, valoracion_valor, fecha FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( ficha, grupo_codigo, lista_chequeo, id_item, valoracion_valor, fecha ) VALUES ( ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET ficha = ?, grupo_codigo = ?, lista_chequeo = ?, id_item = ?, valoracion_valor = ?, fecha = ? WHERE ficha = ? AND grupo_codigo = ? AND lista_chequeo = ? AND id_item = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE ficha = ? AND grupo_codigo = ? AND lista_chequeo = ? AND id_item = ?";

	/** 
	 * Index of column ficha
	 */
	protected static final int COLUMN_FICHA = 1;

	/** 
	 * Index of column grupo_codigo
	 */
	protected static final int COLUMN_GRUPO_CODIGO = 2;

	/** 
	 * Index of column lista_chequeo
	 */
	protected static final int COLUMN_LISTA_CHEQUEO = 3;

	/** 
	 * Index of column id_item
	 */
	protected static final int COLUMN_ID_ITEM = 4;

	/** 
	 * Index of column valoracion_valor
	 */
	protected static final int COLUMN_VALORACION_VALOR = 5;

	/** 
	 * Index of column fecha
	 */
	protected static final int COLUMN_FECHA = 6;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 6;

	/** 
	 * Index of primary-key column ficha
	 */
	protected static final int PK_COLUMN_FICHA = 1;

	/** 
	 * Index of primary-key column grupo_codigo
	 */
	protected static final int PK_COLUMN_GRUPO_CODIGO = 2;

	/** 
	 * Index of primary-key column lista_chequeo
	 */
	protected static final int PK_COLUMN_LISTA_CHEQUEO = 3;

	/** 
	 * Index of primary-key column id_item
	 */
	protected static final int PK_COLUMN_ID_ITEM = 4;

	/** 
	 * Inserts a new row in the respuesta_grupo table.
	 */
	public RespuestaGrupoPk insert(RespuestaGrupo dto) throws RespuestaGrupoDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_INSERT );
			int index = 1;
			stmt.setString( index++, dto.getFicha() );
			stmt.setInt( index++, dto.getGrupoCodigo() );
			stmt.setString( index++, dto.getListaChequeo() );
			stmt.setInt( index++, dto.getIdItem() );
			stmt.setString( index++, dto.getValoracionValor() );
			stmt.setTimestamp(index++, dto.getFecha()==null ? null : new java.sql.Timestamp( dto.getFecha().getTime() ) );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new RespuestaGrupoDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the respuesta_grupo table.
	 */
	public void update(RespuestaGrupoPk pk, RespuestaGrupo dto) throws RespuestaGrupoDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + dto );
			stmt = conn.prepareStatement( SQL_UPDATE );
			int index=1;
			stmt.setString( index++, dto.getFicha() );
			stmt.setInt( index++, dto.getGrupoCodigo() );
			stmt.setString( index++, dto.getListaChequeo() );
			stmt.setInt( index++, dto.getIdItem() );
			stmt.setString( index++, dto.getValoracionValor() );
			stmt.setTimestamp(index++, dto.getFecha()==null ? null : new java.sql.Timestamp( dto.getFecha().getTime() ) );
			stmt.setString( 7, pk.getFicha() );
			stmt.setInt( 8, pk.getGrupoCodigo() );
			stmt.setString( 9, pk.getListaChequeo() );
			stmt.setInt( 10, pk.getIdItem() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new RespuestaGrupoDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the respuesta_grupo table.
	 */
	public void delete(RespuestaGrupoPk pk) throws RespuestaGrupoDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_DELETE + " with PK: " + pk );
			stmt = conn.prepareStatement( SQL_DELETE );
			stmt.setString( 1, pk.getFicha() );
			stmt.setInt( 2, pk.getGrupoCodigo() );
			stmt.setString( 3, pk.getListaChequeo() );
			stmt.setInt( 4, pk.getIdItem() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new RespuestaGrupoDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the respuesta_grupo table that matches the specified primary-key value.
	 */
	public RespuestaGrupo findByPrimaryKey(RespuestaGrupoPk pk) throws RespuestaGrupoDaoException
	{
		return findByPrimaryKey( pk.getFicha(), pk.getGrupoCodigo(), pk.getListaChequeo(), pk.getIdItem() );
	}

	/** 
	 * Returns all rows from the respuesta_grupo table that match the criteria 'ficha = :ficha AND grupo_codigo = :grupoCodigo AND lista_chequeo = :listaChequeo AND id_item = :idItem'.
	 */
	public RespuestaGrupo findByPrimaryKey(String ficha, int grupoCodigo, String listaChequeo, int idItem) throws RespuestaGrupoDaoException
	{
		RespuestaGrupo ret[] = findByDynamicSelect( SQL_SELECT + " WHERE ficha = ? AND grupo_codigo = ? AND lista_chequeo = ? AND id_item = ?", new Object[] { ficha,  new Integer(grupoCodigo), listaChequeo,  new Integer(idItem) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the respuesta_grupo table that match the criteria ''.
	 */
	public RespuestaGrupo[] findAll() throws RespuestaGrupoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY ficha, grupo_codigo, lista_chequeo, id_item", null );
	}

	/** 
	 * Returns all rows from the respuesta_grupo table that match the criteria 'ficha = :ficha AND grupo_codigo = :grupoCodigo'.
	 */
	public RespuestaGrupo[] findByGrupoProyecto(String ficha, int grupoCodigo) throws RespuestaGrupoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ficha = ? AND grupo_codigo = ?", new Object[] { ficha,  new Integer(grupoCodigo) } );
	}

	/** 
	 * Returns all rows from the respuesta_grupo table that match the criteria 'lista_chequeo = :listaChequeo AND id_item = :idItem'.
	 */
	public RespuestaGrupo[] findByItemChecker(String listaChequeo, int idItem) throws RespuestaGrupoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE lista_chequeo = ? AND id_item = ?", new Object[] { listaChequeo,  new Integer(idItem) } );
	}

	/** 
	 * Returns all rows from the respuesta_grupo table that match the criteria 'valoracion_valor = :valoracionValor'.
	 */
	public RespuestaGrupo[] findByValoracion(String valoracionValor) throws RespuestaGrupoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE valoracion_valor = ?", new Object[] { valoracionValor } );
	}

	/** 
	 * Returns all rows from the respuesta_grupo table that match the criteria 'ficha = :ficha'.
	 */
	public RespuestaGrupo[] findWhereFichaEquals(String ficha) throws RespuestaGrupoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ficha = ? ORDER BY ficha", new Object[] { ficha } );
	}

	/** 
	 * Returns all rows from the respuesta_grupo table that match the criteria 'grupo_codigo = :grupoCodigo'.
	 */
	public RespuestaGrupo[] findWhereGrupoCodigoEquals(int grupoCodigo) throws RespuestaGrupoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE grupo_codigo = ? ORDER BY grupo_codigo", new Object[] {  new Integer(grupoCodigo) } );
	}

	/** 
	 * Returns all rows from the respuesta_grupo table that match the criteria 'lista_chequeo = :listaChequeo'.
	 */
	public RespuestaGrupo[] findWhereListaChequeoEquals(String listaChequeo) throws RespuestaGrupoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE lista_chequeo = ? ORDER BY lista_chequeo", new Object[] { listaChequeo } );
	}

	/** 
	 * Returns all rows from the respuesta_grupo table that match the criteria 'id_item = :idItem'.
	 */
	public RespuestaGrupo[] findWhereIdItemEquals(int idItem) throws RespuestaGrupoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE id_item = ? ORDER BY id_item", new Object[] {  new Integer(idItem) } );
	}

	/** 
	 * Returns all rows from the respuesta_grupo table that match the criteria 'valoracion_valor = :valoracionValor'.
	 */
	public RespuestaGrupo[] findWhereValoracionValorEquals(String valoracionValor) throws RespuestaGrupoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE valoracion_valor = ? ORDER BY valoracion_valor", new Object[] { valoracionValor } );
	}

	/** 
	 * Returns all rows from the respuesta_grupo table that match the criteria 'fecha = :fecha'.
	 */
	public RespuestaGrupo[] findWhereFechaEquals(Date fecha) throws RespuestaGrupoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE fecha = ? ORDER BY fecha", new Object[] { fecha==null ? null : new java.sql.Timestamp( fecha.getTime() ) } );
	}

	/**
	 * Method 'RespuestaGrupoDaoImpl'
	 * 
	 */
	public RespuestaGrupoDaoImpl()
	{
	}

	/**
	 * Method 'RespuestaGrupoDaoImpl'
	 * 
	 * @param userConn
	 */
	public RespuestaGrupoDaoImpl(final Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "observador_de_proyectos.respuesta_grupo";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected RespuestaGrupo fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			RespuestaGrupo dto = new RespuestaGrupo();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected RespuestaGrupo[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			RespuestaGrupo dto = new RespuestaGrupo();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		RespuestaGrupo ret[] = new RespuestaGrupo[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(RespuestaGrupo dto, ResultSet rs) throws SQLException
	{
		dto.setFicha( rs.getString( COLUMN_FICHA ) );
		dto.setGrupoCodigo( rs.getInt( COLUMN_GRUPO_CODIGO ) );
		dto.setListaChequeo( rs.getString( COLUMN_LISTA_CHEQUEO ) );
		dto.setIdItem( rs.getInt( COLUMN_ID_ITEM ) );
		dto.setValoracionValor( rs.getString( COLUMN_VALORACION_VALOR ) );
		dto.setFecha( rs.getTimestamp(COLUMN_FECHA ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(RespuestaGrupo dto)
	{
	}

	/** 
	 * Returns all rows from the respuesta_grupo table that match the specified arbitrary SQL statement
	 */
	public RespuestaGrupo[] findByDynamicSelect(String sql, Object[] sqlParams) throws RespuestaGrupoDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new RespuestaGrupoDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the respuesta_grupo table that match the specified arbitrary SQL statement
	 */
	public RespuestaGrupo[] findByDynamicWhere(String sql, Object[] sqlParams) throws RespuestaGrupoDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new RespuestaGrupoDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

}