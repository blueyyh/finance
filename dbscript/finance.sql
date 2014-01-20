

DROP database if exists eisenmann;
CREATE DATABASE eisenmann;

GRANT all privileges on eisenmann.* to 'eisenmann'@'%' identified by 'eisenmann';

GRANT usage on *.* to 'eisenmann'@'%' identified by 'eisenmann';
set global wait_timeout=31536000;

USE eisenmann;
CREATE TABLE CASH_IN_ADVANCE
(
        ID int unsigned not null auto_increment primary key,		
		chnName text,
		empName text,
		balance DECIMAL(10,2) default 0.0,
		remark1 text,
		vouchNo text,
		dateTerm datetime NULL,
		remark2 text,
		mailAddress text
);

CREATE TABLE EMPLOYEE_INFO
(
        ID int unsigned not null auto_increment primary key,		
		chnName text,
		empName text,
		mailAddress text

);
