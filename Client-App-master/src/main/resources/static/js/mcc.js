// Arrays
let cars = ["Saab", "Volvo", "BMW"];
        console.log(document.getElementById("demo").innerHTML = cars);
        console.log(document.querySelector("#demo2").innerHTML);
        cars.push("Avanza");
        console.log(cars);
        cars.pop();
        console.log(cars);
        cars.unshift("Avanza");
        console.log(cars);
        cars.shift("Avanza");
        console.log(cars);
        let colors = ['red', 'green', 'blue'];
        colors[0] = 'orange';
        console.log(colors[0]);
        let firstName = ['Fadel', 'Willi', 'Christina'];
        let lastName = ['Nasution', 'yangjaya', 'regita'];
        let fullName = firstName.concat(lastName);
        console.log(fullName);
        
// String
        let msg = "heLlO";
        console.log(msg.toUpperCase());
        console.log(msg.toLowerCase());
        let input = "  hello mcc    ";
        console.log(input.trim());
        let index = "abcdefg";
        console.log(index.indexOf("b"));
        let str = "metrodata";
        console.log(str.slice(0, 5));
        console.log(str.replace('data', 'mini'));
        let product = "SUMSANG";
        let price = 100.99;
        let qty = 10;
        console.log(`Saya membeli ${product} seharga $${price} sebanyak ${qty} unit`);
        
        // Objects
        const object = {
        "nama":"fadel"
        };
        console.log(object.nama);
        
        // Filter Array
        var numbers = [4, 9, 16, 25];
        console.log(numbers.map(Math.sqrt));

// Truthy Falsy
// sebuah nilai yang dibaca menjadi sebuah boolean
if (true) {
console.log("trueee");
}
if ({}) {
console.log("trueee");
}
if ([]) {
console.log("trueee");
}
if (42) {
console.log("trueee");
}
if ("0") {
console.log("trueee");
}
if ("false") {
console.log("trueee");
}
if (new Date()) {
console.log("trueee");
}
if ( - 42) {
console.log("trueee");
}
if (12n) {
console.log("trueee");
}
if (3.14) {
console.log("trueee");
}
if ( - 3.14) {
console.log("trueee");
}
if (Infinity) {
console.log("trueee");
}
if ( - Infinity) {
console.log("trueee");
}

if (false){
console.log("false");
}
if (null){
console.log("false");
}
if (undefined){
console.log("false");
}
if (0){
console.log("false");
}
if ( - 0){
console.log("false");
}
if (0n){
console.log("false");
}
if (NaN){
console.log("false");
}
if (""){
console.log("false");
}

// If the first object is falsy, it returns that object
false && "dog"
// ↪ false
        console.log(false && "dog");
0 && "dog"
// ↪ 0
        console.log(0 && "dog");

function myFunction() {
        x = document.getElementById("demo1");
                x.innerHTML = numbers.map(Math.sqrt);
        }

// Basic Syntax : $(selector).action()
$(document).ready(function(){
    $("h1").click(function(){ // hides all element H1
        $(this).hide(); // hides the current element
    });
});

$(document).ready(function(){
    $(".button2").click(function(){
        $("h3").hide();
  });
});