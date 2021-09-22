use sakila;

show tables;

#1. Find out the number of documentaries with deleted scenes.
select count(*) from film
inner join film_category
on film_category.film_id=film.film_id
inner join category
on category.category_id=film_category.category_id
where category.name="Documentary" and film.special_features like "%Deleted Scenes%";


#2. Find out the number of sci-fi movies rented by the store managed by Jon Stephens.
select distinct count(*) from film_category
inner join category
on category.category_id=film_category.category_id
inner join inventory
on inventory.film_id=film_category.film_id
inner join store
on inventory.store_id=store.store_id
inner join staff
on staff.staff_id=store.manager_staff_id
where category.name="Sci-Fi" and staff.first_name="Jon" and staff.last_name="Stephens";


#3. Find out the total sales from Animation movies.
select total_sales from sales_by_film_category where category='Animation';


#4. Find out the top 3 rented category of movies by “PATRICIA JOHNSON”.
select category.name from customer
inner join rental
on rental.customer_id=customer.customer_id
inner join inventory
on inventory.inventory_id=rental.inventory_id
inner join film_category
on film_category.film_id=inventory.film_id
inner join category
on category.category_id=film_category.category_id
where customer.first_name='PATRICIA' and customer.last_name='JOHNSON'
group by category.name 
order by count(customer.customer_id) desc
limit 3;


#5. Find out the number of R rated movies rented by “SUSAN WILSON”.
select count(*) as "R rated movies rented by Susan Wilson" from rental
inner join customer
on customer.customer_id=rental.customer_id and customer.first_name="SUSAN" and customer.last_name="WILSON"
inner join inventory
on inventory.inventory_id=rental.inventory_id
inner join film
on film.film_id = inventory.film_id and film.rating="R";