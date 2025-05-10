CREATE TABLE tb_produtos
(
    cd_produto UUID NOT NULL DEFAULT UUID(),
    nm_produto VARCHAR(150) NOT NULL,
    ds_descricao LONGTEXT NOT NULL,
    vl_preco DECIMAL NOT NULL,
    tp_categoria VARCHAR(100) NOT NULL,
    PRIMARY KEY (cd_produto)
) ENGINE=InnoDB;
