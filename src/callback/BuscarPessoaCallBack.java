package callback;

import java.util.List;

import entidade.Pessoa;

public interface BuscarPessoaCallBack {

    void backBuscarNome(List<Pessoa> names);

    void errorBuscarNome(String error);
}