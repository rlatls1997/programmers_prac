//Regular Expression
var pattern = /b./;
var pattern = new RegExp(/b./);

//정규식 메소드인 exec,
console.log(pattern.exec("dfsb"));

//exec와 비슷한 문자열 메소드
console.log("bfsb".match(/b/g));

console.log("\n----g(매칭되는 모든 문자에 대해), i(대소문자 구분 x)");
//처음 b에 대해
console.log("bfsbB".replace(/b/, "@"));
//모든 b에 대해
console.log("bfsbB".replace(/b/g, "@"));
//대소문자 구분 x
console.log("bfsbB".replace(/b/gi, "@"));

//모든 문자 = \w
console.log("bfsbB".replace(/\w/g, "@"));


console.log("\n---------------------------------캐럿, 달러");
// ^ : 앞에서 찾기, $ : 뒤에서 찾기
let reg = /^who/
console.log("who is who is who".replace(reg, "@"));
let reg1 = /who$/
console.log("who is who is who".replace(reg1, "@"));


console.log("\n---------------------------------이스케이프");
// 이스케이프(\) : 문자열에 특수문자가 포함된 경우
let reg2 = /^$/             //찾지못함
console.log("$ is $ is $".replace(reg2, "@"));
reg2 = /\$/
console.log("$ is $ is $".replace(reg2, "@"));
reg2 = /\$/g
console.log("$ is $ is $".replace(reg2, "@"));
reg2 = /^\$/g
console.log("$ is $ is $".replace(reg2, "@"));
reg2 = /\$$/
console.log("$ is $ is $".replace(reg2, "@"));

console.log("\n---------------------------------포인트");
// 포인트 (.) : 대상이 특정되지 않았을 때. 모든 Character와 매칭
reg2 = /./
console.log("$ is $ is $".replace(reg2, "@"));
reg2 = /./g
console.log("$ is $ is $".replace(reg2, "@"));
reg2 = /..../
console.log("$ is $ is $".replace(reg2, "@"));
reg2 = /..../g                  //나머지가 생길 경우에는 replace를 수행하지 않음
console.log("$ is $ is $".replace(reg2, "@"));

console.log("\n---------------------------------브라켓");
reg2 = /[oyn]/
console.log("How do you do?".replace(reg2, "@"));
reg2 = /[oyn]/g
console.log("How do you do?".replace(reg2, "@"));
reg2 = /[dH]./g
console.log("How do you do?".replace(reg2, "@"));
reg2 = /[owy][yow]/g
console.log("How do you do?".replace(reg2, "@"));

console.log("\n---------------------------------레인지");
reg2 = /[C-K]/
console.log("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".replace(reg2, "@"));
reg2 = /[C-K]/g
console.log("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".replace(reg2, "@"));
reg2 = /[a-d]/g
console.log("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".replace(reg2, "@"));
reg2 = /[2-6]/g
console.log("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".replace(reg2, "@"));

//[^ ] : not 의미의 캐럿
console.log("\n---------------------------브라켓 안의 첫번째 캐럿");
reg2 = /[^CDghi45]/g
console.log("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".replace(reg2, "@"));


//서브패턴 : () 안에 정의, 문자가 아닌 문자열 패턴에 대해 검증
// 여러문자열을 검증할 경우 | 로 이음
console.log("\n---------------------------서브패턴");
reg2 = /(on|ues|rida)/g
console.log("Monday Tuesday Friday".replace(reg2, "@@"));
reg2 = /(Mon|Tues|Fri)day/g
console.log("Monday Tuesday Friday".replace(reg2, "@@"));
reg2 = /..(id|esd|nd)ay/g
console.log("Monday Tuesday Friday".replace(reg2, "@@"));

//수량자 Quantifiers
console.log("\n---------------------------수량자");
//*앞에 존재하는 문자가 0~무한 개까지인 문자열과 일치하는경우
reg2 = /a*b/g
console.log("aabc abc bc".replace(reg2, "@"));

//+앞에 존재하는 문자가 1~무한 개까지인 문자열과 일치하는 경우
reg2 = /a+b/g
console.log("aabc abc bc".replace(reg2, "@"));

//?앞에 존재하는 문자가 0~1 개까지인 문자열과 일치하는 경우
reg2 = /a?b/g
console.log("aabc abc bc".replace(reg2, "@"));