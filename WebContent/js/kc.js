var kc = [ 38, 38, 40, 40, 37, 39, 37, 39, 66, 65 ];
var kcQueue = [];
document.onkeydown = kcQueueKey;
var kcApply = true;

function kcQueueKey(e) {
	var event = window.event ? window.event : e;

	kcQueue.push(event.keyCode);
	if (kcQueue.length > 10) {
		kcQueue.shift();
	}

	if (kcQueue.length == 10) {
		var kcOK = true;
		for (var i = 0; i < kc.length; i++) {
			if (kc[i] !== kcQueue[i]) {
				kcOK = false;
				break;
			}
		}
		if (kcOK) {
			var body = document.body;

			if (kcApply) {
				body.style.filter = 'invert(75%)';
				body.style.webkitFilter = 'invert(75%)';
			} else {
				body.style.filter = '';
				body.style.webkitFilter = '';
			}
			kcApply = !kcApply;
		}
	}
}
