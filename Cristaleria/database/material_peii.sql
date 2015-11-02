-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-11-2015 a las 19:50:06
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `material_peii`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `idCategoria` int(11) NOT NULL,
  `nombreCategoria` varchar(100) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciclo`
--

CREATE TABLE IF NOT EXISTS `ciclo` (
  `idCiclo` int(11) NOT NULL,
  `anhoCiclo` int(11) NOT NULL,
  `numeroCiclo` int(11) NOT NULL,
  PRIMARY KEY (`idCiclo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE IF NOT EXISTS `marca` (
  `idMarca` int(11) NOT NULL AUTO_INCREMENT,
  `nombreMarca` varchar(100) NOT NULL,
  PRIMARY KEY (`idMarca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material`
--

CREATE TABLE IF NOT EXISTS `material` (
  `idMaterial` int(11) NOT NULL AUTO_INCREMENT,
  `nombreMaterial` varchar(100) NOT NULL,
  `idMarca` int(11) NOT NULL,
  `idCiclo` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `idTipoMaterial` int(11) NOT NULL,
  `fechaEntrada` int(11) NOT NULL,
  `fechaDesecho` int(11) DEFAULT NULL,
  `estado` int(11) NOT NULL,
  `detalleEntrada` varchar(200) DEFAULT NULL,
  `detalleSalida` varchar(200) DEFAULT NULL,
  `ubicacion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idMaterial`),
  UNIQUE KEY `idMarca` (`idMarca`),
  UNIQUE KEY `idCiclo` (`idCiclo`),
  UNIQUE KEY `idProveedor` (`idProveedor`),
  UNIQUE KEY `idTipoMaterial` (`idTipoMaterial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `porveedor`
--

CREATE TABLE IF NOT EXISTS `porveedor` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombreProveedor` varchar(100) NOT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE IF NOT EXISTS `prestamo` (
  `idPrestamo` int(11) NOT NULL,
  `idTipoPrestamo` int(11) NOT NULL,
  `prestadoA` varchar(100) NOT NULL,
  `fechaPrestamo` datetime NOT NULL,
  `fechaDevuelto` int(11) NOT NULL,
  `razonPrestamo` varchar(200) NOT NULL,
  `idMaterial` int(11) NOT NULL,
  `idCiclo` int(11) NOT NULL,
  PRIMARY KEY (`idPrestamo`),
  UNIQUE KEY `idTipoPrestamo` (`idTipoPrestamo`),
  UNIQUE KEY `idMaterial` (`idMaterial`),
  UNIQUE KEY `idCiclo` (`idCiclo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subcategoria`
--

CREATE TABLE IF NOT EXISTS `subcategoria` (
  `idSubCategoria` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `nombreSubCategoria` varchar(100) NOT NULL,
  PRIMARY KEY (`idSubCategoria`),
  UNIQUE KEY `idCategoria` (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipomaterial`
--

CREATE TABLE IF NOT EXISTS `tipomaterial` (
  `idTipoMaterial` int(11) NOT NULL AUTO_INCREMENT,
  `idSubCategoria` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idTipoMaterial`),
  UNIQUE KEY `idSubCategoria` (`idSubCategoria`),
  UNIQUE KEY `idCategoria` (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoprestamo`
--

CREATE TABLE IF NOT EXISTS `tipoprestamo` (
  `idTipoPrestamo` int(11) NOT NULL,
  `nombreTipo` varchar(100) NOT NULL,
  PRIMARY KEY (`idTipoPrestamo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `material`
--
ALTER TABLE `material`
  ADD CONSTRAINT `FK_Material_Marca` FOREIGN KEY (`idMarca`) REFERENCES `marca` (`idMarca`),
  ADD CONSTRAINT `FK_Material_TipoMaterial` FOREIGN KEY (`idTipoMaterial`) REFERENCES `tipomaterial` (`idTipoMaterial`),
  ADD CONSTRAINT `FK_Materia_Ciclo` FOREIGN KEY (`idCiclo`) REFERENCES `ciclo` (`idCiclo`),
  ADD CONSTRAINT `FK_Materia_Proveedor` FOREIGN KEY (`idProveedor`) REFERENCES `porveedor` (`idProveedor`);

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `FK_Prestamo_Ciclo` FOREIGN KEY (`idCiclo`) REFERENCES `ciclo` (`idCiclo`),
  ADD CONSTRAINT `FK_Prestamo_Material` FOREIGN KEY (`idMaterial`) REFERENCES `material` (`idMaterial`),
  ADD CONSTRAINT `FK_Prestamo_TipoPrestamo` FOREIGN KEY (`idTipoPrestamo`) REFERENCES `tipoprestamo` (`idTipoPrestamo`);

--
-- Filtros para la tabla `subcategoria`
--
ALTER TABLE `subcategoria`
  ADD CONSTRAINT `FK_SubCategoria_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`);

--
-- Filtros para la tabla `tipomaterial`
--
ALTER TABLE `tipomaterial`
  ADD CONSTRAINT `FK_TipoMaterial_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`),
  ADD CONSTRAINT `FK_TipoMaterial_SubCategoria` FOREIGN KEY (`idSubCategoria`) REFERENCES `subcategoria` (`idSubCategoria`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
