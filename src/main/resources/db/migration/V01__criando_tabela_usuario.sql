CREATE TABLE usuario(
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  login VARCHAR(50) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  nome VARCHAR(50) NOT NULL,
  sobrenome VARCHAR(50)
);