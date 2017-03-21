<?php
include 'parser_functions.php';


$text = file_get_contents('sgf.txt');
//echo $text;
$text = preg_replace('/\s+/', '', $text);
$text = substr($text, 2); 
$text=substr($text,0,strlen($text)-2);
$text=explode(")(",$text);
var_dump($text);

$state=0;
while($state != 2)
{
switch ($state) {

	case 0:
            $state = obradiUlaz0($text);
	    break;
	case 1:
	    $state = obradiUlaz1($text);
            break;
}
}

?>