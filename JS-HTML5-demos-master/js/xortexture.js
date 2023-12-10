var cxt, width = 256, height = 256, c;

function init() {
	var drawingCanvas = document.getElementById('texture1');
	if (drawingCanvas.getContext) {
		cxt = drawingCanvas.getContext('2d');
		cxt.canvas.width = width;
		cxt.canvas.height = height;
	}
	cxt.fillStyle = "#FFF";
	cxt.fillRect(0, 0, width, height);
	for (x = 0; x < width; x++)
		for (y = 0; y < height; y++) {
			c = (x ^ y);
			r = 255 - c;
			g = c;
			b = c % 128;
			cxt.fillStyle = "rgb(" + r + "," + g + "," + b + ")";
			cxt.fillRect(x, y, 1, 1);
		}

	var drawingCanvas = document.getElementById('texture2');
	if (drawingCanvas.getContext) {
		cxt = drawingCanvas.getContext('2d');
		cxt.canvas.width = width;
		cxt.canvas.height = height;
	}
	cxt.fillStyle = "#FFF";
	cxt.fillRect(0, 0, width, height);
	for (x = 0; x < width; x++)
		for (y = 0; y < height; y++) {
			c = x ^ y;
			cxt.fillStyle = "rgb(" + c + "," + c + "," + c + ")";
			cxt.fillRect(x, y, 1, 1);
		}
}