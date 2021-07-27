use sakila;

show tables;

#1. Find out the PG-13 rated comedy movies. DO NOT use the film_list table.
select title, rating, category.name from film
inner join film_category
on film.film_id = film_category.film_id
inner join category
on category.category_id=film_category.category_id
where category.name='Comedy' and rating='PG-13';

#2. Find out the top 3 rented horror movies.
select film.title, count(customer.customer_id) as "Total count of rented" from customer 
inner join rental on rental.customer_id = customer.customer_id
inner join inventory on inventory.inventory_id = rental.inventory_id
inner join film on film.film_id = inventory.film_id 
inner join film_category on film_category.film_id  = film.film_id
inner join category on film_category.category_id = category.category_id
where category.name="horror" group by film.film_id order by "Total count of rented" desc limit 3;

#3. Find out the list of customers from India who have rented sports movies.
select distinct(customer_list.name) from customer_list
inner join rental on rental.customer_id = customer_list.ID
inner join inventory on inventory.inventory_id = rental.inventory_id
inner join film_category on film_category.film_id = inventory.film_id
inner join category on film_category.category_id = category.category_id
where country="India" and category.name="Sports";

#4. Find out the list of customers from Canada who have rented “NICK WAHLBERG” movies.
select distinct(customer_list.name) from customer_list
inner join rental on rental.customer_id = customer_list.ID
inner join inventory on inventory.inventory_id = rental.inventory_id
INNER JOIN film_actor ON inventory.film_id = film_actor.film_id
INNER JOIN actor ON film_actor.actor_id = actor.actor_id
where country="Canada" and actor.first_name = "NICK" and actor.last_name="WAHLBERG";

#5. Find out the number of movies in which “SEAN WILLIAMS” acted.
select actor.first_name,actor.last_name,count(actor.actor_id) as no_of_movies
from film_actor inner join actor on film_actor.actor_id = actor.actor_id
where actor.first_name = "SEAN" and actor.last_name= "WILLIAMS";