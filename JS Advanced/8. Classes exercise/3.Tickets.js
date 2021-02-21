function solution(arr, sortCriteria) {
    function splitFn(e) {return e.split('|')};

    function objectify([destination, price, status]) { return new Ticket(destination,Number(price),status) };

    const objSorter = {
        'destination': (a,b) => a.destination.localeCompare(b.destination),
        'price': (a,b) => a - b,
        'status': (a,b) => a.status.localeCompare(b.status)
    }

    class Ticket {
        constructor(destination, price, status){
            this.destination=destination;
            this.price=price;
            this.status=status;
        }
    }

    return arr.map(splitFn)
              .map(objectify)
              .sort(objSorter[sortCriteria]);
}

console.log(solution([
    'Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'],
    'destination'
))