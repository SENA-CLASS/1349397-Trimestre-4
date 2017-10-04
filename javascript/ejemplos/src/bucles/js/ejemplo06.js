var numero =100000;

var d = new Date();
var tiempoAntes = d.getTime().valueOf();
console.log(tiempoAntes);

cicloPrimos: for(let i=1;i<=numero;i++){
    let cont=0;
    for(let j=1;j<=i;j++){
        if(i%j===0){
            cont++;
        }
        if(cont>2){
            continue cicloPrimos;
        }

    }
    if(cont===2){
        console.log("el siguiente numero es primo: "+i);
    }


}

var d2 = new Date();
var tiempoDespues = d2.getTime().valueOf();
console.log(tiempoDespues);

console.log(tiempoDespues-tiempoAntes);

