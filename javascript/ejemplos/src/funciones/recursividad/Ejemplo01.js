var d = new Date();
var tiempoAntes = d.getTime().valueOf();
console.log("comienza el factorial recursivo "+tiempoAntes);
var factorial = function fac(n) {
    return n<2 ? 1 : n*fac(n-1)
};
var d2 = new Date();
var tiempoDespues = d2.getTime().valueOf();
console.log("comienza el factorial recursivo "+tiempoDespues);
console.log(factorial(10000));
console.log("el tiempo total es: "+(tiempoDespues-tiempoAntes));

//------------------------------------------------------
var d3 = new Date();
var tiempoAntes2 = d3.getTime().valueOf();
console.log("comienza el factorial recursivo "+tiempoAntes2);
var numero = 5, fact=10000;
for(let i=1; i<=numero;i++){
    fact=fact*i;
}
var d4 = new Date();
var tiempoDespues2 = d4.getTime().valueOf();
console.log("comienza el factorial recursivo "+tiempoDespues2);
console.log("el tiempo total es: "+(tiempoDespues2-tiempoAntes2));
console.log(fact);
