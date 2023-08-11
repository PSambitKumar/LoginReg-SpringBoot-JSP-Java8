function regexVar(){
    const re = /^(Mr|Mrs|Ms|Dr|Er)(\.)([a-zA-Z])+$/;
    return re;
}

function main(){
    const re = regexVar();
    const s = readLine();

    console.log(!!s.match(re));
}