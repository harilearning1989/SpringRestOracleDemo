DROP TABLE PERSON;
DROP SEQUENCE SQ_PERSON;

CREATE TABLE PERSON(
 ID NUMBER(19),
 FIRST_NAME VARCHAR(255),
 LAST_NAME VARCHAR(255),
 ADDRESS VARCHAR(255),
 PRIMARY KEY (ID)
);

CREATE SEQUENCE SQ_PERSON MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 10;
DROP TABLE PERSON_HISTORY;
CREATE TABLE PERSON_HISTORY AS SELECT * FROM PERSON WHERE 1=0;

CREATE OR REPLACE PROCEDURE MOVE_TO_HISTORY(person_id_in IN NUMBER, msg_out OUT VARCHAR2)
IS
 temp_count NUMBER := -1;
BEGIN
   select count(*) into temp_count from PERSON p where p.id = person_id_in;
  IF temp_count > -1  THEN
      insert into PERSON_HISTORY (select * from PERSON where id = person_id_in);
      msg_out := 'Person with id: ' || person_id_in || ' moved to History table. Update count: ' || sql%Rowcount;
      delete from PERSON p where p.id = person_id_in;
  ELSE
   msg_out := 'No Person Exists with id: '|| person_id_in;
 END IF;
END;
/

CREATE OR REPLACE PROCEDURE FETCH_PERSON_HISTORY(history_cursor OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN history_cursor FOR SELECT * FROM PERSON_HISTORY;
END;