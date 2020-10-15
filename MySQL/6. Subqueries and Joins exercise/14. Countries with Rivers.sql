select c.country_name, r.river_name
from `countries` as c
left join `countries_rivers` as cr
	on c.country_code = cr.country_code
left join `rivers` as r
	on cr.river_id = r.id
left join `continents` as con
	on c.continent_code = con.continent_code
where  con.continent_name = 'Africa'
order by c.country_name
limit 5;