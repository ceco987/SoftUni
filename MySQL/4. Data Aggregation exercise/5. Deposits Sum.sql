SELECT deposit_group,
sum(deposit_amount) as total_sum
from `wizzard_deposits`
group by deposit_group
order by total_sum;