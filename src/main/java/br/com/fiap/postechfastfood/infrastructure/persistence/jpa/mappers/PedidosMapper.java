package br.com.fiap.postechfastfood.infrastructure.persistence.jpa.mappers;

import br.com.fiap.postechfastfood.domain.models.PedidoModel;
import br.com.fiap.postechfastfood.domain.models.ProdutoPedidoModel;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities.PedidosEntity;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities.ProdutoPedidoEntity;

import java.util.ArrayList;
import java.util.List;

public class PedidosMapper {

    public static PedidosEntity toEntity(PedidoModel model) {
        PedidosEntity entity = new PedidosEntity();
        entity.setCdPedido(model.getCdPedido());
        entity.setCdDocCliente(model.getcdDocCliente());
        entity.setCdDocFuncionario(model.getCdDocFuncionario());
        entity.setTxStatus(model.getTxStatus());
        entity.setNrPedido(model.getNrPedido());
        entity.setDhCriacaoPedido(model.getDhCriacaoPedido());
        entity.setDhUltAtualizacao(model.getDhUltAtualizacao());
        return entity;
    }

    public static PedidoModel toModel(PedidosEntity entity) {
        PedidoModel model = new PedidoModel();
        model.setCdPedido(entity.getCdPedido());
        model.setcdDocCliente(entity.getCdDocCliente());
        model.setCdDocFuncionario(entity.getCdDocFuncionario());
        model.setTxStatus(entity.getTxStatus());
        model.setNrPedido(entity.getNrPedido());
        model.setDhCriacaoPedido(entity.getDhCriacaoPedido());
        model.setDhUltAtualizacao(entity.getDhUltAtualizacao());
        model.setLsProdutoPedido(toModelList(entity.getLsProdutoPedido()));
        return model;
    }

    private static List<ProdutoPedidoModel> toModelList(List<ProdutoPedidoEntity> entity){
        List<ProdutoPedidoModel> lsModel = new ArrayList<>();
        entity.forEach(e -> {
            ProdutoPedidoModel model = new ProdutoPedidoModel();
            model.setProdutoModel(ProdutoMapper.toModel(e.getProduto()));
            model.setPedidoModel(PedidosMapper.toModel(e.getPedido()));
            model.setVlQuantidadeProduto(e.getVlQuantidadeProduto());
            lsModel.add(model);
        });
        return lsModel;
    }

}
