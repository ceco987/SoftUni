function solution(face, suit) {
    let faces = [2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K', 'A'];
    let suits = {
        S: '\u2660',
        H: '\u2665',
        D: '\u2666',
        C: '\u2663'
    }
    if(!faces.includes(face)) throw new Error('Invalid Face');
    if(!Object.keys(suits).includes(suit)) throw new Error ('Invalid Suit');
    return {
        toString() {
            return `${face}${suits[suit]}`
        }
    }
}

console.log(''+solution(2, 'S'))
console.log(''+solution(-1, 'C'))
console.log(''+solution(3, 'C'))
console.log(''+solution(4, 'H'))

// '\u2660' – Spades (♠)
// '\u2665' – Hearts (♥)
// '\u2666' – Diamonds (♦)
// '\u2663' – Clubs (♣)
