SELECT p.`peak_name`, r.`river_name`,
lower(CONCAT(p.`peak_name`,substring(r.`river_name`,2))) as `mix`
FROM `peaks` as p, `rivers` as r
WHERE right(p.`peak_name`,1) = left(r.`river_name`,1)
ORDER BY `mix`;