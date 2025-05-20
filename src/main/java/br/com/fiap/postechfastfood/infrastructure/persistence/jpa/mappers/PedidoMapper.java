package br.com.fiap.postechfastfood.infrastructure.persistence.jpa.mappers;

import br.com.fiap.postechfastfood.domain.models.PedidoModel;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities.PedidoEntity;

public class PedidoMapper {

    public static PedidoEntity toEntity(PedidoModel model) {
        PedidoEntity entity = new PedidoEntity();
        entity.setCdPedido(model.getCd_pedido());
        entity.setCdDocCliente(model.getCd_doc_cliente());
        entity.setCdDocFuncionario(model.getCd_doc_funcionario());
        entity.setTxStatus(model.getTx_status());
        entity.setNrPedido(model.getNr_pedido());
        entity.setDhCriacaoPedido(model.getDh_criacao_pedido());
        entity.setDhUltAtualizacao(model.getDh_ult_atualizacao());
        return entity;
    }

    public static PedidoModel toModel(PedidoEntity entity) {
        PedidoModel model = new PedidoModel();
        model.setCd_pedido(entity.getCdPedido());
        model.setCd_doc_cliente(entity.getCdDocCliente());
        model.setCd_doc_funcionario(entity.getCdDocFuncionario());
        model.setTx_status(entity.getTxStatus());
        model.setNr_pedido(entity.getNrPedido());
        model.setDh_criacao_pedido(entity.getDhCriacaoPedido());
        model.setDh_ult_atualizacao(entity.getDhUltAtualizacao());
        return model;
    }
}
