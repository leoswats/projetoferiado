package br.com.isidrocorp.projetoferiado.dao;



import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.isidrocorp.projetoferiado.model.Agencia;
import br.com.isidrocorp.projetoferiado.model.Feriado;

public interface FeriadoDAO extends CrudRepository<Feriado, Integer> {
	
	public ArrayList<Feriado> findByAgencia(Agencia agencia);
	
	public ArrayList<Feriado> findByOrderByDataInicio();
	public ArrayList<Feriado> findByAgenciaOrderByDataInicio(Agencia agencia);

}
