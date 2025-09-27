CREATE TABLE tb_pedidos (
    cd_pedido CHAR(36) NOT NULL,
    cd_doc_cliente CHAR(11),
    cd_doc_funcionario CHAR(11),
    tx_status VARCHAR(200) NOT NULL, -- AGUARDANDO_PAGAMENTO, RECEBIDO, EM_PREPARACAO, PRONTO, FINALIZADO
    nr_pedido INT NOT NULL DEFAULT 0,
    dh_criacao_pedido TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dh_ult_atualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (cd_pedido)
) ENGINE=InnoDB;

ALTER TABLE tb_pedidos
    ADD CONSTRAINT FK_PEDIDO_PESSOA_CDDOCCLIENTE FOREIGN KEY (cd_doc_cliente)
        REFERENCES tb_pessoas(cd_doc_pessoa);

ALTER TABLE tb_pedidos
    ADD CONSTRAINT FK_PEDIDO_PESSOA_CDDOCFUNCIONARIO FOREIGN KEY (cd_doc_funcionario)
        REFERENCES tb_pessoas(cd_doc_pessoa);

--ENGINE: MARIADB
--CREATE TABLE tb_pedidos
--(
--    cd_pedido UUID NOT NULL DEFAULT UUID(),
--    cd_doc_cliente CHAR(11),
--    cd_doc_funcionario CHAR(11),
--    tx_status VARCHAR(200) NOT NULL, -- AGUARDANDO_PAGAMENTO, RECEBIDO, EM_PREPARACAO, RECEBIDO, PRONTO, FINALIZADO
--    nr_pedido TINYINT NOT NULL DEFAULT 0,
--    dh_criacao_pedido TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
--    dh_ult_atualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
--    PRIMARY KEY (cd_pedido)
--) ENGINE=InnoDB;
--ALTER TABLE tb_pedidos
--    ADD CONSTRAINT FK_PEDIDO_PESSOA_CDDOCCLIENTE FOREIGN KEY (cd_doc_cliente)
--        REFERENCES tb_pessoas(cd_doc_pessoa);
--ALTER TABLE tb_pedidos
--    ADD CONSTRAINT FK_PEDIDO_PESSOA_CDDOCFUNCIONARIO FOREIGN KEY (cd_doc_funcionario)
--        REFERENCES tb_pessoas(cd_doc_pessoa);