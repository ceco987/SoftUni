SELECT `user_name`,
right(`email`,char_length(`email`)-locate('@',`email`)) as `Email Provider` 
FROM `users`
ORDER BY `Email Provider`, `user_name`;