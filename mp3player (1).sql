-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 30, 2023 at 09:49 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mp3player`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `ID` int(11) NOT NULL,
  `nama` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`ID`, `nama`, `password`) VALUES
(111, 'fawwaz_yasirah', '696969'),
(2, 'Pramudya', '55550000');

-- --------------------------------------------------------

--
-- Table structure for table `playlist`
--

CREATE TABLE `playlist` (
  `PlaylistID` int(11) NOT NULL,
  `name` text NOT NULL,
  `userID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `playlist`
--

INSERT INTO `playlist` (`PlaylistID`, `name`, `userID`) VALUES
(0, 'Playlist1', 555),
(5, 'Playlist saya', 555),
(9, 'test', 5336);

-- --------------------------------------------------------

--
-- Table structure for table `playlistsong`
--

CREATE TABLE `playlistsong` (
  `SongID` int(11) NOT NULL,
  `PlaylistID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `playlistsong`
--

INSERT INTO `playlistsong` (`SongID`, `PlaylistID`) VALUES
(1, 0),
(3, 0),
(6, 0),
(4, 0);

-- --------------------------------------------------------

--
-- Table structure for table `song`
--

CREATE TABLE `song` (
  `SongID` int(11) NOT NULL,
  `name` text NOT NULL,
  `duration` int(11) NOT NULL,
  `artist` text NOT NULL,
  `genre` text NOT NULL,
  `times_played` int(11) NOT NULL,
  `Link_Lagu` text NOT NULL,
  `Link_Gambar` text NOT NULL,
  `Lirik` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `song`
--

INSERT INTO `song` (`SongID`, `name`, `duration`, `artist`, `genre`, `times_played`, `Link_Lagu`, `Link_Gambar`, `Lirik`) VALUES
(1, 'Tiara', 100, 'Raffa Affar', 'Koplo', 0, '', '', ''),
(2, 'Bokura no spectre', 267, 'Hiroshi Kitadani', 'Rock', 0, 'https://download853.mediafire.com/jur0wmsu4logPJEgruKpetC4AW4Y3lx5Ot3o12GEoKr6SZ7zHvpPOYPLk3IsIbtuVXcFDDY5Po62uL2EPnA9g-UM1QE1zscpSY9CojVQ7CenefCNHUMU4vOgmiVsbtBHicmgFdOUMO_XywAYWLTG66NJh6IYFucLzuNbzop7phknAA/wtoqp5vtwgsn6wg/y2mate.com+-+Bokura+no+Spectra+Off+Vocal.mp3', 'https://static.wikia.nocookie.net/ultra/images/6/62/LACM-24403.jpg', ''),
(3, 'Cyclone Effect', 267, 'Labor Day', 'Rock', 0, 'https://download848.mediafire.com/xn7pxes0c2qg2M5B3vI0fTEUfX8lUnIFRW59uGfu_nu5INvSqjq2RdadWKFbozwtPGWbWmwlZTuoeXZIJINZc5yWhNw_h8umnZ9oJM-tmJ_QU_fPjl1xMAQvySfVuxxbJTpN0DvVQdlQDliKCm08tZ1hBMt5C55HcVU8JV2loa5oLg/x3vbiglsl0rn1a7/y2mate.com+-+Cyclone+Effect.mp3', 'https://static.wikia.nocookie.net/kamenrider/images/a/a2/Cyclone_Effect-Labor_Day.png', ''),
(4, 'Mars Telkom University', 127, 'Telkom University', 'Mars', 0, 'https://download948.mediafire.com/xqgmotxlx4ugm-EnhXQOq_W0lFr2Pn674PJKRNoioWlfpKPfgixnUDnGiQGWVkrtYcg9BHti5pRGViB0UK1bK4qB44qfWvj4uTNY4qaQQ6hryu0mbdiA-IoMrO1WGq1zbAT8bAMZJSSGNjbSMeijzyfYtGTfvUZMdUauwuyD_pWgCQ/rmaexfdlrzcy71m/y2mate.com+-+Mars+Telkom+University.mp3', 'https://upload.wikimedia.org/wikipedia/commons/0/03/Logo_Telkom_University_potrait.png', ''),
(5, 'NEXT LEVEL', 250, 'YU-KI', 'Techno', 0, 'https://www.mediafire.com/file/rrvou42yv9xfa47/y2mate.com_-_NEXT_LEVEL.mp3/file', 'https://static.wikia.nocookie.net/kamenrider/images/0/01/NEXT_LEVEL_YU-KI.jpg', ''),
(6, 'Almighty ~ Kamen no Yakusoku', 244, 'Tokyo Ska Paradise', 'Ska', 0, 'https://download1590.mediafire.com/x48hf0uhnyvgEaArZUdHg0jO6Dh3BuNb5kyVQiDu7ujwg9lfdhnYEFyic8DxuID2L6dlq1jmgxS75l6gLyR4bl3wLpAgi1Cs38SmG0VjcoicdAFAx-DiKeZG5dh8O6Gl8jjqTxpCVOG7KXsFDzC-KveF3UACvwMxY-eN_uI45igygg/yuj9mch5bolf2k2/y2mate.com+-+ALMIGHTY%E4%BB%AE%E9%9D%A2%E3%81%AE%E7%B4%84%E6%9D%9F+feat%E5%B7%9D%E4%B8%8A%E6%B4%8B%E5%B9%B3.mp3', 'https://i1.sndcdn.com/artworks-PrWYzTXXYjbW0yYs-2nujcw-t500x500.jpg', ''),
(7, 'Zenryoku King', 188, 'Takayuki Furukawa', 'Rock', 0, 'https://download1590.mediafire.com/x48hf0uhnyvgwUuF05A-kNFP0mQIDcCbLh6Wn0kUZuw06EYN1tDoNYjCSdBRgy4yrDKUekjOvtEFuf34fZ8VJqj0EaWEgpz8RCJP1mkBSdwhqDiKb6qYiEyAcuzYcqHXiOwvv8PcX1feHpUfzXVBeKBlMELrdpMjWVnF_HR-pyHbAg/yuj9mch5bolf2k2/y2mate.com+-+ALMIGHTY%E4%BB%AE%E9%9D%A2%E3%81%AE%E7%B4%84%E6%9D%9F+feat%E5%B7%9D%E4%B8%8A%E6%B4%8B%E5%B9%B3.mp3', 'https://is1-ssl.mzstatic.com/image/thumb/Music126/v4/61/98/97/619897ab-4c6d-f32d-3b88-0221efcf00cd/COKM-44496.jpg/375x375bb.jpg', ''),
(8, 'Luna', 256, 'KINEMA106', 'doujin', 0, 'https://download1523.mediafire.com/6y74na8yzejgrjzm5_MIiGkadt4gHWNI6LBCfKGvCD0bFbLtKBQTs-QyEmRKyQKvfE0cZs23SmbWWwLAQ_m7ueHpF5g2pdwU4snUSeknesknXx6_4hNndk_7CtnkHawYq0NuUbDPxi1U31dzx9XxPL6Yw-MHLw4DhPjgq48ci6z5PA/8vb50l9e998n9pn/y2mate.com+-+Luna%E3%82%AD%E3%83%8D%E3%83%9E106FGO%E3%82%A8%E3%82%A4%E3%83%97%E3%83%AA%E3%83%AB%E3%83%95%E3%83%BC%E3%83%AB%E3%83%8D%E3%82%BF%E5%8B%95%E7%94%BB%E7%94%A8%E6%9B%B8%E3%81%8D%E4%B8%8B%E3%82%8D%E3%81%97%E6%9B%B2+FullVer.mp3', 'https://i.ytimg.com/vi/CUzcB_kPrhs/maxresdefault.jpg', ''),
(9, 'BLACK STAR', 203, 'MindaRyn', 'Rock', 0, 'https://download1523.mediafire.com/1pihgo44okegb_j_-hJQ8-Vc6VCSBcUOcpN2xEmnjmzxjZTM2cVJLg8fQ_gfSk2dpfS9rJ1A1MmiNGf3WyWEASP9638TksP_dG_f2Hpf3j-lY7pPz--GTsVxUFjvcJyPqFJr50Iodwb8QIzAwhS6jme5WlVk7fpfxzBJ-HRCiL8sVQ/l75h0ev85o84iea/y2mate.com+-+MindaRyn++BLACK+STAR+ULTRAMAN+BLAZAR+ED++Music+Video.mp3', 'https://i.ytimg.com/vi/Zs2GPhjHbrk/maxresdefault.jpg', '');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userID` int(3) NOT NULL,
  `nama` mediumtext NOT NULL,
  `password` mediumtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `nama`, `password`) VALUES
(555, 'fawwaz', 'pootis69'),
(900, 'cross', 'balls69'),
(5035, 'suharto', '555'),
(5336, 'bujank', '727'),
(6955, 'imran', 'uwu');

-- --------------------------------------------------------

--
-- Table structure for table `usersong`
--

CREATE TABLE `usersong` (
  `userID` int(11) NOT NULL,
  `SongID` int(11) NOT NULL,
  `local_Dir` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usersong`
--

INSERT INTO `usersong` (`userID`, `SongID`, `local_Dir`) VALUES
(555, 7, ''),
(555, 6, ''),
(6955, 6, '-'),
(6955, 9, '-'),
(6955, 8, '-'),
(6955, 1, '-'),
(6955, 7, ''),
(6955, 3, '-');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`PlaylistID`),
  ADD KEY `playlist_ibfk_1` (`userID`);

--
-- Indexes for table `playlistsong`
--
ALTER TABLE `playlistsong`
  ADD KEY `playlistsong_ibfk_1` (`PlaylistID`),
  ADD KEY `SongID` (`SongID`);

--
-- Indexes for table `song`
--
ALTER TABLE `song`
  ADD PRIMARY KEY (`SongID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userID`);

--
-- Indexes for table `usersong`
--
ALTER TABLE `usersong`
  ADD KEY `SongID` (`SongID`),
  ADD KEY `userID` (`userID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `playlist`
--
ALTER TABLE `playlist`
  ADD CONSTRAINT `playlist_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `playlistsong`
--
ALTER TABLE `playlistsong`
  ADD CONSTRAINT `playlistsong_ibfk_1` FOREIGN KEY (`PlaylistID`) REFERENCES `playlist` (`PlaylistID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `playlistsong_ibfk_2` FOREIGN KEY (`SongID`) REFERENCES `song` (`SongID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `usersong`
--
ALTER TABLE `usersong`
  ADD CONSTRAINT `usersong_ibfk_1` FOREIGN KEY (`SongID`) REFERENCES `song` (`SongID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usersong_ibfk_2` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
