var cxt, width = 100, height = 90;

function Point(x, y) {
	var dx = 4, dy = 4;
	this.x = x;
	this.y = y;
	this.size = 4;

	this.getX = function() {
		this.x += dx;
		if (this.x < this.size) {
			this.x = this.size;
			dx = -dx;
		}
		if (this.x > width - this.size) {
			this.x = width - this.size;
			dx = -dx;
		}
		return this.x;
	};

	this.getY = function() {
		this.y += dy;
		if (this.y < this.size) {
			this.y = this.size;
			dy = -dy;
		}
		if (this.y > height - this.size) {
			this.y = height - this.size;
			dy = -dy;
		}
		return this.y;
	};
	this.getSize = function() {
		return this.size;
	};
}

function init() {
	var drawingCanvas = document.getElementById('bouncing');
	if (drawingCanvas.getContext) {
		cxt = drawingCanvas.getContext('2d');
	}
	obj1 = new Point(44, 25);
	obj2 = new Point(5, 80);
	return setInterval(drawBall, 33);
}

function drawBall() {
	cxt.fillStyle = "#D1D1D1";
	cxt.fillRect(0, 0, width, height);
	cxt.fillStyle = "blue";
	cxt.beginPath();
	cxt.arc(obj1.getX(), obj1.getY(), obj1.getSize(), 0, Math.PI * 2, true);
	cxt.arc(obj2.getX(), obj2.getY(), obj2.getSize(), 0, Math.PI * 2, true);
	cxt.closePath();
	cxt.fill();
}