package br.com.fiap.postechfastfood.infrastructure.persistence.jpa.mappers;

import br.com.fiap.postechfastfood.domain.models.PedidosModel;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities.PedidosEntity;

import java.util.UUID;

public class PedidosMapper {

    public static PedidosEntity toEntity(PedidosModel model) {
        PedidosEntity entity = new PedidosEntity();
        entity.setCdPedido(model.getCd_pedido());
        entity.setCdDocCliente(model.getCd_doc_cliente());
        entity.setCdDocFuncionario(model.getCd_doc_funcionario());
        entity.setTxStatus(model.getTx_status());
        entity.setNrPedido(model.getNr_pedido());
        entity.setDhCriacaoPedido(model.getDh_criacao_pedido());
        entity.setDhUltAtualizacao(model.getDh_ult_atualizacao());
        return entity;
    }

    public static PedidosModel toModel(PedidosEntity entity) {
        PedidosModel model = new PedidosModel();
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
