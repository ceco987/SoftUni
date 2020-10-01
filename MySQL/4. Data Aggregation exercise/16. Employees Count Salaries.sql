SELECT count(`salary`) as salary_count
from `employees`
where `manager_id` is null;