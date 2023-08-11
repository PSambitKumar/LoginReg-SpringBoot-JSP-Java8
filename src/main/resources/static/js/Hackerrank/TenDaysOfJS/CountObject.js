function getCount(objects){
    let count = 0;
    for (let i = 0; i < objects.length; i++) {
        if (objects[i].x === objects[i].y) {
            count++;
        }
    }
    return count;
}

function main(){
    const N = +(readLine());
    let objects = [];
    for(let i = 0; i < N; i++){
        const [a, b] = readLine().split(' ');
        objects.push({x: +(a), y: +(b)});
    }
    console.log(getCount(objects));
}