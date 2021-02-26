create or replace type myType as object (a int,b varchar2(10))
/

create or replace type myTable_type as table of myType;
/

create or replace function get_number_upto return myTable_type as
l_data myTable_type := myTable_type();
begin
for i in 1 .. 5 loop
l_data.extend;
l_data(i) := myType(i, 'Row #'||i );
end loop;
return l_data;
end get_number_upto;
/

--select * from TABLE ( cast( get_number_upto() as myTable_type ) );
--select a,b from TABLE ( cast( get_number_upto() as myTable_type ) );