/*
how do we do it?

1) Set up event listner
2) set up function to be excuted when event triggers
3) create XMLHttpRequest object
4) XMLHttpRequest object sends a request to web server and receive response
5) read object from the response
*/


// step 1 - start listning to the even when the page loads
window.onload = function(){
    document.getElementById("swSubmit").addEventListener('mouseenter', getSW());
}

// step 2
function getSW(){
    let swID = document.getElementById("swID").Value;
    console.log(swID);

    // step 3 - create the XMLHttpRequest object
    // allow us to make requests and get back data
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        console.log(xhttp.readystate)
        /*
        readystate property holds the status of the XMLHttpRequest
            0 - request not initialized
            1 - server connection established
            2 - request received 
            3 - processing request
            4 - request is finished and the response is ready
        */

        // response is ready
        if(xhttp.readyState == 4 && xhttp.status == 200){
            console.log("xhttp is done");
            // get JSON object from response
          
           var MyJSON= JSON.parse(xhttp.responseText);
            console.log(JSON);
            // call a function that update the elements on the page 
            DOMupdate(MyJSON);
        }

        if(xhttp.readyState == 4 && xhttp.status == 404){
            console.log("request was not successful!");
            cont  = {"name":"does not exist", "birth_year":"0"}
        }
    }

    // step 4 - open the url
    xhttp.open("GET", "http://swapi.dev/api/people/" + swID);
    // send 
    xhttp.send();
}

// function to update page with info from the server
function DOMupdate(ourJSON){
    document.getElementById("swName").innerText = ourJSON.name;
    document.getElementById("swBirthYear").innerText = ourJSON.birth_year;
}
