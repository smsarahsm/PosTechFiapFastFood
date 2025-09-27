CREATE TABLE tb_pagamentos
(
    cd_pagamento CHAR(36) NOT NULL,
    cd_pedido CHAR(36) NOT NULL,
    vl_pagamento DOUBLE(10,2) NOT NULL,
    dh_pagamento TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dh_atualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    tp_status VARCHAR(100) NOT NULL DEFAULT 'PENDENTE_PAGAMENTO',
    PRIMARY KEY (cd_pagamento)
) ENGINE=InnoDB;

ALTER TABLE tb_pagamentos
    ADD CONSTRAINT FK_PAGAMENTO_PEDIDO_CDPEDIDO
        FOREIGN KEY (cd_pedido)
        REFERENCES tb_pedidos(cd_pedido)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

--ENGINE: MARIADB
--CREATE TABLE tb_pagamentos
--(
--    cd_pagamento UUID NOT NULL DEFAULT UUID(),
--    cd_pedido UUID NOT NULL,
--    vl_pagamento DOUBLE(10,2) NOT NULL,
--    dh_pagamento TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
--    dh_atualizacao TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
--    tp_status VARCHAR(100) NOT NULL DEFAULT 'PENDENTE_PAGAMENTO',
--    PRIMARY KEY (cd_pagamento)
--) ENGINE=InnoDB;
--ALTER TABLE tb_pagamentos
--    ADD CONSTRAINT FK_PAGAMENTO_PEDIDO_CDPEDIDO FOREIGN KEY (cd_pedido)
--        REFERENCES tb_pedidos(cd_pedido);