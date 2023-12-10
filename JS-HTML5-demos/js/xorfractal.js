var cxt, width = 320, height = 400;

function init() {
	var drawingCanvas = document.getElementById('xor');
	if (drawingCanvas.getContext) {
		cxt = drawingCanvas.getContext('2d');
		cxt.canvas.width = width;
		cxt.canvas.height = height;
	}
	cxt.fillStyle = "#FFF";
	cxt.fillRect(0, 0, width, height);
	for (w = 0; w <= width; w++) {
		for (h = 0; h <= height; h++) {
			if (((w ^ h) % 3) % 2 == 0) {
				cxt.fillStyle = "#000";
				cxt.fillRect(w, h, 1, 1);
			}
		}
	}
}