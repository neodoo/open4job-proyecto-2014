USE `opensigad`;
-- MySQL dump 10.13  Distrib 5.5.41, for debian-linux-gnu (x86_64)
--
-- Host: 54.154.192.80    Database: opensigad
-- ------------------------------------------------------
-- Server version	5.5.42

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
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,1,'N1','A1','A2','h',NULL,'dni','25167317G','0000-00-00','Zaragoza','ES741','ES');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `alumno_contacto`
--

LOCK TABLES `alumno_contacto` WRITE;
/*!40000 ALTER TABLE `alumno_contacto` DISABLE KEYS */;
INSERT INTO `alumno_contacto` VALUES (1,1,'telefono','635650100',1),(2,1,'telefono','976202020',0);
/*!40000 ALTER TABLE `alumno_contacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `alumno_direccion`
--

LOCK TABLES `alumno_direccion` WRITE;
/*!40000 ALTER TABLE `alumno_direccion` DISABLE KEYS */;
INSERT INTO `alumno_direccion` VALUES (1,1,'D1',50005,'Zaragoza','ES741','ES',1),(2,1,'D2',50001,'Zaragoza','ES741','ES',0);
/*!40000 ALTER TABLE `alumno_direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `alumno_matricula`
--

LOCK TABLES `alumno_matricula` WRITE;
/*!40000 ALTER TABLE `alumno_matricula` DISABLE KEYS */;
INSERT INTO `alumno_matricula` VALUES (3,1,1,0,1,'1',1);
/*!40000 ALTER TABLE `alumno_matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `alumno_nota`
--

LOCK TABLES `alumno_nota` WRITE;
/*!40000 ALTER TABLE `alumno_nota` DISABLE KEYS */;
INSERT INTO `alumno_nota` VALUES (2,3,'1',1,'1','Suspenso');
/*!40000 ALTER TABLE `alumno_nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `alumno_seguimiento`
--

LOCK TABLES `alumno_seguimiento` WRITE;
/*!40000 ALTER TABLE `alumno_seguimiento` DISABLE KEYS */;
INSERT INTO `alumno_seguimiento` VALUES (1,3,'0000-00-00','1',1,'falta',0,'Ha roto dos sillas.');
/*!40000 ALTER TABLE `alumno_seguimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `alumno_tutor`
--

LOCK TABLES `alumno_tutor` WRITE;
/*!40000 ALTER TABLE `alumno_tutor` DISABLE KEYS */;
INSERT INTO `alumno_tutor` VALUES (1,1,1,'Padre');
/*!40000 ALTER TABLE `alumno_tutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `centro`
--

LOCK TABLES `centro` WRITE;
/*!40000 ALTER TABLE `centro` DISABLE KEYS */;
INSERT INTO `centro` VALUES (0,'Centro 1','Centro 1','Centro 1','50005','Zaragoza',NULL,'ES',NULL,'976253520','info@neodoo.es');
/*!40000 ALTER TABLE `centro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ensenanza`
--

LOCK TABLES `ensenanza` WRITE;
/*!40000 ALTER TABLE `ensenanza` DISABLE KEYS */;
INSERT INTO `ensenanza` VALUES (1,1,'E1','E1',100);
/*!40000 ALTER TABLE `ensenanza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ensenanza_ciclo`
--

LOCK TABLES `ensenanza_ciclo` WRITE;
/*!40000 ALTER TABLE `ensenanza_ciclo` DISABLE KEYS */;
INSERT INTO `ensenanza_ciclo` VALUES (1,1,1);
/*!40000 ALTER TABLE `ensenanza_ciclo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ensenanza_curso`
--

LOCK TABLES `ensenanza_curso` WRITE;
/*!40000 ALTER TABLE `ensenanza_curso` DISABLE KEYS */;
INSERT INTO `ensenanza_curso` VALUES (1,1,1);
/*!40000 ALTER TABLE `ensenanza_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ensenanza_materia`
--

LOCK TABLES `ensenanza_materia` WRITE;
/*!40000 ALTER TABLE `ensenanza_materia` DISABLE KEYS */;
INSERT INTO `ensenanza_materia` VALUES (1,1,'M1',100,10);
/*!40000 ALTER TABLE `ensenanza_materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ensenanza_tipo`
--

LOCK TABLES `ensenanza_tipo` WRITE;
/*!40000 ALTER TABLE `ensenanza_tipo` DISABLE KEYS */;
INSERT INTO `ensenanza_tipo` VALUES (1,'2014','ET1','ET1');
/*!40000 ALTER TABLE `ensenanza_tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,'G.','G.','G.','dni','25167317G',NULL,'h',NULL,'1001'),(4,'H.','H.','H.','dni','25167318H',NULL,'m',NULL,'2002');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `territorio`
--

LOCK TABLES `territorio` WRITE;
/*!40000 ALTER TABLE `territorio` DISABLE KEYS */;
INSERT INTO `territorio` VALUES ('ES','España'),('ES741','Zaragoza'),('ES742','Huesca'),('ES743','Teruel');
/*!40000 ALTER TABLE `territorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tutor`
--

LOCK TABLES `tutor` WRITE;
/*!40000 ALTER TABLE `tutor` DISABLE KEYS */;
INSERT INTO `tutor` VALUES (1,'T1','T1','T1','dni','25167317G','0000-00-00','h','976253520','info@neodoo.es');
/*!40000 ALTER TABLE `tutor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-23 21:58:07
