var cxt, width = 200, height = 150;
var objp = new Array(5);

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
	this.setSize = function(size) {
		this.size = size;
	};
	this.setSpeed = function(speed) {
		this.speed = speed;
	};
	this.setAngle = function(angle) {
		this.angle = angle;
	};
}

function collide(p1, p2){
	dx = p1.x - p2.x;
    dy = p1.y - p2.y;
    dist = Math.sqrt(dx * dx + dy * dy);
    if (dist < p1.size+p2.size){
    	tangent = Math.atan2(dy, dx);
    	angle = 0.5*Math.PI+tangent;
    	angle1 = 2*tangent - p1.angle;
        angle2 = 2*tangent - p2.angle;
        speed1 = p2.speed*elasticity;
        speed2 = p1.speed*elasticity;
        p1.angle = angle1;
        p2.angle = angle2;
        p1.speed = speed1;
        p2.speed = speed2;
        p1.x += Math.sin(angle);
        p1.y -= Math.cos(angle);
        p2.x -= Math.sin(angle);
        p2.y += Math.cos(angle);
    }
}

function addVectors(angle1, length1, angle2, length2){
 	x  = Math.sin(angle1) * length1 + Math.sin(angle2) * length2;
    y  = Math.cos(angle1) * length1 + Math.cos(angle2) * length2;
    angle = 0.5 * Math.PI - Math.atan2(y, x);
    length  = Math.sqrt(x * x + y * y);
    return {angle : angle, length : length};
}

function getRandom(min, max) {
	return Math.floor(Math.random() * (max - min + 1)) + min;
}

function init() {
	var drawingCanvas = document.getElementById('particle');
	if (drawingCanvas.getContext) {
		cxt = drawingCanvas.getContext('2d');
		cxt.canvas.width = width;
		cxt.canvas.height = height;
	}
	for (var c=0;c<objp.length;c++){
		size = 4;
		var x = getRandom(size, width-size);
		var y = getRandom(size, height-size);
		objp[c] = new Particle(x, y, 5);
		objp[c].setSpeed(5.5);
	}
	return setInterval(drawBall, 33);
}

function drawBall() {
	cxt.fillStyle = "#D1D1D1";
	cxt.fillRect(0, 0, width, height);
	cxt.fillStyle = "blue";
	for (var c=0;c<objp.length;c++){
		cxt.beginPath();
		objp[c].move();
		objp[c].bounce();
		cxt.arc(objp[c].x, objp[c].y, objp[c].size, 0, Math.PI * 2, true);
		for (var p=0;p<objp.length;p++){
			if (p!=c)
				collide(objp[c], objp[p]);
		}
		cxt.closePath();
		cxt.fill();
	}
}