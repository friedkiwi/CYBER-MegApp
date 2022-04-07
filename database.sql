
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


CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `role` varchar(50) NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2;

/* username: admin, password: nimda */
INSERT INTO `users` (`username`, `password`, `role`, `enabled`) VALUES
    ('admin', '$2a$10$zxvEq8XzYEYtNjbkRsJEbukHeRx3XS6MDXHMu8cNuNsRfZJWwswDy', 'ROLE_USER', 1);
