var cxt, width = 100, height = 90;

var drag = 0.999;
var elasticity = 0.75;
var gforce = 0.3;

function Particle(x, y, size) {
	this.x = x;
	this.y = y;
	this.size = size;
	this.speed = 0;
	this.angle = 120;

	this.move = function() {
		var gravity = addVectors(this.angle, this.speed, Math.PI, gforce);
		this.angle = gravity.angle;
		this.speed = gravity.length;
		this.x += Math.sin(this.angle)*this.speed;
		this.y -= Math.cos(this.angle)*this.speed;
		this.speed *= drag;
	}

	this.bounce = function() {
		if (this.x < this.size) {
			this.x = this.size;
			this.angle = -this.angle;
			this.speed *= elasticity;
		}
		if (this.x > width - this.size) {
			this.x = width - this.size;
			this.angle = -this.angle;
			this.speed *= elasticity;
		}
		if (this.y < this.size) {
			this.y = this.size;
			this.angle = Math.PI-this.angle;
			this.speed *= elasticity;
		}
		if (this.y > height - this.size) {
			this.y = height - this.size;
			this.angle = Math.PI-this.angle;
			this.speed *= elasticity;
		}
	}
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

function addVectors(angle1, length1, angle2, length2){
 	x  = Math.sin(angle1) * length1 + Math.sin(angle2) * length2;
    y  = Math.cos(angle1) * length1 + Math.cos(angle2) * length2;
    angle = 0.5 * Math.PI - Math.atan2(y, x);
    length  = Math.sqrt(x * x + y * y);
    return {angle : angle, length : length};
}

function init() {
	var drawingCanvas = document.getElementById('particle');
	if (drawingCanvas.getContext) {
		cxt = drawingCanvas.getContext('2d');
	}
	obj1 = new Particle(44, 25, 5);
	obj1.setSpeed(5.5);
	
	return setInterval(drawBall, 33);
}

function drawBall() {
	cxt.fillStyle = "#D1D1D1";
	cxt.fillRect(0, 0, width, height);
	cxt.fillStyle = "blue";
	cxt.beginPath();
	obj1.move();
	obj1.bounce();
	cxt.arc(obj1.x, obj1.y, obj1.getSize(), 0, Math.PI * 2, true);
	cxt.closePath();
	cxt.fill();
}