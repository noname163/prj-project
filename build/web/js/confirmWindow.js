/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
function myFunction() {
    let text = "Press a button!\nEither OK or Cancel.";
    var a = document.getElementById('submitConfirm');
    if (confirm(text) == true) {
        a.href = "mainController?action=confirm";
    } else {
        a.href = "errosPage.jsp";
    }
    console.log(a.herf);
}
function plush(id) {

    var a = parseInt(document.getElementById(id).value);
    document.getElementById(id).value = a + 1;
    console.log(a);
}
function subtract(id) {
    var a = 0;
    a = parseInt(document.getElementById(id).value);
    document.getElementById(id).value = a - 1;
    if (a <= 0) {
        document.getElementById(id).value = 0;
    }
    console.log(a);
}

//function total() {
//    var sum = 0;
//    document.getElementById("total").innerHTML = document.getElementsByClassName("quantity")[0].value;
//    document.getElementById("total").innerHTML = document.getElementsByClassName("quantity").length;
//    for (let i = 0; i < document.getElementsByClassName("quantity").length; i++) {
//        var price = parseInt(document.getElementsByClassName("quantity")[i].value) * parseInt(document.getElementsByClassName("price")[i].innerHTML);
//        sum += price;
//    }
//    document.getElementById("total").innerHTML = sum;
//}