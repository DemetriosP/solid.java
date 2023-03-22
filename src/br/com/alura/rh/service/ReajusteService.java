package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ReajusteService {

	private List<ValidacaoReajuste> validacoes;

	public ReajusteService(List<ValidacaoReajuste> validacoes){
		this.validacoes = validacoes;
	}

    public void reajustarSalario(Funcionario funcionario, BigDecimal aumento) {
		this.validacoes.forEach(v -> v.validar(funcionario, aumento));
        BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
        funcionario.atualizaSalario(salarioReajustado);
	}
    
}
