SELECT concat_ws(' ',`first_name`, `middle_name`, `last_name`) as `Full Name`
from `employees`
where `salary` in (25000,14000,12500,23600);