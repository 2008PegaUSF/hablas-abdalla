$(document).ready(function () {

    $("#amount").keypress(function (e) {
       
       if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
          
          $("#errmsg").html("Digits Only").show().fadeOut("slow");
                 return false;
      }
     });
  });

function percentage(e) {
    var number = parseInt(document.getElementById("amount").value);
    var type = document.getElementById("coursetype").value;
    if(type == "universitycourse"){
        var p = 80/100;
        var newnumber = number*p;
        document.getElementById("amount").value = newnumber;
    } else if(type == "certification"){
        
    } else if(type == "certificationPrep"){
        var p = 75/100;
        var newnumber = number*p;
        document.getElementById("amount").value = newnumber;
    } else if(type == "seminars"){
        var p = 60/100;
        var newnumber = number*p;
        document.getElementById("amount").value = newnumber;
    } else if(type == "technicalTraining"){
        var p = 90/100;
        var newnumber = number*p;
        document.getElementById("amount").value = newnumber;
    } else if(type == "other"){
        var p = 30/100;
        var newnumber = number*p;
        document.getElementById("amount").value = newnumber;
    }
    return newnumber;
}

function gradingFormat(e){
    var type = document.getElementById("coursetype").value;
    if(type == "universitycourse"){
        document.getElementById("grading-format").value = "Letter Grade";
    } else if(type == "certification"){
        document.getElementById("grading-format").value = "Pass/Fail";
    } else if(type == "certificationPrep"){
        document.getElementById("grading-format").value = "Pass/Fail";
    } else if(type == "seminars"){
        document.getElementById("grading-format").value = "Completion Proof";
    } else if(type == "technicalTraining"){
        document.getElementById("grading-format").value = "Certificate";
    } else if(type == "other"){
        document.getElementById("grading-format").value = "Completion Proof";
    }
}
//FORM DATA TO JSON

(function() {
	function toJSONString( form ) {
		var obj = {};
		var elements = form.querySelectorAll( "input, select" );
		for( var i = 0; i < elements.length; ++i ) {
			var element = elements[i];
			var name = element.name;
			var value = element.value;

			if( name ) {
				obj[ name ] = value;
			}
        }
        newObj = {
            "requestid" : 50,
            "employeeid" : 50,
            "requesttype" : obj["coursetype"],
            "requestdate" : "2020-06-04",
            "coursedate" : obj["coursedate"],
            "amount" : obj["amount"],
            "status" : "pending",
            "coursename" : obj["coursename"],
            "coursedescription" : obj["coursedescription"]
        };
        console.log(obj);
        console.log(newObj);
		return JSON.stringify( newObj );
    }
    

	document.addEventListener( "DOMContentLoaded", function() {
		var form = document.getElementById( "requestform" );
		form.addEventListener( "submit", function( e ) {
            e.preventDefault();
            percentage()
			var json = toJSONString( this );
            console.log(json);
            postRequest(json);
alert("Form Submitted Successfully!");

		}, false);

	});

})();

function postRequest(json){

    console.log("in postRequest");
    var xhr= new XMLHttpRequest();
    xhr.onreadystatechange= function() {
        console.log("in ORSC "+ xhr.readyState );
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
        }
    }
    xhr.open("POST","/Project1/project1/newreimbursementrequest",true);
    var payload=json;
    xhr.send(payload);

}


function forward(){
	//window.location.replace("/Project1/project1/home");
}
