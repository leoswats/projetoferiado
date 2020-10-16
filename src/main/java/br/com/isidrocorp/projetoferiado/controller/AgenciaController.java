package br.com.isidrocorp.projetoferiado.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.projetoferiado.dao.AgenciaDAO;
import br.com.isidrocorp.projetoferiado.model.Agencia;

@CrossOrigin("*")
@RestController
public class AgenciaController {
	/*  O que faz o Autowired? Tecnicamente ele faz uma Injeção de Dependências
	 *  A injeção de dependência é basicamente eu (programador) delegar a instanciação
	 *  (new) do objeto para a Máquina Virtual Java. Eu apenas preciso declará-la com
	 *  esta anotação.
	 *  Mas onde está a implementação? (ou seja, a classe que foi declarada como
	 *  public class AgenciaDAOIMplmeentacao implements AgenciaDAO)???
	 *  
	 *  O Autowired além de assumir a responsabilidade da instanciação, também irá
	 *  procurar a implementação padrão desta classe. Se não houver, ele gera em tempo
	 *  de execução uma implementação
	 */
	@Autowired
	private AgenciaDAO dao;  // esse cara que vai fazer o acesso ao banco
	
	
	// aqui precisamos criar um método que retorne TODAS as agências
	// ele precisa recuperar tudo do banco de dados!!! Como faremos??
	
	@GetMapping("/agencias")
	public ArrayList<Agencia> recuperarTodas(){
		ArrayList<Agencia> lista;
		lista = (ArrayList<Agencia>)dao.findAll();  // essa linha aqui que faz o select!!!
		return lista;
	}

}
