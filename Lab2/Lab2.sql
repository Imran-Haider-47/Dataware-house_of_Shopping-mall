desc sakila.customer;
select * from sakila.customer;
select countrycode, Language from world.countrylanguage;
select LocalName as Name, GovernmentForm as Govt FROM world.country;
select * from world.city where Population > 1000000;
select * from world.city where Population between 1000000 and 3000000;
select Name, Population, Region from world.country where region like '%ou%';
select LocalName as Name from world.country where Name like '_a%' and Region="Southern Europe";
select * from world.country order by Population;
select Name, SurfaceArea, Population, Region from world.country group by region;
desc world.country;
select LocalName as Name, LifeExpectancy + (LifeExpectancy *0.1) from world.country;
select continent , Population, IndepYear from world.country where IndepYear is NULL;
select * from world.country where LifeExpectancy>70 or IndepYear != 1991;
select count(Region) from world.country group by (Code );
select Region,min(population) from world.country group by (population);
