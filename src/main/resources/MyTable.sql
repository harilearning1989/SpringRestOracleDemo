CREATE OR REPLACE PACKAGE test_pkg AS
   PROCEDURE in_only_test (inParam1 IN VARCHAR2);
   PROCEDURE in_and_out_test (inParam1 IN VARCHAR2, outParam1 OUT VARCHAR2);
END test_pkg;
/

CREATE OR REPLACE PACKAGE BODY test_pkg AS
   PROCEDURE in_only_test(inParam1 IN VARCHAR2) AS
   BEGIN
      DBMS_OUTPUT.PUT_LINE('in_only_test');
   END in_only_test;
   PROCEDURE in_and_out_test(inParam1 IN VARCHAR2, outParam1 OUT VARCHAR2) AS
   BEGIN
      outParam1 := 'Woohoo Im an outparam, and this is my inparam ' || inParam1;
   END in_and_out_test;
END test_pkg;
/

-- A simple, reusable person type
CREATE TYPE person AS OBJECT(
  id NUMBER(7),
  name VARCHAR2(100)
);

-- An array of such users
CREATE TYPE person_array AS VARRAY(10) OF person;

-- An unnested array of such users used in SQL:
SELECT * FROM TABLE(person_array(
  person(1, 'Jim'),
  person(2, 'Joe')
));
