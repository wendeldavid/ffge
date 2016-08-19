var ff = [ 70, 70 ];
var ffQueue = [];
document.onkeydown = ffQueueKey;

function ffQueueKey(e) {
    var event = window.event ? window.event : e;

    ffQueue.push(event.keyCode);
    if (ffQueue.length > 2) {
        ffQueue.shift();
    }

    if (ffQueue.length == 2) {
        var ffOK = true;
        for (var i = 0; i < ff.length; i++) {
            if (ff[i] !== ffQueue[i]) {
                ffOK = false;
                break;
            }
        }
        if (ffOK) {
            ffQueue = []

            var imgIndex = Math.floor((Math.random() * 7) + 1);

            var image = document.getElementById('ffgeImage');
            image.src = 'img/ff' + imgIndex + '.jpg';

            var player = document.getElementById('ffgePlayer');
            player.style.display = '';
        }
    }
}
