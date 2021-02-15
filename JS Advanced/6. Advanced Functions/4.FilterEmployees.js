const examples = [{
    data: `[{
    "id": "1",
    "first_name": "Ardine",
    "last_name": "Bassam",
    "email": "abassam0@cnn.com",
    "gender": "Female"
  }, {
    "id": "2",
    "first_name": "Kizzee",
    "last_name": "Jost",
    "email": "kjost1@forbes.com",
    "gender": "Female"
  },  
{
    "id": "3",
    "first_name": "Evanne",
    "last_name": "Maldin",
    "email": "emaldin2@hostgator.com",
    "gender": "Male"
  }]`,
    criteria: 'gender-Female'
},
{
    data: `[{
        "id": "1",
        "first_name": "Kaylee",
        "last_name": "Johnson",
        "email": "k0@cnn.com",
        "gender": "Female"
      }, {
        "id": "2",
        "first_name": "Kizzee",
        "last_name": "Johnson",
        "email": "kjost1@forbes.com",
        "gender": "Female"
      }, {
        "id": "3",
        "first_name": "Evanne",
        "last_name": "Maldin",
        "email": "emaldin2@hostgator.com",
        "gender": "Male"
      }, {
        "id": "4",
        "first_name": "Evanne",
        "last_name": "Johnson",
        "email": "ev2@hostgator.com",
        "gender": "Male"
      }]`,
    criteria: 'last_name-Johnson'
}
]

function solution(data, criteria) {
    let inputData = JSON.parse(data);
    let [filter, value] = criteria.split('-');
    let count = 0;

    return filter == 'all' ?
        reducer(inputData) :
        reducer(inputData.filter(e => e[filter] == value));

    function reducer(data) {
        let output =  data.reduce((acc, c) => {
            acc.push(`${count++}. ${c.first_name} ${c.last_name} - ${c.email}`);
            return acc;
        }, [])
        return output.join('\n');
    }
}

console.log(solution(examples[1].data, examples[1].criteria));