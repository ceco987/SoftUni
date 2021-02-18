function solution(arrCards) {
    function cardGenerator(face, suit) {
        let faces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
        let suits = {
            S: '\u2660',
            H: '\u2665',
            D: '\u2666',
            C: '\u2663'
        }
        if (!faces.includes(face) || !Object.keys(suits).includes(suit)) return `Invalid card: ${face}${suit}`;
        return `${face}${suits[suit]}`
    }
    let output = [];
    output = arrCards.map(e => {
        let suit = e[e.length - 1];
        let face = e.slice(0, -1)
        return cardGenerator(face, suit)
    });

    let brokenCard = '';
    output.forEach(e => {
        if (e.includes('Invalid card')) {
            brokenCard = e;
        }
    })
    if (!brokenCard) console.log(output.join(' '));
    else console.log(brokenCard);
}

solution(['AS', '10D', 'KH', '2C']);