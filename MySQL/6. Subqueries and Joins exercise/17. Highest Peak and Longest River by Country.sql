SELECT c.country_name, 
max(p.elevation) as highest_peak_elevation,
max(r.length) as longest_river_length
from countries as c
join mountains_countries as mc 
	on c.country_code = mc.country_code
join mountains as m
	on mc.mountain_id = m.id
join peaks as p
	on m.id = p.mountain_id
join countries_rivers as cr
	on c.country_code = cr.country_code
join rivers as r
	on cr.river_id = r.id
group by c.country_name
order by highest_peak_elevation desc, longest_river_length desc, c.country_name
limit 5;