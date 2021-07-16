function solution(arr) {
    var answer = [];
    let index = 0;
    for(let i = 0; i<arr.length; i++){
        if(answer.length === 0){
            answer[index++] = arr[i];
        }else{
            if(answer[index-1] !== arr[i]){
                answer[index++] = arr[i];
            }
        }
    }
    return answer;
}