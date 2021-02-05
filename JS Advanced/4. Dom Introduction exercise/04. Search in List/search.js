function search() {
   let list = [...document.querySelectorAll("#towns li")];
   const pattern = document.getElementById("searchText").value;
   const result = document.getElementById("result")
   let count = 0;
   for (let word of list) {
      if (word.textContent.toLowerCase().includes(pattern.toLowerCase())) {
         word.style.fontWeight = "bold";
         word.style.textDecoration = "underline";
         count++;
      }
      else {
         word.style.fontWeight = "";
         word.style.textDecoration = "";
      }
   }
   result.textContent = `${count} matches found`;
}