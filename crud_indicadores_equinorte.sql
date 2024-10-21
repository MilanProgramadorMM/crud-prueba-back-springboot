-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 21-10-2024 a las 07:18:08
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
-- Base de datos: `crud_indicadores_equinorte`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_medicion`
--

CREATE TABLE `historial_medicion` (
  `id` int(11) NOT NULL,
  `id_indicador` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `valor_medido` decimal(10,2) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historial_medicion`
--

INSERT INTO `historial_medicion` (`id`, `id_indicador`, `fecha`, `valor_medido`, `descripcion`) VALUES
(1, 1, '2024-10-01', 4447.00, 'Medición diaria de producción'),
(2, 1, '2024-10-02', 55.00, 'Medición diaria de producción'),
(3, 1, '2024-10-03', 105.00, 'Medición diaria de producción'),
(4, 2, '2024-10-01', 60.00, 'Medición diaria de ventas'),
(5, 2, '2024-10-02', 75.00, 'Medición diaria de ventas'),
(6, 3, '2024-10-01', 20.00, 'Medición diaria de calidad');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `indicador`
--

CREATE TABLE `indicador` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `valor_minimo` decimal(10,2) NOT NULL,
  `valor_esperado` decimal(10,2) NOT NULL,
  `valor_maximo` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `indicador`
--

INSERT INTO `indicador` (`id`, `nombre`, `valor_minimo`, `valor_esperado`, `valor_maximo`) VALUES
(1, 'Indicador de Producción', 50.00, 80.00, 100.00),
(2, 'Indicador de Ventas', 30.00, 70.00, 90.00),
(3, 'Indicador de Calidad', 10.00, 25.00, 40.00),
(4, 'Indicador de Ejemplo', 10.50, 20.00, 30.50),
(5, 'Indicador de prueba 1', 10.00, 20.00, 50.00),
(6, 'Indicador de prueba 2', 42.13, 50.00, 100.00);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `historial_medicion`
--
ALTER TABLE `historial_medicion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_indicador` (`id_indicador`);

--
-- Indices de la tabla `indicador`
--
ALTER TABLE `indicador`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `historial_medicion`
--
ALTER TABLE `historial_medicion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `indicador`
--
ALTER TABLE `indicador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historial_medicion`
--
ALTER TABLE `historial_medicion`
  ADD CONSTRAINT `fk_indicador` FOREIGN KEY (`id_indicador`) REFERENCES `indicador` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
