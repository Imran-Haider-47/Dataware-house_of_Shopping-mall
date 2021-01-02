
#Query#1
SELECT a.city 
FROM sakila.city a join sakila.country b 
Where (b.country="United States");
select * from sakila.film;

#Query#2
select * from category;
select a.first_name as "First Name" , a.last_name as "Last Name"
from sakila.actor a join sakila.category b
where b.name="Action";

#Query#3 */
select a.* 
from staff a join address b
where b.district="QLD";

