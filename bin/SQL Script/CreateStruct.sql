
-- Cria o banco de dados do sistema de veículos.
CREATE DATABASE SistemaVeiculos;
GO

-- Seleciona o banco de dados criado.
USE SistemaVeiculos;
GO

-- Tabela base: armazena os dados comuns dos veículos.
CREATE TABLE Veiculo (
    VeiculoId INT IDENTITY(1,1) NOT NULL,   -- Identificador único do veículo
    Placa VARCHAR(10) NOT NULL,     -- Placa do veículo
    Ano INT NOT NULL,     -- Ano de fabricação do veículo

    CONSTRAINT PK_Veiculo       
        PRIMARY KEY (VeiculoId)         -- Chave primária da tabela Veiculo
);
GO

-- Tabela derivada: armazena os dados específicos dos caminhões.
CREATE TABLE Caminhao (
    VeiculoId INT NOT NULL, -- Identificador único do veículo (chave estrangeira)
    Eixos INT NOT NULL, -- Quantidade de eixos do caminhão

    CONSTRAINT PK_Caminhao       -- Chave primária da tabela Caminhao
        PRIMARY KEY (VeiculoId),

    CONSTRAINT FK_Caminhao_Veiculo
        FOREIGN KEY (VeiculoId)       -- Chave estrangeira referenciando a tabela Veiculo
        REFERENCES Veiculo(VeiculoId),

    CONSTRAINT CK_Caminhao_Eixos   -- Restrição para garantir que a quantidade de eixos seja positiva
        CHECK (Eixos > 0)
);
GO

-- Tabela derivada: armazena os dados específicos dos ônibus.
CREATE TABLE Onibus (
    VeiculoId INT NOT NULL, -- Identificador único do veículo (chave estrangeira)
    Assentos INT NOT NULL, -- Quantidade de assentos do ônibus

    CONSTRAINT PK_Onibus       -- Chave primária da tabela Onibus
        PRIMARY KEY (VeiculoId),

    CONSTRAINT FK_Onibus_Veiculo
        FOREIGN KEY (VeiculoId)       -- Chave estrangeira referenciando a tabela Veiculo
        REFERENCES Veiculo(VeiculoId),

    CONSTRAINT CK_Onibus_Assentos   -- Restrição para garantir que a quantidade de assentos seja positiva
        CHECK (Assentos > 0)
);
GO
