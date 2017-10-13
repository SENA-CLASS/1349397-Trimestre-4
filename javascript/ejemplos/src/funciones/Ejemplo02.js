var mycar = {make: "Honda", model: "Accord", year: 1998},
    x,
    y;

console.log(mycar);
x= mycar.make;
console.log(x);

function myFunc(theObject) {
    theObject.make = "Toyota";
}

myFunc(mycar);
console.log(mycar);
console.log(x);

y = mycar.make;
console.log(y);
