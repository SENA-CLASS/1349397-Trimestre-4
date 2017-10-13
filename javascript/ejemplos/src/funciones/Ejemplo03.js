function myFunc(theObject) {
    theObject = {make: "Ford", model: "Focus", year: 2006};
}

var mycar = {make: "Honda", model: "Accord", year: 1998},
    x,
    y;

x = mycar.make;     // x toma el valor "Honda"

myFunc(mycar);
y = mycar.make;     // y sigue con el valor "Honda"

console.log(mycar);