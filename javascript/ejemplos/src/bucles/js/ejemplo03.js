var j=0;
var i=0;
labelCiclo: while(i<10){
    console.log("hola mundo "+i);
    i++;
    if(j===1){
        continue labelCiclo;
    }else{
        break labelCiclo;
    }

    console.log("termino el ciclo");

}

cicloa: while(a==1){
    ciclob: while(b==1){
        cicloc: while(c==1){

            if(c>1){
                continue cicloa;
            }

            if(c<0){
                continue ciclob;
            }


        }
    }
}












