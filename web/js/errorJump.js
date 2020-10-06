function sendStats(url) {
    var n = "log_" + (new Date()).getTime();
    var c = window[n] = new Image();
    c.onload = (c.onerror = function () {
        window[n] = null;
    });
    c.src = 'index.jsp' + url;
    c = null;
}

var time = document.getElementById('time');
var btn = document.getElementById('Btn');

function count() {
    if (+time.innerHTML > 0) {
        time.innerHTML = time.innerHTML - 1;
    } else {
        sendStats('gotoindex');
        location.href = btn.href;
    }
}

setInterval(count, 1000);

btn.onclick = function () {
    sendStats('gotoindex');
};