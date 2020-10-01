SELECT `department_id`,
min(`salary`) AS `minimum_salary`
FROM `employees`
where `department_id` in (2,5,7) and
date(hire_date) > '2000-01-01'
group by `department_id`
order by `department_id`;