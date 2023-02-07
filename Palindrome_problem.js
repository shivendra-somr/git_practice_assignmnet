let str = "naman";
let N = str.length;
let new_str = "";
for (let i = N-1;i >= 0;i--){
    new_str += str[i];
}
if (str === new_str){
    console.log("Yes");
}
else{
    console.log("No");
}