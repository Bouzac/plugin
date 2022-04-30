let ageTaken = false
let pseudoTaken = false
let studentTaken = false

let Random = 0;

let age
let pseudo
let student

document.getElementById("myPseudoButton").onclick = function(){

    pseudo = document.getElementById("myPseudoText").value
    document.getElementById("pseudoInput").innerText = "Ton nom est: " + pseudo
    pseudoTaken = true
}

document.getElementById("myAgeButton").onclick = function(){

    age = document.getElementById("myAgeInt").value
    document.getElementById("ageInput").innerText = "Ton age est: " + age
    ageTaken = true
}

document.getElementById("yes").onclick = function(){

    student = true
    document.getElementById("studentInput").innerText = "Tu va a l'école"
    studentTaken = true;
}

document.getElementById("no").onclick = function(){

    student = false
    document.getElementById("studentInput").innerText = "Tu ne va pas a l'école"
    studentTaken = true;
}

document.getElementById("sendResults").onclick = function(){

    if(ageTaken == true && pseudoTaken == true && studentTaken == true){

        Random = Math.floor(Math.random() * 11)
        document.getElementById("p1").innerHTML = "Désir de biscuit : " + Random + "/10" 
    }
}