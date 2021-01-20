

CREATE OR REPLACE PROCEDURE count_regions (
   code IN NUMBER,
   total_regions OUT NUMBER )
AS
BEGIN
    SELECT COUNT(*) INTO total_regions
    FROM countries
    WHERE REGION_CODE = code;
END;
/

SET serveroutput on;
DECLARE
    code_In number;
    count_Out varchar2(100);
BEGIN
    code_In := 9;
    count_regions(code_In, count_Out);
    dbms_output.put_line('count_Out:= ' || count_Out);
END;
/

--==================================================================

create or replace NONEDITIONABLE PACKAGE test_pkg AS
   PROCEDURE in_only_test (inParam1 IN VARCHAR2);
   PROCEDURE in_and_out_test (inParam1 IN VARCHAR2, outParam1 OUT VARCHAR2);
   FUNCTION HELLO_WORLD(TEXT VARCHAR2) RETURN VARCHAR2;
   --SELECT  test_pkg.HELLO_WORLD('Hari')  FROM dual;
END test_pkg;

create or replace NONEDITIONABLE PACKAGE BODY test_pkg AS
   PROCEDURE in_only_test(inParam1 IN VARCHAR2) AS
   BEGIN
      DBMS_OUTPUT.PUT_LINE('in_only_test');
   END in_only_test;
   PROCEDURE in_and_out_test(inParam1 IN VARCHAR2, outParam1 OUT VARCHAR2) AS
   BEGIN
      outParam1 := 'Woohoo Im an outparam, and this is my inparam ' || inParam1;
   END in_and_out_test;
   FUNCTION HELLO_WORLD(TEXT VARCHAR2) RETURN VARCHAR2 IS
  BEGIN
    RETURN 'HELLO WORLD ' || TEXT;
  END;
END test_pkg;
--==========================================================================