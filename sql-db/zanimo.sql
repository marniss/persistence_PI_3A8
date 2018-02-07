-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 06 fév. 2018 à 18:41
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `zanimo`
--

-- --------------------------------------------------------

--
-- Structure de la table `accessoires`
--

DROP TABLE IF EXISTS `accessoires`;
CREATE TABLE IF NOT EXISTS `accessoires` (
  `id_accesoire` int(25) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) CHARACTER SET latin1 NOT NULL,
  `marque` varchar(255) CHARACTER SET latin1 NOT NULL,
  `type` varchar(255) CHARACTER SET latin1 NOT NULL,
  `stock` int(25) NOT NULL,
  PRIMARY KEY (`id_accesoire`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `animal`
--

DROP TABLE IF EXISTS `animal`;
CREATE TABLE IF NOT EXISTS `animal` (
  `id_animal` int(25) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `race` varchar(255) NOT NULL,
  `date_n` date NOT NULL,
  `id_m` int(25) NOT NULL,
  `id_f_dressage` int(25) NOT NULL,
  `id_f_soin` int(25) NOT NULL,
  PRIMARY KEY (`id_animal`),
  KEY `id_m` (`id_m`,`id_f_dressage`,`id_f_soin`),
  KEY `id_f_soin` (`id_f_soin`),
  KEY `id_f_dressage` (`id_f_dressage`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `centre_dressage`
--

DROP TABLE IF EXISTS `centre_dressage`;
CREATE TABLE IF NOT EXISTS `centre_dressage` (
  `id_centre` int(25) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `numero` int(25) NOT NULL,
  `note` int(5) NOT NULL,
  PRIMARY KEY (`id_centre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `concours`
--

DROP TABLE IF EXISTS `concours`;
CREATE TABLE IF NOT EXISTS `concours` (
  `id_concours` int(25) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `race` varchar(255) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  PRIMARY KEY (`id_concours`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `fiche_dressage`
--

DROP TABLE IF EXISTS `fiche_dressage`;
CREATE TABLE IF NOT EXISTS `fiche_dressage` (
  `id_f_dressage` int(25) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `etat` varchar(255) NOT NULL,
  `date_visite` date NOT NULL,
  `id_a` int(25) NOT NULL,
  `id_m` int(25) NOT NULL,
  PRIMARY KEY (`id_f_dressage`),
  KEY `id_a` (`id_a`,`id_m`),
  KEY `id_m` (`id_m`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `fiche_soin`
--

DROP TABLE IF EXISTS `fiche_soin`;
CREATE TABLE IF NOT EXISTS `fiche_soin` (
  `id_f_soin` int(25) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `etat` varchar(255) NOT NULL,
  `date_visite` date NOT NULL,
  `id_a` int(25) NOT NULL,
  `id_m` int(25) NOT NULL,
  PRIMARY KEY (`id_f_soin`),
  KEY `id_a` (`id_a`,`id_m`),
  KEY `id_m` (`id_m`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `membre`
--

DROP TABLE IF EXISTS `membre`;
CREATE TABLE IF NOT EXISTS `membre` (
  `id_m` int(25) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `age` int(25) NOT NULL,
  `adresse` varchar(25) NOT NULL,
  `sexe` char(1) NOT NULL,
  `num_tel` int(25) NOT NULL,
  `type` int(255) NOT NULL,
  PRIMARY KEY (`id_m`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `nourriture`
--

DROP TABLE IF EXISTS `nourriture`;
CREATE TABLE IF NOT EXISTS `nourriture` (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `marque` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `stock` int(25) NOT NULL,
  `date_limite` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

DROP TABLE IF EXISTS `participation`;
CREATE TABLE IF NOT EXISTS `participation` (
  `id_participation` int(25) NOT NULL AUTO_INCREMENT,
  `id_a` int(25) NOT NULL,
  PRIMARY KEY (`id_participation`),
  KEY `id_a` (`id_a`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sos_disparition`
--

DROP TABLE IF EXISTS `sos_disparition`;
CREATE TABLE IF NOT EXISTS `sos_disparition` (
  `id_sos` int(25) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) NOT NULL,
  `type` char(1) NOT NULL,
  `race` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `numero_tel` int(25) NOT NULL,
  PRIMARY KEY (`id_sos`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `animal`
--
ALTER TABLE `animal`
  ADD CONSTRAINT `animal_ibfk_1` FOREIGN KEY (`id_f_soin`) REFERENCES `fiche_soin` (`id_f_soin`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `animal_ibfk_2` FOREIGN KEY (`id_f_dressage`) REFERENCES `fiche_dressage` (`id_f_dressage`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `animal_ibfk_3` FOREIGN KEY (`id_m`) REFERENCES `membre` (`id_m`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `fiche_dressage`
--
ALTER TABLE `fiche_dressage`
  ADD CONSTRAINT `fiche_dressage_ibfk_1` FOREIGN KEY (`id_a`) REFERENCES `animal` (`id_animal`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fiche_dressage_ibfk_2` FOREIGN KEY (`id_m`) REFERENCES `membre` (`id_m`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `fiche_soin`
--
ALTER TABLE `fiche_soin`
  ADD CONSTRAINT `fiche_soin_ibfk_1` FOREIGN KEY (`id_a`) REFERENCES `animal` (`id_animal`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fiche_soin_ibfk_2` FOREIGN KEY (`id_m`) REFERENCES `membre` (`id_m`);

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `participation_ibfk_1` FOREIGN KEY (`id_a`) REFERENCES `animal` (`id_animal`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
