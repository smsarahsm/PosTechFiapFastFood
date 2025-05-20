package br.com.fiap.postechfastfood.infrastructure.web.api.dtos;

import br.com.fiap.postechfastfood.domain.enums.TipoProdutoStatusEnum;
import br.com.fiap.postechfastfood.domain.models.PedidoModel;

import java.time.LocalDateTime;
import java.util.UUID;

public record PedidoResponseDto(
        UUID cdPedido,
        String cdDocCliente,
        String cdDocFuncionario,
        TipoProdutoStatusEnum txStatus,
        int nrPedido,
        LocalDateTime dhCriacaoPedido,
        LocalDateTime dhUltAtualizacao
    ) {
        public PedidoResponseDto(PedidoModel model) {
            this(model.getCd_pedido(),
                 model.getCd_doc_cliente(),
                 model.getCd_doc_funcionario(),
                 model.getTx_status(),
                 model.getNr_pedido(),
                 model.getDh_criacao_pedido(),
                 model.getDh_ult_atualizacao());
        }
}
