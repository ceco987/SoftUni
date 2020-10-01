SELECT `department_id`, max(`salary`) as max_salary
from `employees`
group by `department_id`
having max_salary not between 30000 and 70000
order by department_id;