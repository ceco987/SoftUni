SELECT c.country_code, count(m.mountain_range) as mountain_range
from countries as c
join `mountains_countries` as mc
	on c.country_code = mc.country_code
join `mountains` as m
	on m.id = mc.mountain_id
where c.country_code in ('BG', 'US', 'RU')
group by c.country_code
order by mountain_range desc;