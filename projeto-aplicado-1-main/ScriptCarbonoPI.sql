-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 12, 2022 at 04:06 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carbonofinal`
--

-- --------------------------------------------------------

--
-- Table structure for table `chamado`
--

CREATE TABLE `chamado` (
  `idchamado` int(11) NOT NULL,
  `data` datetime NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `distancia` float NOT NULL,
  `veiculo` int(11) NOT NULL,
  `funcionario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `funcionario`
--

CREATE TABLE `funcionario` (
  `idfuncionario` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `aniversario` date NOT NULL,
  `ingresso` datetime NOT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `habilitacao` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `funcionario`
--

INSERT INTO `funcionario` (`idfuncionario`, `nome`, `aniversario`, `ingresso`, `endereco`, `habilitacao`) VALUES
(1, 'Felipe', '1998-04-14', '2022-04-10 00:00:00', 'Rua Bolinha', 'B'),
(4, 'Bruno', '2000-09-04', '2022-04-10 00:00:00', 'Rua Quadrado', 'A'),
(5, 'Guga', '2010-10-10', '2011-11-11 00:00:00', 'Rua Bingo', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `veiculo`
--

CREATE TABLE `veiculo` (
  `idveiculo` int(11) NOT NULL,
  `placa` varchar(10) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `km` int(11) DEFAULT NULL,
  `consumo` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `veiculo`
--

INSERT INTO `veiculo` (`idveiculo`, `placa`, `modelo`, `km`, `consumo`) VALUES
(1, 'abcd123', 'nitrox10', 1, 1),
(2, 'abcd124', 'megaturbo', 1, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chamado`
--
ALTER TABLE `chamado`
  ADD PRIMARY KEY (`idchamado`),
  ADD KEY `FK_veiculochamado` (`veiculo`),
  ADD KEY `FK_funcionariochamado` (`funcionario`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idfuncionario`);

--
-- Indexes for table `veiculo`
--
ALTER TABLE `veiculo`
  ADD PRIMARY KEY (`idveiculo`),
  ADD UNIQUE KEY `placa` (`placa`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chamado`
--
ALTER TABLE `chamado`
  MODIFY `idchamado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idfuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `veiculo`
--
ALTER TABLE `veiculo`
  MODIFY `idveiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chamado`
--
ALTER TABLE `chamado`
  ADD CONSTRAINT `FK_funcionariochamado` FOREIGN KEY (`funcionario`) REFERENCES `funcionario` (`idfuncionario`),
  ADD CONSTRAINT `FK_veiculochamado` FOREIGN KEY (`veiculo`) REFERENCES `veiculo` (`idveiculo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
