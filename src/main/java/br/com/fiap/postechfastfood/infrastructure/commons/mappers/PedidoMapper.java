package br.com.fiap.postechfastfood.infrastructure.commons.mappers;

import br.com.fiap.postechfastfood.domain.models.ItensPedidoModel;
import br.com.fiap.postechfastfood.domain.models.PedidoModel;
import br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities.PedidoEntity;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidoRequestDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.PedidoResponseDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {

    public static PedidoEntity modelToEntity(PedidoModel model) {
        PedidoEntity entity = new PedidoEntity();
        entity.setCdPedido(model.getCdPedido());
        entity.setCdDocCliente(model.getCdDocCliente());
        entity.setCdDocFuncionario(model.getCdDocFuncionario());
        entity.setTxStatus(model.getTxStatus());
        entity.setNrPedido(model.getNrPedido());
        entity.setDhCriacaoPedido(model.getDhCriacaoPedido());
        entity.setDhUltAtualizacao(model.getDhUltAtualizacao());
        return entity;
    }

    public static PedidoModel entityToModel(PedidoEntity entity) {
        PedidoModel model = new PedidoModel();
        model.setCdPedido(entity.getCdPedido());
        model.setCdDocCliente(entity.getCdDocCliente());
        model.setCdDocFuncionario(entity.getCdDocFuncionario());
        model.setTxStatus(entity.getTxStatus());
        model.setNrPedido(entity.getNrPedido());
        model.setDhCriacaoPedido(entity.getDhCriacaoPedido());
        model.setDhUltAtualizacao(entity.getDhUltAtualizacao());
        if (entity.getProdutosPedidoEntities() != null && !entity.getProdutosPedidoEntities().isEmpty()){
            model.setItens(
                    entity.getProdutosPedidoEntities().stream()
                    .map(m -> new ItensPedidoModel(ProdutoMapper.toModel(m.getProduto()), m.getVlQuantidadeProduto()))
                    .toList()
            );
        }
        return model;
    }

    public static PedidoModel requestToModel(PedidoRequestDto req) {
        PedidoModel model = new PedidoModel();
        model.setCdDocCliente(req.cdDocCliente());
        model.setCdDocFuncionario(req.cdDocFuncionario());
        model.setTxStatus(req.txStatus());
        model.setNrPedido(req.nrPedido());
        model.setDhCriacaoPedido(req.dhCriacaoPedido());
        model.setDhUltAtualizacao(req.dhUltAtualizacao());
        List<ItensPedidoModel> itensPedidoModels = new ArrayList<>();
        if (req.itens() != null && !req.itens().isEmpty()){
            req.itens().forEach(itensPedidoModels::add);
            model.setItens(itensPedidoModels);
        }
        return model;
    }

    public static PedidoResponseDto modelToResponse (PedidoModel model) {
        PedidoResponseDto responseDto = new PedidoResponseDto(model);
        return responseDto;
    }

    public static List<PedidoResponseDto> modelToListResponse(List<PedidoModel> pedidoModels) {
        return pedidoModels.stream().map(PedidoMapper::modelToResponse).collect(Collectors.toList());
    }
}
