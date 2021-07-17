function solution(strings, n) {
    var answer = [];

    strings.sort((o1, o2)=>{
        if(o1[n] === o2[n]){
            if(o1 > o2){
                return 1;
            }else if(o1 < o2){
                return -1;
            }else{
                return 0;
            }
        }else{
            if(o1[n] > o2[n]){
                return 1;
            }
            else{
                return -1;
            }
        }
    })
    return strings;
}
let a = "avs";
let b = "avs"

console.log(
    a.localeCompare(b));