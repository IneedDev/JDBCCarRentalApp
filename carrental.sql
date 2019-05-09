-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 09 Maj 2019, 16:30
-- Wersja serwera: 10.1.38-MariaDB
-- Wersja PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `carrental`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tadmins`
--

CREATE TABLE `tadmins` (
  `AdminID` int(11) NOT NULL,
  `Name` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `Login` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `Password_not_encrypted` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `Password_encrypted` varchar(255) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `tadmins`
--

INSERT INTO `tadmins` (`AdminID`, `Name`, `Login`, `Password_not_encrypted`, `Password_encrypted`) VALUES
(1, 'John', 'Admin001', 'q', '7694f4a66316e53c8cdd9d9954bd611d');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tcars`
--

CREATE TABLE `tcars` (
  `CarID` int(11) NOT NULL,
  `Type` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `Name` varchar(20) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `tcars`
--

INSERT INTO `tcars` (`CarID`, `Type`, `Name`) VALUES
(1, 'Off Road', 'Nissan Patrol'),
(2, 'Off Road', 'Nissan Patrol Long'),
(3, 'Off Road', 'Suzuki Vitara'),
(4, 'Limusin', 'Daimler'),
(5, 'City Car', 'Micra');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tclients`
--

CREATE TABLE `tclients` (
  `ClientID` int(11) NOT NULL,
  `Name` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `Login` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `Password_not_encrypted` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `Password_encrypted` varchar(255) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `tclients`
--

INSERT INTO `tclients` (`ClientID`, `Name`, `Login`, `Password_not_encrypted`, `Password_encrypted`) VALUES
(1, 'q', 'w', 'q', '7694f4a66316e53c8cdd9d9954bd611d'),
(2, 'e', 'e', 'e', 'e1671797c52e15f763380b45e841ec32'),
(3, 'Pawel', 'Pawellogin', 'sasanka01', '4579e551142ce1e855f84e8b3b69b0ef'),
(4, 'Paul', 'login1', 'aa', '4124bc0a9335c27f086f24ba207a4912'),
(5, 'Paul', 'login1', 'aa', '4124bc0a9335c27f086f24ba207a4912'),
(6, 'Paul', 'login1', 'aa', '4124bc0a9335c27f086f24ba207a4912'),
(7, 'wer', 'sdf', 'sdf', 'd9729feb74992cc3482b350163a1a010'),
(8, 'ewr', 'dsfsdf', 'J@vaC0deG##ks', 'bedcd6ca86f806038ae583c66823664b');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `treservations`
--

CREATE TABLE `treservations` (
  `CarID` int(10) NOT NULL,
  `ReservationStartDate` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `ReservationEndDate` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `Pesel` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `ReservationID` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `treservations`
--

INSERT INTO `treservations` (`CarID`, `ReservationStartDate`, `ReservationEndDate`, `Pesel`, `ReservationID`) VALUES
(2, '2019-07-10', '2019-07-15', '86175598970', 1),
(2, '2019-08-11', '2019-08-11', '8798789564', 2),
(2, '2019-08-11', '2019-08-15', '8798789564', 3),
(2, '2019-09-11', '2019-09-19', '12459878654', 4),
(2, '2019-08-11', '2019-08-15', '4', 5),
(2, '2019-08-11', '2019-08-15', '54', 6);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `tcars`
--
ALTER TABLE `tcars`
  ADD PRIMARY KEY (`CarID`);

--
-- Indeksy dla tabeli `tclients`
--
ALTER TABLE `tclients`
  ADD PRIMARY KEY (`ClientID`);

--
-- Indeksy dla tabeli `treservations`
--
ALTER TABLE `treservations`
  ADD PRIMARY KEY (`ReservationID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `tcars`
--
ALTER TABLE `tcars`
  MODIFY `CarID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT dla tabeli `tclients`
--
ALTER TABLE `tclients`
  MODIFY `ClientID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT dla tabeli `treservations`
--
ALTER TABLE `treservations`
  MODIFY `ReservationID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
