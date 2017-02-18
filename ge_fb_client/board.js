var canvas;
var ctx;
var img = [];
var boardState = []; // empty: 0, black: 1, white: -1
var mousePosition = [];
var fieldCoords = [];
var nearestFieldCoords;
var currentPlayer = 1;

function Init()
{
	canvas = document.getElementById("board");
	ctx = canvas.getContext("2d");
	img[0] = document.getElementById("white-stone");
	img[1] = document.getElementById("board-image");
	img[2] = document.getElementById("black-stone");
	SetInitialBoardState();
	
	DrawBoard();
	
	canvas.addEventListener('mousedown', function(evt)
	{
		if (IsMoveLegal())
		{
			PlaceStone();
		}
    }, false);
	canvas.addEventListener('mousemove', function(evt)
	{
		mousePosition = GetMousePosition(canvas, evt);
    }, false);
	
}

function SetInitialBoardState()
{
	for (var i = 0; i < 19; i++)
	{
		boardState[i] = [];
		for (var j = 0; j < 19; j++)
		{
			boardState[i][j] = 0;
		}
		fieldCoords[i] = i*28 + 13;
	}
}

function DrawBoard()
{
	ctx.drawImage(img[1], 0, 0);
	
	for (var i = 0; i < 19; i++)
	{
		for (var j = 0; j < 19; j++)
		{
			if (boardState[i][j] != 0)
				ctx.drawImage(img[boardState[i][j] + 1], fieldCoords[i] - 13, fieldCoords[j] - 13, 26, 26);
		}
	}
}

function ShowMovePreview()
{
	var newNearestFieldCoords = GetNearestFieldCoords();
	if (newNearestFieldCoords != nearestFieldCoords)
	{
		nearestFieldCoords = newNearestFieldCoords;
		DrawBoard();
		if (IsMoveLegal())
		{
			ctx.globalAlpha = 0.7;
			ctx.drawImage(img[currentPlayer+1], fieldCoords[nearestFieldCoords[0]] - 13, fieldCoords[nearestFieldCoords[1]] - 13, 26, 26);
			ctx.globalAlpha = 1;
		}
	}
}

function IsMoveLegal()
{
	if (boardState[nearestFieldCoords[0]][nearestFieldCoords[1]] != 0)
		return false;
	return true;
}

function PlaceStone()
{
	boardState[nearestFieldCoords[0]][nearestFieldCoords[1]] = currentPlayer;
	ctx.drawImage(img[currentPlayer+1], fieldCoords[nearestFieldCoords[0]] - 13, fieldCoords[nearestFieldCoords[1]] - 13, 26, 26);
	currentPlayer *= -1;
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
			pos[0] = i;
		if (fieldCoords[i] >= mousePosition[1] - 14 && fieldCoords[i] <= mousePosition[1] + 14)
			pos[1] = i;
	}
	return pos;
}