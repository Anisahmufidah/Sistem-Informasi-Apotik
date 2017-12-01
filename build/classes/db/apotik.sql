-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: apotik
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `obat`
--

DROP TABLE IF EXISTS `obat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `obat` (
  `idObat` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) DEFAULT NULL,
  `harga` float DEFAULT NULL,
  `tipeObat` varchar(50) DEFAULT NULL,
  `jum` int(11) DEFAULT NULL,
  PRIMARY KEY (`idObat`),
  UNIQUE KEY `idObat_UNIQUE` (`idObat`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obat`
--

LOCK TABLES `obat` WRITE;
/*!40000 ALTER TABLE `obat` DISABLE KEYS */;
INSERT INTO `obat` VALUES (1,'paracetamol',5000,'generic',5),(2,'bisolvon',10000,'generic',3);
/*!40000 ALTER TABLE `obat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orang`
--

DROP TABLE IF EXISTS `orang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orang` (
  `idOrang` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) DEFAULT NULL,
  `noHp` varchar(15) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tipeOrang` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOrang`),
  UNIQUE KEY `idOrang_UNIQUE` (`idOrang`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orang`
--

LOCK TABLES `orang` WRITE;
/*!40000 ALTER TABLE `orang` DISABLE KEYS */;
INSERT INTO `orang` VALUES (1,'akmal','0821923242','Jl Kiaracondong no 255','akmafdy','admin',1),(2,'andy','08123435','Jl Dayeuh kolot','andy','admin',2);
/*!40000 ALTER TABLE `orang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaksi`
--

DROP TABLE IF EXISTS `transaksi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaksi` (
  `idTransaksi` int(11) NOT NULL AUTO_INCREMENT,
  `idPembeli` int(11) DEFAULT NULL,
  `idKasir` int(11) DEFAULT NULL,
  `tglTrx` date DEFAULT NULL,
  `totalHarga` float DEFAULT NULL,
  PRIMARY KEY (`idTransaksi`),
  UNIQUE KEY `idTransaksi_UNIQUE` (`idTransaksi`),
  KEY `fk_transaksi_1_idx` (`idKasir`),
  KEY `fk_transaksi_20_idx` (`idPembeli`),
  CONSTRAINT `fk_transaksi_1` FOREIGN KEY (`idKasir`) REFERENCES `orang` (`idOrang`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaksi_20` FOREIGN KEY (`idPembeli`) REFERENCES `orang` (`idOrang`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaksi`
--

LOCK TABLES `transaksi` WRITE;
/*!40000 ALTER TABLE `transaksi` DISABLE KEYS */;
INSERT INTO `transaksi` VALUES (1,1,2,'2017-01-01',5000);
/*!40000 ALTER TABLE `transaksi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaksiDetail`
--

DROP TABLE IF EXISTS `transaksiDetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaksiDetail` (
  `idTransaksiDetail` int(11) NOT NULL AUTO_INCREMENT,
  `idTransaksi` int(11) DEFAULT NULL,
  `idObat` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `harga` float DEFAULT NULL,
  PRIMARY KEY (`idTransaksiDetail`),
  KEY `fk_transaksiDetail_1_idx` (`idTransaksi`),
  KEY `fk_transaksiDetail_2_idx` (`idObat`),
  CONSTRAINT `fk_transaksiDetail_1` FOREIGN KEY (`idTransaksi`) REFERENCES `transaksi` (`idTransaksi`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaksiDetail_2` FOREIGN KEY (`idObat`) REFERENCES `obat` (`idObat`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaksiDetail`
--

LOCK TABLES `transaksiDetail` WRITE;
/*!40000 ALTER TABLE `transaksiDetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaksiDetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'apotik'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-01 13:02:40
