var x = 0;
var z = 0
labelCancelLoops: while (true) {
    console.log("Outer loops: " + x);
    x += 1;
    z = 1;
    while (true) {
        console.log("Inner loops: " + z);
        z += 1;
        if (z === 2 && x === 2) {
            continue labelCancelLoops;
        } else if (z === 2) {
            break;
        }
    }
}