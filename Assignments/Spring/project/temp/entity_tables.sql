DROP SCHEMA IF EXISTS `racing-demo-db`;

CREATE SCHEMA `racing-demo-db`;

use `racing-demo-db`;


DROP TABLE IF EXISTS `cars`;

CREATE TABLE `cars` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_name` varchar(128) DEFAULT NULL,
  `model_year` varchar(45) DEFAULT NULL,
  `fuel_type` varchar(45) DEFAULT NULL,
  `intake_type` varchar(45) DEFAULT NULL,
  `power` varchar(45) DEFAULT NULL,
  `torque` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `driver`;

CREATE TABLE `driver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `driver_name` varchar(45) DEFAULT NULL,
  `track_name` varchar(45) DEFAULT NULL,
  `crime` varchar(45) DEFAULT NULL,
  `sentence` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;