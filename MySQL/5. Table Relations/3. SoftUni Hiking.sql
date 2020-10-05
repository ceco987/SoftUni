SELECT `starting_point` as `route_starting_point `,
`end_point` as `route_ending_point`,
`leader_id`,
concat_ws(' ', `first_name`, `last_name`) AS`leader_name`
FROM `routes` as r JOIN `campers` as c
ON r.`leader_id` = c.`id`;