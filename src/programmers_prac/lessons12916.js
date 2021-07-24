function solution(s) {
    let pNums = s.toLowerCase().split("").filter(e => e == 'p').length;
    let yNums = s.toLowerCase().split("").filter(e => e == 'y').length;
    return (pNums === yNums)? true : false;
}
