-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 02, 2024 at 02:09 PM
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
(6, 'Playlist1', 7240),
(7, 'PlaylistSaya', 762);

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
(5, 6),
(4, 6),
(2, 7),
(7, 7);

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
(1, 'BloodDrain', 168, 'Raito', 'rock', 0, 'https://drive.google.com/uc?export=download&id=11mXNsNJbqq6WEGN6HwBGw2-LQ9E57A9c', '-', 'Lirik'),
(2, 'Bokura no spectre', 267, 'Hiroshi Kitadani', 'Rock', 0, 'https://drive.usercontent.google.com/download?id=1xt1_ht2OSzeIVXeY8f7YR20Ol_itfNEb&export=download&authuser=0&confirm=t&uuid=2c01d744-58a2-4544-93b1-9726fb7578ea&at=APZUnTUdIPAekXuXAFNNsecrK230:1704112733087', 'https://static.wikia.nocookie.net/ultra/images/6/62/LACM-24403.jpg', ''),
(3, 'Cyclone Effect', 267, 'Labor Day', 'Rock', 0, 'https://drive.usercontent.google.com/download?id=12kpWjjJsJEiTkoDcol0g8-DJ6xtg3tk6&export=download&authuser=0&confirm=t&uuid=c939cf6f-0359-4c34-8f09-2b3217944ad1&at=APZUnTWZ6XW7jHjO-JA-3mQE9CJ7:1704117771489', 'https://static.wikia.nocookie.net/kamenrider/images/a/a2/Cyclone_Effect-Labor_Day.png', ''),
(4, 'Mars Telkom University', 127, 'Telkom University', 'Mars', 0, 'https://drive.usercontent.google.com/download?id=1Ng1L9tC1se-dtEPVDwTc33WsUMfnnS7G&export=download&authuser=0&confirm=t&uuid=5cf96492-bec4-478f-97dc-3607aa3155e3&at=APZUnTVPdyeBu6fiNHGHonBtgSjw:1704117799108', 'https://upload.wikimedia.org/wikipedia/commons/0/03/Logo_Telkom_University_potrait.png', ''),
(5, 'NEXT LEVEL', 250, 'YU-KI', 'Techno', 0, 'https://drive.usercontent.google.com/download?id=1NBszIKzI4s5VHMsZYEcdp9cYge0igyy-&export=download&authuser=0&confirm=t&uuid=17175404-e0c2-42a2-a384-abcf4a202d49&at=APZUnTUxTaSwKuOf02kCpfl2eIbh:1704117824410', 'https://static.wikia.nocookie.net/kamenrider/images/0/01/NEXT_LEVEL_YU-KI.jpg', ''),
(6, 'Almighty ~ Kamen no Yakusoku', 244, 'Tokyo Ska Paradise', 'Ska', 0, 'https://drive.usercontent.google.com/download?id=1HNQDkZbigzZX76cnFUehup6pB8nKlx40&export=download&authuser=0&confirm=t&uuid=ee70c846-cc36-4136-86ed-79b1579fa045&at=APZUnTWw32heujjzTl_Eii7GDk9h:1704117967783', 'https://i1.sndcdn.com/artworks-PrWYzTXXYjbW0yYs-2nujcw-t500x500.jpg', ''),
(7, 'Zenryoku King', 188, 'Takayuki Furukawa', 'Rock', 0, 'https://drive.usercontent.google.com/download?id=1602gLJ0p48dMvEiURvdK0jDoZVKe4B40&export=download&authuser=0&confirm=t&uuid=4c7aaf69-5d7f-409c-a276-ecf799b08fd8&at=APZUnTUji4LLaALjjpOno_5oqNWH:1704117988128', 'https://is1-ssl.mzstatic.com/image/thumb/Music126/v4/61/98/97/619897ab-4c6d-f32d-3b88-0221efcf00cd/COKM-44496.jpg/375x375bb.jpg', ''),
(8, 'Luna', 256, 'KINEMA106', 'doujin', 0, 'https://drive.usercontent.google.com/download?id=19cMPW0NmlVee38zM_67T8UNbLihmhJrr&export=download&authuser=0&confirm=t&uuid=1d173a9d-e7d6-4756-901c-33040eaa22ce&at=APZUnTWTZVhRhQUrBvqePycy5lNA:1704118027150', 'https://i.ytimg.com/vi/CUzcB_kPrhs/maxresdefault.jpg', ''),
(9, 'BLACK STAR', 203, 'MindaRyn', 'Rock', 0, 'https://drive.usercontent.google.com/download?id=1KoenT51BYisLaY807Sia2nJRb-kAiKsV&export=download&authuser=0&confirm=t&uuid=58537cc3-c286-4ee2-a605-dee63bc65d39&at=APZUnTUFmhzFmBVx6Ia1WCwoQqEE:1704118053109', 'https://i.ytimg.com/vi/Zs2GPhjHbrk/maxresdefault.jpg', ''),
(10, 'MeltyBlood', 10, 'Mintjam', 'rock', 0, 'https://drive.google.com/uc?export=download&id=11mXNsNJbqq6WEGN6HwBGw2-LQ9E57A9c', '-', '-');

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
(762, 'abijar', '111'),
(6221, 'Pramudya', '55550000'),
(7240, 'suharto', '111');

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
(7240, 5, './src/Music/NEXT LEVEL.mp3'),
(7240, 4, './src/Music/Mars Telkom University.mp3'),
(7240, 9, './src/Music/BLACK STAR.mp3'),
(762, 2, './src/Music/Bokura no spectre.mp3'),
(762, 7, './src/Music/Zenryoku King.mp3'),
(762, 4, './src/Music/Mars Telkom University.mp3');

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
  ADD KEY `SongID` (`SongID`),
  ADD KEY `PlaylistID` (`PlaylistID`);

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
  ADD KEY `usersong_ibfk_1` (`SongID`),
  ADD KEY `usersong_ibfk_2` (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `playlist`
--
ALTER TABLE `playlist`
  MODIFY `PlaylistID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

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
  ADD CONSTRAINT `playlistsong_ibfk_1` FOREIGN KEY (`SongID`) REFERENCES `song` (`SongID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `playlistsong_ibfk_2` FOREIGN KEY (`PlaylistID`) REFERENCES `playlist` (`PlaylistID`) ON DELETE CASCADE ON UPDATE CASCADE;

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
