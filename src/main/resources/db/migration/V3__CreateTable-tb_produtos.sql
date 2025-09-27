CREATE TABLE tb_produtos (
    cd_produto CHAR(36) NOT NULL, -- UUID deve ser gerado pela aplicação ou trigger
    nm_produto VARCHAR(150) NOT NULL,
    ds_descricao LONGTEXT NOT NULL,
    vl_preco DECIMAL(10,2) NOT NULL,
    tp_categoria VARCHAR(100) NOT NULL,
    sn_ativo BIT DEFAULT 1,
    PRIMARY KEY (cd_produto)
) ENGINE=InnoDB;

CREATE TRIGGER before_insert_tb_produtos
BEFORE INSERT ON tb_produtos
FOR EACH ROW
SET NEW.cd_produto = IF(NEW.cd_produto IS NULL OR NEW.cd_produto = '', UUID(), NEW.cd_produto);

--ENGINE: MARIADB
--CREATE TABLE tb_produtos
--(
--    cd_produto UUID NOT NULL DEFAULT UUID(),
--    nm_produto VARCHAR(150) NOT NULL,
--    ds_descricao LONGTEXT NOT NULL,
--    vl_preco DECIMAL NOT NULL,
--    tp_categoria VARCHAR(100) NOT NULL,
--    sn_ativo BIT DEFAULT 1,
--    PRIMARY KEY (cd_produto)
--) ENGINE=InnoDB;
