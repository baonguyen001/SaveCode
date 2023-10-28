/* Truncate Card Title */
window.addEventListener("load", function(){
    truncateCardTitle();

})


function truncateCardTitle(){
    var cardList = document.getElementsByClassName("card-title");
    for(var i = 0; i< cardList.length; i++){
        var text = cardList[i].innerHTML;
        var newText = truncateString(text, 35);
        cardList[i].innerHTML = newText;
    }
    
}

function truncateString(str, num){
    if(str.length > num){
        return str.slice(0, num) + "...";
    }else{
        return str;
    }
}

/* Sidebar mini */
var toggleBtn = document.querySelector(".sidebarMini__btn");
var sidebarMini = document.querySelector(".sidebarMini");
var switchBtn = document.querySelector('#checkbox');

// THêm sự kiện
toggleBtn.addEventListener('click', function(){
    // nếu class sidebarMini đã có class 'is-open' thì remove ngược lại thì add class 'is-open'
    sidebarMini.classList.toggle('is-open')
})

switchBtn.addEventListener('click', function(){
    // nếu class sidebarMini đã có class 'is-open' thì remove ngược lại thì add class 'is-open'
    document.querySelector('body').classList.toggle('darkMode');
})