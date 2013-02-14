DROP DATABASE IF EXISTS tme_ntw;
CREATE DATABASE IF NOT EXISTS tme_ntw;

USE tme_ntw;

CREATE TABLE history (
	id int primary key auto_increment,
	log TEXT,
	published timestamp 
)ENGINE=MyISAM;

CREATE TABLE users (
	id int primary key auto_increment,
	mail varchar(70),
	password varchar(50)
)ENGINE=MyISAM;

CREATE TABLE french_area (
	id int primary key,
	area varchar(50)
)ENGINE=MyISAM;

CREATE TABLE broker (
	id int primary key auto_increment,
	name varchar(50),
	bank varchar(30)
)ENGINE=MyISAM;

CREATE TABLE transaction (
	id int primary key auto_increment,
	id_user int,
	id_broker int,
	price double,
	realised timestamp,
	INDEX(id_user),
	INDEX(id_broker),
	CONSTRAINT FOREIGN KEY (id_user) REFERENCES users(id) ON UPDATE CASCADE ON DELETE RESTRICT,
	CONSTRAINT FOREIGN KEY (id_broker) REFERENCES broker(id) ON UPDATE CASCADE ON DELETE RESTRICT
)ENGINE=MyISAM; 
