function drawCard(card){
    document.getElementById("cardimage").src=card.cards[0].image;
    document.getElementById("cardvalue").innerHTML=card.cards[0].value;
    document.getElementById("cardsuit").innerHTML=card.cards[0].suit;
}

function getCard() {
    var xhr= new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var card= JSON.parse(xhr.responseText);
            drawCard(card);
        }
    }
    xhr.open("GET", "https://deckofcardsapi.com/api/deck/new/draw/?count=1", true);
    xhr.send();
}

window.onload=function(){
    console.log("in onload");
    document.getElementById("CardDraw").addEventListener("click",getCard,false);
}
