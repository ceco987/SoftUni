select count(*) as country_count from
countries as c
left join `mountains_countries` as mc
	on c.country_code = mc.country_code
where mc.mountain_id is null;