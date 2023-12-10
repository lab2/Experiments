var cxt, width = 100, height = 90;

function Particle(x, y, size) {
	var dx = 4, dy = 4;
	this.x = x;
	this.y = y;
	this.speed = 0;
	this.angle = 90;
	this.size = size;

	this.getX = function() {
		this.x += Math.sin(this.angle)*this.speed;
		if (this.x < this.size) {
			this.x = this.size;
			this.angle = -this.angle;
		}
		if (this.x > width - this.size) {
			this.x = width - this.size;
			this.angle = -this.angle;
		}
		return this.x;
	};

	this.getY = function() {
		this.y -= Math.cos(this.angle)*this.speed;
		if (this.y < this.size) {
			this.y = this.size;
			this.angle = Math.PI-this.angle;
		}
		if (this.y > height - this.size) {
			this.y = height - this.size;
			this.angle = Math.PI-this.angle;
		}
		return this.y;
	};
	this.getSize = function() {
		return this.size;
	};
	this.setSpeed = function(speed) {
		this.speed = speed;
	};
	this.setAngle = function(angle) {
		this.angle = angle;
	};
}

function init() {
	var drawingCanvas = document.getElementById('particle');
	if (drawingCanvas.getContext) {
		cxt = drawingCanvas.getContext('2d');
	}
	obj1 = new Particle(44, 25, 5);
	obj1.setAngle(100); 
	obj1.setSpeed(3);
	
	return setInterval(drawBall, 33);
}

function drawBall() {
	cxt.fillStyle = "#D1D1D1";
	cxt.fillRect(0, 0, width, height);
	cxt.fillStyle = "blue";
	cxt.beginPath();
	cxt.arc(obj1.getX(), obj1.getY(), obj1.getSize(), 0, Math.PI * 2, true);
	cxt.closePath();
	cxt.fill();
}