package br.com.fiap.postechfastfood.domain.ports.out;

import br.com.fiap.postechfastfood.domain.models.ComandaModel;

import java.util.List;
import java.util.Optional;

public interface ComandaRepositoryPort {

    Optional<ComandaModel> buscarPedido(ComandaModel comandaModel);
    Optional<ComandaModel> buscarPorCdPedido(String cdPedido);
    List<ComandaModel> listarTodosPedidos();
}
