CREATE TABLE tb_produtos
(
    cd_produto UUID NOT NULL DEFAULT UUID(),
    nm_produto VARCHAR(150) NOT NULL,
    ds_descricao LONGTEXT NOT NULL,
    vl_preco DECIMAL(8,2) NOT NULL,
    tp_categoria VARCHAR(100) NOT NULL,
    sn_ativo BIT DEFAULT 1,
    PRIMARY KEY (cd_produto)
) ENGINE=InnoDB;
