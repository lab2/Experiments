//Thanks to: Foundation ActionScript 3.0 animation: making things move!
//Ported from AS to JS

var cxt, width = 320, height = 240;
var numParticles = 10;
var particles = new Array();

function Particle(size) {
	this.x = 0;
	this.y = 0;
	this.size = size;
	this.mass = 0;
	this.vx = 0;
	this.vy = 0;
}

function gravitate(partA, partB) {
	var dx = partB.x - partA.x;
	var dy = partB.y - partA.y;
	var distSQ = dx * dx + dy * dy;
	var dist = Math.sqrt(distSQ);
	var force = partA.mass * partB.mass / distSQ;
	var ax = force * dx / dist;
	var ay = force * dy / dist;
	partA.vx += ax / partA.mass;
	partA.vy += ay / partA.mass;
	partB.vx -= ax / partB.mass;
	partB.vy -= ay / partB.mass;
	partA.x += partA.vx;
	partA.y += partA.vy;
	partB.x += partB.vx;
	partB.y += partB.vy;
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

	for ( var c = 0; c < numParticles; c++) {
		body = new Particle(3);
		body.x = getRandom(0, width - body.size / 2);
		body.y = getRandom(0, height - body.size / 2);
		body.mass = 10;
		particles.push(body);
	}
	return setInterval(draw, 33);
}

function draw() {
	cxt.fillStyle = "#000";
	cxt.fillRect(0, 0, width, height);
	cxt.fillStyle = "#CCC";

	for ( var c = 0; c < particles.length; c++) {
		cxt.beginPath();
		cxt.arc(particles[c].x, particles[c].y, particles[c].size, 0,
				2 * Math.PI, false);
		for ( var p = 0; p < particles.length; p++) {
			if (p != c)
				gravitate(particles[c], particles[p]);
		}
		cxt.closePath();
		cxt.fill();
	}
}