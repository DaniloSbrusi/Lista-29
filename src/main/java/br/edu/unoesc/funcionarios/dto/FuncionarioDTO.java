package br.edu.unoesc.funcionarios.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import br.edu.unoesc.funcionarios.model.Funcionario;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
public class FuncionarioDTO implements Serializable {
	
	Long id;
	
	@NotBlank(message="É obrigatório informar o nome do funcionário")
	@Size(min=1, max=100, message="O nome do funcionário deve estar entre 1 e 100 caracteres")
	String nome;

	String endereco;
	
	@NotNull(message="É obrigatório informar o número de dependentes do funcionário")
	@Min(value=0, message="O funcionário não pode ter dependentes negativos")
	@Max(value=10, message="O funcionário não pode ter mais que 10 dependentes")
	Integer numDep;
	
	@NotNull(message="É obrigatório informar o salário do funcionário")
	@Min(value=0, message="O funcionário não pode ter salário negativo")
	BigDecimal salario;
	
	@NotBlank(message="É obrigatório informar a data de nascimento do funcionário")
	@Past(message = "A data deve ser anterior à data atual")
	LocalDate nascimento;
	
	public FuncionarioDTO(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
		this.endereco = funcionario.getEndereco();
		this.numDep = funcionario.getNumDep();
		this.salario = funcionario.getSalario();
		this.nascimento = funcionario.getNascimento();
	}
	
	public void setNascimento(String data) {
		this.nascimento = LocalDate.parse(data);
	}
}