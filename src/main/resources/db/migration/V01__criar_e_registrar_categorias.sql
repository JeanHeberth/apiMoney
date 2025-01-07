CREATE TABLE categoria
(
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    nome   VARCHAR(255) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO categoria (nome)
VALUES ('LAZER');
INSERT INTO categoria (nome)
VALUES ('ALIMENTAÇÃO');
INSERT INTO categoria (nome)
VALUES ('SUPERMERCADO');
INSERT INTO categoria (nome)
VALUES ('FARMÁCIA');
INSERT INTO categoria (nome)
VALUES ('OUTROS');

