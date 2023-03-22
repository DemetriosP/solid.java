package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ValidacaoPeriodicidade implements ValidacaoReajuste{

    public void validar(Funcionario funcionario, BigDecimal aumento){

        LocalDate dataultimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();

        long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataultimoReajuste, dataAtual);

		if (mesesDesdeUltimoReajuste < 6) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
    }
    
}
