var perro = {raza: "dobermang", sexo: "machito", color: "blanco"};

console.log(perro);

var Ventas = "Toyota";

function TiposCarro(nombre) {
    if (nombre == "Honda") {
        return nombre;
    } else {
        return "Lo siento, nosotros no vendemos " + nombre + ".";
    }
}

var carro = {miCarro: "Saturn", getCarro: TiposCarro("Honda1"), especial: Ventas};

console.log(carro.miCarro);  // Saturn
console.log(carro.getCarro); // Honda
console.log(carro.especial); // Toyota

var auto = {algunosAutos: {a: "Saab", "b": "Jeep"}, 7: "Mazda"};

console.log(auto.algunosAutos.a); // Jeep
console.log(auto.algunosAutos.b); // Jeep
console.log(auto["7"]); // Jeep
console.log(auto[7]); // Mazda

// propiedades de objeto literales inusuales

var propiedadesDeNombreInusual = {
    "": "Un string vacio",
    "!": "Bang!"
};
//console.log(propiedadesDeNombreInusual."");   // SyntaxError: Unexpected string
console.log(propiedadesDeNombreInusual[""]);  // "Un string vacio"
//console.log(propiedadesDeNombreInusual .!);    // SyntaxError: Unexpected token !
console.log(propiedadesDeNombreInusual["!"]); // "Bang!"

var foo = {a: "alpha", 2: "two"};
console.log(foo.a);    // alpha
console.log(foo[2]);   // two
//console.log(foo.2);  // Error: missing ) after argument list
//console.log(foo[a]); // Error: a is not defined
console.log(foo["a"]); // alpha
console.log(foo["2"]); // two




