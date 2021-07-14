
var b = ["leo", "kiki", "eden"];
var c = 	["eden", "kiki"];

solution(b, c);

function solution(participant, completion) {
    var answer = '';
    completion.sort();
    participant.sort();
    for(let i = 0; i<completion.length; i++){
        console.log(participant[i] + " : " + completion[i]);
        if(participant[i] != completion[i]){
            return participant[i];
        }
    }
    return participant[participant.length -1];
}