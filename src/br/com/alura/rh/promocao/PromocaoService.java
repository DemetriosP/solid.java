package br.com.alura.rh.promocao;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, boolean metaBatida){

        Cargo cargoAtual = funcionario.getDadosPessoais().getCargo();

        if(Cargo.GERENTE == cargoAtual) {
            throw new ValidacaoException("Gerentes não podem ser promovidos");
        }

        if(metaBatida){
            Cargo novCargo = cargoAtual.getProximoCargo();
            funcionario.promover(novCargo);
        }else{
            throw new ValidacaoException("Funcionário não bateu a meta");
        }

    }
    
}
