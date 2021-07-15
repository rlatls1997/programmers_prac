function solution(answers) {
    var answer = [];
    let whoGiveUpMath1 = [1, 2, 3, 4, 5];
    let whoGiveUpMath2 = [2, 1, 2, 3, 2, 4, 2, 5];
    let whoGiveUpMath3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];

    let totalCorrect = [0, 0, 0];
    for (let i = 0; i < answers.length; i++) {
        if (whoGiveUpMath1[i % whoGiveUpMath1.length] === answers[i]) {
            totalCorrect[0]++;
        }
        if (whoGiveUpMath2[i % whoGiveUpMath2.length] === answers[i]) {
            totalCorrect[1]++;
        }
        if (whoGiveUpMath3[i % whoGiveUpMath3.length] === answers[i]) {
            totalCorrect[2]++;
        }
    }
    if (totalCorrect[0] === totalCorrect[1]) {
        if (totalCorrect[1] > totalCorrect[2]) {
            answer[0] = 1;
            answer[1] = 2;
        }
        if (totalCorrect[1] < totalCorrect) {
            answer[0] = 3;
        }
    }
    if (totalCorrect[1] === totalCorrect[2]) {
        if (totalCorrect[2] > totalCorrect[0]) {
            answer[0] = 2;
            answer[1] = 3;
        }
        if (totalCorrect[2] < totalCorrect[0]) {
            answer[0] = 1;
        }
    }
    if (totalCorrect[0] === totalCorrect[2]) {
        if (totalCorrect[2] > totalCorrect[1]) {
            answer[0] = 1;
            answer[1] = 3;
        }
        if (totalCorrect[2] < totalCorrect[1]) {
            answer[0] = 2;
        }
    }
    if (totalCorrect[0] === totalCorrect[1] && totalCorrect[1] === totalCorrect[2]) {
        answer[0] = 1;
        answer[1] = 2;
        answer[2] = 3;
    }
    if (totalCorrect[0] !== totalCorrect[1] && totalCorrect[1] !== totalCorrect[2] && totalCorrect[0] !== totalCorrect[2]) {
        let max = totalCorrect[0];
        for (let i = 0; i < totalCorrect.length; i++) {
            if (totalCorrect[i] >= max) {
                max = totalCorrect[i];
                answer[0] = i + 1;
            }
        }
    }
    return answer;
}

let answers = [5, 5, 5, 1, 4, 1];
solution(answers);