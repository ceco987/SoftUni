SELECT `product_name`,`order_date`, 
adddate(`order_date`,3)
AS `pay_date`,
DATE_ADD(`order_date`,INTERVAL 1 MONTH)
AS `deliver_date`
FROM `orders`;