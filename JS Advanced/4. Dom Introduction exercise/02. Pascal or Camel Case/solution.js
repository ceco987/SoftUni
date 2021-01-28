function solve() {
  let conventionString = document.getElementById("naming-convention").value;
  let conventionArray = conventionString.split(/\s+/).filter(x => x != '');
  conventionString = conventionArray.reduce((acc,curr)=>acc+curr.toLowerCase(),'');

  const inputStringText = document.getElementById("text").value;
  let inputArray = inputStringText.split(/\s+/).filter(x => x != '');

  inputArray = inputArray.map(x => x.toLowerCase());

  let output = '';

  switch (conventionString) {
    case 'camelcase':
      output = inputArray.reduce((acc, curr) => acc + curr[0].toUpperCase() + curr.slice(1));
      break;
    case 'pascalcase':
      output = inputArray.reduce((acc, curr) => acc + curr[0].toUpperCase() + curr.slice(1), '');
      break;
    default:
      output = 'Error!';
  }

  document.getElementById("result").textContent = output;

}