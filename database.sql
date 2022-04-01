
CREATE DATABASE IF NOT EXISTS `energymon`;
USE `energymon`;


CREATE TABLE IF NOT EXISTS `payments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paidon` datetime DEFAULT NULL,
  `amount` double DEFAULT NULL,
  KEY `Index 1` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4;


CREATE TABLE IF NOT EXISTS `readings` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `value` double DEFAULT NULL,
  `moment` datetime DEFAULT NULL,
  KEY `Index 1` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2;
