function getSecondLargest(nums){
    let max = Math.max(...nums);
    return Math.max(...nums.filter(num => num !== max));
}

function main() {
    const n = +(readLine());
    const nums = readLine().split(' ').map(Number);

    console.log(getSecondLargest(nums));
}