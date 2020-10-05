SELECT v.`driver_id`, v.`vehicle_type`,
CONCAT_WS(' ', c.`first_name`, c.`last_name`) as `driver_name`
FROM `vehicles` as v JOIN `campers` as c
	ON v.`driver_id` = c.`id`;