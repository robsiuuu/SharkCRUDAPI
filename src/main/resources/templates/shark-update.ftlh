<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Shark</title>
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
                <li><a href="/sharks/createForm"><i class="material-icons left">add</i>New Shark</a></li>
            </ul>
        </div>
    </nav>
</header>

<main>
<div class="container" style="margin-top: 15px;">
    <h1>${title}</h1>
    <form id="new-shark" action="/sharks/update/${shark.sharkId?c}" method="post">
        <input type="text" id="sharkId" name="sharkId" value="${shark.sharkId?c}" readonly/>
        <input type="text" id="name" name="name" value="${shark.name}" placeholder="Name"/>
        <input type="text" id="description" name="description"  value="${shark.description}" placeholder="Description"/>
        <input type="text" id="species" name="species" value="${shark.species}" placeholder="Species"/>
        <button type="submit" class="btn blue darken-3 waves-effect waves-light">Save</button>
        <a href="/sharks/${shark.sharkId?c}" class="btn blue darken-3 waves-effect waves-light">Cancel</a>
    </form>
</div>
</main>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</body>
</html>