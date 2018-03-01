-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 01 Mars 2018 à 04:40
-- Version du serveur :  10.1.19-MariaDB
-- Version de PHP :  7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `test3`
--

-- --------------------------------------------------------

--
-- Structure de la table `accessoire`
--

CREATE TABLE `accessoire` (
  `Id_Accessoire` int(11) NOT NULL,
  `Nom_Accessoire` varchar(254) DEFAULT NULL,
  `Description_Accessoire` varchar(254) DEFAULT NULL,
  `Prix_Accessoire` int(10) DEFAULT NULL,
  `Qte_Stock_Accessoire` int(100) DEFAULT NULL,
  `Type_Accessoire` varchar(254) DEFAULT NULL,
  `Photo_Accessoire` varchar(254) DEFAULT NULL,
  `Date_Publication_Accessoire` varchar(254) DEFAULT NULL,
  `Validite_Publication_Accessoire` int(11) DEFAULT NULL,
  `Etat_Accessoire` int(1) DEFAULT NULL,
  `categorie_Accessoire` int(11) DEFAULT NULL,
  `Id_Membre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `accessoire`
--

INSERT INTO `accessoire` (`Id_Accessoire`, `Nom_Accessoire`, `Description_Accessoire`, `Prix_Accessoire`, `Qte_Stock_Accessoire`, `Type_Accessoire`, `Photo_Accessoire`, `Date_Publication_Accessoire`, `Validite_Publication_Accessoire`, `Etat_Accessoire`, `categorie_Accessoire`, `Id_Membre`) VALUES
(2, 'aaaaaaa', 'aaaaaaaaaaaaaa', 1, 2, 'aaaaa', 'src/data/3.jpg', '26/02/2018', 1, 1, 1, 1),
(3, 'bracelet', 'etdrcfyvgbuhjk,lmcfgvhbjnk,l ', 120, 2, 'xrdcfvgbh', 'src/data/4.jpg', '26/02/2018', 1, 0, 1, 1),
(4, 'bbbb', 'bbbbbbbbbbbbbbbb', 123, 3, 'bbbbbb', 'src/data/5.jpg', '26/02/2018', 1, 0, 1, 1),
(5, 'ghada', 'txfcgvhbjn', 12000, 2, 'femme', 'src/data/6.jpg', '26/02/2018', 1, 0, 1, 1),
(6, 'habla', 'disponible 24/24', 100, 10, 'jaw', 'src/data/7.jpg', '26/02/2018', 1, 0, 1, 1),
(7, 'mosab', 'je met en vente un gazon special pour chien, ce la lui procurera  un bien etre et une .....', 2000, 12, 'bonne etat', 'src/data/aaa.jpg', '26/02/2018', 1, 1, 1, 1),
(8, 'hhhhhhhhh', 'sdfsdqfsqd', 321, 56, 'sdfsqd', 'src/data/8.jpg', '24/02/2018', 1, 0, 1, 1),
(9, 'aaaaaaaa', 'aaaaaaaaaaaaa', 3, 2, 'aaaaaaa', 'src/data/9.jpg', '26/02/2018', 4, 1, 1, 1),
(10, 'aaa', 'aaaaaaaa', 555, 555, 'aaaaaa', 'src/data/10.jpg', '26/02/2018', 8, 0, 1, 1),
(11, 'test 22 ', 'oui oui oui ', 53422, 402, 'bonne etat', 'C:UsersAhmedPicturesimageaccessoires5.jpg', '24/02/2018', 1, 0, 1, 1),
(12, 'etsttt', 'w<dqsdsqdqsdqsd', 555222, 222, '323', 'C:/Users/Ahmed/Pictures/image/accessoires/5.jpg', '26/02/2018', 4, 0, 1, 1),
(13, 'sms', 'smssmssmssmssmssmssmssmssmssmssmssmssmssmssmssms', 123, 22, 'sms', 'C:/Users/Ahmed/Pictures/image/accessoires/7.jpg', '26/02/2018', 4, 1, 1, 1),
(14, 'etst', 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', 55555, 5, 'beoonne etat', 'C:/Users/Ahmed/Pictures/image/nourriture/14.jpg', '26/02/2018', 8, 1, 1, 1),
(15, 'dkr', 'dkr', 120, 2, 'dkr', 'C:/Users/Ahmed/Pictures/image/accessoires/5.jpg', '26/02/2018', 8, 0, 1, 1),
(16, 'il ont laa', 'ils sont là ils sont là ils sont là ils sont là ils sont là ils sont là ils sont là ils sont là ils sont là ils sont là ils sont là ', 333, 2, 'il sont là ..', '', '25/02/2018', 12, 1, 2, 1),
(17, 'wiem', 'wiem', 312, 3, 'wiem', '', '25/02/2018', 4, 1, 5, 1),
(18, 'madison', 'madison', 3, 2, 'madison', '', '26/02/2018', 12, 1, 2, 1),
(19, 'madisonnnnn', 'madisonmadisonmadisonmadisonmadisonmadisonmadison', 321132, 3, 'madison', '', '26/02/2018', 8, 1, 4, 1),
(20, 'test', 'aaaaaaaaaaaaaaaaaaaaaaa', 999, 2, 'aaaaa', 'C:/Users/Ahmed/Pictures/image/accessoires/5.jpg', '26/02/2018', 8, 1, 3, 1),
(21, 'zambala', 'aaaaaaaaaaaa', 33333, 1, 'zambala', 'C:/Users/Public/Pictures/Sample Pictures/Koala.jpg', '26/02/2018', 4, 0, 4, 1),
(22, 'Aler', 'aletr', 23232, 30, 'aaaaa', 'C:/Users/Ahmed/Pictures/image/nourriture/14.jpg', '26/02/2018', 1, 1, 3, 1),
(23, 'ousama', 'ousamaousamaousamaousamaousamaousamaousamaousama', 123, 3, 'humai', 'C:/Users/Ahmed/Pictures/image/nourriture/13.jpg', '26/02/2018', 8, 1, 2, 1),
(24, 'test', 'zzzzzzzzzzz', 333, 1, '333333', 'C:/Users/Public/Pictures/Sample Pictures/Desert.jpg', '26/02/2018', 4, 1, 1, 1),
(25, 'wiem', 'wiemwiemwiemwiemwiemwiemwiemwiemwiemwiemwiemwiemwiem', 3333, 3, 'wiem', 'C:/Users/Ahmed/Pictures/image/nourriture/14.jpg', '26/02/2018', 4, 0, 4, 1),
(26, 'aaaaaaa', 'zzzzzzzzzzzzzzzzzzzzzzzzzzz', 123, 2, 'xdgdfxgsdfg', 'C:/Users/Ahmed/Pictures/image/nourriture/14.jpg', '28/02/2018', 4, 1, 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `adoption`
--

CREATE TABLE `adoption` (
  `id_adoption` int(11) NOT NULL,
  `id_membre` int(11) DEFAULT NULL,
  `type` varchar(11) DEFAULT NULL,
  `dateAnnonce` date DEFAULT NULL,
  `lieu` varchar(50) DEFAULT NULL,
  `etatAdoption` int(11) DEFAULT NULL,
  `description` text,
  `id_animal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `adoption`
--

INSERT INTO `adoption` (`id_adoption`, `id_membre`, `type`, `dateAnnonce`, `lieu`, `etatAdoption`, `description`, `id_animal`) VALUES
(1, 1, 'donner', '2018-02-28', 'dfdsfdffd', 1, 'dfdfdfdfdf', 1);

-- --------------------------------------------------------

--
-- Structure de la table `animal`
--

CREATE TABLE `animal` (
  `id_animal` int(11) NOT NULL,
  `type` varchar(254) DEFAULT NULL,
  `nom` varchar(20) DEFAULT NULL,
  `race` varchar(20) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `photo` text,
  `poid` double DEFAULT NULL,
  `id_membre` int(11) DEFAULT NULL,
  `etat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `animal`
--

INSERT INTO `animal` (`id_animal`, `type`, `nom`, `race`, `date_naissance`, `description`, `photo`, `poid`, `id_membre`, `etat`) VALUES
(1, 'femelle', 'nom', 'race', '2018-02-23', 'descriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescription', NULL, 500, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `Id_Categorie` int(11) NOT NULL,
  `Id_Categorie_Id` int(11) DEFAULT NULL,
  `Nom_Categorie` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`Id_Categorie`, `Id_Categorie_Id`, `Nom_Categorie`) VALUES
(1, 1, 'Ils savent voler'),
(2, NULL, 'Ils ont des poils...'),
(3, NULL, 'Ils ont des plumes...'),
(4, NULL, 'Ils ont des écailles..'),
(5, NULL, 'Ils nont ni poil, ni plume, ni écaille...');

-- --------------------------------------------------------

--
-- Structure de la table `centre_de_dressage`
--

CREATE TABLE `centre_de_dressage` (
  `id_centre_de_dreeage` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `numero` int(25) DEFAULT NULL,
  `note` double DEFAULT NULL,
  `visible` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `centre_de_soin`
--

CREATE TABLE `centre_de_soin` (
  `id_centre` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `numero` int(25) DEFAULT NULL,
  `note` double DEFAULT NULL,
  `SomeNotes` double DEFAULT NULL,
  `NombreVote` int(11) DEFAULT NULL,
  `Longtitude` double DEFAULT NULL,
  `Laltitude` double DEFAULT NULL,
  `visible` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `centre_de_soin`
--

INSERT INTO `centre_de_soin` (`id_centre`, `nom`, `type`, `adresse`, `numero`, `note`, `SomeNotes`, `NombreVote`, `Longtitude`, `Laltitude`, `visible`) VALUES
(31, 'nom1', 'type', 'adresse', 12, 2.5, NULL, NULL, NULL, NULL, 1),
(32, '3om1', 'type', 'adresse', 12, 2.5, NULL, NULL, NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `concour`
--

CREATE TABLE `concour` (
  `idConcour` int(11) NOT NULL,
  `typeConcour` varchar(50) DEFAULT NULL,
  `race` varchar(50) DEFAULT NULL,
  `dateDebut` date DEFAULT NULL,
  `dateFin` date DEFAULT NULL,
  `titreConcour` varchar(60) DEFAULT NULL,
  `capacite` int(11) DEFAULT NULL,
  `lieu` varchar(100) DEFAULT NULL,
  `nbparticipant` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `concour`
--

INSERT INTO `concour` (`idConcour`, `typeConcour`, `race`, `dateDebut`, `dateFin`, `titreConcour`, `capacite`, `lieu`, `nbparticipant`) VALUES
(1, 'le mignon', 'chat', '2018-03-01', '2018-03-02', 'beaute', 45, 'nabeul', 0),
(2, 'le mignon', 'chat', '2018-03-01', '2018-03-02', 'beaute', 1212, 'nabeul', 1),
(3, 'hh', 'hhh', '2018-03-09', '2018-03-11', 'hhh', 4554, 'jkjkj', 0),
(4, 'cheval', 'run', '2018-03-01', '2018-03-09', 'course', 50, 'ksar saad', 0),
(6, 'pppp', 'iiiiiiii', '2018-03-01', '2018-03-02', 'oooo', 20, 'ddd', 0);

-- --------------------------------------------------------

--
-- Structure de la table `f_dressage`
--

CREATE TABLE `f_dressage` (
  `id_f_Dressage` int(11) NOT NULL,
  `id_membre` int(11) DEFAULT NULL,
  `displine` int(6) DEFAULT NULL,
  `obeissance` int(6) DEFAULT NULL,
  `specialite` varchar(250) DEFAULT NULL,
  `accompagnement` int(6) DEFAULT NULL,
  `interception` int(6) DEFAULT NULL,
  `noteTotal` float DEFAULT NULL,
  `dateDebut` date DEFAULT NULL,
  `datFin` date DEFAULT NULL,
  `id_animal` int(11) DEFAULT NULL,
  `etat` int(11) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `f_dressage`
--

INSERT INTO `f_dressage` (`id_f_Dressage`, `id_membre`, `displine`, `obeissance`, `specialite`, `accompagnement`, `interception`, `noteTotal`, `dateDebut`, `datFin`, `id_animal`, `etat`) VALUES
(6, 1, 12, 12, 'hghjhj', 10, 18, 38.5, '2018-01-25', '2018-01-26', 1, 1),
(7, 1, 1, 0, 'qdqsdqs', 0, 0, 1, '2016-01-08', '2017-01-06', 100, 0),
(10, 1, 14, 16, 'defence', 18, 20, 53, '2018-01-17', '2018-01-07', 2, 1),
(14, 1, 15, 7, 'attaque', 14, 10, 38.5, '2018-02-05', '2018-02-23', 2, 0),
(15, 2, 14, 10, '', 10, 12, 37, '2018-02-07', '2018-02-04', 2, 0),
(16, 2, 14, 14, 'khj;,h', 14, 14, 45.575, '2018-02-20', '2018-02-18', 0, 1),
(17, 1, 14, 8, 'fd', 14, 14, 39.5, '2018-02-18', '2018-02-21', 0, 1),
(18, 1, 14, 5, 'attaque', 14, 14, 36.5, '2018-02-07', '2018-02-07', 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `f_soin`
--

CREATE TABLE `f_soin` (
  `id_f_Soin` int(11) NOT NULL,
  `id_membre` int(11) DEFAULT NULL,
  `observation` varchar(250) DEFAULT NULL,
  `medicament` varchar(250) DEFAULT NULL,
  `dateCreation` date DEFAULT NULL,
  `prochainRDV` date DEFAULT NULL,
  `id_animal` int(11) DEFAULT NULL,
  `etat` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `f_soin`
--

INSERT INTO `f_soin` (`id_f_Soin`, `id_membre`, `observation`, `medicament`, `dateCreation`, `prochainRDV`, `id_animal`, `etat`) VALUES
(32, 2, 'hjknjlkjm', 'azze', NULL, '2018-01-12', 1, 1),
(33, 2, 'tretr', 'fhfhnf', NULL, '2017-09-20', 1, 1),
(34, 2, 'yyyhy', 'azazaza', NULL, '2018-01-30', 1, 1),
(35, 2, 'No', 'No', NULL, '2018-01-22', 1, 1),
(36, 2, 'iyed', 'ahmed', NULL, '2018-01-01', 1, 0),
(37, 2, 'iopop', 'ahahaha', NULL, '2018-01-22', 1, 1),
(38, 2, 'htdgc', 'hhhh', NULL, '2018-01-27', 1, 1),
(39, 2, 'OKOK', 'OK', NULL, '0005-12-31', 1, 1),
(40, 2, 'yjfyjjy', 'fhghgh', NULL, '0023-03-09', 1, 1),
(41, 2, 'reter', 'khjkl:', NULL, '0022-11-29', 1, 1),
(42, 2, 'jljk,jkjk', 'kljklkl', NULL, '0005-11-02', 2, 1),
(43, 2, 'jklklkl', 'jklkljkl', NULL, '2018-01-20', 1, 1),
(44, 2, 'jkjkjk', 'jkjkjkjk', NULL, '2018-01-07', 1, 1),
(45, 1, 'bdbdb', 'bfdbf', NULL, '2017-02-16', 1, 0),
(46, 2, 'azzzzz', '14445', NULL, '2018-03-10', 100, 1),
(47, 2, 'jklkkl', 'ggg', NULL, '2018-02-20', 2, 1),
(48, 1, '888', 'yyyyee', NULL, '2018-02-27', 1, 1),
(49, 1, 'nfnf', 'yyy', '2018-02-25', '2018-02-21', 100, 1),
(50, 1, 'hjk', 'jjkjk', '2018-02-25', '2018-02-21', 2, 0),
(51, 1, 'gjh', 'iukjk', '2018-02-25', '2018-02-06', 2, 1),
(52, 2, 'jjjjjj', 'hhhhh', '2018-02-26', '2018-02-27', 100, 1);

-- --------------------------------------------------------

--
-- Structure de la table `listedesdresseurs`
--

CREATE TABLE `listedesdresseurs` (
  `id` int(11) NOT NULL,
  `nom` varchar(250) DEFAULT NULL,
  `prenom` varchar(250) DEFAULT NULL,
  `tel` varchar(250) DEFAULT NULL,
  `adresse` varchar(250) DEFAULT NULL,
  `mail` varchar(250) DEFAULT NULL,
  `photo` varchar(250) DEFAULT NULL,
  `idnote` int(11) DEFAULT NULL,
  `etat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `listedesdresseurs`
--

INSERT INTO `listedesdresseurs` (`id`, `nom`, `prenom`, `tel`, `adresse`, `mail`, `photo`, `idnote`, `etat`) VALUES
(1, 'mohamed', 'alii', '22222222', 'jgh,hg', 'zaza@dzzad.com', 'tyy', 1, 1),
(2, 'aymen', 'taherklkl', '4567892', 'hfdhdf', 'aajkjk@jj.nkl', 'azaz', 2, 0),
(3, 'alii', 'issam', '25487a', 'aa', 'azee', 'zdfev', 3, 0),
(4, 'hedia', 'zz,,z', 'aaa', 'nbb', 'nnn', 'aaa', 4, 0),
(5, 'hosni', 'az', '14789638', 'ze', 'rr', 'tyy', 5, 0),
(6, 'azaza', 'ayaya', '12345678', 'Beb Souika', 'azza@zamzam.com', 'zeez', NULL, 1),
(7, 'azaza', 'azaza', '12345678', 'zaaz', 'azza@zamzam.com', 'zeez', NULL, 0),
(8, 'azazazazazaza', 'azaza', '12345678', 'Tunis', 'azza@zamzam.com', 'zeez', NULL, 1),
(9, 'azazazazazaza', 'azaza', '12345678', 'Ariana', 'azza@zamzam.com', 'zeez', NULL, 1),
(10, 'aaaaaaaaaa', 'azaza', '12345678', 'tunis', 'azza@zamzam.com', 'zeez', NULL, 1),
(11, 'oioiiouoii', 'azaza', '12345678', 'zaaz', 'azza@zamzam.com', 'zeez', NULL, 1),
(12, 'eeeeeeeeeeeee', 'azaza', '12345678', 'zaaz', 'azza@zamzam.com', 'zeez', NULL, 0),
(13, 'gffffffffffff', 'azaza', '12345678', 'zaaz', 'azza@zamzam.com', 'zeez', NULL, 0),
(14, 'mmmmmmmmmm', 'azaza', '12345678', 'zaaz', 'azza@zamzam.com', 'zeez', NULL, 1),
(15, 'uuuuu', 'azaza', '12345678', 'zaaz', 'azza@zamzam.com', 'zeez', 13, 1);

-- --------------------------------------------------------

--
-- Structure de la table `listedesvetirinaire`
--

CREATE TABLE `listedesvetirinaire` (
  `id_ved` int(11) NOT NULL,
  `nom` varchar(250) DEFAULT NULL,
  `prenom` varchar(250) DEFAULT NULL,
  `tel` varchar(250) DEFAULT NULL,
  `adresse` varchar(250) DEFAULT NULL,
  `mail` varchar(250) DEFAULT NULL,
  `photo` varchar(25) DEFAULT NULL,
  `id_note` int(11) DEFAULT NULL,
  `etat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `listedesvetirinaire`
--

INSERT INTO `listedesvetirinaire` (`id_ved`, `nom`, `prenom`, `tel`, `adresse`, `mail`, `photo`, `id_note`, `etat`) VALUES
(2, 'aaaaa', 'zzzzz', '12345678', 'dddffff', 'aaaa@amama.com', 'zeez', 2, 1),
(3, 'aliiii', 'aaaa', 'z', 'zzzee', 'rrrr', 'tttt', 3, 1),
(10, 'emel', 'garwachi', '25225555', 'llllk', 'ono@jjk.com', 'jjkkj', 29, 1),
(14, 'ffdfdfddfzd', 'uuo', '22222222', 'jknlnlk', 'keeke@ekee.cd', 'zzz', 39, 1),
(15, 'emel', 'garwachi', '25225555', 'llllk', 'ono@jjk.com', 'jjkkj', NULL, 0),
(16, 'Ahmeed', 'Maaaaaaaalni', '22222222', 'Ariana', 'keeke@ekee.cd', 'zzz', 45, 1),
(17, 'OKOKOKOK', 'HAHAHAHAHAHH', '22222222', 'Marsa', 'keeke@ekee.cd', 'zzz', 49, 1),
(18, 'NONONONONO', 'HAHAHAHAHAHH', '22222222', 'Ben Arous', 'keeke@ekee.cd', 'zzz', 50, 1),
(19, 'behy', 'yesser', '22222222', 'soukra', 'keeke@ekee.cd', 'zzz', 51, 1),
(20, 'AAAAAAAA', 'yesser', '22222222', 'sfax', 'keeke@ekee.cd', 'zzz', 52, 1),
(21, 'BBBBBBBBBB', 'yesser', '22222222', 'gafsa', 'keeke@ekee.cd', 'zzz', 53, 1),
(22, 'cccccccc', 'yesser', '22222222', 'jknlnlk', 'keeke@ekee.cd', 'zzz', 54, 0),
(23, 'cfcfcfcgfcgff', 'yesser', '22222222', 'jknlnlk', 'keeke@ekee.cd', 'zzz', 55, 0),
(24, 'yyyyyyyyyyyy', 'yesser', '22222222', 'jknlnlk', 'keeke@ekee.cd', 'zzz', 55, 0),
(25, 'xxxxxxxxxxxxxxxxxx', 'yesser', '22222222', 'jknlnlk', 'keeke@ekee.cd', 'zzz', 55, 1),
(26, 'tttttttttttttttttt', 'yesser', '22222222', 'jknlnlk', 'keeke@ekee.cd', 'zzz', 55, 1),
(27, 'nnnnnnnnnnnnnnnnn', 'yesser', '22222222', 'jknlnlk', 'keeke@ekee.cd', 'zzz', 55, 1),
(28, 'oooooooooooo', 'yesser', '22222222', 'jknlnlk', 'keeke@ekee.cd', 'zzz', 55, 1),
(29, 'oioioioioioioioi', 'yesser', '22222222', 'jknlnlk', 'keeke@ekee.cd', 'zzz', 61, 1),
(30, 'ytdytdhtdgdhfdhfdhfdgfdgfbd', 'yesser', '22222222', 'jknlnlk', 'keeke@ekee.cd', 'zzz', 62, 1),
(31, 'Ahmeed', 'Maaaaaaaalni', '22222222', 'jknlnlk', 'keeke@ekee.cd', 'zzz', 63, 1),
(32, 'zazazzaza', 'kjhnlkjo', '22222222', 'jknlnlk', 'keeke@ekee.cd', 'zzz', 64, 1);

-- --------------------------------------------------------

--
-- Structure de la table `membre`
--

CREATE TABLE `membre` (
  `id_membre` int(11) NOT NULL,
  `type` varchar(254) DEFAULT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `DateInscription` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `note` float DEFAULT NULL,
  `pasword` varchar(100) DEFAULT NULL,
  `etat` int(11) DEFAULT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  `connecter` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `membre`
--

INSERT INTO `membre` (`id_membre`, `type`, `photo`, `nom`, `prenom`, `num`, `DateInscription`, `email`, `note`, `pasword`, `etat`, `adresse`, `connecter`) VALUES
(1, 'Admin', '', 'houssem', 'marnissiii', 53685754, '2018-02-28', 'admin@admin.com', NULL, '\0	', 1, '', NULL),
(2, 'membre', '', 'houssem', 'marnissi', 53685754, '2018-02-28', 'houssem.marnissi@gmail.com', NULL, '\0	', 1, '', NULL),
(3, 'Admin', '', 'a', 'a', 99999999, '2018-03-01', 'a@a.a', NULL, 'aaaaaaaa', 1, 'a', NULL),
(4, 'veterinaire', '', 'bb', 'bb', 88888888, '2018-03-01', 'b@b.b', NULL, 'bbbbbbbb', 1, 'b', NULL),
(5, 'dresseur', '', 'bb', 'bb', 88888888, '2018-03-01', 'bb@b.b', NULL, 'bbbbbbbb', 1, 'b', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `notedresseur`
--

CREATE TABLE `notedresseur` (
  `idnote` int(11) NOT NULL,
  `idmembre` int(11) DEFAULT NULL,
  `note` float DEFAULT NULL,
  `observation` varchar(252) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `notedresseur`
--

INSERT INTO `notedresseur` (`idnote`, `idmembre`, `note`, `observation`) VALUES
(1, 1, 3.80682, 'frrz'),
(2, 1, 2.20942, 'azzee'),
(3, 1, 3.30256, 'jyy'),
(4, 1, 0, ''),
(5, 1, 0, ''),
(6, 1, 0, ''),
(7, 1, 0, ''),
(8, 1, 0, ''),
(9, 1, 0, ''),
(10, 1, 0, ''),
(11, 1, 0, ''),
(12, 1, 0, ''),
(13, 1, 1.53409, '');

-- --------------------------------------------------------

--
-- Structure de la table `notevetirinaire`
--

CREATE TABLE `notevetirinaire` (
  `idnoteVet` int(11) NOT NULL,
  `idmembre` int(11) DEFAULT NULL,
  `note` float DEFAULT '0',
  `observation` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `notevetirinaire`
--

INSERT INTO `notevetirinaire` (`idnoteVet`, `idmembre`, `note`, `observation`) VALUES
(1, 1, 0, ''),
(2, 1, 0, ''),
(29, 1, 3.4446, ''),
(30, 1, 2.14489, ''),
(31, 1, 2.14489, ''),
(32, 1, 2.04545, ''),
(33, 1, 2.04545, ''),
(34, 1, 1.81818, ''),
(35, 1, 1.81818, ''),
(36, 1, 1.73295, ''),
(37, 1, 1.81818, ''),
(38, 1, 1.90341, ''),
(39, 1, 3.00426, ''),
(40, 1, 2.45739, ''),
(41, 1, 2.45739, ''),
(42, 1, 2.11648, ''),
(43, 1, 2.40057, ''),
(44, 1, 1.90341, ''),
(45, 1, 2.3473, ''),
(46, 1, 1.64773, ''),
(47, 1, 1.73295, ''),
(48, 1, 1.73295, ''),
(49, 1, 1.50568, ''),
(50, 1, 1.63352, ''),
(51, 1, 2.90483, ''),
(52, 1, 3.1179, ''),
(53, 1, 0, ''),
(54, 1, 1.81818, ''),
(55, 1, 3.43927, ''),
(61, 1, 0, ''),
(62, 1, 2.07386, ''),
(63, 1, 0, ''),
(64, 1, 0, '');

-- --------------------------------------------------------

--
-- Structure de la table `nourriture`
--

CREATE TABLE `nourriture` (
  `Id_Nourriture` int(11) NOT NULL,
  `Nom_Nourriture` varchar(254) DEFAULT NULL,
  `Description_Nourriture` varchar(254) DEFAULT NULL,
  `Prix_Nourriture` int(10) DEFAULT NULL,
  `Qte_Stock_Nourriture` int(100) DEFAULT NULL,
  `Type_Nourriture` varchar(254) DEFAULT NULL,
  `Photo_Nourriture` varchar(254) DEFAULT NULL,
  `Date_Publication_Nourriture` varchar(254) DEFAULT NULL,
  `Validite_Publication_Nourriture` int(10) DEFAULT NULL,
  `Etat_Nourriture` int(1) DEFAULT NULL,
  `Date_Fabrication_Nourriture` varchar(254) DEFAULT NULL,
  `Date_Limite_Nourriture` varchar(254) DEFAULT NULL,
  `Id_Membre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `nourriture`
--

INSERT INTO `nourriture` (`Id_Nourriture`, `Nom_Nourriture`, `Description_Nourriture`, `Prix_Nourriture`, `Qte_Stock_Nourriture`, `Type_Nourriture`, `Photo_Nourriture`, `Date_Publication_Nourriture`, `Validite_Publication_Nourriture`, `Etat_Nourriture`, `Date_Fabrication_Nourriture`, `Date_Limite_Nourriture`, `Id_Membre`) VALUES
(1, 'la premiere annonce', 'fqsdfqsdf', 321, 1, 'sdfqsd', 'src/data/12.jpg', '24/02/2018', 20, 1, '20/02/2018', '27/02/2018', 1),
(2, 'jawww', 'azedqsfsdfqsdf', 120, 2, 'aze', 'src/data/0.jpg', '24/02/2018', 20, 1, '20/02/2018', '27/02/2018', 1),
(3, 'habla', 'sdqsdqsdqsdqs', 666, 2, 'aqdqsd', 'src/data/13.jpg', '24/02/2018', 20, 0, '20/02/2018', '27/02/2018', 1),
(4, 'hahahh', 'qsdfsqdfqsdfqsdfqsdfqsdfqsdfsd', 351, 20, 'sdqf', 'src/data/14.jpg', '24/02/2018', 20, 1, '20/02/2018', '27/02/2018', 1),
(5, 'pizza', 'sdfsfsdqfqsdfsqdfqsdfqs', 25, 1, 'tres bonne', 'src/data/15.jpg', '24/02/2018', 20, 1, '20/02/2018', '27/02/2018', 1),
(6, 'sqdsqd', 'fqsdfqsd', 2, 2, 'sdqf', 'src/data/16.jpg', '24/02/2018', 20, 1, '20/02/2018', '27/02/2018', 1),
(17, 'bien', 'tres bien', 123, 3, 'tres bien', '', '27/02/2018', 8, 1, '01/02/2018', '28/02/2018', 1);

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

CREATE TABLE `participation` (
  `idParticipation` int(11) NOT NULL,
  `idAnimal` int(11) DEFAULT NULL,
  `idConcour` int(11) DEFAULT NULL,
  `etat` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `participation`
--

INSERT INTO `participation` (`idParticipation`, `idAnimal`, `idConcour`, `etat`) VALUES
(36, 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

CREATE TABLE `question` (
  `id_question` int(10) NOT NULL,
  `question` varchar(254) DEFAULT NULL,
  `id_reponse` varchar(254) DEFAULT NULL,
  `etat` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `question`
--

INSERT INTO `question` (`id_question`, `question`, `id_reponse`, `etat`) VALUES
(1, 'est ce nous allons arrivé ? ', '1,', 1),
(2, 'hhhhhhhhhhh ?', '2,', 1),
(3, 'Comment apprendre la propreté à un chaton et à un chiot ? ', '2', 1),
(4, 'Qu''est-ce que la gale notoédrique chez le chat ? ', '4', 1),
(6, 'Qu''est-ce que la gale notoédrique chez le chat ? ', NULL, 0),
(10, '\r\nPeut-on donner du chocolat à un chien ? \r\n', NULL, 0),
(11, 'Peut-on donner du lait à un chat ?', '1,2,3,4,5', 1),
(14, 'Quels animaux sont acceptés à bord ?', NULL, 0),
(15, 'Quels animaux sont acceptés à bord ?', '13,', 1),
(28, 'hahahhahahhahaha ?', '21,', 1),
(29, 'comment chier ? ', '24,', 1),
(30, 'hahahhahahhahahaahhaaaaa ?', NULL, 0);

-- --------------------------------------------------------

--
-- Structure de la table `questionquiz`
--

CREATE TABLE `questionquiz` (
  `idQ` int(11) NOT NULL,
  `idR` int(11) DEFAULT NULL,
  `Question` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `questionquiz`
--

INSERT INTO `questionquiz` (`idQ`, `idR`, `Question`) VALUES
(1, 1, 'Quelle est la femelle du lièvre ?'),
(2, 2, 'Quel est le seul oiseau au monde qui puisse voler à reculons ?'),
(3, 3, 'De quoi le poisson clown ne peut-il se passer ?'),
(4, 4, 'Comment les papillons portent-ils leur trompe au repos ?'),
(5, 5, 'Quel poisson possède environ 700 dents ?'),
(6, 6, 'Laquelle de ces araignées est la plus dangereuse ?'),
(7, 7, 'À quel animal les îles Canaries doivent-elles leur nom ?'),
(8, 8, 'De combien de tentacules la tête de la limace est-elle munie ?'),
(9, 9, 'Quelle variété de pigeons est aussi appelée « palombe » ?'),
(10, 10, 'Quel mammifère cétacé des mers arctiques surnommait-on autrefois « licorne de mer » ?');

-- --------------------------------------------------------

--
-- Structure de la table `reponse`
--

CREATE TABLE `reponse` (
  `id_reponse` int(11) NOT NULL,
  `reponse` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `reponse`
--

INSERT INTO `reponse` (`id_reponse`, `reponse`) VALUES
(1, 'oui INCHALAH :)'),
(2, 'iohoion');

-- --------------------------------------------------------

--
-- Structure de la table `reponsequiz`
--

CREATE TABLE `reponsequiz` (
  `idR` int(11) NOT NULL,
  `reponse` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `sos_disparition`
--

CREATE TABLE `sos_disparition` (
  `id_sos_disparition` int(20) NOT NULL,
  `nom` varchar(20) DEFAULT NULL,
  `num_tel` int(222) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `sos_disparition`
--

INSERT INTO `sos_disparition` (`id_sos_disparition`, `nom`, `num_tel`, `description`, `email`, `adresse`) VALUES
(1, 'nomm', 198, 'description ', 'jhjh@jv.fr', 'adresse');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `accessoire`
--
ALTER TABLE `accessoire`
  ADD PRIMARY KEY (`Id_Accessoire`),
  ADD KEY `Id_Membre` (`Id_Membre`),
  ADD KEY `categorie_Accessoire` (`categorie_Accessoire`);

--
-- Index pour la table `adoption`
--
ALTER TABLE `adoption`
  ADD PRIMARY KEY (`id_adoption`) USING BTREE,
  ADD KEY `FK_membreAdoption` (`id_membre`) USING BTREE;

--
-- Index pour la table `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`id_animal`),
  ADD UNIQUE KEY `id_animal` (`id_animal`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`Id_Categorie`),
  ADD KEY `Id_Categorie_Id` (`Id_Categorie_Id`);

--
-- Index pour la table `centre_de_dressage`
--
ALTER TABLE `centre_de_dressage`
  ADD PRIMARY KEY (`id_centre_de_dreeage`),
  ADD KEY `AK_Identifier_1` (`id_centre_de_dreeage`);

--
-- Index pour la table `centre_de_soin`
--
ALTER TABLE `centre_de_soin`
  ADD PRIMARY KEY (`id_centre`);

--
-- Index pour la table `concour`
--
ALTER TABLE `concour`
  ADD PRIMARY KEY (`idConcour`);

--
-- Index pour la table `f_dressage`
--
ALTER TABLE `f_dressage`
  ADD PRIMARY KEY (`id_f_Dressage`),
  ADD KEY `id_membre` (`id_membre`),
  ADD KEY `id_animal` (`id_animal`) USING BTREE;

--
-- Index pour la table `f_soin`
--
ALTER TABLE `f_soin`
  ADD PRIMARY KEY (`id_f_Soin`),
  ADD KEY `id_membre` (`id_membre`),
  ADD KEY `id_animal` (`id_animal`);

--
-- Index pour la table `listedesdresseurs`
--
ALTER TABLE `listedesdresseurs`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `listedesvetirinaire`
--
ALTER TABLE `listedesvetirinaire`
  ADD PRIMARY KEY (`id_ved`),
  ADD KEY `id_note` (`id_note`);

--
-- Index pour la table `membre`
--
ALTER TABLE `membre`
  ADD PRIMARY KEY (`id_membre`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `notedresseur`
--
ALTER TABLE `notedresseur`
  ADD PRIMARY KEY (`idnote`),
  ADD KEY `idmembre` (`idmembre`);

--
-- Index pour la table `notevetirinaire`
--
ALTER TABLE `notevetirinaire`
  ADD PRIMARY KEY (`idnoteVet`),
  ADD KEY `idmembre` (`idmembre`);

--
-- Index pour la table `nourriture`
--
ALTER TABLE `nourriture`
  ADD PRIMARY KEY (`Id_Nourriture`);

--
-- Index pour la table `participation`
--
ALTER TABLE `participation`
  ADD PRIMARY KEY (`idParticipation`);

--
-- Index pour la table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id_question`);

--
-- Index pour la table `questionquiz`
--
ALTER TABLE `questionquiz`
  ADD PRIMARY KEY (`idQ`);

--
-- Index pour la table `reponse`
--
ALTER TABLE `reponse`
  ADD PRIMARY KEY (`id_reponse`);

--
-- Index pour la table `reponsequiz`
--
ALTER TABLE `reponsequiz`
  ADD PRIMARY KEY (`idR`);

--
-- Index pour la table `sos_disparition`
--
ALTER TABLE `sos_disparition`
  ADD PRIMARY KEY (`id_sos_disparition`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `accessoire`
--
ALTER TABLE `accessoire`
  MODIFY `Id_Accessoire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT pour la table `adoption`
--
ALTER TABLE `adoption`
  MODIFY `id_adoption` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `animal`
--
ALTER TABLE `animal`
  MODIFY `id_animal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `Id_Categorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `centre_de_dressage`
--
ALTER TABLE `centre_de_dressage`
  MODIFY `id_centre_de_dreeage` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `centre_de_soin`
--
ALTER TABLE `centre_de_soin`
  MODIFY `id_centre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT pour la table `concour`
--
ALTER TABLE `concour`
  MODIFY `idConcour` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `f_dressage`
--
ALTER TABLE `f_dressage`
  MODIFY `id_f_Dressage` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT pour la table `f_soin`
--
ALTER TABLE `f_soin`
  MODIFY `id_f_Soin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;
--
-- AUTO_INCREMENT pour la table `listedesdresseurs`
--
ALTER TABLE `listedesdresseurs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT pour la table `listedesvetirinaire`
--
ALTER TABLE `listedesvetirinaire`
  MODIFY `id_ved` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT pour la table `membre`
--
ALTER TABLE `membre`
  MODIFY `id_membre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `notedresseur`
--
ALTER TABLE `notedresseur`
  MODIFY `idnote` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT pour la table `notevetirinaire`
--
ALTER TABLE `notevetirinaire`
  MODIFY `idnoteVet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;
--
-- AUTO_INCREMENT pour la table `nourriture`
--
ALTER TABLE `nourriture`
  MODIFY `Id_Nourriture` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT pour la table `participation`
--
ALTER TABLE `participation`
  MODIFY `idParticipation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT pour la table `question`
--
ALTER TABLE `question`
  MODIFY `id_question` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT pour la table `questionquiz`
--
ALTER TABLE `questionquiz`
  MODIFY `idQ` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT pour la table `reponse`
--
ALTER TABLE `reponse`
  MODIFY `id_reponse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `reponsequiz`
--
ALTER TABLE `reponsequiz`
  MODIFY `idR` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `sos_disparition`
--
ALTER TABLE `sos_disparition`
  MODIFY `id_sos_disparition` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
