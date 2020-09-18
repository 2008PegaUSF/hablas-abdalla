

window.onload = function(){
    document.getElementById("swSubmit").addEventListener("click", getSW())
}

function getSW(){
    let swID = document.getElementById("swID").nodeValue;
    fetch("http://swapi.dev/api/people/5")
    .then(
        // put the response into JSON object
        function(responseThingy){
            console.log(responseThingy);
            return responseThingy.json();
        }
    ).then(
        // update the DOM on the HTML page
        (daResponse)=>{
            console.log(daResponse);
            DOMupdate(daResponse); // update DOM
        }
    ).catch(
        // basically CATCH is error/exception handling// if the object 
        (daResponse)=> {
            console.log("Error Message");
        }
    )
}

function DOMupdate(ourJSON){
    document.getElementById("swName").innerText = ourJSON.name;
    document.getElementById("swBirthYear").innerText = ourJSON['birth_year']; // using brackets notation
}


// some extra cool stuff to know
    // using template literals 
    let num = 40;
    let myprintout = `my number is ${num}, this is so cool 
                    it keeps the format`;
    console.log(myprintout);

    // fat arrow notation insted of using function keyword
    let math = (x,y) => {return x/y};

    // constructors
    class Robot {
    constructor(name, ability, weight) {
        this.name = name;
        this.ability = ability;
        this.weight = weight;
    }

    /*
    or you can use older notation 
    function Robot(name, ability, weight){
        this.name = name;
        this.ability = ability;
        this.weight = weight;
    }
    */ 
}
    // to use that class or constructor 
    var r1 = new Robot ("bob", "sleepy", 10);

    // CallBack Functions
    function doStuff(stiff, callBackFunc){
        alert(`look at me, i'm ${stuff}`);
        callBackFunc(stuff);
    }



