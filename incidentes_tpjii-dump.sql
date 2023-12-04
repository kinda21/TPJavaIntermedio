-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-12-2023 a las 10:33:36
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `incidentes_tpjii`
--
CREATE DATABASE IF NOT EXISTS `incidentes_tpjii` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `incidentes_tpjii`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL,
  `cuit` int(11) DEFAULT NULL,
  `razon_social` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `cuit`, `razon_social`) VALUES
(1, 214556841, 'terrabusi'),
(2, 214556852, 'taragui'),
(3, 214556893, 'sc Johnson'),
(4, 214556814, 'Coop soda chicho');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_servicio`
--

CREATE TABLE `cliente_servicio` (
  `id_servicio` bigint(20) NOT NULL,
  `id_cliente` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente_servicio`
--

INSERT INTO `cliente_servicio` (`id_servicio`, `id_cliente`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 1),
(2, 2),
(2, 3),
(3, 1),
(3, 2),
(4, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE `especialidad` (
  `id_especialidad` bigint(20) NOT NULL,
  `nombre_especialidad` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `especialidad`
--

INSERT INTO `especialidad` (`id_especialidad`, `nombre_especialidad`) VALUES
(1, 'Network'),
(2, 'Troubleshooting'),
(3, 'Config'),
(4, 'Miscelaneo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidente`
--

CREATE TABLE `incidente` (
  `id` bigint(20) NOT NULL,
  `consideraciones` varchar(255) DEFAULT NULL,
  `descripcion_incidente` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha_ingreso` datetime(6) DEFAULT NULL,
  `fecha_resolucion_estimada` datetime(6) DEFAULT NULL,
  `fecha_resolucion_final` datetime(6) DEFAULT NULL,
  `tiempo_extra_enHS` int(11) DEFAULT NULL,
  `cliente_id` bigint(20) DEFAULT NULL,
  `servicio_id` bigint(20) DEFAULT NULL,
  `tecnico_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `incidente`
--

INSERT INTO `incidente` (`id`, `consideraciones`, `descripcion_incidente`, `estado`, `fecha_ingreso`, `fecha_resolucion_estimada`, `fecha_resolucion_final`, `tiempo_extra_enHS`, `cliente_id`, `servicio_id`, `tecnico_id`) VALUES
(1, NULL, 'rip tango', 'CREADO', '2023-12-04 06:28:52.000000', '2023-12-09 14:28:52.000000', NULL, 120, 4, 1, 1),
(2, NULL, 'complejo, tiene 2 problemas crashea o dice token invalido', 'EN_PROGRESO', '2023-12-04 06:28:52.000000', '2023-12-26 04:28:52.000000', NULL, 480, 4, 2, 2),
(3, 'Bug legitimo. Mas dificil de lo esperado hubo que reescribir codigo.', 'ERROR FILTROS', 'RESUELTO', '2023-12-04 06:28:52.000000', '2023-12-04 12:28:52.000000', '2023-12-14 06:28:52.000000', 0, 3, 1, 3),
(4, 'tiempo record, lo encontro en un txt', 'Un boludo se olvido el usuario Y la contraseña', 'RESUELTO', '2023-12-04 06:28:52.000000', '2023-12-04 18:28:52.000000', '2023-12-09 06:28:52.000000', 0, 3, 4, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidentes_especialidad`
--

CREATE TABLE `incidentes_especialidad` (
  `incidente_id` bigint(20) NOT NULL,
  `especialidad_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `incidentes_especialidad`
--

INSERT INTO `incidentes_especialidad` (`incidente_id`, `especialidad_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 2),
(4, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidente_problema`
--

CREATE TABLE `incidente_problema` (
  `Incidente_id` bigint(20) NOT NULL,
  `problemas_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `incidente_problema`
--

INSERT INTO `incidente_problema` (`Incidente_id`, `problemas_id`) VALUES
(1, 1),
(2, 2),
(2, 6),
(3, 3),
(4, 4),
(4, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plataforma`
--

CREATE TABLE `plataforma` (
  `id` bigint(20) NOT NULL,
  `nombre_plataforma` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `plataforma`
--

INSERT INTO `plataforma` (`id`, `nombre_plataforma`) VALUES
(1, 'Windows'),
(2, 'Linux Ubuntu'),
(3, 'Mac OS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `problema`
--

CREATE TABLE `problema` (
  `id` bigint(20) NOT NULL,
  `descripcion_problema` varchar(255) DEFAULT NULL,
  `tiempoenHS_estimado` int(11) DEFAULT NULL,
  `incidente_id` bigint(20) DEFAULT NULL,
  `tipoProblema_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `problema`
--

INSERT INTO `problema` (`id`, `descripcion_problema`, `tiempoenHS_estimado`, `incidente_id`, `tipoProblema_id`) VALUES
(1, 'al intentar obtener los asientos contables salta un cartel que dice conexión fallida', 8, 1, 1),
(2, 'despues de ingresar mi usuario y contraseña aparece un error que dice Token invalido', 14, 2, 2),
(3, 'intento filtrar los spreadsheet por fecha y monto y salta una excepcion', 6, 3, 3),
(4, 'me olvide el usuario y se lockeo el login', 6, 4, 4),
(5, 'olvide la contraseña y se lockeo el login', 6, 4, 5),
(6, 'al intentar abrir la aplicación crashea', 32, 2, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `id` bigint(20) NOT NULL,
  `nombre_servicio` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`id`, `nombre_servicio`) VALUES
(1, 'Tango'),
(2, 'SAP'),
(3, 'Moodle'),
(4, 'vBulletin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio_plataforma`
--

CREATE TABLE `servicio_plataforma` (
  `id_servicio` bigint(20) NOT NULL,
  `id_plataforma` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `servicio_plataforma`
--

INSERT INTO `servicio_plataforma` (`id_servicio`, `id_plataforma`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 2),
(2, 3),
(3, 1),
(3, 1),
(4, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tecnico`
--

CREATE TABLE `tecnico` (
  `id` bigint(20) NOT NULL,
  `legajo` bigint(20) DEFAULT NULL,
  `medio_notificacion` varchar(255) DEFAULT NULL,
  `nombre_tecnico` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tecnico`
--

INSERT INTO `tecnico` (`id`, `legajo`, `medio_notificacion`, `nombre_tecnico`) VALUES
(1, 33125, 'e-mail', 'pancho'),
(2, 11125, 'whatsapp', 'pancho'),
(3, 48125, 'e-mail', 'jose'),
(4, 18455, 'whatsapp', 'tomas'),
(5, 2245, 'whatsapp', 'capo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tecnico_especialidad`
--

CREATE TABLE `tecnico_especialidad` (
  `Tecnico_id` bigint(20) NOT NULL,
  `especialidades_id_especialidad` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tecnico_especialidad`
--

INSERT INTO `tecnico_especialidad` (`Tecnico_id`, `especialidades_id_especialidad`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 1),
(4, 2),
(5, 1),
(5, 2),
(5, 3),
(5, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoproblema`
--

CREATE TABLE `tipoproblema` (
  `id` bigint(20) NOT NULL,
  `nombre_tipo` varchar(255) DEFAULT NULL,
  `tiempoenHS_maxResolucion` int(11) DEFAULT NULL,
  `id_especialidad_problema` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipoproblema`
--

INSERT INTO `tipoproblema` (`id`, `nombre_tipo`, `tiempoenHS_maxResolucion`, `id_especialidad_problema`) VALUES
(1, 'Conexion Fallida', 8, 1),
(2, 'Token invalido', 14, 2),
(3, 'Problemas con filtros', 6, 3),
(4, 'Usuario incorrecto', 6, 2),
(5, 'Contraseña olvidada', 6, 4),
(6, 'Error al iniciar', 32, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cliente_servicio`
--
ALTER TABLE `cliente_servicio`
  ADD KEY `FK5wgpabf0psvu898tclgg2ev7a` (`id_cliente`),
  ADD KEY `FK5bqs9vk7o105vfv50cpablvk6` (`id_servicio`);

--
-- Indices de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`id_especialidad`);

--
-- Indices de la tabla `incidente`
--
ALTER TABLE `incidente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9op4o91f9rohjayhvctjxde9x` (`cliente_id`),
  ADD KEY `FKb0t8ap55daymocw1o9brcguu7` (`servicio_id`),
  ADD KEY `FK7aqbn77r6kjypgxw0d2nc20ts` (`tecnico_id`);

--
-- Indices de la tabla `incidentes_especialidad`
--
ALTER TABLE `incidentes_especialidad`
  ADD KEY `FKg1xd2ahpdnb4emi030sy048g3` (`especialidad_id`),
  ADD KEY `FKoi2pvyku94x8ot2dxy941y18x` (`incidente_id`);

--
-- Indices de la tabla `incidente_problema`
--
ALTER TABLE `incidente_problema`
  ADD UNIQUE KEY `UK_pvq85h6kiudsricik2xtgs27w` (`problemas_id`),
  ADD KEY `FKc8cbwb99ft3jld9y0lhte3rap` (`Incidente_id`);

--
-- Indices de la tabla `plataforma`
--
ALTER TABLE `plataforma`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `problema`
--
ALTER TABLE `problema`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmii7359gvdkrgxsq3g6b1syoj` (`incidente_id`),
  ADD KEY `FK3ec0pwfu3cs940p8vh2r8u7o3` (`tipoProblema_id`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `servicio_plataforma`
--
ALTER TABLE `servicio_plataforma`
  ADD KEY `FKjqf3h8po56nm4xueji9aqadmg` (`id_plataforma`),
  ADD KEY `FK5v3bxbanjkqvj5263l6xun789` (`id_servicio`);

--
-- Indices de la tabla `tecnico`
--
ALTER TABLE `tecnico`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tecnico_especialidad`
--
ALTER TABLE `tecnico_especialidad`
  ADD KEY `FK1dc1f0hvvjdknw6f7ibhyu0x6` (`especialidades_id_especialidad`),
  ADD KEY `FKlb79rqr6lvsf6qch2shktqrud` (`Tecnico_id`);

--
-- Indices de la tabla `tipoproblema`
--
ALTER TABLE `tipoproblema`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3w4n8i23xi5orqhlb0ql7mpjv` (`id_especialidad_problema`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  MODIFY `id_especialidad` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `incidente`
--
ALTER TABLE `incidente`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `plataforma`
--
ALTER TABLE `plataforma`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `problema`
--
ALTER TABLE `problema`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tecnico`
--
ALTER TABLE `tecnico`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tipoproblema`
--
ALTER TABLE `tipoproblema`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente_servicio`
--
ALTER TABLE `cliente_servicio`
  ADD CONSTRAINT `FK5bqs9vk7o105vfv50cpablvk6` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id`),
  ADD CONSTRAINT `FK5wgpabf0psvu898tclgg2ev7a` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`);

--
-- Filtros para la tabla `incidente`
--
ALTER TABLE `incidente`
  ADD CONSTRAINT `FK7aqbn77r6kjypgxw0d2nc20ts` FOREIGN KEY (`tecnico_id`) REFERENCES `tecnico` (`id`),
  ADD CONSTRAINT `FK9op4o91f9rohjayhvctjxde9x` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FKb0t8ap55daymocw1o9brcguu7` FOREIGN KEY (`servicio_id`) REFERENCES `servicio` (`id`);

--
-- Filtros para la tabla `incidentes_especialidad`
--
ALTER TABLE `incidentes_especialidad`
  ADD CONSTRAINT `FKg1xd2ahpdnb4emi030sy048g3` FOREIGN KEY (`especialidad_id`) REFERENCES `especialidad` (`id_especialidad`),
  ADD CONSTRAINT `FKoi2pvyku94x8ot2dxy941y18x` FOREIGN KEY (`incidente_id`) REFERENCES `incidente` (`id`);

--
-- Filtros para la tabla `incidente_problema`
--
ALTER TABLE `incidente_problema`
  ADD CONSTRAINT `FKacwo7fw0t3rntwo4m63kg4ev2` FOREIGN KEY (`problemas_id`) REFERENCES `problema` (`id`),
  ADD CONSTRAINT `FKc8cbwb99ft3jld9y0lhte3rap` FOREIGN KEY (`Incidente_id`) REFERENCES `incidente` (`id`);

--
-- Filtros para la tabla `problema`
--
ALTER TABLE `problema`
  ADD CONSTRAINT `FK3ec0pwfu3cs940p8vh2r8u7o3` FOREIGN KEY (`tipoProblema_id`) REFERENCES `tipoproblema` (`id`),
  ADD CONSTRAINT `FKmii7359gvdkrgxsq3g6b1syoj` FOREIGN KEY (`incidente_id`) REFERENCES `incidente` (`id`);

--
-- Filtros para la tabla `servicio_plataforma`
--
ALTER TABLE `servicio_plataforma`
  ADD CONSTRAINT `FK5v3bxbanjkqvj5263l6xun789` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id`),
  ADD CONSTRAINT `FKjqf3h8po56nm4xueji9aqadmg` FOREIGN KEY (`id_plataforma`) REFERENCES `plataforma` (`id`);

--
-- Filtros para la tabla `tecnico_especialidad`
--
ALTER TABLE `tecnico_especialidad`
  ADD CONSTRAINT `FK1dc1f0hvvjdknw6f7ibhyu0x6` FOREIGN KEY (`especialidades_id_especialidad`) REFERENCES `especialidad` (`id_especialidad`),
  ADD CONSTRAINT `FKlb79rqr6lvsf6qch2shktqrud` FOREIGN KEY (`Tecnico_id`) REFERENCES `tecnico` (`id`);

--
-- Filtros para la tabla `tipoproblema`
--
ALTER TABLE `tipoproblema`
  ADD CONSTRAINT `FK3w4n8i23xi5orqhlb0ql7mpjv` FOREIGN KEY (`id_especialidad_problema`) REFERENCES `especialidad` (`id_especialidad`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
