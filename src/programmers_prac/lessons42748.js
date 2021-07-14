var a = [1, 5, 2, 6, 3, 7, 4];
var v = [[2, 5, 3], [4, 4, 1], [1, 7, 3]];
solution(a, v);

function solution(array, commands) {
    var answer = [];
    for (let i = 0; i < commands.length; i++) {
        let c = array.slice(commands[i][0] - 1, commands[i][1]);
        c.sort((o1, o2) =>{
            return o1- o2;
        });
        answer.push(c[commands[i][2]-1]);
    }
    return answer;
}