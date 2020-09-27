SELECT * FROM `towns`
WHERE left(`name`,1) regexp '(?i)[mkbe]'
order by `name`;