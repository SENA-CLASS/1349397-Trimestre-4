/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package co.edu.sena.model.dao.dto;

import co.edu.sena.model.dao.dao.*;
import co.edu.sena.model.dao.factory.*;
import co.edu.sena.model.dao.exceptions.*;
import java.io.Serializable;
import java.util.*;

public class RaeHasTrimestre implements Serializable
{
	/** 
	 * This attribute maps to the column rae_codigo in the rae_has_trimestre table.
	 */
	protected String raeCodigo;

	/** 
	 * This attribute maps to the column competencia_codigo in the rae_has_trimestre table.
	 */
	protected String competenciaCodigo;

	/** 
	 * This attribute maps to the column programa_codigo_version in the rae_has_trimestre table.
	 */
	protected String programaCodigoVersion;

	/** 
	 * This attribute maps to the column id_trimestre in the rae_has_trimestre table.
	 */
	protected String idTrimestre;

	/** 
	 * This attribute maps to the column jornada in the rae_has_trimestre table.
	 */
	protected String jornada;

	/**
	 * Method 'RaeHasTrimestre'
	 * 
	 */
	public RaeHasTrimestre()
	{
	}

	/**
	 * Method 'getRaeCodigo'
	 * 
	 * @return String
	 */
	public String getRaeCodigo()
	{
		return raeCodigo;
	}

	/**
	 * Method 'setRaeCodigo'
	 * 
	 * @param raeCodigo
	 */
	public void setRaeCodigo(String raeCodigo)
	{
		this.raeCodigo = raeCodigo;
	}

	/**
	 * Method 'getCompetenciaCodigo'
	 * 
	 * @return String
	 */
	public String getCompetenciaCodigo()
	{
		return competenciaCodigo;
	}

	/**
	 * Method 'setCompetenciaCodigo'
	 * 
	 * @param competenciaCodigo
	 */
	public void setCompetenciaCodigo(String competenciaCodigo)
	{
		this.competenciaCodigo = competenciaCodigo;
	}

	/**
	 * Method 'getProgramaCodigoVersion'
	 * 
	 * @return String
	 */
	public String getProgramaCodigoVersion()
	{
		return programaCodigoVersion;
	}

	/**
	 * Method 'setProgramaCodigoVersion'
	 * 
	 * @param programaCodigoVersion
	 */
	public void setProgramaCodigoVersion(String programaCodigoVersion)
	{
		this.programaCodigoVersion = programaCodigoVersion;
	}

	/**
	 * Method 'getIdTrimestre'
	 * 
	 * @return String
	 */
	public String getIdTrimestre()
	{
		return idTrimestre;
	}

	/**
	 * Method 'setIdTrimestre'
	 * 
	 * @param idTrimestre
	 */
	public void setIdTrimestre(String idTrimestre)
	{
		this.idTrimestre = idTrimestre;
	}

	/**
	 * Method 'getJornada'
	 * 
	 * @return String
	 */
	public String getJornada()
	{
		return jornada;
	}

	/**
	 * Method 'setJornada'
	 * 
	 * @param jornada
	 */
	public void setJornada(String jornada)
	{
		this.jornada = jornada;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof RaeHasTrimestre)) {
			return false;
		}
		
		final RaeHasTrimestre _cast = (RaeHasTrimestre) _other;
		if (raeCodigo == null ? _cast.raeCodigo != raeCodigo : !raeCodigo.equals( _cast.raeCodigo )) {
			return false;
		}
		
		if (competenciaCodigo == null ? _cast.competenciaCodigo != competenciaCodigo : !competenciaCodigo.equals( _cast.competenciaCodigo )) {
			return false;
		}
		
		if (programaCodigoVersion == null ? _cast.programaCodigoVersion != programaCodigoVersion : !programaCodigoVersion.equals( _cast.programaCodigoVersion )) {
			return false;
		}
		
		if (idTrimestre == null ? _cast.idTrimestre != idTrimestre : !idTrimestre.equals( _cast.idTrimestre )) {
			return false;
		}
		
		if (jornada == null ? _cast.jornada != jornada : !jornada.equals( _cast.jornada )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		if (raeCodigo != null) {
			_hashCode = 29 * _hashCode + raeCodigo.hashCode();
		}
		
		if (competenciaCodigo != null) {
			_hashCode = 29 * _hashCode + competenciaCodigo.hashCode();
		}
		
		if (programaCodigoVersion != null) {
			_hashCode = 29 * _hashCode + programaCodigoVersion.hashCode();
		}
		
		if (idTrimestre != null) {
			_hashCode = 29 * _hashCode + idTrimestre.hashCode();
		}
		
		if (jornada != null) {
			_hashCode = 29 * _hashCode + jornada.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return RaeHasTrimestrePk
	 */
	public RaeHasTrimestrePk createPk()
	{
		return new RaeHasTrimestrePk(raeCodigo, competenciaCodigo, programaCodigoVersion, idTrimestre, jornada);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "co.edu.sena.model.dao.dto.RaeHasTrimestre: " );
		ret.append( "raeCodigo=" + raeCodigo );
		ret.append( ", competenciaCodigo=" + competenciaCodigo );
		ret.append( ", programaCodigoVersion=" + programaCodigoVersion );
		ret.append( ", idTrimestre=" + idTrimestre );
		ret.append( ", jornada=" + jornada );
		return ret.toString();
	}

}