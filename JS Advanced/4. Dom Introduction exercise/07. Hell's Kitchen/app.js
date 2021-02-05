function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function onClick () {
      const initialInput = JSON.parse(document.querySelector("div#inputs textarea")).value.split(' - ').filter(x=>x!='\n');
      console.log(initialInput)
   }
}