/*function loadRequests(text) {
    var table = document.getElementById('display');
    for(var i=0; i < text.length; i++) {

        if(text[i].status!="approved") {
            row = document.createElement("tr");
            
            data1 = document.createElement("td");
            data3 = document.createElement("td");

            row.className = "request";
            table.appendChild(row);
            
            row.appendChild(data1);
         
            row.appendChild(data3);

            const field1 = document.createTextNode(text[i].requestid);
 
            const field3 = document.createTextNode(text[i].status);
            
            data1.appendChild(field1);
            
            data3.appendChild(field3);
        }
    }
}

function getRequests(){
	console.log("in get requests");
    var request = new XMLHttpRequest();
    request.open('GET', '/Project1/project1/reimbursementrequest', true);
    request.onload = function() {
        console.log(request.responseText);
        var text= JSON.parse(request.responseText);
console.log(text);
        loadRequests(text);
        awardedRequests(text);
		setTimeout(getEmployee(),5000);
    }
    request.send();
    
}

function awardedRequests(text){

    var table2 = document.getElementById('request');

    for(var i=0; i < text.length; i++){
        
        if(text[i].status=="approved") {
            row2 = document.createElement("tr");
        
            newData1 = document.createElement("td");
            newData2 = document.createElement("td");
            
            row2.className = "request2";
            table2.appendChild(row2);
            
            row2.appendChild(newData1);
            row2.appendChild(newData2);

            const requestNum = document.createTextNode(text[i].requestid);
            const amount = document.createTextNode("$"+text[i].amount);

            newData1.appendChild(requestNum);
            newData2.appendChild(amount);
        }
    }
}


function getEmployeeInfo(employee) {
    document.getElementById("reimburbalance").innerHTML="Reimbursement Balance: " +"$"+ employee.balance;
    document.getElementById("welcome").innerHTML="Welcome, "+ employee.firstname + " " + employee.lastname;
    document.getElementById("address").innerHTML=employee.address;
    document.getElementById("citystatezipcode").innerHTML=employee.city + ", " + employee.state + " " + employee.zipcode;
    console.log("in getEmployeeInfo");
}



function getEmployee() {
    console.log("In getEmployee()");
    var xhr= new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange = function(){
    
    if(xhr.readyState==4 && xhr.status==200){
        console.log(xhr.responseText);
        var employee = JSON.parse(xhr.responseText);
		console.log(employee);
        getEmployeeInfo(employee);

    }

 }
    xhr.open("GET","/Project1/project1/employeeinfo",true);
    //Step 4
    xhr.send();

}
*/


function loadRequests(text) {
    var table = document.getElementById('display');
    for(var i=0; i < text.length; i++) {

        if(text[i].status!="approved") {
            row = document.createElement("tr");
            
            data1 = document.createElement("td");
            data3 = document.createElement("td");

            row.className = "request";
            table.appendChild(row);
            
            row.appendChild(data1);
         
            row.appendChild(data3);

            const field1 = document.createTextNode(text[i].requestid);
 
            const field3 = document.createTextNode(text[i].status);
            
            data1.appendChild(field1);
            
            data3.appendChild(field3);
        }
    }
}

var files = null; // when files input changes this will be initiliazed.
$(function() {
    $('#upload-form').on('submit', uploadFile);
});

function uploadFile(event) {
    event.stopPropagation();
    event.preventDefault();
    var files = files;
    var form = document.getElementById('upload-form');
    var data = new FormData(form);
    postFilesData(data);
}

function postFilesData(data) {
    console.log(data)
    $.ajax({
        url :  'yourUrl',
        type : 'POST',
        data : data,
        cache : false,
        dataType : 'json',
        processData : false,
        contentType : false,
        success : function(data, textStatus, jqXHR) {
            alert(data);
            console.log(data);
        },
        error : function(jqXHR, textStatus, errorThrown) {
            alert('ERRORS: ' + textStatus);
        }
    });
}

var files = null; // when files input changes this will be initiliazed.
$(function() {
    $('#upload-form').on('submit', uploadFile);
});

function uploadFile(event) {
    event.stopPropagation();
    event.preventDefault();
    var files = files;
    var form = document.getElementById('upload-form');
    var data = new FormData(form);
    postFilesData(data);
}

function postFilesData(data) {
    console.log(data)
    $.ajax({
        url :  'yourUrl',
        type : 'POST',
        data : data,
        cache : false,
        dataType : 'json',
        processData : false,
        contentType : false,
        success : function(data, textStatus, jqXHR) {
            alert(data);
            console.log(data);
        },
        error : function(jqXHR, textStatus, errorThrown) {
            alert('ERRORS: ' + textStatus);
        }
    });
}

function populate(){
    var form = document.createElement("form");
    form.setAttribute("id", "upload-form") 
    form.setAttribute("method", "post");
    form.setAttribute("action", "");

    var FN = document.createElement("input"); 
    FN.setAttribute("type", "file"); 
    FN.setAttribute("name", "file"); 

    var s = document.createElement("input"); 
    s.setAttribute("type", "submit"); 
    s.setAttribute("class", "btn btn-primary");
    s.setAttribute("value", "Submit");

    form.appendChild(FN);
    form.appendChild(s);

    document.getElementsById("action")[0].appendChild(form);

}

// Still need to add logic for file upload
function loadActionRequired(text) {
    
    var table2 = document.getElementById('action');

    for(var i=0; i < text.length; i++){
        if(text[i].status=="dsinput" || text[i].status=="dhinput" || text[i].status=="bcinput") {
            row2 = document.createElement("tr");
        
            newData2 = document.createElement("td");
            newData3 = document.createElement("td");
            
            row2.className = "request2";
            table2.appendChild(row2);
            
            row2.appendChild(newData2);
            row2.appendChild(newData3);

            const requestNum = document.createTextNode(text[i].requestid);
            var form = document.createElement("form");
            form.setAttribute("id", "upload-form") 
            form.setAttribute("method", "post");
            form.setAttribute("action", "");
        
            var FN = document.createElement("input"); 
            FN.setAttribute("type", "file"); 
            FN.setAttribute("name", "file"); 
        
            var s = document.createElement("input"); 
            s.setAttribute("type", "submit"); 
            s.setAttribute("class", "btn btn-primary");
            s.setAttribute("value", "Submit");
        
            form.appendChild(FN);
            form.appendChild(s);

            newData2.appendChild(requestNum);
            newData3.appendChild(form);
        }
        
    }
}

function getRequests(){
	console.log("in get requests");
    var request = new XMLHttpRequest();
    request.open('GET', '/Project1/project1/reimbursementrequest', true);
    request.onload = function() {
        console.log(request.responseText);
        var text= JSON.parse(request.responseText);
console.log(text);
        loadRequests(text);
        awardedRequests(text);
        loadActionRequired(text);
		getEmployee();
    }
    request.send();
    
}

function awardedRequests(text){

    var table2 = document.getElementById('request');

    for(var i=0; i < text.length; i++){
        
        if(text[i].status=="awarded") {
            row2 = document.createElement("tr");
        
            newData1 = document.createElement("td");
            newData2 = document.createElement("td");
            
            row2.className = "request2";
            table2.appendChild(row2);
            
            row2.appendChild(newData1);
            row2.appendChild(newData2);

            const requestNum = document.createTextNode(text[i].requestid);
            const amount = document.createTextNode(text[i].amount);

            newData1.appendChild(requestNum);
            newData2.appendChild(amount);
        }
    }
}

function getEmployeeInfo(employee) {
    document.getElementById("reimburbalance").innerHTML="Reimbursement Balance: " +"$"+ employee.balance;
    document.getElementById("welcome").innerHTML="Welcome, "+ employee.firstname + " " + employee.lastname;
    document.getElementById("address").innerHTML=employee.address;
    document.getElementById("citystatezipcode").innerHTML=employee.city + ", " + employee.state + " " + employee.zipcode;
    console.log("in getEmployeeInfo");
}


function getEmployee() {
    console.log("In getEmployee()");
    var xhr= new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange = function(){
    
    if(xhr.readyState==4 && xhr.status==200){
        console.log(xhr.responseText);
        var employee = JSON.parse(xhr.responseText);
		console.log(employee);
        getEmployeeInfo(employee);

    }

 }
    xhr.open("GET","http://localhost:8080/Project1/project1/employeeinfo?",true);
    //Step 4
    xhr.send();

}