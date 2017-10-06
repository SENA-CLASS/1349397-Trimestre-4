var numeroRango = 1;
var conPalindromes = 0;
var rangoEntero = parseInt( prompt("digite el rango"));
while (numeroRango <= rangoEntero) {


    var numeroLeido = prompt("digite el numero " + numeroRango);
    numeroLeido = numeroLeido.toLowerCase();

    var asc = 0;
    var des = numeroLeido.length - 1;
    var palindrome = true;
    while (asc <= des) {
        if (numeroLeido.charAt(asc) == numeroLeido.charAt(des)) {
            asc++;
            des--;
        } else {
            palindrome = false;
            break;
        }
    }

    if (palindrome === true) {
        console.log("el numero es palindrome");
        conPalindromes++;
    } else {
        console.log("el numero no es palindrome");
    }


    numeroRango++;
}
alert("el numero de palindromes que hay en el rango de nuemro es " + conPalindromes);


