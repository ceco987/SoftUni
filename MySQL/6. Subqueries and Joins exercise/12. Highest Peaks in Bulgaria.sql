SELECT c.country_code, m.mountain_range, p.peak_name, p.elevation
FROM `countries` as c 
join `mountains_countries` as mc 
	on c.country_code = mc.country_code
join `mountains` as m
	on mc.mountain_id = m.id
join `peaks` as p
	on m.id = p.mountain_id
where p.elevation > 2835 and c.country_code = 'BG'
order by p.elevation desc;