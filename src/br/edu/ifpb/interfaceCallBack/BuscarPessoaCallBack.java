package br.edu.ifpb.interfaceCallBack;

import java.util.List;

import br.edu.ifpb.entidade.Pessoa;

public interface BuscarPessoaCallBack {

	//assinaturas de interface dever�o ser implementadas na classe Main
	void backBuscarNome(List<Pessoa> names);
    
}
