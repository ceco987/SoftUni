SELECT substring(`first_name`,1,1) AS `first_letter`
FROM `wizzard_deposits`
WHERE deposit_group = 'Troll Chest'
group by `first_letter`
order by `first_letter`;