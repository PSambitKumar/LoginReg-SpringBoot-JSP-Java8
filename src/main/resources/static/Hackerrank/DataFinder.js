function  dataFinder(data){

    let min = Math.min.apply(null, data);
    let max = Math.max.apply(null, data);

    return function (minRange, maxRange){
        return find(minRange, maxRange, data);
    }
}

function find(minRange, maxRange, data){
    if (minRange > maxRange){
        throw new Error("minRange must be less than maxRange");
    }
    if (maxRange > data.length){
        throw new Error("Invalid range");
    }
    let result = false;
    for(let i=0; i<data.length; i++){
        if(data[i] >= minRange && data[i] <= maxRange){
            result = true;
            break;
        }
    }
    return result;
}



