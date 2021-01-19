const solution = arr => arr.sort((a,b)=>a.length==b.length ? a.localeCompare(b) : a.length-b.length).join('\n');

console.log(solution(['alpha', 
'beta', 
'gamma']
));