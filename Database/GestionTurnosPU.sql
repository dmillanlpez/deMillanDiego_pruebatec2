-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 30, 2023 at 10:50 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `GestionTurnosPU`
--
CREATE DATABASE IF NOT EXISTS `GestionTurnosPU` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `GestionTurnosPU`;

-- --------------------------------------------------------

--
-- Table structure for table `ciudadano`
--

DROP TABLE IF EXISTS `ciudadano`;
CREATE TABLE `ciudadano` (
  `id` bigint(20) NOT NULL,
  `dni` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ciudadano`
--

INSERT INTO `ciudadano` (`id`, `dni`, `nombre`, `apellidos`, `telefono`) VALUES
(1, '47435259J', 'Diego', 'Millan', '605166599'),
(2, '58055631C', 'Carmen', 'Millan', '981624635'),
(3, '32426115W', 'Cath', 'Millan', '000000000'),
(4, '12345619Z', 'Mario', 'Santiago', '981617564'),
(5, '14567432U', 'Pedro', 'Garcia', '698789563'),
(6, '12345677T', 'Kat', 'Lopez', '659876334'),
(7, '665543761C', 'Danne', 'Baltimor', '554387615');

-- --------------------------------------------------------

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
CREATE TABLE `turno` (
  `id` bigint(20) NOT NULL,
  `fechaTurno` date NOT NULL,
  `descripcionTram` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `ciudadano_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `turno`
--

INSERT INTO `turno` (`id`, `fechaTurno`, `descripcionTram`, `estado`, `ciudadano_id`) VALUES
(1, '2023-11-30', 'Se ha ido la luz en la calle Antonio Sanjurjo', 'Ya atendido', 1),
(2, '2023-12-05', 'Obras proximamente en Sada', 'En espera', 2),
(3, '2023-11-30', 'Reunion AMPA', 'Ya atendido', 3),
(6, '2023-11-30', 'Validacion Turnero', 'Ya atendido', 6),
(7, '2023-11-30', 'Validacion Turnero 2', 'En espera', 6),
(8, '2023-12-01', 'Validacion Turnero 3', 'En espera', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ciudadano`
--
ALTER TABLE `ciudadano`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `telefono` (`telefono`);

--
-- Indexes for table `turno`
--
ALTER TABLE `turno`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ciudadano_id` (`ciudadano_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ciudadano`
--
ALTER TABLE `ciudadano`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `turno`
--
ALTER TABLE `turno`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `turno`
--
ALTER TABLE `turno`
  ADD CONSTRAINT `turno_ibfk_1` FOREIGN KEY (`ciudadano_id`) REFERENCES `ciudadano` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
