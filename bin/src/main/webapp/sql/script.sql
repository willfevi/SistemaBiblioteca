create DATABASE dbsisbiblioteca character set utf8mb4 collate utf8mb4_bin;
use dbsisbiblioteca;


CREATE TABLE bibliotecario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    matricula VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE genero (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE livro (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    valor FLOAT NOT NULL,
    genero_id INT,
    dataDePublicacao DATE,
    quantidadeEstoque INT NOT NULL,
    FOREIGN KEY (genero_id) REFERENCES genero(id)
);

CREATE TABLE usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE emprestimo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    bibliotecario_id INT,
    usuario_id INT,
    livro_id INT,
    dataDeRetorno DATE NOT NULL,
    FOREIGN KEY (bibliotecario_id) REFERENCES bibliotecario(id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (livro_id) REFERENCES livro(id)
);

CREATE TABLE relatorio (
    id INT PRIMARY KEY AUTO_INCREMENT,
    bibliotecario_id INT,
    emprestimo_id INT,
    dataGerado DATE NOT NULL,
    FOREIGN KEY (bibliotecario_id) REFERENCES bibliotecario(id),
    FOREIGN KEY (emprestimo_id) REFERENCES emprestimo(id)
);

INSERT INTO bibliotecario (nome, cpf, email, senha, matricula) VALUES
('root', '99999999999', 'root@example.com', '0000', 'ROOT123'),
('Alice Silva', '11111111111', 'alice@example.com', 'senha123', 'MAT12345'),
('Bruno Gomes', '22222222222', 'bruno@example.com', 'senha234', 'MAT23456'),
('Carla Dias', '33333333333', 'carla@example.com', 'senha345', 'MAT34567'),
('David Sousa', '44444444444', 'david@example.com', 'senha456', 'MAT45678'),
('Eva Lima', '55555555555', 'eva@example.com', 'senha567', 'MAT56789'),
('Fábio Costa', '66666666666', 'fabio@example.com', 'senha678', 'MAT67890'),
('Gabriela Martins', '77777777777', 'gabriela@example.com', 'senha789', 'MAT78901'),
('Hugo Pereira', '88888888888', 'hugo@example.com', 'senha890', 'MAT89012'),
('Iris Fernandes', '99999999998', 'iris@example.com', 'senha901', 'MAT90123');

INSERT INTO genero (nome) VALUES
('Ficção Científica'),
('Romance'),
('Terror'),
('Fantasia'),
('Biografia'),
('História'),
('Educação'),
('Filosofia'),
('Negócios'),
('Autoajuda');

INSERT INTO livro (titulo, autor, valor, genero_id, dataDePublicacao, quantidadeEstoque) VALUES
('O Guia do Mochileiro das Galáxias', 'Douglas Adams', 29.90, 1, '1979-10-12', 10),
('Orgulho e Preconceito', 'Jane Austen', 39.90, 2, '1813-01-28', 15),
('Drácula', 'Bram Stoker', 25.90, 3, '1897-05-26', 8),
('O Senhor dos Anéis', 'J.R.R. Tolkien', 55.90, 4, '1954-07-29', 12),
('Steve Jobs', 'Walter Isaacson', 45.90, 5, '2011-10-24', 7),
('Sapiens', 'Yuval Noah Harari', 49.90, 6, '2011-09-01', 9),
('Pedagogia da Autonomia', 'Paulo Freire', 22.90, 7, '1996-01-01', 10),
('A República', 'Platão', 31.90, 8, '-0380-01-01', 6),
('Pai Rico, Pai Pobre', 'Robert Kiyosaki', 42.90, 9, '1997-04-01', 11),
('O Poder do Hábito', 'Charles Duhigg', 36.90, 10, '2012-02-28', 14);


INSERT INTO usuario (nome, cpf, email, senha) VALUES
('Carlos Pereira', '00000000001', 'carlos@example.com', 'senha345'),
('Daniela Rocha', '00000000002', 'daniela@example.com', 'senha456'),
('Eduardo Silva', '00000000003', 'eduardo@example.com', 'senha567'),
('Fernanda Gomes', '00000000004', 'fernanda@example.com', 'senha678'),
('Gustavo Santos', '00000000005', 'gustavo@example.com', 'senha789'),
('Helena Oliveira', '00000000006', 'helena@example.com', 'senha890'),
('Igor Almeida', '00000000007', 'igor@example.com', 'senha901'),
('Juliana Barros', '00000000008', 'juliana@example.com', 'senha012'),
('Leandro Costa', '00000000009', 'leandro@example.com', 'senha123'),
('Márcia Souza', '00000000010', 'marcia@example.com', 'senha234');

-- Nota: As datas de retorno são fictícias

INSERT INTO emprestimo (bibliotecario_id, usuario_id, livro_id, dataDeRetorno) VALUES
(1, 1, 1, '2023-10-01'),
(2, 2, 2, '2023-10-15'),
(3, 3, 3, '2023-11-01'),
(4, 4, 4, '2023-11-15'),
(5, 5, 5, '2023-12-01'),
(6, 6, 6, '2023-12-15'),
(7, 7, 7, '2024-01-01'),
(8, 8, 8, '2024-01-15'),
(9, 9, 9, '2024-02-01'),
(10, 10, 10, '2024-02-15');
