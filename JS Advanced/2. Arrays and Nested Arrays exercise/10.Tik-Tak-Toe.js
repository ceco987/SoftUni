function solution(arr) {
    let dashboard = [[], [], []];
    let resultMessage = '';
    let count = 0;
    let mark = '';
    let won = false;

    for (let i = 0; i < 3; i++) {
        for (let j = 0; j < 3; j++) {
            dashboard[i][j] = false;
        }

    }

    function checkWin(dashboard) {
        for (let i = 0; i < 3; i++) {
            if (dashboard[i].every((el, i, arr) => el == arr[0] && el != false && el != undefined)) return true;
        }

        let primDiag = [];
        let secDiag = [];
        let firstCol = [];
        let secCol = [];
        let thirdCol = [];

        for (let i = 0; i < dashboard.length; i++) {
            primDiag.push(dashboard[i][i]);
            secDiag.push(dashboard[i][dashboard.length - i - 1]);
            firstCol.push(dashboard[i][0]);
            secCol.push(dashboard[i][1]);
            thirdCol.push(dashboard[i][2]);
        }

        function condition(primDiag, secDiag, firstCol, secCol, thirdCol) {
            let allDiags = [];
            allDiags.push(primDiag, secDiag, firstCol, secCol, thirdCol);
            for (let i = 0; i < allDiags.length; i++) {
                if (allDiags[i].every((el, i, arr) => el == arr[0] && el != false && el != undefined)) {
                    return true;
                }
            }
            return false;
        }

        return condition(primDiag, secDiag, firstCol, secCol, thirdCol);
    }

    for (let i = 0; i < 9; i++) {
        let coor = arr[i].split(/\s+/).map(Number);
        if (dashboard[coor[0]][coor[1]]) {
            resultMessage += 'This place is already taken. Please choose another!' + '\n';
            continue;
        }
        mark = count % 2 == 0 ? 'X' : 'O';
        dashboard[coor[0]][coor[1]] = mark;
        won = checkWin(dashboard);
        if (won) {
            resultMessage += `Player ${mark} wins!` + "\n";
            break;
        }
        count++;
    }

    if (!won) {
        resultMessage += 'The game ended! Nobody wins :(' + '\n';
    }

    return resultMessage + dashboard.map(x => x.join("\t")).join("\n");
}

console.log(solution(
    ["0 1",
        "0 0",
        "0 2",
        "2 0",
        "1 0",
        "1 1",
        "1 2",
        "2 2",
        "2 1",
        "0 0"]
));
console.log('-'.repeat(25));
console.log(solution(
    ["0 0",
        "0 0",
        "1 1",
        "0 1",
        "1 2",
        "0 2",
        "2 2",
        "1 2",
        "2 2",
        "2 1"]
));
console.log('-'.repeat(25));
console.log(solution(
    ["0 1",
        "0 0",
        "0 2",
        "2 0",
        "1 0",
        "1 2",
        "1 1",
        "2 1",
        "2 2",
        "0 0"]
));