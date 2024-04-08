-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 28, 2022 at 09:54 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


-- --------------------------------------------------------

--
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
CREATE TABLE `authors` (
  `Id` int(11) NOT NULL,
  `Name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Country` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `authors`:
--

--
-- Dumping data for table `authors`
--

INSERT INTO `authors` (`Id`, `Name`, `Country`) VALUES
(1, 'J.D. Salinger', 'USA'),
(2, 'F. Scott. Fitzgerald', 'USA'),
(3, 'Jane Austen', 'UK'),
(4, 'Scott Hanselman', 'USA'),
(5, 'Jason N. Gaylord', 'USA'),
(6, 'Pranav Rastogi', 'India'),
(7, 'Todd Miranda', 'USA'),
(8, 'Christian Wenz', 'USA'),
(9, 'Morgan Greene', 'UK');

-- --------------------------------------------------------

--
-- Table structure for table `bookcomment`
--

DROP TABLE IF EXISTS `bookcomment`;
CREATE TABLE `bookcomment` (
  `Id` int(11) NOT NULL,
  `BookId` int(11) NOT NULL,
  `Comment` varchar(10000) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `bookcomment`:
--   `BookId`
--       `books` -> `Id`
--

--
-- Dumping data for table `bookcomment`
--

INSERT INTO `bookcomment` (`Id`, `BookId`, `Comment`) VALUES
(1, 3, 'Franny and Zooey is a book by American author J. D. Salinger which comprises his short story \"Franny\" and novella Zooey. The two works were published together as a book in 1961, having originally appeared in The New Yorker in 1955 and 1957 respective'),
(2, 3, 'I read this marvellous book in the winter of 1973-74 and it marked for me a moment at which my adult intelligence was crystallized. The product was a plodding, alienated way of thinking that marked me with a modern label: a keenly sensitive existenti'),
(3, 3, 'So, this semester I am teaching a course on postwar American novels. I am basically a former high school English teacher who became an English educator (preparing people to become English teachers themselves), and only relatively recently have been a'),
(4, 3, 'This is in actuality two short stories combined by the enigmatic writer to form a novel and even together not very long at that.. The opening looks rather ordinary a boy waits for his girl at a train station ( set in the 1950\'s) in an unnamed city in'),
(5, 2, 'If I can get serious for a moment, and cast aside the brittle, smartassed, persona that the social networking aspect of goodreads tends to bring out, I\'d like to try to express what it is that drives me in this life. It is the following belief, insti'),
(6, 2, 'If kidnappers had snatched up J D Salinger some time in the early 1970s, driven like madmen through the night and the next day too and imprisoned him in a small but pleasant room somewhere near Boise, furnished him with with all mod cons, and told hi'),
(7, 1, 'I LOVE IT when I go into a book with low expectations and it ends up knocking me on my ass. Admittedly, this is tougher to do with \"classics\" but it certainly happened in this case. I remember first reading this in school (like many of us) and not th'),
(8, 1, 'I read this book for the first time in the 8th grade. I had to get my mom to sign a permission slip because of the cursing. Before I began reading, I had so many expectations. Back then, I read Seventeen Magazine, and back then, Seventeen Magazine ra'),
(9, 1, 'My theory as to this book\'s unusually polarizing nature: either you identify with Holden Caulfield or you don\'t.\r\n\r\nThose who see themselves (either as they were or, God help them, as they are) in Holden see a misunderstood warrior-poet, fighting the'),
(10, 1, 'Sometimes truth isn\'t just stranger than fiction, it\'s also more interesting and better plotted. Salinger helped to pioneer a genre where fiction was deliberately less remarkable than reality. His protagonist says little, does little, and thinks litt'),
(11, 1, 'First of all, this is a shitty way to start a novel no matter how you want to introduce your main character.\r\n\r\nIf you really want to hear about it, the first thing you\'ll probably want to know is where I was born and what my lousy childhood was like');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `Id` int(11) NOT NULL,
  `Title` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `books`:
--

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`Id`, `Title`) VALUES
(1, 'The Catcher in the Rye'),
(2, 'Nine Stories'),
(3, 'Franny and Zooey'),
(4, 'The Great Gatsby'),
(5, 'Tender id the Night'),
(6, 'Pride and Prejudice'),
(7, 'Professional ASP.NET 4.5 in C# and VB'),
(12, 'The Book Thief'),
(13, 'The Man Who Died Twice: Thursday Murder Club'),
(14, 'Angel Maker');

-- --------------------------------------------------------

--
-- Table structure for table `booksauthors`
--

DROP TABLE IF EXISTS `booksauthors`;
CREATE TABLE `booksauthors` (
  `AuthorId` int(11) NOT NULL,
  `BookId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `booksauthors`:
--   `AuthorId`
--       `authors` -> `Id`
--   `BookId`
--       `books` -> `Id`
--

--
-- Dumping data for table `booksauthors`
--

INSERT INTO `booksauthors` (`AuthorId`, `BookId`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 12),
(2, 4),
(2, 5),
(3, 6),
(4, 7),
(5, 7),
(6, 7),
(7, 7),
(8, 7),
(8, 13),
(9, 14);

-- --------------------------------------------------------

--
-- Table structure for table `booksummary`
--

DROP TABLE IF EXISTS `booksummary`;
CREATE TABLE `booksummary` (
  `Id` int(11) NOT NULL,
  `BookId` int(11) NOT NULL,
  `Summary` varchar(10000) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- RELATIONSHIPS FOR TABLE `booksummary`:
--   `BookId`
--       `books` -> `Id`
--

--
-- Dumping data for table `booksummary`
--

INSERT INTO `booksummary` (`Id`, `BookId`, `Summary`) VALUES
(1, 1, 'The Catcher in the Rye is a novel by J. D. Salinger, partially published in serial form in 1945–1946 and as a novel in 1951. It was originally intended for adults but is often read by adolescents for its themes of angst, alienation, and as a critique'),
(3, 2, 'Nine Stories is a collection of short stories by American fiction writer J. D. Salinger published in April 1953. It includes two of his most famous short stories, \"A Perfect Day for Bananafish\" and \"For Esmé – with Love and Squalor\".'),
(4, 3, 'Franny and Zooey is a book by American author J. D. Salinger which comprises his short story \"Franny\" and novella Zooey. The two works were published together as a book in 1961, having originally appeared in The New Yorker in 1955 and 1957 respective'),
(5, 4, 'Nick Carraway, a World War I veteran who moves to New York with the hope of making it big, finds himself attracted to Jay Gatsby and his flamboyant lifestyle.'),
(6, 5, 'Tender Is the Night is the fourth and final novel completed by American writer F. Scott Fitzgerald. The work was first serialized in Scribner\'s Magazine between January and April 1934 in four issues. The title is taken from the poem \"Ode to a Nightin'),
(7, 6, 'Pride and Prejudice is an 1813 novel of manners written by Jane Austen. The novel follows the character development of Elizabeth Bennet, the dynamic protagonist of the book who learns about the repercussions of hasty judgments and comes to appreciate'),
(8, 7, 'ASP.NET is Microsoft′s technology for building dynamically generated web pages from database content. Originally introduced in 2002, ASP.NET has undergone many changes in multiple versions and iterations as developers have gained a decade of experien'),
(10, 12, 'Geoffrey Rush and Emily Watson star in this moving film based on the bestseller about a girl (Sophie N?lisse) who transforms the lives of those around her in World War II Germany.'),
(11, 13, 'Elizabeth has received a letter from an old colleague, a man with whom she has a long history. He\'s made a big mistake, and he needs her help. His story involves stolen diamonds, a violent mobster and a very real threat to his life.'),
(12, 14, 'When a teenage girl is found dead in the woods, her body posed like an angel, Stockholm holds its breath. The kill bears a chilling resemblance to those of the Angel Maker, a serial killer caught two decades ago');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `authors`
--
ALTER TABLE `authors`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `bookcomment`
--
ALTER TABLE `bookcomment`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `BookId` (`BookId`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `booksauthors`
--
ALTER TABLE `booksauthors`
  ADD UNIQUE KEY `AuthorId_2` (`AuthorId`,`BookId`),
  ADD KEY `AuthorId` (`AuthorId`),
  ADD KEY `BookId` (`BookId`);

--
-- Indexes for table `booksummary`
--
ALTER TABLE `booksummary`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `BookId_2` (`BookId`),
  ADD KEY `BookId` (`BookId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `authors`
--
ALTER TABLE `authors`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `bookcomment`
--
ALTER TABLE `bookcomment`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `booksummary`
--
ALTER TABLE `booksummary`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookcomment`
--
ALTER TABLE `bookcomment`
  ADD CONSTRAINT `bookcomment_ibfk_1` FOREIGN KEY (`BookId`) REFERENCES `books` (`Id`);

--
-- Constraints for table `booksauthors`
--
ALTER TABLE `booksauthors`
  ADD CONSTRAINT `booksauthors_ibfk_1` FOREIGN KEY (`AuthorId`) REFERENCES `authors` (`Id`),
  ADD CONSTRAINT `booksauthors_ibfk_2` FOREIGN KEY (`BookId`) REFERENCES `books` (`Id`);

--
-- Constraints for table `booksummary`
--
ALTER TABLE `booksummary`
  ADD CONSTRAINT `booksummary_ibfk_1` FOREIGN KEY (`BookId`) REFERENCES `books` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
