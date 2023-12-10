var cxt, width = 640, height = 480;

function isPrime(n) {
	if (n == 1)
		return 0;
	if (n == 2)
		return 1;
	if (n % 2 == 0)
		return 0;
	var sqr = Math.sqrt(n * 1);
	for (c = 3; c <= sqr; c += 2) {
		if (n % c == 0)
			return 0;
	}
	return 1;
}

function init() {
	var drawingCanvas = document.getElementById('primes');
	if (drawingCanvas.getContext) {
		cxt = drawingCanvas.getContext('2d');
		cxt.canvas.width = width;
		cxt.canvas.height = height;
	}
	cxt.fillStyle = "#000";
	cxt.fillRect(0, 0, width, height);
	for (w = 0; w <= width; w++) {
		for (h = 0; h <= height; h++) {
			if (isPrime(w & h)) {
				cxt.fillStyle = "#6495ED";
				cxt.fillRect(w, h, 1, 1);
			}
		}
	}
}