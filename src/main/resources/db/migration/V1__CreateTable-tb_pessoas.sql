CREATE TABLE tb_pessoas
(
    cd_doc_pessoa CHAR(11) NOT NULL,
    nm_pessoa VARCHAR(200) NOT NULL,
    tp_pessoa VARCHAR(100) NOT NULL,
    ds_email VARCHAR(255) NOT NULL,
    PRIMARY KEY(cd_doc_pessoa)
) ENGINE=InnoDB;