-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 09 fév. 2018 à 19:12
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
-- Structure de la table `accesoirs`
--

DROP TABLE IF EXISTS `accesoirs`;
CREATE TABLE IF NOT EXISTS `accesoirs` (
  `id_produits` int(11) NOT NULL,
  `id_accesoir` int(11) NOT NULL,
  PRIMARY KEY (`id_produits`,`id_accesoir`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `adoption`
--

DROP TABLE IF EXISTS `adoption`;
CREATE TABLE IF NOT EXISTS `adoption` (
  `id_adoption` int(11) NOT NULL,
  `id_membre` int(11) NOT NULL,
  PRIMARY KEY (`id_adoption`),
  KEY `FK_membreAdoption` (`id_membre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `animal`
--

DROP TABLE IF EXISTS `animal`;
CREATE TABLE IF NOT EXISTS `animal` (
  `id_animal` int(11) NOT NULL,
  `id_adoption` int(11) DEFAULT NULL,
  `id_sos_disparition` int(11) DEFAULT NULL,
  `type` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`id_animal`),
  KEY `FK_animalAdoption` (`id_adoption`),
  KEY `FK_animalSoSDisparition` (`id_sos_disparition`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `concours`
--

DROP TABLE IF EXISTS `concours`;
CREATE TABLE IF NOT EXISTS `concours` (
  `id_concours` int(11) NOT NULL,
  `id_membre` int(11) NOT NULL,
  PRIMARY KEY (`id_concours`),
  KEY `FK_AdminConcours` (`id_membre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `documentation`
--

DROP TABLE IF EXISTS `documentation`;
CREATE TABLE IF NOT EXISTS `documentation` (
  `id_doc` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_doc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `faq`
--

DROP TABLE IF EXISTS `faq`;
CREATE TABLE IF NOT EXISTS `faq` (
  `id_faq` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_faq`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `f_dressage`
--

DROP TABLE IF EXISTS `f_dressage`;
CREATE TABLE IF NOT EXISTS `f_dressage` (
  `id_f_Dressage` int(11) NOT NULL,
  `id_membre` int(11) NOT NULL,
  PRIMARY KEY (`id_f_Dressage`),
  KEY `id_membre` (`id_membre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `f_soin`
--

DROP TABLE IF EXISTS `f_soin`;
CREATE TABLE IF NOT EXISTS `f_soin` (
  `id_f_Soin` int(11) NOT NULL AUTO_INCREMENT,
  `id_membre` int(11) NOT NULL,
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
  PRIMARY KEY (`id_f_Soin`),
  KEY `id_membre` (`id_membre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `membre`
--

DROP TABLE IF EXISTS `membre`;
CREATE TABLE IF NOT EXISTS `membre` (
  `id_membre` int(11) NOT NULL,
  `type` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`id_membre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `nouriture`
--

DROP TABLE IF EXISTS `nouriture`;
CREATE TABLE IF NOT EXISTS `nouriture` (
  `id_produits` int(11) NOT NULL,
  `id_nouriture` int(11) NOT NULL,
  PRIMARY KEY (`id_produits`,`id_nouriture`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

DROP TABLE IF EXISTS `participation`;
CREATE TABLE IF NOT EXISTS `participation` (
  `id_membre` int(11) NOT NULL,
  `id_concours` int(11) NOT NULL,
  `date_concour` date NOT NULL,
  PRIMARY KEY (`id_membre`,`id_concours`,`date_concour`),
  KEY `AK_id_concours` (`id_membre`,`id_concours`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

DROP TABLE IF EXISTS `produits`;
CREATE TABLE IF NOT EXISTS `produits` (
  `id_produits` int(11) NOT NULL,
  `id_membre` int(11) NOT NULL,
  PRIMARY KEY (`id_produits`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `sceancedressage`
--

DROP TABLE IF EXISTS `sceancedressage`;
CREATE TABLE IF NOT EXISTS `sceancedressage` (
  `id_membre` int(11) NOT NULL,
  `id_animal` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id_membre`,`id_animal`,`date`),
  KEY `AK_id_animal` (`id_membre`,`id_animal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `sos_disparition`
--

DROP TABLE IF EXISTS `sos_disparition`;
CREATE TABLE IF NOT EXISTS `sos_disparition` (
  `id_sos_disparition` int(11) NOT NULL,
  `id_membre` int(11) NOT NULL,
  PRIMARY KEY (`id_sos_disparition`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `visite`
--

DROP TABLE IF EXISTS `visite`;
CREATE TABLE IF NOT EXISTS `visite` (
  `id_membre` int(11) NOT NULL,
  `id_animal` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id_membre`,`id_animal`,`date`),
  KEY `AK_id_animal` (`id_membre`,`id_animal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `accesoirs`
--
ALTER TABLE `accesoirs`
  ADD CONSTRAINT `FK_Generalization_5` FOREIGN KEY (`id_produits`) REFERENCES `produits` (`id_produits`);

--
-- Contraintes pour la table `adoption`
--
ALTER TABLE `adoption`
  ADD CONSTRAINT `FK_membreAdoption` FOREIGN KEY (`id_membre`) REFERENCES `membre` (`id_membre`);

--
-- Contraintes pour la table `animal`
--
ALTER TABLE `animal`
  ADD CONSTRAINT `FK_animalAdoption` FOREIGN KEY (`id_adoption`) REFERENCES `adoption` (`id_adoption`),
  ADD CONSTRAINT `FK_animalSoSDisparition` FOREIGN KEY (`id_sos_disparition`) REFERENCES `sos_disparition` (`id_sos_disparition`);

--
-- Contraintes pour la table `concours`
--
ALTER TABLE `concours`
  ADD CONSTRAINT `FK_AdminConcours` FOREIGN KEY (`id_membre`) REFERENCES `membre` (`id_membre`);

--
-- Contraintes pour la table `f_dressage`
--
ALTER TABLE `f_dressage`
  ADD CONSTRAINT `f_dressage_ibfk_1` FOREIGN KEY (`id_membre`) REFERENCES `membre` (`id_membre`);

--
-- Contraintes pour la table `f_soin`
--
ALTER TABLE `f_soin`
  ADD CONSTRAINT `f_soin_ibfk_1` FOREIGN KEY (`id_membre`) REFERENCES `membre` (`id_membre`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
