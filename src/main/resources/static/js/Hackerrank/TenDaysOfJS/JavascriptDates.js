function getDayName(dateString) {
    let dayName;
    let dayNames = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
    let date = new Date(dateString);
    dayName = dayNames[date.getDay()];

    return dayName;
}

function main(){
    const d = +(readLine());

    for (let i = 0; i < d; i++) {
        const date = readLine();
        console.log(getDayName(date));
    }
}