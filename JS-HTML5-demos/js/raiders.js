var stars = new Array(512);
var screen_x;
var screen_y;
var screen_diameter;

window.onload = function() {
	canvas = document.getElementById("stars");
	if (canvas && canvas.getContext) {
		ctx = canvas.getContext("2d");
		ctx.canvas.width = window.innerWidth;
		ctx.canvas.height = window.innerHeight;
		init();
		setInterval(loop, 33);
	}
}

function getRandom(min, max) {
	return Math.floor(Math.random() * (max - min + 1)) + min;
}

function init() {
	for ( var i = 0; i < stars.length; i++) {
		stars[i] = {
			x : getRandom(-canvas.width * 2, canvas.width * 2),
			y : getRandom(-canvas.height * 2, canvas.height * 2),
			z : getRandom(100, 1000),
			velocity : 3,
			size : getRandom(2, 10)
		}
	}
}

function loop() {
	ctx.fillStyle = "rgb(0,0,0)";
	ctx.fillRect(0, 0, canvas.width, canvas.height);
	for ( var i = 0; i < stars.length; i++) {
		col = Math.floor(255 - stars[i].z * 255 / 1000);
		ctx.fillStyle = "rgb(" + col + "," + col + "," + col + ")";
		screen_x = Math.floor(stars[i].x / stars[i].z * 100 + canvas.width / 2);
		screen_y = Math.floor(stars[i].y / stars[i].z * 100 + canvas.height / 2);
		screen_diameter = Math.floor(stars[i].size / stars[i].z * 100);
		if (screen_x < 0 || screen_x > canvas.width || screen_y < 0 || screen_y > canvas.height || stars[i].z < 1)
			stars[i].z = 1000;
		stars[i].z -= stars[i].velocity * 2;
		ctx.fillRect(screen_x, screen_y, screen_diameter, screen_diameter);
	}
}