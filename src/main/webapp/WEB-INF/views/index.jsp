

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Event Manager&reg;</title>


<link rel="stylesheet" type="text/css"
	href="./resources/css/pa.recon.css" media="screen" />
<link rel="stylesheet" type="text/css" href="./resources/css/slide.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="./resources/css/jquery.alerts.css" media="screen" />
<link rel="stylesheet" type="text/css" href="./resources/css/style.css"
	media="screen" />
<link href='http://fonts.googleapis.com/css?family=Dosis'
	rel='stylesheet' type='text/css' />

<script type="text/javascript" src="./resources/js/jquery.min.js"></script>
<script type="text/javascript" src="./resources/js/jquery.alerts.js"></script>
<script type="text/javascript" src="./resources/js/tinybox.js"></script>
<script src="./resources/js/slide.js" type="text/javascript"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>

<script>
	$(document).ready(function() {
		var $winwidth = $(window).width();
		var $winheight = $(window).height();
		$("img.source-image").attr({
			width : $winwidth
		});
		$("img.source-image").attr({
			height : $winheight
		});
		$(window).bind("resize", function() {
			var $winwidth = $(window).width();
			$("img.source-image").attr({
				width : $winwidth
			});
		});

		$("a").click(function(event) {
			//	event.preventDefault();
			$("#demo").hide();
		});

	});
</script>

<script type="text/javascript">
	function openJS() {
		alert('loaded')
	}
	function closeJS() {
		$("#demo").show();
	}
</script>
</head>

<body>

	<!-- Panel -->
	<div id="toppanel">
		<div id="demo">
			<nav>
			<ul>
				<li
					onclick="TINY.box.show({iframe:'/user',boxid:'frameless',width:565,height:450,fixed:false,maskid:'bluemask',maskopacity:40,closejs:function(){closeJS()}})">
					<a href="#" onClick=""> <span>User</span>
				</a>
				</li>
				<li
					onclick="TINY.box.show({iframe:'/group',boxid:'frameless',width:565,height:450,fixed:false,maskid:'bluemask',maskopacity:40,closejs:function(){closeJS()}})">
					<a href="#"> <span>Group</span>
				</a>
				</li>
				<li
					onclick="TINY.box.show({iframe:'/groupdetail',boxid:'frameless',width:565,height:450,fixed:false,maskid:'bluemask',maskopacity:40,closejs:function(){closeJS()}})">
					<a href="#"> <span>Grouping</span>
				</a>
				</li>
				<li><a href="#"> <span>WIP</span>
				</a></li>

			</ul>
			</nav>
		</div>

	</div>
	<!--panel -->

	<img src="./resources/images/main.jpg" class="source-image" border="0"
		alt="" />


</body>
</html>
