function solution(n) {
    var answer = "";
    let a = Array.from(n.toString());
    a.sort((o1, o2) => {
        return o2 - o1;
    })
    a.forEach((e)=>{
        answer += e;
    })
    return Number(answer);
}

solution(118372);