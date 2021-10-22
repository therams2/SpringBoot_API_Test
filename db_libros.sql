-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-10-2021 a las 19:31:11
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.3.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_libros`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentarios`
--

CREATE TABLE `comentarios` (
  `id` int(11) NOT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  `reseña_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `comentarios`
--

INSERT INTO `comentarios` (`id`, `comentario`, `reseña_id`, `usuario_id`) VALUES
(1, 'Comparto la misma opinión, excelente', 1, 2),
(2, 'Muy acertada la reseña, felicidades', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `id` int(11) NOT NULL,
  `fecha_publicacion` date DEFAULT NULL,
  `portada` varchar(255) DEFAULT NULL,
  `sinopsis` text DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`id`, `fecha_publicacion`, `portada`, `sinopsis`, `titulo`) VALUES
(1, '1956-05-31', 'pedroparamo.jpg', 'Pedro Páramo es una de las obras maestras de la literatura hispanoamericana. La novela cuenta cómo el protagonista, Juan Preciado, va en busca de su padre, Pedro Páramo, hasta el pueblo mexicano de Comala, un lugar vacio, misterioso, sin vida. Allí, el joven descubrirá que toda la gente del pueblo se llama Páramo, que muchos de ellos son sus propios hermanos, y que Pedro Páramo está muerto. Estamos, pues, ante una novela misteriosa y fantástica cuya atmósfera envuelve al lector y los transporta a un territorio mágico de sorprendentes ramificaciones.', 'Pedro Páramo'),
(2, '1915-09-30', 'metamorfosis.jpg', 'La metamorfosis es un relato dividido en tres partes, donde se narra la transformación de Gregorio Samsa, un viajante de comercio de telas, en un monstruoso insecto, y el impacto que tendrá este acontecimiento no solo en su vida, sino en la de su familia.', 'La metamorfosis'),
(3, '1941-12-31', 'elextranjero.jpg', 'Extranjero en su tierra, extranjero de sí mismo, Meursault vive una angustiosa situación. Íntimamente ajeno al alcance moral de sus actos, llega a asesinar, a la prisión, al patíbulo, y no hay para él, en este inevitable proceso, ni rebeldía ni esperanza. En estas páginas magistrales, el realismo logra la perfección: Meursault nos refiere su historia, no la de sus razones y sentimientos, sino la de su imposible destino. Novelista, dramaturgo y ensayista, Albert Camus nació en Orán (Argelia) en 1912. Estudió en África del Norte y trabajó en distintas actividades hasta convertirse en periodista. El extranjero empezó a gestarse, según parece, en 1937, mientras Camus convalecía en un sanatorio de una tuberculosis recurrente, y lo terminó en 1940. El libro fue publicado dos años después. Durante la resistencia, Camus dirigió el periódico Combat. Fue asesor literario de la editorial Gallimard. Recibió el Premio Nobel de Literatura en el año 1957. Su trágica muerte en un accidente, en 1960, interrumpió prematuramente una brillante carrera literaria en la que se destacan también El hombre rebelde, La peste y El mito de Sísifo.', 'El extranjero'),
(4, '1965-12-31', 'lacasaverde.jpg', 'Novela ejemplar en la historia del boom latinoamericano, La Casa Verde es una experiencia ineludible para todo aquel que quiera conocer en profundidad la obra narrativa del Premio Nobel de Literatura 2010 y Príncipe de Asturias de las Letras, Mario Vargas Llosa.¿Cuál es el secreto que encierra La casa verde?La Casa Verde ocurre en dos lugares muy alejados entre sí: Piura, en el desierto del litoral peruano, y Santa María de Nieva, una factoría y misión religiosa perdida en el corazón de la Amazonía. Símbolo de la historia es la mítica casa de placer que don Anselmo, el forastero, erige en las afueras de Piura.La Casa Verde (1965) recibió al año siguiente de su publicación el Premio de la Crítica y, en 1967, el Premio Internacional de Literatura Rómulo Gallegos a la mejor novela en lengua española.Julio Cortázar dijo...', 'La casa verde'),
(5, '1992-12-31', 'mitadsiniestra.jpg', 'Thad Beaumont es el protagonista de La mitad siniestra, un escritor que durante años publicó bajo el seudónimo de George Stark varias novelas de terror. Incluso escribió para la revista People una biografía más o menos aterradora de Stark que entusiasmó a los admiradores de su alter ego. Pero ahora rico, feliz, con una atractiva esposa y padre de dos gemelos, Beaumont no necesita ya a su doble en su ascendente carrera literaria, y decide enterrarlo. Sólo que de súbito, y de una manera brutal, descubrirá que no es nada fácil deshacerse del sombrío fantasma que ha creado. En el pequeño pueblo de Castle Rock, en Maine, donde Beaumont y su esposa tienen una casa de verano, el sheriff Alan Pangborn investiga un crimen de sadismo ejemplar, sólo comparable a las delirantes imaginaciones con que Stark se complacía en sus novelas. En el lugar, la policía encuentra también un verdadero mural de sangre con las huellas dactilares del homicida y, además, idénticas a las de That Beaumont. La pesadilla ha comenzado y oscuras fuerzas se ciernen sobre Castle Rock, ¿de dónde vienen? Aquí está la mitad siniestra, una historia tan real y fascinante que las legiones cada vez más numerosas de lectores de Stephen King verán renacer sus más recónditas emociones bajo el dominio -y los demonios- del maestro. Este retrato del lado oscuro del sueño americano les helará la sangre y paralizará su corazón, pero lo disfrutarán como ningún otro.', 'La mitad siniestra');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reseñas`
--

CREATE TABLE `reseñas` (
  `id` int(11) NOT NULL,
  `reseña` text DEFAULT NULL,
  `libro_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reseñas`
--

INSERT INTO `reseñas` (`id`, `reseña`, `libro_id`, `usuario_id`) VALUES
(1, 'Excelente libro, me encanto demasiado.  Un pequeño punto dentro de la inmensidad infinita de la galaxia. La angustia existencial y el dolor que tales afirmaciones pueden provocar parecen no tener fin. No en vano, la ansiedad y los trastornos psicológicos son la verdadera pandemia del nuevo siglo que acabamos de traspasar.\r\n', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `email`, `password`, `username`) VALUES
(1, 'javi@gmail.com', '$argon2id$v=19$m=1024,t=1,p=1$dOCcVqwg0o+Q35jk9AlK8A$enHKfwlXcgUSpL6qTQKNgI4LgWZwMy7rsGib33L4sjo', 'Javier'),
(2, 'sergio@kiritek.com', '$argon2id$v=19$m=1024,t=1,p=1$yCZ6Yr8YWvC5Bj7nPyh+yQ$+LRamKsk0M/ZtdIUFrXgOM4e2w+A1ihdHQHRjKJSbTw', 'Sergio');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgws9i4xip5cjgvkfjfq7lyy36` (`reseña_id`),
  ADD KEY `FKdts62yj83qe3k748cgcjvm48r` (`usuario_id`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `reseñas`
--
ALTER TABLE `reseñas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK44gvbdvrll74ucy231mnk3vob` (`libro_id`),
  ADD KEY `FK92h2cha4pwwlts8fwp7asjwh5` (`usuario_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_kfsp0s1tflm1cwlj8idhqsad0` (`email`) USING HASH;

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `libros`
--
ALTER TABLE `libros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `reseñas`
--
ALTER TABLE `reseñas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
