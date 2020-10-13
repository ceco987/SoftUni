SELECT
a.town_id,
t.`name` as town_name,
a. address_text
FROM addresses as A
JOIN towns as t ON a.town_id = t.town_id
WHERE t.`name` in ('San Francisco', 'Sofia', 'Carnation')
ORDER BY a.town_id, address_id;