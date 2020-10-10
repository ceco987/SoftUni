SELECT `mountain_range`, `peak_name`, elevation as peak_elevation
FROM `mountains` as m join peaks as p on m.id = p.mountain_id
WHERE mountain_range = 'Rila'
ORDER BY peak_elevation desc;