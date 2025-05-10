CREATE TABLE tb_pedidos_produtos
(
    cd_pedido UUID NOT NULL,
    cd_produto UUID NOT NULL,
    vl_qtd INT NOT NULL DEFAULT 0
) ENGINE=InnoDB;
ALTER TABLE tb_pedidos_produtos
    ADD CONSTRAINT FK_PEDIDO_PRODUTO_PEDIDO_CDPEDIDO FOREIGN KEY (cd_pedido)
        REFERENCES tb_pedidos(cd_pedido);
ALTER TABLE tb_pedidos_produtos
    ADD CONSTRAINT FK_PEDIDO_PRODUTO_PRODUTO_CDPRODUTO FOREIGN KEY (cd_produto)
        REFERENCES tb_produtos(cd_produto);