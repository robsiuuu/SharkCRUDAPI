<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${shark.name} Details</title>
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
                <li><a href="/sharks/createForm"><i class="material-icons left">add</i>New Shark</a></li>
            </ul>
        </div>
    </nav>
</header>

<main class="container">
    <div class="nav-arrows">
        <#if prevSharkId??>
        <a href="/sharks/${prevSharkId}" class="btn-large waves-effect waves-light blue darken-3">
            <i class="material-icons left">chevron_left</i>Previous
        </a>
        <#else>
        <a class="btn-large disabled"><i class="material-icons left">chevron_left</i>Previous</a>
    </#if>

    <#if nextSharkId??>
    <a href="/sharks/${nextSharkId}" class="btn-large waves-effect waves-light blue darken-3">
        Next<i class="material-icons right">chevron_right</i>
    </a>
    <#else>
    <a class="btn-large disabled">Next<i class="material-icons right">chevron_right</i></a>
</#if>
</div>

<div class="row details-header">
    <div class="col s12">
        <h2 class="header center-align text-darken-3">${shark.name}</h2>
        <div class="divider"></div>
    </div>
</div>

<div class="row">
    <div class="col s12 m6">
        <div class="card">
            <div class="card-image">
                <img src="" alt="${shark.name}">
                <span class="card-title">${shark.species}</span>
            </div>
        </div>
    </div>

    <div class="col s12 m6">
        <div class="card">
            <div class="card-content">
                <table class="striped">
                    <tbody>
                    <tr>
                        <th>ID</th>
                        <td>${shark.sharkId?c}</td>
                    </tr>
                    <tr>
                        <th>Species</th>
                        <td>${shark.species}</td>
                    </tr>
                    <tr>
                        <th>Description</th>
                        <td>${shark.description!"No description available"}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="card-action right-align">
                <a href="/sharks/update/${shark.sharkId?c}" class="btn blue darken-3 waves-effect waves-light">
                    <i class="material-icons left">edit</i>Edit
                </a>
                <form action="/sharks/delete/${shark.sharkId?c}" method="get" style="display: inline;">
                    <input type="hidden" name="_method" value="DELETE">
                    <button type="submit" class="btn red waves-effect waves-light">
                        <i class="material-icons left">delete</i>Delete
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
</main>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</body>
</html>