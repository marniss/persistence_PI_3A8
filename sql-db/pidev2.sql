-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 07 fév. 2018 à 16:14
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
-- Base de données :  `pidev2`
--

-- --------------------------------------------------------

--
-- Structure de la table `animal`
--

DROP TABLE IF EXISTS `animal`;
CREATE TABLE IF NOT EXISTS `animal` (
  `id_animal` int(11) NOT NULL AUTO_INCREMENT,
  `id_f_soin` int(11) DEFAULT NULL,
  `id_f_dressage` int(11) DEFAULT NULL,
  `id_membre` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `race` varchar(255) NOT NULL,
  `date_n` date NOT NULL,
  PRIMARY KEY (`id_animal`),
  KEY `AK_Identifier_1` (`id_animal`),
  KEY `AK_Identifier_2` (`id_animal`),
  KEY `AK_Identifier_3` (`id_animal`),
  KEY `FK_Association_1` (`id_f_soin`),
  KEY `FK_Association_3` (`id_f_dressage`),
  KEY `FK_Association_6` (`id_membre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `centre_de_dressage`
--

DROP TABLE IF EXISTS `centre_de_dressage`;
CREATE TABLE IF NOT EXISTS `centre_de_dressage` (
  `id_centre_de_dreeage` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `numero` int(25) NOT NULL,
  `note` int(5) NOT NULL,
  PRIMARY KEY (`id_centre_de_dreeage`),
  KEY `AK_Identifier_1` (`id_centre_de_dreeage`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `centre_de_soin`
--

DROP TABLE IF EXISTS `centre_de_soin`;
CREATE TABLE IF NOT EXISTS `centre_de_soin` (
  `id_centre` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `numero` int(25) NOT NULL,
  `note` int(5) NOT NULL,
  PRIMARY KEY (`id_centre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `councours`
--

DROP TABLE IF EXISTS `councours`;
CREATE TABLE IF NOT EXISTS `councours` (
  `id_concours` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `race` varchar(255) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  PRIMARY KEY (`id_concours`),
  KEY `AK_Identifier_1` (`id_concours`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `f_dressage`
--

DROP TABLE IF EXISTS `f_dressage`;
CREATE TABLE IF NOT EXISTS `f_dressage` (
  `id_f_dressage` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `etat` varchar(255) NOT NULL,
  `date_visite` date NOT NULL,
  `id_a` int(25) NOT NULL,
  `id_m` int(25) NOT NULL,
  PRIMARY KEY (`id_f_dressage`),
  KEY `AK_Identifier_1` (`id_f_dressage`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `f_soin`
--

DROP TABLE IF EXISTS `f_soin`;
CREATE TABLE IF NOT EXISTS `f_soin` (
  `id_f_soin` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(250) DEFAULT NULL,
  `espece` varchar(250) DEFAULT NULL,
  `poids` varchar(250) DEFAULT NULL,
  `datePoids` date DEFAULT NULL,
  `neLe` date DEFAULT NULL,
  `genre` varchar(250) DEFAULT NULL,
  `observation` varchar(250) DEFAULT NULL,
  `photo` varchar(250) DEFAULT NULL,
  `medicament` varchar(250) DEFAULT NULL,
  `proprietaire` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_f_soin`),
  KEY `AK_Identifier_1` (`id_f_soin`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `loisir`
--

DROP TABLE IF EXISTS `loisir`;
CREATE TABLE IF NOT EXISTS `loisir` (
  `id_animal` int(11) NOT NULL,
  `id_centre_de_dreeage` int(11) NOT NULL,
  PRIMARY KEY (`id_animal`,`id_centre_de_dreeage`),
  KEY `FK_Association_4` (`id_centre_de_dreeage`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `membre`
--

DROP TABLE IF EXISTS `membre`;
CREATE TABLE IF NOT EXISTS `membre` (
  `id_membre` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `age` int(25) NOT NULL,
  `adresse` varchar(25) NOT NULL,
  `sexe` char(1) NOT NULL,
  `num_tel` int(25) NOT NULL,
  `type` int(255) NOT NULL,
  PRIMARY KEY (`id_membre`),
  KEY `AK_Identifier_1` (`id_membre`),
  KEY `AK_Identifier_2` (`id_membre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

DROP TABLE IF EXISTS `participation`;
CREATE TABLE IF NOT EXISTS `participation` (
  `id_concours` int(11) NOT NULL AUTO_INCREMENT,
  `id_animal` int(11) NOT NULL,
  `nomConcours` varchar(255) NOT NULL,
  `date_paticipation` date NOT NULL,
  PRIMARY KEY (`id_concours`,`id_animal`),
  KEY `FK_Association_2` (`id_animal`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sos_disparition`
--

DROP TABLE IF EXISTS `sos_disparition`;
CREATE TABLE IF NOT EXISTS `sos_disparition` (
  `id_sos_dis` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) NOT NULL,
  `type` char(1) NOT NULL,
  `race` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `numero_tel` int(25) NOT NULL,
  PRIMARY KEY (`id_sos_dis`),
  KEY `AK_Identifier_1` (`id_sos_dis`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `visite`
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

DROP TABLE IF EXISTS `visite`;
CREATE TABLE IF NOT EXISTS `visite` (
  `id_animal` int(11) NOT NULL,
  `id_centre` int(11) NOT NULL,
  PRIMARY KEY (`id_animal`,`id_centre`),
  KEY `FK_Association_5` (`id_centre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `accessoires`;
CREATE TABLE IF NOT EXISTS `accessoires` (
  `id_accesoire` int(25) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) CHARACTER SET latin1 NOT NULL,
  `marque` varchar(255) CHARACTER SET latin1 NOT NULL,
  `type` varchar(255) CHARACTER SET latin1 NOT NULL,
  `stock` int(25) NOT NULL,
  PRIMARY KEY (`id_accesoire`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
