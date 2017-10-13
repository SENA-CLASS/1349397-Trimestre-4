var numero = Number.parseInt(prompt("digite el numero"));
var numero2 = Number.parseInt(prompt("digite el numero"));


function multiplo(numero, multiplo) {
        if(numero%multiplo==0){
            return 1;
        }else{
            return 0;
        }
}

alert(multiplo(numero,numero2));
