CREATE TABLE tb_pedidos_produtos
(
    cd_pedido CHAR(36) NOT NULL,
    cd_produto CHAR(36) NOT NULL,
    vl_qtd INT NOT NULL DEFAULT 0,
    PRIMARY KEY (cd_pedido, cd_produto)
) ENGINE=InnoDB;

ALTER TABLE tb_pedidos_produtos
    ADD CONSTRAINT FK_PEDIDO_PRODUTO_PEDIDO_CDPEDIDO
        FOREIGN KEY (cd_pedido)
        REFERENCES tb_pedidos(cd_pedido)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE tb_pedidos_produtos
    ADD CONSTRAINT FK_PEDIDO_PRODUTO_PRODUTO_CDPRODUTO
        FOREIGN KEY (cd_produto)
        REFERENCES tb_produtos(cd_produto)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

--ENGINE: MARIADB
--CREATE TABLE tb_pedidos_produtos
--(
--    cd_pedido UUID NOT NULL,
--    cd_produto UUID NOT NULL,
--    vl_qtd INT NOT NULL DEFAULT 0
--) ENGINE=InnoDB;
--ALTER TABLE tb_pedidos_produtos
--    ADD CONSTRAINT FK_PEDIDO_PRODUTO_PEDIDO_CDPEDIDO FOREIGN KEY (cd_pedido)
--        REFERENCES tb_pedidos(cd_pedido);
--ALTER TABLE tb_pedidos_produtos
--    ADD CONSTRAINT FK_PEDIDO_PRODUTO_PRODUTO_CDPRODUTO FOREIGN KEY (cd_produto)
--        REFERENCES tb_produtos(cd_produto);