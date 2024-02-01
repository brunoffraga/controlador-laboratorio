CREATE TABLE checagemListAdicional (
    id BIGINT NOT NULL AUTO_INCREMENT,
    ativo BOOLEAN,
    
    PRIMARY KEY(id)
);

CREATE TABLE checagem (
    id BIGINT NOT NULL AUTO_INCREMENT,
    checagem VARCHAR(255) NOT NULL,
    ativo BOOLEAN,
    checagemListAdicional_id BIGINT,
    
    PRIMARY KEY(id),
    FOREIGN KEY (checagemListAdicional_id) REFERENCES checagemListAdicional(id)
);