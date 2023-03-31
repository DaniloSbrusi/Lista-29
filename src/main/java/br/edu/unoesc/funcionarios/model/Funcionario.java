package br.edu.unoesc.funcionarios.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import br.edu.unoesc.funcionarios.dto.FuncionarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@XmlRootElement
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(nullable = false, length = 100)
	String nome;
	
	String endereco;
	
	@Column(nullable = false)
	Integer numDep;
	
	@Column(nullable = false)
	BigDecimal salario;
	
	@Column(nullable = false)
	LocalDate nascimento;

	public Funcionario(FuncionarioDTO funcionario) {
		super();
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
		this.endereco = funcionario.getEndereco();
		this.numDep = funcionario.getNumDep();
		this.salario = funcionario.getSalario();
		this.nascimento = funcionario.getNascimento();
	}
	
	
}