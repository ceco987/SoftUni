SELECT first_name, last_name, t.`name` as town, address_text
FROM employees as e join addresses as a on e.address_id = a.address_id
join towns as t on a.town_id = t.town_id
order by first_name, last_name
limit 5;