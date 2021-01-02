/*select first_name from sakila.staff  
union
select email from sakila.staff;

select a.first_name,a.email ,b.*
from sakila.staff a cross join sakila.store b;

select a.first_name, a.email, b.*, c.address 
from sakila.staff a join sakila.store b join sakila.address c
on(a.store_id=b.store_id) and (b.address_id = c.address_id);

select a.* ,b.* 
from sakila.country a left join sakila.city b 
on(a.country_id=b.country_id)
union
select a.* ,b.* 
from sakila.country a right join sakila.city b 
on(a.country_id=b.country_id);

select A.name,B.name as Name, a.Region
from world.country A ,world.country B
where A.code <> B.code
and A.Region = B.Region;


SELECT
	Name, LifeExpectancy
FROM
	world.country
WHERE
	Code in (select Code from world.country WHERE Region='Southern Europe');

SELECT 
	first_name , last_name 
FROM	
	sakila.actor 
WHERE
	actor_id in ( SELECT b.actor_id from sakila.film_actor b 
    where b.film_id in ( select c.film_id from sakila.film c 
						where c.special_features='Trailers,Deleted Scenes'));


#Query#1
SELECT a.city 
FROM sakila.city a join sakila.country b 
Where (b.country="United States");
select * from sakila.film;

Query#2
select * from category;
select a.first_name as "First Name" , a.last_name as "Last Name"
from sakila.actor a join sakila.category b
where b.name="Action";

Query#3 */
select a.* 
from staff a join address b
where b.district="QLD"

























