CREATE SCHEMA `codetest` DEFAULT CHARACTER SET utf8 ;

USE CODETEST;

CREATE TABLE `boardattach` (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `boardSeq` int(11) NOT NULL,
  `fileName` varchar(150) NOT NULL,
  `reg_date` datetime NOT NULL,
  `use_yn` varchar(2) NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`seq`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



CREATE TABLE `board` (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `b_title` varchar(100) NOT NULL,
  `b_contents` varchar(500) NOT NULL,
  `b_views` int(11) NOT NULL DEFAULT '0',
  `b_regdate` datetime NOT NULL,
  `b_writename` varchar(20) NOT NULL,
  `reg_date` datetime NOT NULL,
  `use_yn` varchar(2) NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


