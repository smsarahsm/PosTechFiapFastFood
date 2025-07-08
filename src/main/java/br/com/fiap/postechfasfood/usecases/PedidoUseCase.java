package br.com.fiap.postechfasfood.usecases;

import br.com.fiap.postechfasfood.apis.requests.PedidoWebHandlerRequest;
import br.com.fiap.postechfasfood.entities.PedidoVO;
import br.com.fiap.postechfasfood.gateways.PedidoGateway;

public class PedidoUseCase {

    private final PedidoGateway pedidoGateway;

    public PedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public PedidoVO criarPedido(PedidoWebHandlerRequest pedidoWebHandlerRequest) {
        //inserir na pedido
        var pedido = new PedidoVO(
                pedidoWebHandlerRequest.cdDocCliente(),
                pedidoWebHandlerRequest.itens()
        );
        return pedidoGateway.inserirPedidoNaBase(pedido);
    }

}
