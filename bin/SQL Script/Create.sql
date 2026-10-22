
-- Cria o banco de dados do sistema de veículos.
CREATE DATABASE SistemaVeiculos;
GO

-- Seleciona o banco de dados criado.
USE SistemaVeiculos;
GO

-- Tabela base: armazena os dados comuns dos veículos.
CREATE TABLE Veiculo (
    VeiculoId INT IDENTITY(1,1) NOT NULL,
    Placa VARCHAR(10) NOT NULL,
    Ano INT NOT NULL,
    CONSTRAINT PK_Veiculo PRIMARY KEY (VeiculoId)
);
GO

-- Tabela derivada: armazena os dados específicos dos caminhões.
CREATE TABLE Caminhao (
    VeiculoId INT NOT NULL,
    Eixos INT NOT NULL,
    CONSTRAINT PK_Caminhao PRIMARY KEY (VeiculoId),
    CONSTRAINT FK_Caminhao_Veiculo FOREIGN KEY (VeiculoId)
        REFERENCES Veiculo(VeiculoId)
);
GO

-- Tabela derivada: armazena os dados específicos dos ônibus.
CREATE TABLE Onibus (
    VeiculoId INT NOT NULL,
    Assentos INT NOT NULL,
    CONSTRAINT PK_Onibus PRIMARY KEY (VeiculoId),
    CONSTRAINT FK_Onibus_Veiculo FOREIGN KEY (VeiculoId)
        REFERENCES Veiculo(VeiculoId)
);
GO
