function getGrade(score){
    if (score > 25 && score <= 30) {
        return 'A';
    } else if (score > 20 && score <= 25) {
        return 'B';
    } else if (score > 15 && score <= 20) {
        return 'C';
    } else if (score > 10 && score <= 15) {
        return 'D';
    } else if (score > 5 && score <= 10) {
        return 'E';
    } else {
        return 'F';
    }
}

function main() {
    const score = +(readLine());

    console.log(getGrade(score));
}