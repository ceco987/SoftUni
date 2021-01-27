function sumTable() {
    const allRows = document.querySelectorAll("table tbody tr");
    const usedRows = Array.from(allRows).slice(1,-1);
    let sum = 0;
    for (const row of usedRows) {
        sum+=Number(row.lastElementChild.textContent);
    }
    allRows[allRows.length-1].lastElementChild.textContent=sum;
}