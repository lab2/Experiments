var stars = new Array(512), dirx, diry, direction;

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
	document.onkeydown = function(e) {
		e = e || window.event;
		switch (e.keyCode) {
		case 38: // up
			dirx = 0;
			diry = -1;
			direction = "up";
			break;
		case 40: // down
			dirx = 0;
			diry = 1;
			direction = "down";
			break;
		case 37: // left
			dirx = -1;
			diry = 0;
			direction = "left";
			break;
		case 39: // right
			dirx = 1;
			diry = 0;
			direction = "right";
			break;
		}
	}

	for ( var i = 0; i < stars.length; i++) {
		stars[i] = {
			x : getRandom(0, canvas.width),
			y : getRandom(0, canvas.height),
			z : getRandom(1, 3),
			size : 0
		}
	}
}

function loop() {
	var size = 0, v = 0, color;
	ctx.fillStyle = "rgb(0,0,0)";
	ctx.fillRect(0, 0, canvas.width, canvas.height);

	// start the initial movement
	if (dirx == undefined) {
		dirx = 1;
		diry = 0;
	}

	for ( var i = 0; i < stars.length; i++) {
		switch (stars[i].z) {
		case 1:
			size = 3;
			v = 3;
			color = "#F9F9F9";
			break;
		case 2:
			size = 2;
			v = 2;
			color = "#999";
			break;
		case 3:
			size = 1;
			v = 1;
			color = "#555";
			break;
		default:
			size = 1;
			break;
		}
		ctx.fillStyle = color;
		if (stars[i].x > canvas.width)
			stars[i].x = 0;
		if (stars[i].x < 0)
			stars[i].x = canvas.width;
		if (stars[i].y < 0)
			stars[i].y = canvas.height;
		if (stars[i].y > canvas.height)
			stars[i].y = 0;
		px = stars[i].x += dirx;
		py = stars[i].y += diry;
		ctx.fillRect(v * px, v * py, size, size);
		ctx.fillStyle = "#FFF";
	}
	ctx.font = 'normal 20px Munro';
	ctx.fillStyle = '#FFF';
	ctx.fillText("Direction:" + direction, 20, 20);
}