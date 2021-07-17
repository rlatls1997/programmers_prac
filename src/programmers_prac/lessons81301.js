function solution(s) {
    var answer = "";
    let numbers = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
    let strTemp = "";
    for (let i = 0; i < s.length; i++) {
        if (isNaN(s.charAt(i))) {
            strTemp += s.charAt(i);
            if (numbers.includes(strTemp)) {
                answer += numbers.indexOf(strTemp);
                strTemp = "";
            }
        } else {
            answer += s.charAt(i);
        }
    }
    return Number.parseInt(answer);
}

let numbers = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
solution("one4seveneight");