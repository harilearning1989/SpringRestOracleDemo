CREATE OR REPLACE PACKAGE test_pkg IS
  FUNCTION prnt_strng RETURN VARCHAR2;
  PROCEDURE proc_superhero(f_name VARCHAR2, l_name VARCHAR2);
END test_pkg;
/
CREATE OR REPLACE PACKAGE BODY test_pkg IS
  FUNCTION prnt_strng RETURN VARCHAR2 IS
    BEGIN
      RETURN 'RebellionRider.com';
    END prnt_strng;

   PROCEDURE proc_superhero(f_name VARCHAR2, l_name VARCHAR2) IS
     BEGIN
      INSERT INTO EMPLOYEES (FIRST_NAME, LAST_NAME) VALUES(f_name, l_name);
     END;

END test_pkg;
/

--===============Test Package Ended=================
--tutorialspoint.com/plsql/plsql_packages.htm
CREATE OR REPLACE PACKAGE practiced_pkg IS
  FUNCTION get_database_time RETURN VARCHAR2;
  --select practiced_pkg.get_database_time() from dual;
  PROCEDURE get_crop_by_mandal(mandal_name  IN CROP_INSURANCE.MANDAL_NAME%TYPE,crop_data_by_mandal OUT SYS_REFCURSOR);
END practiced_pkg;

CREATE OR REPLACE PACKAGE BODY practiced_pkg IS

    FUNCTION get_database_time RETURN VARCHAR2 IS
        o_date VARCHAR2(20);
    BEGIN
        SELECT to_char(sysdate, 'DD-MON-YYYY HH:MI:SS') INTO o_date FROM  dual;
        return(o_date);
    END get_database_time ;

    PROCEDURE get_crop_by_mandal (mandal_name IN CROP_INSURANCE.MANDAL_NAME%TYPE,crop_data_by_mandal   OUT   SYS_REFCURSOR) AS
    BEGIN
        OPEN crop_data_by_mandal FOR SELECT *  FROM  CROP_INSURANCE  WHERE  MANDAL_NAME LIKE '%'  || mandal_name || '%';
    END get_crop_by_mandal;

END practiced_pkg;

--====================================================================================================
