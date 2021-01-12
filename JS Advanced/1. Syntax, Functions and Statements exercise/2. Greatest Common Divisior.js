function gcd(n, m) {
    let max = m >= n ? m : n;
    let min = max == m ? n : m;
    let temp=0;
    while (max % min != 0) {
        temp = max%min;
        max = min;
        min = temp;
    }
    console.log(min)
}

gcd(18,48)