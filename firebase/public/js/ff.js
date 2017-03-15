var ff = [ 70, 70 ];
var ffQueue = [];
document.onkeydown = ffQueueKey;

var ffimages = [
		'https://firebasestorage.googleapis.com/v0/b/ffge-9a4e7.appspot.com/o/img%2Fff1.jpg?alt=media&token=6a2170f8-bf5f-46c4-8b8c-a89b465b9d8d',
		'https://firebasestorage.googleapis.com/v0/b/ffge-9a4e7.appspot.com/o/img%2Fff2.jpg?alt=media&token=004b05c6-94cf-4fa4-a24f-e99877224b21',
		'https://firebasestorage.googleapis.com/v0/b/ffge-9a4e7.appspot.com/o/img%2Fff3.jpg?alt=media&token=5d4145f6-616c-4853-b7df-d1709d292e52',
		'https://firebasestorage.googleapis.com/v0/b/ffge-9a4e7.appspot.com/o/img%2Fff3.jpg?alt=media&token=5d4145f6-616c-4853-b7df-d1709d292e52',
		'https://firebasestorage.googleapis.com/v0/b/ffge-9a4e7.appspot.com/o/img%2Fff4.jpg?alt=media&token=43340a46-7afd-47d2-adf3-bbb464a238d1',
		'https://firebasestorage.googleapis.com/v0/b/ffge-9a4e7.appspot.com/o/img%2Fff5.jpg?alt=media&token=21ddcc46-a732-4d15-b203-70df510c6f4b',
		'https://firebasestorage.googleapis.com/v0/b/ffge-9a4e7.appspot.com/o/img%2Fff6.jpg?alt=media&token=1cc98a67-ca7d-431c-9b63-9a37d0963e27',
		'https://firebasestorage.googleapis.com/v0/b/ffge-9a4e7.appspot.com/o/img%2Fff7.jpg?alt=media&token=67a1189a-28b7-4eed-9ef4-f9b089574415' ];

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
			image.src = ffimages[imgIndex];

			var player = document.getElementById('ffgePlayer');
			player.style.display = '';
		}
	}
}
