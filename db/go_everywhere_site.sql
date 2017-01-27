-- phpMyAdmin SQL Dump
-- version 4.6.5.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 27, 2017 at 01:56 PM
-- Server version: 10.1.20-MariaDB
-- PHP Version: 7.0.15

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
-- Table structure for table `chattable`
--

CREATE TABLE `chattable` (
  `id` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chattable`
--

INSERT INTO `chattable` (`id`) VALUES
(1),
(2);

-- --------------------------------------------------------

--
-- Table structure for table `chat_line`
--

CREATE TABLE `chat_line` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `chat_room_id` bigint(20) UNSIGNED NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `text` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chat_line`
--

INSERT INTO `chat_line` (`id`, `chat_room_id`, `timestamp`, `text`) VALUES
(1, 1, '2017-01-27 13:52:49', 'room blabla'),
(2, 2, '2017-01-27 13:52:49', 'game blabla');

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
(1, 'Room chat'),
(2, 'Game chat');

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

CREATE TABLE `game` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `chattable_id` bigint(20) UNSIGNED NOT NULL,
  `room_id` bigint(20) UNSIGNED NOT NULL,
  `player_white_id` bigint(20) UNSIGNED NOT NULL,
  `player_black_id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `status` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `time_rules` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `board_width` int(11) NOT NULL,
  `board_height` int(11) NOT NULL,
  `handicap` int(11) DEFAULT NULL,
  `komi` float NOT NULL,
  `result` char(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `moves` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `game`
--

INSERT INTO `game` (`id`, `chattable_id`, `room_id`, `player_white_id`, `player_black_id`, `name`, `type`, `status`, `time_rules`, `board_width`, `board_height`, `handicap`, `komi`, `result`, `moves`) VALUES
(1, 2, 1, 1, 2, NULL, 'a', 'b', 'ccc', 19, 19, NULL, 6.5, NULL, 'potezi');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `chattable_id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`id`, `chattable_id`, `name`) VALUES
(1, 1, 'Test room');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `facebook_id` bigint(20) UNSIGNED NOT NULL,
  `display_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `go_rank` char(4) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `facebook_id`, `display_name`, `email`, `go_rank`) VALUES
(1, 123, 'UserA', 'email@email.com', NULL),
(2, 456, 'UserB', 'email@email.com', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chattable`
--
ALTER TABLE `chattable`
  ADD PRIMARY KEY (`id`);

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
  ADD KEY `chattable_id` (`chattable_id`),
  ADD KEY `room_id` (`room_id`),
  ADD KEY `player_white_id` (`player_white_id`),
  ADD KEY `player_black_id` (`player_black_id`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`),
  ADD KEY `chattable_id` (`chattable_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chattable`
--
ALTER TABLE `chattable`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `chat_line`
--
ALTER TABLE `chat_line`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `game`
--
ALTER TABLE `game`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `chat_line`
--
ALTER TABLE `chat_line`
  ADD CONSTRAINT `chat_line_ibfk_1` FOREIGN KEY (`chat_room_id`) REFERENCES `chat_room` (`id`);

--
-- Constraints for table `chat_room`
--
ALTER TABLE `chat_room`
  ADD CONSTRAINT `chat_room_ibfk_1` FOREIGN KEY (`id`) REFERENCES `chattable` (`id`);

--
-- Constraints for table `game`
--
ALTER TABLE `game`
  ADD CONSTRAINT `game_ibfk_1` FOREIGN KEY (`chattable_id`) REFERENCES `chattable` (`id`),
  ADD CONSTRAINT `game_ibfk_2` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  ADD CONSTRAINT `game_ibfk_3` FOREIGN KEY (`player_white_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `game_ibfk_4` FOREIGN KEY (`player_black_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `room_ibfk_1` FOREIGN KEY (`chattable_id`) REFERENCES `chattable` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
