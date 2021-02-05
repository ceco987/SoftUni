function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      const rows = document.querySelectorAll("tbody tr");
      const input = document.getElementById("searchField");

      for (let row of rows) {
         if (row.textContent.toLowerCase().includes(input.value.toLowerCase())) {
            row.setAttribute('class', 'select')
         } else {
            row.removeAttribute('class')
         }
      }
      input.value='';
   }
}