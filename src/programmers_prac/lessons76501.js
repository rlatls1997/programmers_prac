function solution(absolutes, signs) {
    var answer = 0;
    for(let i = 0; i<signs.length; i++){
        answer += (signs[i])? absolutes[i] : -absolutes[i];
    }
    return answer;
}