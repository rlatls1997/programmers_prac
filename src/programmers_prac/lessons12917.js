function solution(s) {
    var answer = '';
    answer = s.split("").sort((o1 , o2) =>{ return (o1<o2)? 1 : -1}).join('');
    console.log(answer);
    return answer;
}

solution("Zbcdefg")