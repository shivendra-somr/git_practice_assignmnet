let num = 31;
let p = 0;


    for (let i = 1; i<=num ; i++){
        if (num%i===0){
            p++;
        }
    }
if (p==2 && p != 0){
    console.log("Yes");
}
else{
    console.log("No");
}