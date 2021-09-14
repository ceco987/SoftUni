class Ticket {
    destination: string;
    price: number;
    status: string;

    constructor(destination: string, price: number, status: string) {
        this.destination = destination;
        this.price = price;
        this.status = status;
    }
}

function start(ticketArr, sorter) {
    return ticketArr.reduce((a, c) => {
        let [dest, price, status] = c.split('|');
        a.push(new Ticket(dest, Number(price), status));
        return a;
    }, []).sort((a, b) => sorter == 'price' ? a[sorter] - b[sorter] : a[sorter].localeCompare(b[sorter]))

}

console.log(start([
    'Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'
],
    'status'
))
