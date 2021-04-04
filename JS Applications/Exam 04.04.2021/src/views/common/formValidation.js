const allowedCategories = [
    'JavaScript',
    'C#',
    'Java',
    'Python'
];

export function formValidation(title,category,content){
    if (title == '' || category =='' || content == '') {
        throw new Error('All fields are required!')
    }
    if(!allowedCategories.includes(category)){
        throw new Error('Category must be either "JavaScript", "C#", "Java", or "Python"\n(Case sensitive!)')
    }
}