/*
 * Complete the vowelsAndConsonants function.
 * Print your output using 'console.log()'.
 */
function vowelsAndConsonant(s){
    const vowels = ['a', 'e', 'i', 'o', 'u'];
    var consonants = [];
    for(let i=0; i<s.length; i++){
        if(vowels.indexOf(s[i]) !== -1){
            console.log(s[i]);
        }else{
            consonants.push(s[i]);
        }
    }
    consonants.forEach(item => {
        console.log(item);
    });
}