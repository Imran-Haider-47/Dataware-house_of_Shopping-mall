#Question.1
Delimiter %%
create procedure Lab7Q1( in target int)
begin
		select Name, Population
		from world.country 
        where country.Population >target;
end%%
set @p=100000;
call Lab7Q1(@p);

#Question 2
DELIMITER $$
CREATE procedure Display_City( city_name varchar(30))
begin
select * from world.city where world.city.name=city_name ;
END$$ 
set @c='Kabul';
call Display_City(@c);

#Question#3
Create table New_Country_Language(
	CountryCode char(3) Primary key not null,
    Languages char(30) ,
    IsOfficial enum('T','F'),
    Percentage float(4,1)
    );

#Question.3
Delimiter $$
Create procedure Question3()
begin
create table lab.copy_country_language select distinct CountryCode,Language,IsOfficial,Percentage from
world.countrylanguage;

update copy_country_language
set percentage=percentage+(percentage*0.25)
where ((select substring(Language,1,1))= 'E') or ((select substring(Language,1,1))= 'A') 
or ((select substring(Language,1,1))= 'T') ;


update copy_country_language
set percentage=percentage+(percentage*0.30)
where ((select substring(Language,1,1))= 'C') or ((select substring(Language,1,1))= 'K')  ;

end$$ 
call Question3();


# Question:4
create table Lab7Q4(
	PersonID int 
);

Delimiter $$
create procedure Q4()
begin
	set @i:=1;
	while @i<6 do
		insert into Lab7Q4 values (@i);
 		set @i:=@i+1;
	end while;
end$$
call Q4();



Delimiter $$
create procedure LoopQ6()
Begin
	declare x int;
    set x=1;
    loop_label : Loop
		if x<6 then 
			insert into Lab7Q4 values (x);
		end if;
		set x:=x+1;
        if x >6 then 
			Leave loop_label;
		end if;
	end loop;
end$$
call LoopQ6();

Delimiter $$
create Procedure LabQ4()
begin
	call Q4();
    call LoopQ6();
end$$ 
call LabQ4();
select  * from Lab7Q4;

#Question.5

Delimiter $$
create procedure Q5(in letter varchar(1))
begin
	select Code
    from world.country
    where ((select substring(world.country.Name,1,1))= letter);
end$$

call Q5('A');