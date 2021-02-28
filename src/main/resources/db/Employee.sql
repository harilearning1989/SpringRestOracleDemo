CREATE TABLE employees (
    id NUMBER ,
    first_name      VARCHAR2(20),
    last_name       VARCHAR2(20),
    email_address   VARCHAR2(20),
    CONSTRAINT employees_id_pk PRIMARY KEY(id)
);

CREATE SEQUENCE EMP_SEQ
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

CREATE TABLE employees (
    id NUMBER GENERATED ALWAYS AS IDENTITY ( START WITH 1 INCREMENT BY 1 ),
    first_name      VARCHAR2(20),
    last_name       VARCHAR2(20),
    email_address   VARCHAR2(20)
);

CREATE TABLE "EMPLOYEES"
   ("EMP_ID" NUMBER GENERATED BY DEFAULT AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOT NULL ENABLE,
	"FIRST_NAME" VARCHAR2(50 BYTE),
	"LAST_NAME" VARCHAR2(50 BYTE),
	"EMAIL_ADDRESS" VARCHAR2(100 BYTE),
	PRIMARY KEY (employeeID)
   )

insert into employees (EMP_ID,
 FIRST_NAME,
 LAST_NAME,
 EMAIL_ADDRESS) values (001,'Diane','Murphy','19,Quaker Ridge Rd,06801');

insert into employees (EMP_ID,
 FIRST_NAME,
 LAST_NAME,
 EMAIL_ADDRESS) values (002,'Jeff','Firrelli','1000,Coney Island Ave,11230');

insert into employees (EMP_ID,
 FIRST_NAME,
 LAST_NAME,
 EMAIL_ADDRESS) values (003,'Gerard','Bondur','2962,Dunedin CvGermantown,38138');

insert into employees (EMP_ID,
 FIRST_NAME,
 LAST_NAME,
 EMAIL_ADDRESS) values (004,'Vanauf','George','1500,Vance Ave Memphis,38104');

insert into employees (EMP_ID,
 FIRST_NAME,
 LAST_NAME,
 EMAIL_ADDRESS) values (005,'King','Tom','1577,Lobby Ave,38804');