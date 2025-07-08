package br.com.fiap.postechfasfood.gateways;

import br.com.fiap.postechfasfood.interfaces.DbConnection;
import br.com.fiap.postechfasfood.interfaces.PedidoGatewayInterface;

public class PedidoGateway implements PedidoGatewayInterface {

    private final DbConnection dbConnection;

    public PedidoGateway(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public T inserirPedidoNaBase(T pedidoVO) {
        dbConnection.
        return null;
    }
}
