/*
 * Abdalla Hablas
 * SQL hw
 * 8/27/2020
 */

-- 1 SQL Queries
--1.1 Select
select "EmployeeId", "LastName", "Email" from "Employee" where "LastName"='King';
select "City", "State" from "Employee" where "FirstName" ='Andrew' and "ReportsTo" =null;

--1.2 subQueries
select * from "Album", "Track"  where "Composer"='AC/DC';

--1.3 oreder by
select * from "Album" order by "Title" desc;
select "FirstName" from "Customer" order by "City" asc;

--1.6 Like
select * from "Invoice" where "BillingAddress" like 'T%';

--1.7 Between
select * from "Invoice" where "Total" between '15' and '50';
select * from "Employee" where "HireDate" between '2003-06-01' and '2004-03-01';

-- DML Statements
--2.1 Insert into
insert into "Genre" values (26, 'reggae');
insert into "Genre" values (27, 'orchestra');

insert into "Employee" values (9, 'John', 'Adam', 'Sales Manager', 1, '1980-05-17', '2010-04-15', '1111 5th Ave', 'Chicago', 'IL', 'USA', '60610','+1 (403) 528-4751','+1 (403) 528-4755','john@chinookcorp.com');
insert into "Employee" values (10, 'Hansen', 'Sofia', 'IT Staff', 6, '1990-01-17', '2008-04-15', '1235 8th Ave', 'Chicago', 'IL', 'USA', '60615','+1 (320) 158-2587','+1 (403) 528-3251','sofia@chinookcorp.com');

insert into "Customer" values (60, 'Marry', 'Lane', 'GenoCorp', '196 drive cir', 'Cincinnati', 'OH', 'USA','45125', '+1 (654) 154-3542',null, 'marry@gmail.com', 5);
insert into "Customer" values (61, 'Adam', 'Johnson', null, '154 8th ave', 'New York', 'NY', 'USA','85047', '+1 (315) 548-2145',null, 'adam@gmail.com', 3);

-- 2.2 Update
update "Customer" 
set "FirstName" = 'Robert', "LastName" = 'Walter'
where "CustomerId" = '32';

update "Artist" 
set "Name" = 'CCR'
where "Name" = 'Creedence Clearwater Revival';

--2.3 Delete
alter table "Invoice" 
drop constraint "FK_InvoiceCustomerId";

delete from "Customer"
where "FirstName" = 'Robert' and "LastName" = 'Walter' ;

-- 3.0 SQL Function
-- 3.1 System defined functions
select current_time;

select "Name" as "Name",
length ("Name") as "length" from "MediaType";

-- 3.2 system defined aggregate functions
create or replace function avg_invoices() returns decimal as $$
	select avg("Total") from "Invoice";
$$ language sql;

select avg_invoices();

create or replace function most_expensive_track() returns decimal as $$
	select max("UnitPrice") from "Track";
$$ language sql;

select most_expensive_track();

-- 3.3 user defined functions
create or replace function avg_price()
   returns decimal as $$
   declare average decimal ;
	begin
	select avg("UnitPrice") into average from "InvoiceLine";
		return average;
	end;
$$ language plpgsql;

select avg_price();

create function employee_born_after1968() returns setof "Employee" as $$
    select * from "Employee"  where "BirthDate" > '1968-12-30';
$$ language sql;

select  employee_born_after1968();

-- 4.0 Triggers
-- 4.1 after insert trigger
create or replace function emp_insert()
returns trigger as $$
begin
	if(TG_OP = 'INSERT') then
	new."Phone" = '867-5309';
	end if; 
	return new;
end;
$$ language plpgsql;

create trigger employee_insert
after insert on "Employee"
for each row
execute function emp_insert();

insert into "Employee" ("EmployeeId","FirstName", "LastName", "Phone")
values ('101','Thomas', 'Smith', '12345');

-- 4.2 before insert trigger

create or replace function cus_insert()
returns trigger as $$
begin
	if(TG_OP = 'INSERT') then
	new."Company" = ('Revature');
	end if;
	return new;
end;
$$ language plpgsql;

create trigger customer_insert
before insert on "Customer"
for each row
execute function cus_insert();

insert into "Customer" ("CustomerId" ,"FirstName" , "LastName" ,"Email" ,"Company" )
values ('100','Joey', 'T', 'j@j', 'company');

-- 5.0 Joins
-- 5.1 Inner Join
select "FirstName", "InvoiceId" from "Customer" c inner join "Invoice" i 
using ("CustomerId");

-- 5.2 full outer join
select "CustomerId" ,"FirstName", "LastName", "InvoiceId", "Total" from "Customer" c full join "Invoice" i 
using ("CustomerId");

-- 5.3 right join 
select "Name", "Title" from "Album" a right join "Artist" a2 
using ("ArtistId");

-- 5.4 cross join 
select * from "Album" a cross join "Artist" a2
order by "Name" asc;

-- 5.5 self join
select * from "Employee" a inner join "Employee" b
using ("ReportsTo");

-- 6.0 set operations
-- 6.1 union 
select "LastName", "FirstName", "Phone" from "Customer" c 
union all
select "LastName", "FirstName", "Phone" from "Employee" e;

-- 6.2 except all
select "City", "State", "PostalCode" from "Customer" c 
except
select "City", "State", "PostalCode" from "Employee" e;



