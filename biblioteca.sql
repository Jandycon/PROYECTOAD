-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 07-11-2019 a las 22:28:11
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `Obtenerdevoluciones` ()  BEGIN
     
    SELECT * FROM devoluciones;
     
    END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(26) NOT NULL,
  `apellido1` varchar(26) NOT NULL,
  `apellido2` varchar(26) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `devoluciones`
--

CREATE TABLE `devoluciones` (
  `libro` varchar(13) COLLATE latin1_spanish_ci NOT NULL,
  `alumno` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `fechadevol` date NOT NULL,
  `estado` varchar(13) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `isbn` varchar(13) NOT NULL,
  `titulo` varchar(26) NOT NULL,
  `autor` varchar(26) NOT NULL,
  `editorial` varchar(26) NOT NULL,
  `asignatura` varchar(26) NOT NULL,
  `estado` varchar(26) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE `prestamos` (
  `alumno` varchar(9) NOT NULL,
  `libro` varchar(13) NOT NULL,
  `fechapres` date NOT NULL,
  `fechadevol` date NOT NULL,
  `estado` varchar(26) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`dni`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`isbn`),
  ADD UNIQUE KEY `isbn` (`isbn`),
  ADD UNIQUE KEY `isbn_2` (`isbn`),
  ADD UNIQUE KEY `isbn_3` (`isbn`),
  ADD UNIQUE KEY `isbn_4` (`isbn`),
  ADD UNIQUE KEY `isbn_5` (`isbn`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`alumno`,`libro`),
  ADD KEY `libro` (`libro`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `prestamos_ibfk_1` FOREIGN KEY (`alumno`) REFERENCES `alumnos` (`dni`),
  ADD CONSTRAINT `prestamos_ibfk_2` FOREIGN KEY (`libro`) REFERENCES `libros` (`isbn`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
