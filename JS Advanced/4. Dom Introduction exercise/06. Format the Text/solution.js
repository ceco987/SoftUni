function solve() {
  const input = document.getElementById("input").value;
  const output = document.getElementById("output");
  let inputArr = input.split(/(?<=\.)\s*/).filter(x => x != '');
  console.log(inputArr);
  for (let i = 0; i < inputArr.length; i += 3) {
    const temp = inputArr.slice(i,i+3).join('');
    output.innerHTML += `<p>${temp}</p>`
  }
}