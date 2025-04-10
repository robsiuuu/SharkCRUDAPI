<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Shark</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/static/CSS/style.css">
</head>
<body>

<header>
    <nav class="blue darken-3">
        <div class="nav-wrapper container">
            <a href="/sharks/all" class="brand-logo">🦈 Sharks!</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="/sharks/all"><i class="material-icons left">list</i>All Sharks</a></li>
            </ul>
        </div>
    </nav>
</header>

<main>
<div class="container" style="margin-top: 15px;">
    <h1>${title}</h1>
    <form id="new-shark" action="/sharks/new" method="post">
        <input type="text" id="name" name="name" placeholder="Name"/>
        <input type="text" id="description" name="description" placeholder="Description"/>
        <input type="text" id="species" name="species" placeholder="Species"/>
        <button type="submit" class="btn blue darken-3 waves-effect waves-light">Save</button>
        <a href="/sharks/all" class="btn blue darken-3 waves-effect waves-light" >Cancel</a>
    </form>
</div>
</main>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</body>
</html>