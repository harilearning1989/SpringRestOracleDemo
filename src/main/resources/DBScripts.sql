
select * from cities;
select * from countries;
select * from crop_insurance;
select * from emp_temp;
select * from employee;
select * from employees;
select * from mytable;
select * from sales_order_info;
select * from student_info;
select * from tutorials;

--Countries List
CREATE TABLE countries(
    country_id NUMBER GENERATED BY DEFAULT AS IDENTITY,
    country_name VARCHAR2(100) NOT NULL,
    alpha2 char(2),
    alpha3 char(3),
    country_code NUMBER(10,0),
    region VARCHAR2(100),
    sub_region VARCHAR2(100),
    intermediate_region VARCHAR2(100),
    region_code NUMBER(10,0),
    sub_region_code NUMBER(10,0),
    intermediate_region_code NUMBER(10,0),
    CONSTRAINT country_id_PK PRIMARY KEY(country_id)
);

create table countries_bkp as select * from countries;

--=============Sales Order Data=======================================
CREATE TABLE sales_order_info(
    sales_id NUMBER GENERATED BY DEFAULT AS IDENTITY,
    Region VARCHAR2(50) NOT NULL,
    Country VARCHAR2(50) NOT NULL,
	Item_Type varchar2(50),
	Sales_Channel varchar2(50),
	Order_Priority char(1),
	Order_Date timestamp,
	Order_ID number(20,0),
	Ship_Date timestamp,
	Units_Sold number,
	Unit_Price number(20,5),
	Unit_Cost number(20,5),
	Total_Revenue number(20,5),
	Total_Cost number(20,5),
	Total_Profit number(20,5),
    CONSTRAINT sales_id_PK PRIMARY KEY(sales_id)
);

--Order_Date,Ship_Date  while importing DD-MM-YYYY HH.MI.SS.ff7 AM

--=====================Student Info Start=========================================
CREATE TABLE student_info(
    student_id NUMBER GENERATED BY DEFAULT AS IDENTITY,
    student_name VARCHAR2(50) NOT NULL,
    father_name VARCHAR2(50) NOT NULL,
	gender varchar2(10),
	MOBILE long,
	CATEGORY varchar2(20),
    CONSTRAINT student_id_PK PRIMARY KEY(student_id)
);

select * from student_info where
(upper(GENDER)='FEMALE' and CATEGORY not in ('SC','ST') OR upper(GENDER)='MALE' and CATEGORY not in ('OC','BC-C','BC-D','SC'));

--===============Student Info End==============================================

--====================Crop Insurance=================
CREATE TABLE crop_insurance(
    serial_no NUMBER GENERATED BY DEFAULT AS IDENTITY,
    mandal_name VARCHAR2(100) ,
    village_name VARCHAR2(100) ,
	Name_of_the_Beneficiary VARCHAR2(100) ,
    Crop VARCHAR2(100) ,
	Extent_Ha  number,
    Claim_Amount_Rs  int,
    Category_Loanee_Non_Loanee VARCHAR2(10) ,
    Bank_Name  VARCHAR2(100) ,
    Branch_Name  VARCHAR2(100) ,
    Account_Number number,
    CONSTRAINT serial_no_PK PRIMARY KEY(serial_no)
);

--=======================================================
CREATE TABLE employees (
    emp_id          NUMBER
        GENERATED BY DEFAULT AS IDENTITY,
    first_name      VARCHAR2(50),
    last_name       VARCHAR2(50),
    email_address   VARCHAR2(100)
);

--=======================================================

CREATE TABLE cities(id INT, name VARCHAR(255), population INT);

INSERT INTO cities(id,name, population) VALUES(1,'Bratislava', 432000);
INSERT INTO cities(id,name, population) VALUES(2,'Budapest', 1759000);
INSERT INTO cities(id,name, population) VALUES(3,'Prague', 1280000);
INSERT INTO cities(id,name, population) VALUES(4,'Warsaw', 1748000);
INSERT INTO cities(id,name, population) VALUES(5,'Los Angeles', 3971000);
INSERT INTO cities(id,name, population) VALUES(6,'New York', 8550000);
INSERT INTO cities(id,name, population) VALUES(7,'Edinburgh', 464000);
INSERT INTO cities(id,name, population) VALUES(8,'Suzhou', 4327066);
INSERT INTO cities(id,name, population) VALUES(9,'Zhengzhou', 4122087);
INSERT INTO cities(id,name, population) VALUES(10,'Berlin', 3671000);
