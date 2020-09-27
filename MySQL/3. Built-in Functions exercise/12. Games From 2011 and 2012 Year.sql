SELECT `name`, DATE_FORMAT(`start`,'%Y-%m-%d') as `start` FROM `games`
WHERE YEAR(`start`) in (2012,2011)
ORDER BY `start`
LIMIT 50;