-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 10 déc. 2019 à 09:21
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `escalade`
--

-- --------------------------------------------------------

--
-- Structure de la table `awaiting_topo`
--

DROP TABLE IF EXISTS `awaiting_topo`;
CREATE TABLE IF NOT EXISTS `awaiting_topo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `memberId` int(11) NOT NULL,
  `buyerId` int(11) NOT NULL,
  `topoId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `rundown_reserved_rundown_fk` (`topoId`),
  KEY `user_reserved_rundown_fk` (`memberId`),
  KEY `buyer_awaiting_topo_fk` (`buyerId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) CHARACTER SET utf8 NOT NULL,
  `comment` text CHARACTER SET utf8 NOT NULL,
  `siteId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `site_commentary_fk` (`siteId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- --------------------------------------------------------

--
-- Structure de la table `member`
--

DROP TABLE IF EXISTS `member`;
CREATE TABLE IF NOT EXISTS `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) CHARACTER SET latin1 NOT NULL,
  `password` varchar(255) CHARACTER SET latin1 NOT NULL,
  `email` varchar(255) CHARACTER SET latin1 NOT NULL,
  `phoneNumber` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `address` text CHARACTER SET latin1 NOT NULL,
  `postalCode` int(11) NOT NULL,
  `town` varchar(255) CHARACTER SET latin1 NOT NULL,
  `isAdmin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 NOT NULL,
  `description` text CHARACTER SET latin1 NOT NULL,
  `sectors` text CHARACTER SET latin1 NOT NULL,
  `numberOfSectors` int(11) NOT NULL,
  `length` int(11) NOT NULL,
  `place` varchar(255) CHARACTER SET latin1 NOT NULL,
  `grade` varchar(10) CHARACTER SET latin1 NOT NULL,
  `numberOfWays` int(11) NOT NULL,
  `isOfficial` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `topo`
--

DROP TABLE IF EXISTS `topo`;
CREATE TABLE IF NOT EXISTS `topo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 NOT NULL,
  `description` text CHARACTER SET latin1 NOT NULL,
  `place` varchar(255) CHARACTER SET latin1 NOT NULL,
  `date` date NOT NULL,
  `memberId` int(11) NOT NULL,
  `isAvailable` tinyint(1) NOT NULL,
  `isAwaiting` tinyint(1) NOT NULL DEFAULT '0',
  `isReserved` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `awaiting_topo`
--
ALTER TABLE `awaiting_topo`
  ADD CONSTRAINT `buyer_awaiting_topo_fk` FOREIGN KEY (`buyerId`) REFERENCES `member` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `rundown_reserved_rundown_fk` FOREIGN KEY (`topoId`) REFERENCES `topo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `user_reserved_rundown_fk` FOREIGN KEY (`memberId`) REFERENCES `member` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `topo`
  ADD CONSTRAINT `member_topo_fk` FOREIGN KEY (`memberId`) REFERENCES `member` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `site_commentary_fk` FOREIGN KEY (`siteId`) REFERENCES `site` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
