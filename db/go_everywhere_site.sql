-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 21, 2017 at 11:27 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `go_everywhere_site`
--

-- --------------------------------------------------------

--
-- Table structure for table `chat_line`
--

CREATE TABLE `chat_line` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `chat_room_id` bigint(20) UNSIGNED NOT NULL,
  `line_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `text` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chat_line`
--

INSERT INTO `chat_line` (`id`, `chat_room_id`, `line_datetime`, `text`) VALUES
(1, 2, '2017-02-11 16:40:55', 'cao'),
(2, 2, '2017-02-11 16:40:57', 'cao'),
(3, 2, '2017-02-11 16:40:59', 'cao'),
(4, 2, '2017-02-11 16:41:21', 'cao'),
(5, 2, '2017-02-11 16:41:22', 'cao'),
(6, 2, '2017-02-12 19:20:54', 'yyy'),
(7, 2, '2017-02-12 19:26:33', 'ggg'),
(8, 2, '2017-02-13 17:54:41', 'sss'),
(9, 2, '2017-02-13 17:54:42', 'sss'),
(10, 2, '2017-02-14 18:32:26', 'm');

-- --------------------------------------------------------

--
-- Table structure for table `chat_room`
--

CREATE TABLE `chat_room` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chat_room`
--

INSERT INTO `chat_room` (`id`, `name`) VALUES
(1, 'test'),
(2, 'lobby'),
(3, 'english'),
(4, 'french'),
(5, 'korean');

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

CREATE TABLE `game` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `chat_room_id` bigint(20) UNSIGNED NOT NULL,
  `room_id` bigint(20) UNSIGNED NOT NULL,
  `player_white_id` bigint(20) UNSIGNED DEFAULT NULL,
  `player_black_id` bigint(20) UNSIGNED DEFAULT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `status` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `time_rules` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `board_width` int(11) NOT NULL,
  `board_height` int(11) NOT NULL,
  `handicap` int(11) DEFAULT NULL,
  `komi` float NOT NULL,
  `result` char(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `moves` text COLLATE utf8_unicode_ci NOT NULL,
  `min_rank` char(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `max_rank` char(4) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `game`
--

INSERT INTO `game` (`id`, `chat_room_id`, `room_id`, `player_white_id`, `player_black_id`, `name`, `type`, `status`, `time_rules`, `board_width`, `board_height`, `handicap`, `komi`, `result`, `moves`, `min_rank`, `max_rank`) VALUES
(2, 1, 1, NULL, 1, 'nebitno nesto', '1', 'n', 'bla', 9, 9, NULL, 10, NULL, '', NULL, NULL),
(4, 1, 1, NULL, 3, 'game 2', 'r', 'n', 'n', 13, 13, NULL, 1, NULL, '', NULL, NULL),
(6, 1, 1, NULL, 1, 'igra 4', 'r', 'n', 'BY | 01:00 | 5 X 00:20', 13, 13, 1, 1, NULL, '', NULL, NULL),
(7, 1, 1, 2, 3, 'igra 4', 'r', 's', 'BY|300|4x30', 19, 19, NULL, 1, NULL, '', NULL, NULL),
(8, 1, 1, 2, 2, 'igra 6', 'r', 's', 'BY|7000|3x40', 9, 9, 1, 2, NULL, '', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `go_rank` char(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `domain` char(3) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`id`, `user_id`, `name`, `go_rank`, `domain`) VALUES
(1, 1, 'Martina', '25', 'nbt'),
(2, 2, 'nemanja', NULL, 'nbt'),
(3, 3, 'Name', NULL, 'GOE');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `chat_room_id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `private` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`id`, `chat_room_id`, `name`, `private`) VALUES
(1, 1, 'soba 1', 0),
(2, 3, 'english', 0),
(3, 4, 'french', 0),
(4, 5, 'korean', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `facebook_id` bigint(20) UNSIGNED DEFAULT NULL,
  `display_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `facebook_id`, `display_name`, `email`) VALUES
(1, NULL, 'maca', 'm@m.m'),
(2, NULL, 'Nemanja', 'n@n.n'),
(3, 1, 'Name', 'email@site.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chat_line`
--
ALTER TABLE `chat_line`
  ADD PRIMARY KEY (`id`),
  ADD KEY `chat_room_id` (`chat_room_id`);

--
-- Indexes for table `chat_room`
--
ALTER TABLE `chat_room`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`id`),
  ADD KEY `room_id` (`room_id`),
  ADD KEY `game_ibfk_3` (`player_white_id`),
  ADD KEY `game_ibfk_4` (`player_black_id`),
  ADD KEY `chat_room_id` (`chat_room_id`);

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`),
  ADD KEY `chat_room_id` (`chat_room_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chat_line`
--
ALTER TABLE `chat_line`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `chat_room`
--
ALTER TABLE `chat_room`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `game`
--
ALTER TABLE `game`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `chat_line`
--
ALTER TABLE `chat_line`
  ADD CONSTRAINT `chat_line_ibfk_1` FOREIGN KEY (`chat_room_id`) REFERENCES `chat_room` (`id`);

--
-- Constraints for table `game`
--
ALTER TABLE `game`
  ADD CONSTRAINT `game_ibfk_2` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  ADD CONSTRAINT `game_ibfk_3` FOREIGN KEY (`player_white_id`) REFERENCES `player` (`id`),
  ADD CONSTRAINT `game_ibfk_4` FOREIGN KEY (`player_black_id`) REFERENCES `player` (`id`),
  ADD CONSTRAINT `game_ibfk_5` FOREIGN KEY (`chat_room_id`) REFERENCES `chat_room` (`id`);

--
-- Constraints for table `player`
--
ALTER TABLE `player`
  ADD CONSTRAINT `player_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `room_ibfk_1` FOREIGN KEY (`chat_room_id`) REFERENCES `chat_room` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
