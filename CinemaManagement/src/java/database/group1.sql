-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th7 06, 2020 lúc 05:09 PM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `group1`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `bId` int(11) NOT NULL,
  `cusId` int(11) DEFAULT NULL,
  `sId` int(11) DEFAULT NULL,
  `dateBuy` datetime NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `billdetail`
--

CREATE TABLE `billdetail` (
  `tId` int(11) DEFAULT NULL,
  `bId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `cateId` int(11) NOT NULL,
  `cateName` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `description` varchar(500) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`cateId`, `cateName`, `description`) VALUES
(1, 'Hanh Dong', 'Hoi hop lam'),
(2, 'Kinh di', 'Ghe lam'),
(3, 'Tinh cam', 'Sen lam'),
(4, 'Trinh tham', 'Hay lam');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categoryinfilm`
--

CREATE TABLE `categoryinfilm` (
  `fId` int(11) NOT NULL,
  `cateId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customers`
--

CREATE TABLE `customers` (
  `cusId` int(11) NOT NULL,
  `levelAccount` int(11) NOT NULL,
  `totalPrice` int(11) NOT NULL,
  `totalTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `films`
--

CREATE TABLE `films` (
  `fId` int(11) NOT NULL,
  `fName` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `pId` int(11) DEFAULT NULL,
  `rating` int(11) NOT NULL,
  `limitAge` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `releaseDate` datetime NOT NULL,
  `airDate` datetime NOT NULL,
  `endDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `films`
--

INSERT INTO `films` (`fId`, `fName`, `pId`, `rating`, `limitAge`, `status`, `releaseDate`, `airDate`, `endDate`) VALUES
(1, 'NGÔI ĐỀN KỲ QUÁI 2', 3, 10, 16, 0, '2020-07-03 07:00:00', '2020-07-06 07:00:00', '2020-08-06 23:59:00'),
(2, 'KẺ XÂM NHẬP\r\n', 1, 10, 16, 1, '2020-06-26 07:00:00', '2020-07-01 07:00:00', '2020-08-01 23:59:00'),
(3, 'PHI VỤ BÃO TỐ', 2, 10, 16, 1, '2020-07-03 07:00:00', '2020-07-06 07:00:00', '2020-08-06 23:59:00'),
(4, 'ANH THỢ SỬA ỐNG NƯỚC', 2, 10, 18, 1, '2020-07-03 07:00:00', '2020-07-06 07:00:00', '2020-08-06 23:59:00'),
(5, 'EM CHƯA 18', 1, 10, 18, 2, '2019-07-03 07:00:00', '2019-07-06 07:00:00', '2019-08-06 23:59:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `formality`
--

CREATE TABLE `formality` (
  `fmId` int(11) NOT NULL,
  `fmName` varchar(5) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `description` varchar(500) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `ticketPrice` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `formality`
--

INSERT INTO `formality` (`fmId`, `fmName`, `description`, `ticketPrice`) VALUES
(1, '2D', 'Khong co kinh', 90000),
(2, '3D', 'Co kinh', 120000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `graphic`
--

CREATE TABLE `graphic` (
  `gId` int(11) NOT NULL,
  `fId` int(11) DEFAULT NULL,
  `dateUpdate` datetime NOT NULL,
  `path` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `graphic`
--

INSERT INTO `graphic` (`gId`, `fId`, `dateUpdate`, `path`) VALUES
(1, 1, '2020-07-04 22:02:39', 'Ngoi_den_ki_quai.jpg'),
(2, 2, '2020-07-04 22:02:39', 'Ke_xam_nhap.jpg'),
(3, 3, '2020-07-04 22:02:39', 'phi_vu_bao_to.jpg'),
(4, 4, '2020-07-04 22:02:39', 'sua-ong-nuoc.jpg'),
(5, 5, '2020-07-04 22:02:39', 'Em_chưa_18.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nationality`
--

CREATE TABLE `nationality` (
  `nId` int(11) NOT NULL,
  `nName` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `nationality`
--

INSERT INTO `nationality` (`nId`, `nName`) VALUES
(1, 'ThaiLand'),
(2, 'Viet Nam'),
(3, 'Han Quoc'),
(4, 'My'),
(5, 'Trung Quoc'),
(6, 'Nhat Ban');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `person`
--

CREATE TABLE `person` (
  `pId` int(11) NOT NULL,
  `dName` varchar(25) COLLATE utf8_vietnamese_ci NOT NULL,
  `nId` int(11) DEFAULT NULL,
  `gender` int(11) NOT NULL,
  `birthday` datetime NOT NULL,
  `description` varchar(1000) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `rId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `person`
--

INSERT INTO `person` (`pId`, `dName`, `nId`, `gender`, `birthday`, `description`, `rId`) VALUES
(1, 'Phontharis Chotkijsadarso', 1, 1, '1978-07-09 14:30:22', 'Thailand National Film Association Award for Best Art Direction', 1),
(2, 'Attachitsataporn', 1, 1, '1998-03-05 14:38:31', 'Phiravich Attachitsataporn, nicknamed Mean is a Thai television actor and model. He is best known for his role as Tin in the 2018 Thai television drama Love by Chance', 2),
(3, 'Timethai', 1, 1, '1996-01-02 18:38:31', 'Dharmthai Plangsilp (Thai: ธามไท แพลงศิลป์ - Thai pronunciation: [tʰɑːmtʰaɪ pʰlæŋsɪn]) (born January 2, 1996), known professionally as Timethai ', 2),
(4, 'Emile Hirsch', 4, 1, '1985-03-13 07:00:31', 'Emile Davenport Hirsch is an American actor. He is best known for portraying Chris McCandless in Into the Wild. Other roles of his are in films such as The Girl Next Door, Lords of Dogtown, Speed Racer, Milk, Lone Survivor, and Once Upon a Time in Hollywood. ', 2),
(5, 'Michael Polish', 4, 1, '1970-10-30 17:00:00', 'Michael Polish was born on October 30, 1970 in El Centro, California, USA. He is a director and producer, known for Twin Falls Idaho (1999), Northfork (2003) and Jackpot (2001). He has been married to Kate Bosworth since August 31, 2013. He was previously married to Jo Strettell.', 1),
(6, 'Mel Gibson', 4, 1, '1956-01-03 17:00:00', 'Mel Colmcille Gerard Gibson AO (born January 3, 1956)[1] is an American actor and filmmaker. He is best known for his action hero roles, particularly his breakout role as Max Rockatansky in the first three films of the post-apocalyptic action series Mad Max and as Martin Riggs in the buddy cop film series Lethal Weapon', 2),
(7, 'Won-Pyung Sohn', 3, 0, '1979-01-03 17:00:00', 'Sohn Won-pyung is a film director, screenwriter, and novelist living in South Korea. She earned a BA in social studies and philosophy at Sogang University and film directing at the Korean Academy of Film Arts.', 1),
(8, 'Kim Moo Yul', 3, 1, '1982-05-22 17:00:00', 'Kim Mu-yeol (born May 22, 1982) is a South Korean actor. Following a successful career in ... Other names, Kim Moo-yul. Education, Sungkyunkwan University', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `personinfilm`
--

CREATE TABLE `personinfilm` (
  `fId` int(11) NOT NULL,
  `pId` int(11) DEFAULT NULL,
  `description` varchar(500) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `personinfilm`
--

INSERT INTO `personinfilm` (`fId`, `pId`, `description`) VALUES
(1, 3, 'abc'),
(2, 8, 'abc'),
(3, 6, 'hihi'),
(4, 4, 'Hi');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `producers`
--

CREATE TABLE `producers` (
  `pId` int(11) NOT NULL,
  `pName` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `nId` int(11) DEFAULT NULL,
  `description` varchar(500) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `birthday` datetime NOT NULL,
  `address` varchar(500) COLLATE utf8_vietnamese_ci NOT NULL,
  `phoneNumber` varchar(15) COLLATE utf8_vietnamese_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `producers`
--

INSERT INTO `producers` (`pId`, `pName`, `nId`, `description`, `birthday`, `address`, `phoneNumber`, `email`) VALUES
(1, 'Nguyen Quoc Toan', 3, 'zxczxczxvcbcvbc', '2000-08-14 18:00:00', 'Cần Thơ', '0949668182', 'toannqce140110@fpt.edu.vn'),
(2, 'Pham Quoc Nghi', 4, 'Quai Vat', '2000-01-01 18:00:00', 'Cần Thơ', '0832629473', 'nghipqce140179@fpt.edu.vn'),
(3, 'Le Thanh Nhan', 1, 'Dep trai', '2000-07-18 17:00:00', 'Cần Thơ', '0587964355', 'nhanltce140044@fpt.edu.vn');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `rId` int(11) NOT NULL,
  `rName` varchar(25) COLLATE utf8_vietnamese_ci NOT NULL,
  `rDescription` varchar(500) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`rId`, `rName`, `rDescription`) VALUES
(1, 'Dao dien', 'Dao dien phim '),
(2, 'Dien vien', 'Dien vien dong phim '),
(3, 'Bien dich', 'Dich phim ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `room`
--

CREATE TABLE `room` (
  `rId` int(11) NOT NULL,
  `seatNumber` int(11) NOT NULL,
  `size` int(11) NOT NULL,
  `rStatus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `room`
--

INSERT INTO `room` (`rId`, `seatNumber`, `size`, `rStatus`) VALUES
(1, 64, 100, 1),
(2, 64, 100, 1),
(3, 64, 100, 1),
(4, 64, 100, 1),
(5, 64, 100, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roomseat`
--

CREATE TABLE `roomseat` (
  `seatId` int(11) NOT NULL,
  `rId` int(11) DEFAULT NULL,
  `seatName` varchar(5) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `roomseat`
--

INSERT INTO `roomseat` (`seatId`, `rId`, `seatName`) VALUES
(1, 1, 'A1'),
(2, 1, 'A2'),
(3, 1, 'A3'),
(4, 1, 'A4'),
(5, 1, 'A5'),
(6, 1, 'A6'),
(7, 1, 'A7'),
(8, 1, 'A8'),
(9, 1, 'B1'),
(10, 1, 'B2'),
(11, 1, 'B3'),
(12, 1, 'B4'),
(13, 1, 'B5'),
(14, 1, 'B6'),
(15, 1, 'B7'),
(16, 1, 'B8'),
(17, 1, 'C1'),
(18, 1, 'C2'),
(19, 1, 'C3'),
(20, 1, 'C4'),
(21, 1, 'C5'),
(22, 1, 'C6'),
(23, 1, 'C7'),
(24, 1, 'C8'),
(25, 1, 'D1'),
(26, 1, 'D2'),
(27, 1, 'D3'),
(28, 1, 'D4'),
(29, 1, 'D5'),
(30, 1, 'D6'),
(31, 1, 'D7'),
(32, 1, 'D8'),
(33, 1, 'E1'),
(34, 1, 'E2'),
(35, 1, 'E3'),
(36, 1, 'E4'),
(37, 1, 'E5'),
(38, 1, 'E6'),
(39, 1, 'E7'),
(40, 1, 'E8'),
(41, 1, 'F1'),
(42, 1, 'F2'),
(43, 1, 'F3'),
(44, 1, 'F4'),
(45, 1, 'F5'),
(46, 1, 'F6'),
(47, 1, 'F7'),
(48, 1, 'F8'),
(49, 1, 'G1'),
(50, 1, 'G2'),
(51, 1, 'G3'),
(52, 1, 'G4'),
(53, 1, 'G5'),
(54, 1, 'G6'),
(55, 1, 'G7'),
(56, 1, 'G8'),
(57, 1, 'H1'),
(58, 1, 'H2'),
(59, 1, 'H3'),
(60, 1, 'H4'),
(61, 1, 'H5'),
(62, 1, 'H6'),
(63, 1, 'H7'),
(64, 1, 'H8'),
(65, 2, 'A1'),
(66, 2, 'A2'),
(67, 2, 'A3'),
(68, 2, 'A4'),
(69, 2, 'A5'),
(70, 2, 'A6'),
(71, 2, 'A7'),
(72, 2, 'A8'),
(73, 2, 'B1'),
(74, 2, 'B2'),
(75, 2, 'B3'),
(76, 2, 'B4'),
(77, 2, 'B5'),
(78, 2, 'B6'),
(79, 2, 'B7'),
(80, 2, 'B8'),
(81, 2, 'C1'),
(82, 2, 'C2'),
(83, 2, 'C3'),
(84, 2, 'C4'),
(85, 2, 'C5'),
(86, 2, 'C6'),
(87, 2, 'C7'),
(88, 2, 'C8'),
(89, 2, 'D1'),
(90, 2, 'D2'),
(91, 2, 'D3'),
(92, 2, 'D4'),
(93, 2, 'D5'),
(94, 2, 'D6'),
(95, 2, 'D7'),
(96, 2, 'D8'),
(97, 2, 'E1'),
(98, 2, 'E2'),
(99, 2, 'E3'),
(100, 2, 'E4'),
(101, 2, 'E5'),
(102, 2, 'E6'),
(103, 2, 'E7'),
(104, 2, 'E8'),
(105, 2, 'F1'),
(106, 2, 'F2'),
(107, 2, 'F3'),
(108, 2, 'F4'),
(109, 2, 'F5'),
(110, 2, 'F6'),
(111, 2, 'F7'),
(112, 2, 'F8'),
(113, 2, 'G1'),
(114, 2, 'G2'),
(115, 2, 'G3'),
(116, 2, 'G4'),
(117, 2, 'G5'),
(118, 2, 'G6'),
(119, 2, 'G7'),
(120, 2, 'G8'),
(121, 2, 'H1'),
(122, 2, 'H2'),
(123, 2, 'H3'),
(124, 2, 'H4'),
(125, 2, 'H5'),
(126, 2, 'H6'),
(127, 2, 'H7'),
(128, 2, 'H8');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `schedule`
--

CREATE TABLE `schedule` (
  `scheId` int(11) NOT NULL,
  `sesId` int(11) DEFAULT NULL,
  `fmId` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `schedule`
--

INSERT INTO `schedule` (`scheId`, `sesId`, `fmId`, `status`) VALUES
(1, 1, 1, 1),
(2, 2, 2, 1),
(3, 3, 1, 1),
(4, 4, 2, 1),
(5, 5, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `session`
--

CREATE TABLE `session` (
  `sesId` int(11) NOT NULL,
  `startTime` time NOT NULL,
  `endTime` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `session`
--

INSERT INTO `session` (`sesId`, `startTime`, `endTime`) VALUES
(1, '13:30:00', '15:30:00'),
(2, '15:50:00', '17:50:00'),
(3, '18:15:00', '20:15:00'),
(4, '20:30:00', '22:30:00'),
(5, '22:45:00', '00:45:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `staff`
--

CREATE TABLE `staff` (
  `sId` int(11) NOT NULL,
  `levelStaff` int(11) NOT NULL,
  `CMND` varchar(15) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ticket`
--

CREATE TABLE `ticket` (
  `tId` int(11) NOT NULL,
  `scheId` int(11) DEFAULT NULL,
  `seatId` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `ticket`
--

INSERT INTO `ticket` (`tId`, `scheId`, `seatId`, `status`) VALUES
(1, 1, 1, 1),
(2, 1, 2, 0),
(3, 1, 3, 0),
(4, 1, 4, 0),
(5, 1, 5, 0),
(6, 1, 6, 0),
(7, 1, 7, 0),
(8, 1, 8, 0),
(9, 1, 9, 0),
(10, 1, 10, 0),
(11, 1, 11, 0),
(12, 1, 12, 0),
(13, 1, 13, 0),
(14, 1, 14, 0),
(15, 1, 15, 0),
(16, 1, 16, 0),
(17, 1, 17, 0),
(18, 1, 18, 0),
(19, 1, 19, 0),
(20, 1, 20, 0),
(21, 1, 21, 0),
(22, 1, 22, 0),
(23, 1, 23, 0),
(24, 1, 24, 0),
(25, 1, 25, 0),
(26, 1, 26, 0),
(27, 1, 27, 0),
(28, 1, 28, 0),
(29, 1, 29, 0),
(30, 1, 30, 0),
(31, 1, 31, 0),
(32, 1, 32, 0),
(33, 1, 33, 0),
(34, 1, 34, 0),
(35, 1, 35, 0),
(36, 1, 36, 0),
(37, 1, 37, 0),
(38, 1, 38, 0),
(39, 1, 39, 0),
(40, 1, 40, 0),
(41, 1, 41, 0),
(42, 1, 42, 0),
(43, 1, 43, 0),
(44, 1, 44, 0),
(45, 1, 45, 0),
(46, 1, 46, 0),
(47, 1, 47, 0),
(48, 1, 48, 0),
(49, 1, 49, 0),
(50, 1, 50, 0),
(51, 1, 51, 0),
(52, 1, 52, 0),
(53, 1, 53, 0),
(54, 1, 54, 0),
(55, 1, 55, 0),
(56, 1, 56, 0),
(57, 1, 57, 0),
(58, 1, 58, 0),
(59, 1, 59, 0),
(60, 1, 60, 0),
(61, 1, 61, 0),
(62, 1, 62, 0),
(63, 1, 63, 0),
(64, 1, 64, 0),
(65, 2, 65, 0),
(66, 2, 66, 0),
(67, 2, 67, 0),
(68, 2, 68, 0),
(69, 2, 69, 0),
(70, 2, 70, 0),
(71, 2, 71, 0),
(72, 2, 72, 0),
(73, 2, 73, 0),
(74, 2, 74, 0),
(75, 2, 75, 0),
(76, 2, 76, 0),
(77, 2, 77, 0),
(78, 2, 78, 0),
(79, 2, 79, 0),
(80, 2, 80, 0),
(81, 2, 81, 0),
(82, 2, 82, 0),
(83, 2, 83, 0),
(84, 2, 84, 0),
(85, 2, 85, 0),
(86, 2, 86, 0),
(87, 2, 87, 0),
(88, 2, 88, 0),
(89, 2, 89, 0),
(90, 2, 90, 0),
(91, 2, 91, 0),
(92, 2, 92, 0),
(93, 2, 93, 0),
(94, 2, 94, 0),
(95, 2, 95, 0),
(96, 2, 96, 0),
(97, 2, 97, 0),
(98, 2, 98, 0),
(99, 2, 99, 0),
(100, 2, 100, 0),
(101, 2, 101, 0),
(102, 2, 102, 0),
(103, 2, 103, 0),
(104, 2, 104, 0),
(105, 2, 105, 0),
(106, 2, 106, 0),
(107, 2, 107, 0),
(108, 2, 108, 0),
(109, 2, 109, 0),
(110, 2, 110, 0),
(111, 2, 111, 0),
(112, 2, 112, 0),
(113, 2, 113, 0),
(114, 2, 114, 0),
(115, 2, 115, 0),
(116, 2, 116, 0),
(117, 2, 117, 0),
(118, 2, 118, 0),
(119, 2, 119, 0),
(120, 2, 120, 0),
(121, 2, 121, 0),
(122, 2, 122, 0),
(123, 2, 123, 0),
(124, 2, 124, 0),
(125, 2, 125, 0),
(126, 2, 126, 0),
(127, 2, 127, 0),
(128, 2, 128, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `updatehistory`
--

CREATE TABLE `updatehistory` (
  `upId` int(11) NOT NULL,
  `fId` int(11) DEFAULT NULL,
  `sId` int(11) DEFAULT NULL,
  `content` varchar(500) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `uId` int(11) NOT NULL,
  `username` varchar(25) COLLATE utf8_vietnamese_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `password` varchar(15) COLLATE utf8_vietnamese_ci NOT NULL,
  `birthday` datetime NOT NULL,
  `nId` int(11) DEFAULT NULL,
  `gender` int(11) NOT NULL,
  `address` varchar(500) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `phone` varchar(15) COLLATE utf8_vietnamese_ci NOT NULL,
  `regisDate` datetime DEFAULT current_timestamp(),
  `permission` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`bId`),
  ADD KEY `cusId` (`cusId`),
  ADD KEY `sId` (`sId`);

--
-- Chỉ mục cho bảng `billdetail`
--
ALTER TABLE `billdetail`
  ADD KEY `tId` (`tId`),
  ADD KEY `bId` (`bId`);

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`cateId`);

--
-- Chỉ mục cho bảng `categoryinfilm`
--
ALTER TABLE `categoryinfilm`
  ADD PRIMARY KEY (`fId`),
  ADD KEY `cateId` (`cateId`);

--
-- Chỉ mục cho bảng `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`cusId`);

--
-- Chỉ mục cho bảng `films`
--
ALTER TABLE `films`
  ADD PRIMARY KEY (`fId`),
  ADD KEY `pId` (`pId`);

--
-- Chỉ mục cho bảng `formality`
--
ALTER TABLE `formality`
  ADD PRIMARY KEY (`fmId`);

--
-- Chỉ mục cho bảng `graphic`
--
ALTER TABLE `graphic`
  ADD PRIMARY KEY (`gId`),
  ADD KEY `fId` (`fId`);

--
-- Chỉ mục cho bảng `nationality`
--
ALTER TABLE `nationality`
  ADD PRIMARY KEY (`nId`);

--
-- Chỉ mục cho bảng `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`pId`),
  ADD KEY `nId` (`nId`),
  ADD KEY `rId` (`rId`);

--
-- Chỉ mục cho bảng `personinfilm`
--
ALTER TABLE `personinfilm`
  ADD PRIMARY KEY (`fId`),
  ADD KEY `pId` (`pId`);

--
-- Chỉ mục cho bảng `producers`
--
ALTER TABLE `producers`
  ADD PRIMARY KEY (`pId`),
  ADD KEY `nId` (`nId`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`rId`);

--
-- Chỉ mục cho bảng `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`rId`);

--
-- Chỉ mục cho bảng `roomseat`
--
ALTER TABLE `roomseat`
  ADD PRIMARY KEY (`seatId`);

--
-- Chỉ mục cho bảng `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`scheId`),
  ADD KEY `sesId` (`sesId`),
  ADD KEY `fmId` (`fmId`);

--
-- Chỉ mục cho bảng `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`sesId`);

--
-- Chỉ mục cho bảng `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`sId`);

--
-- Chỉ mục cho bảng `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`tId`),
  ADD KEY `scheId` (`scheId`),
  ADD KEY `seatId` (`seatId`);

--
-- Chỉ mục cho bảng `updatehistory`
--
ALTER TABLE `updatehistory`
  ADD PRIMARY KEY (`upId`),
  ADD KEY `fId` (`fId`),
  ADD KEY `sId` (`sId`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uId`),
  ADD KEY `nId` (`nId`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `bill`
--
ALTER TABLE `bill`
  MODIFY `bId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `cateId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `films`
--
ALTER TABLE `films`
  MODIFY `fId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `formality`
--
ALTER TABLE `formality`
  MODIFY `fmId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `graphic`
--
ALTER TABLE `graphic`
  MODIFY `gId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `nationality`
--
ALTER TABLE `nationality`
  MODIFY `nId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `person`
--
ALTER TABLE `person`
  MODIFY `pId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `producers`
--
ALTER TABLE `producers`
  MODIFY `pId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `role`
--
ALTER TABLE `role`
  MODIFY `rId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `room`
--
ALTER TABLE `room`
  MODIFY `rId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `roomseat`
--
ALTER TABLE `roomseat`
  MODIFY `seatId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=129;

--
-- AUTO_INCREMENT cho bảng `schedule`
--
ALTER TABLE `schedule`
  MODIFY `scheId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `session`
--
ALTER TABLE `session`
  MODIFY `sesId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `ticket`
--
ALTER TABLE `ticket`
  MODIFY `tId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=129;

--
-- AUTO_INCREMENT cho bảng `updatehistory`
--
ALTER TABLE `updatehistory`
  MODIFY `upId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `uId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`cusId`) REFERENCES `customers` (`cusId`),
  ADD CONSTRAINT `bill_ibfk_2` FOREIGN KEY (`sId`) REFERENCES `staff` (`sId`);

--
-- Các ràng buộc cho bảng `billdetail`
--
ALTER TABLE `billdetail`
  ADD CONSTRAINT `billdetail_ibfk_1` FOREIGN KEY (`tId`) REFERENCES `ticket` (`tId`),
  ADD CONSTRAINT `billdetail_ibfk_2` FOREIGN KEY (`bId`) REFERENCES `staff` (`sId`);

--
-- Các ràng buộc cho bảng `categoryinfilm`
--
ALTER TABLE `categoryinfilm`
  ADD CONSTRAINT `categoryinfilm_ibfk_1` FOREIGN KEY (`fId`) REFERENCES `films` (`fId`),
  ADD CONSTRAINT `categoryinfilm_ibfk_2` FOREIGN KEY (`cateId`) REFERENCES `categories` (`cateId`);

--
-- Các ràng buộc cho bảng `customers`
--
ALTER TABLE `customers`
  ADD CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`cusId`) REFERENCES `user` (`uId`);

--
-- Các ràng buộc cho bảng `films`
--
ALTER TABLE `films`
  ADD CONSTRAINT `films_ibfk_1` FOREIGN KEY (`pId`) REFERENCES `producers` (`pId`);

--
-- Các ràng buộc cho bảng `graphic`
--
ALTER TABLE `graphic`
  ADD CONSTRAINT `graphic_ibfk_1` FOREIGN KEY (`fId`) REFERENCES `films` (`fId`);

--
-- Các ràng buộc cho bảng `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `person_ibfk_1` FOREIGN KEY (`nId`) REFERENCES `nationality` (`nId`),
  ADD CONSTRAINT `person_ibfk_2` FOREIGN KEY (`rId`) REFERENCES `role` (`rId`);

--
-- Các ràng buộc cho bảng `personinfilm`
--
ALTER TABLE `personinfilm`
  ADD CONSTRAINT `personinfilm_ibfk_1` FOREIGN KEY (`fId`) REFERENCES `films` (`fId`),
  ADD CONSTRAINT `personinfilm_ibfk_2` FOREIGN KEY (`pId`) REFERENCES `person` (`pId`);

--
-- Các ràng buộc cho bảng `producers`
--
ALTER TABLE `producers`
  ADD CONSTRAINT `producers_ibfk_1` FOREIGN KEY (`nId`) REFERENCES `nationality` (`nId`);

--
-- Các ràng buộc cho bảng `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`sesId`) REFERENCES `session` (`sesId`),
  ADD CONSTRAINT `schedule_ibfk_2` FOREIGN KEY (`fmId`) REFERENCES `formality` (`fmId`);

--
-- Các ràng buộc cho bảng `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`sId`) REFERENCES `user` (`uId`);

--
-- Các ràng buộc cho bảng `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`scheId`) REFERENCES `schedule` (`scheId`),
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`seatId`) REFERENCES `roomseat` (`seatId`);

--
-- Các ràng buộc cho bảng `updatehistory`
--
ALTER TABLE `updatehistory`
  ADD CONSTRAINT `updatehistory_ibfk_1` FOREIGN KEY (`fId`) REFERENCES `films` (`fId`),
  ADD CONSTRAINT `updatehistory_ibfk_2` FOREIGN KEY (`sId`) REFERENCES `staff` (`sId`);

--
-- Các ràng buộc cho bảng `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`nId`) REFERENCES `nationality` (`nId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
