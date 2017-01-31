var canvas;
var ctx;
var img;
var mousePosition = [];
var fieldCoords = [];

function Init()
{
	canvas = document.getElementById("board");
	ctx = canvas.getContext("2d");
	DrawBoard();
	img = document.getElementById("black-stone");
	
	canvas.addEventListener('mousedown', function(evt)
	{
		mousePosition = GetMousePosition(canvas, evt);
    }, false);
	canvas.addEventListener('mousemove', function(evt)
	{
		mousePosition = GetMousePosition(canvas, evt);
    }, false);
}

function DrawBoard()
{
	for (var i = 0; i < 19; i++)
	{
		fieldCoords[i] = i*28 + 13;
		ctx.moveTo(i*28 + 13, 13);
		ctx.lineTo(i*28 + 13, 518);
		ctx.moveTo(13, i*28 + 13);
		ctx.lineTo(518, i*28 + 13);
	}
	ctx.stroke();

	for (var i = 0; i < 3; i++)
	{
		for (var j = 0; j < 3; j++)
		{
			ctx.moveTo(i*6*28 + 100, j*6*28 + 97);
			ctx.arc(i*6*28 + 97, j*6*28 + 97, 3, 0, 2*Math.PI);
		}
	}
	ctx.fill();
}

function ShowMovePreview()
{
	var nearestFieldCoords = GetNearestFieldCoords();
	ctx.drawImage(img, nearestFieldCoords[0] - 13, nearestFieldCoords[1] - 13, 26, 26);
}

function PlaceStone()
{
	console.log(img);
	var nearestFieldCoords = GetNearestFieldCoords();
	ctx.drawImage(img, nearestFieldCoords[0] - 13, nearestFieldCoords[1] - 13, 26, 26);
	if (img.id != "black-stone")
		img = document.getElementById("black-stone");
	else
		img = document.getElementById("white-stone");
}

function GetMousePosition(canvas, evt)
{
	var rect = canvas.getBoundingClientRect();
	var pos = [];
	pos[0] = evt.clientX - rect.left;
	pos[1] = evt.clientY - rect.top;
	return pos;
}

function GetNearestFieldCoords()
{
	var pos = [];
	for(var i = 0; i < 19; i++)
	{
		if (fieldCoords[i] >= mousePosition[0] - 14 && fieldCoords[i] <= mousePosition[0] + 14)
			pos[0] = fieldCoords[i];
		if (fieldCoords[i] >= mousePosition[1] - 14 && fieldCoords[i] <= mousePosition[1] + 14)
			pos[1] = fieldCoords[i];
	}
	return pos;
}