-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-10-2024 a las 05:03:15
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `faunacolombia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tdcaracteristicas`
--

CREATE TABLE `tdcaracteristicas` (
  `IDCaracteristica` int(10) NOT NULL,
  `FKIDAnimal` int(10) NOT NULL,
  `Tamaño` double(4,2) NOT NULL,
  `Peso` double(4,2) NOT NULL,
  `Coloracion` varchar(20) NOT NULL,
  `FKHabitat` int(10) NOT NULL,
  `Dieta` text NOT NULL,
  `Comportamiento` text NOT NULL,
  `Conservacion` int(11) NOT NULL,
  `FKIDTipoAnimal` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tdtipoanimal`
--

CREATE TABLE `tdtipoanimal` (
  `IDTipoAnimal` int(10) NOT NULL,
  `descripcion` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tmanimal`
--

CREATE TABLE `tmanimal` (
  `IDAnimal` int(10) NOT NULL,
  `imgFondo` text NOT NULL,
  `nomCom` varchar(40) NOT NULL,
  `nomCie` varchar(50) NOT NULL,
  `desGeneral` text NOT NULL,
  `FKCaracteristicas` int(10) NOT NULL,
  `curiosidades` text NOT NULL,
  `FKHabitat` int(10) NOT NULL,
  `regiones` varchar(50) NOT NULL,
  `imgSlide` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tmhabitat`
--

CREATE TABLE `tmhabitat` (
  `IDHabitat` int(10) NOT NULL,
  `nomHabitat` varchar(20) NOT NULL,
  `desHabitat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tdcaracteristicas`
--
ALTER TABLE `tdcaracteristicas`
  ADD PRIMARY KEY (`IDCaracteristica`),
  ADD UNIQUE KEY `IDCaracteristica` (`IDCaracteristica`),
  ADD KEY `FKIDAnimal` (`FKIDAnimal`),
  ADD KEY `FKHabitat` (`FKHabitat`),
  ADD KEY `FKIDtipoAnimal` (`FKIDTipoAnimal`);

--
-- Indices de la tabla `tdtipoanimal`
--
ALTER TABLE `tdtipoanimal`
  ADD PRIMARY KEY (`IDTipoAnimal`),
  ADD UNIQUE KEY `IDTipoAnimal` (`IDTipoAnimal`);

--
-- Indices de la tabla `tmanimal`
--
ALTER TABLE `tmanimal`
  ADD PRIMARY KEY (`IDAnimal`),
  ADD UNIQUE KEY `IDAnimal` (`IDAnimal`),
  ADD KEY `FKCaracteristicas` (`FKCaracteristicas`,`FKHabitat`);

--
-- Indices de la tabla `tmhabitat`
--
ALTER TABLE `tmhabitat`
  ADD PRIMARY KEY (`IDHabitat`),
  ADD UNIQUE KEY `IDHabitat` (`IDHabitat`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tdcaracteristicas`
--
ALTER TABLE `tdcaracteristicas`
  MODIFY `IDCaracteristica` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tdtipoanimal`
--
ALTER TABLE `tdtipoanimal`
  MODIFY `IDTipoAnimal` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tmanimal`
--
ALTER TABLE `tmanimal`
  MODIFY `IDAnimal` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tmhabitat`
--
ALTER TABLE `tmhabitat`
  MODIFY `IDHabitat` int(10) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tdcaracteristicas`
--
ALTER TABLE `tdcaracteristicas`
  ADD CONSTRAINT `tdcaracteristicas_ibfk_1` FOREIGN KEY (`FKIDTipoAnimal`) REFERENCES `tdtipoanimal` (`IDTipoAnimal`) ON UPDATE CASCADE,
  ADD CONSTRAINT `tdcaracteristicas_ibfk_2` FOREIGN KEY (`FKHabitat`) REFERENCES `tmhabitat` (`IDHabitat`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `tmanimal`
--
ALTER TABLE `tmanimal`
  ADD CONSTRAINT `tmanimal_ibfk_1` FOREIGN KEY (`FKCaracteristicas`) REFERENCES `tdcaracteristicas` (`IDCaracteristica`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
