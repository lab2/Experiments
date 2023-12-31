var size1 = 44, size2 = 52, size3 = 38;
var x = 0, dx = 5, r = 0, g = 0, b = 0, c = 1, angle = 40;

window.onload = function() {
	canvas = document.getElementById("effects");
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
	text1 = "C64 demo effects are cool";
	text2 = "Lab2"
	text3 = "Simple spaghetti code"
}

function loop() {
	ctx.fillStyle = "rgb(0,0,0)";
	ctx.fillRect(0, 0, canvas.width, canvas.height);
	ctx.fillStyle = "#CCC";

	// Text2
	ctx.font = "normal " + size2 + "px Munro";
	colors = "rgb(" + getRandom(1, 254) + "," + getRandom(1, 254) + ","
			+ getRandom(1, 254) + ")";
	ctx.fillStyle = colors;
	txtw = Math.floor(canvas.width / 2 - ctx.measureText(text2).width / 2)
	ctx.fillText(text2, txtw, Math.floor(canvas.height / 4));

	// Text1
	ctx.font = "normal " + size1 + "px Munro";
	color = "rgb(" + r + "," + g + "," + b + ")";
	ctx.fillStyle = color;
	txtw = Math.floor(canvas.width - ctx.measureText(text1).width);
	ctx.fillText(text1, x, Math.floor(canvas.height / 2));
	if (x > txtw || x < 0)
		dx = -dx;
	x += dx;
	if (r > 253 || g > 253 || b > 253) {
		r = 254;
		g = 254;
		b = 254;
		c = -c;
	}
	if (r < 1 || g < 1 || b < 1) {
		r = 0;
		g = 0;
		b = 0;
		c = -c;
	}
	r += c;
	b += c;
	g += c;

	// Text3
	ctx.font = "normal " + size3 + "px Munro";
	ctx.fillStyle = "#CCC";
	txtw = Math.floor(canvas.width / 2 - ctx.measureText(text3).width / 2)
	ctx.fillText(text3, txtw, Math.floor(canvas.height / 2)
			+ Math.sin(angle * Math.PI / 180) * 100);
	if (angle > 359)
		angle = 0;
	else
		angle++;
}