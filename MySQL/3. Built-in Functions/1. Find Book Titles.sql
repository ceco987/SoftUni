SELECT `title` FROM `books`
WHERE SUBSTRING(`title`, 1,3) ='the'
ORDER BY `id`;