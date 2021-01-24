function assembly() {
    const result = {};
    result.hasClima = function hasClima(car) {
        car.temp = 21;
        car.tempSettings = 21;
        car.adjustTemp = function adjustTemp() {
            if (car.temp < car.tempSettings) {
                car.temp++;
            } else if (car.temp > car.tempSettings) {
                car.temp--;
            }
        }
    }
    result.hasAudio = function hasAudio(car) {
        car.currentTrack = { name: '', artist: '' };
        car.nowPlaying = function nowPlaying() {
            if (car.currentTrack != null) {
                console.log(`Now playing '${car.currentTrack.name} by ${car.currentTrack.artist}'`)
            }
        }
    }

    result.hasParktronic = function hasParktronic(car) {
        car.checkDistance = function checkDistance(distance) {
            let message = '';
            if (distance < 0.1) message = 'Beep! Beep! Beep!';
            else if (distance < 0.25) message = 'Beep! Beep!';
            else if (distance < 0.5) message = 'Beep!';
            console.log(message)
        }
    }

    return result;
}

const assemblyLine = assembly();

const myCar = {
    make: 'Toyota',
    model: 'Avensis'
};

assemblyLine.hasClima(myCar);
console.log(myCar.temp);
myCar.tempSettings = 18;
myCar.adjustTemp();
console.log(myCar.temp);

assemblyLine.hasAudio(myCar);
myCar.currentTrack = {
    name: 'Never Gonna Give You Up',
    artist: 'Rick Astley'
};
myCar.nowPlaying();

assemblyLine.hasParktronic(myCar);
myCar.checkDistance(0.4);
myCar.checkDistance(0.2);

console.log(myCar);
