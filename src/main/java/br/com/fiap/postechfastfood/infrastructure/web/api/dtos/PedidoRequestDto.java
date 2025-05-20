package br.com.fiap.postechfastfood.infrastructure.web.api.dtos;

import br.com.fiap.postechfastfood.domain.enums.TipoStatusPedidoEnum;
import br.com.fiap.postechfastfood.domain.models.PedidoModel;
import br.com.fiap.postechfastfood.domain.models.ProdutoPedidoModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record PedidoRequestDto(
        UUID cdPedido, //não pode ser obrigatório
        String cdDocCliente,
        String cdDocFuncionario,
        TipoStatusPedidoEnum txStatus,
        int nrPedido,
        LocalDateTime dhCriacaoPedido,
        LocalDateTime dhUltAtualizacao,
        List<ProdutoPedidoRequestDto> lsProdutoPedido
)

    {
        public PedidoRequestDto(PedidoModel model) {
            this(model.getCdPedido(),
                    model.getcdDocCliente(),
                    model.getCdDocFuncionario(),
                    model.getTxStatus(),
                    model.getNrPedido(),
                    model.getDhCriacaoPedido(),
                    model.getDhUltAtualizacao(),
                    model.getLsProdutoPedido().stream().map(ProdutoPedidoRequestDto::new).collect(Collectors.toList()));
        }
    }
