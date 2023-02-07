let num = 97;
let p = 0;

if (num>1){
    for (let i = 2; i<num ; i++){
        if (num%i===0){
            p = 1;
            break;
        }
    }
}
if (p==1){
    console.log("No");
}
else{
    console.log("Yes");
}