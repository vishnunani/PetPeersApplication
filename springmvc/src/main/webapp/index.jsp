<html>
<title>HOME</title>
<!-- <link rel="stylesheet" href="/webapp/resources/css/index.css"> -->
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}
</style>
<body>
	<h2 style="text-align: center">WELCOME TO PET PEERS</h2>
	<br>
	<nav>
		<ul>
			<li><a href="Login">LOGIN</a></li>
			<li><a href="RegisterPage">REGISTER</a></li>
		</ul>
	</nav>
	<p style="color: green; text-align: center;">${message}</p>
</body>
</html>
