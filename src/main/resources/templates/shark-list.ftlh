<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sharks!</title>
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

<main class="container">
    <div class="row shark-header">
        <div class="col s12">
            <h2 class="header center-align text-darken-3">${title!"All Sharks"}</h2>
        </div>
    </div>

    <div class="row search-box">
        <form action="/sharks/search/name" class="col s12">
            <div class="row">
                <div class="input-field col s10 m11">
                    <i class="material-icons prefix">search</i>
                    <input id="search" type="text" name="search" class="validate">
                    <label for="search">Search by name</label>
                </div>
                <div class="input-field col s2 m1">
                    <button class="btn waves-effect waves-light blue darken-3" type="submit">
                        <i class="material-icons">send</i>
                    </button>
                </div>
            </div>
        </form>
    </div>

    <div class="row">
        <div class="col s12">
            <table class="striped highlight responsive-table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Species</th>
                    <th class="right-align">More Info</th>
                </tr>
                </thead>
                <tbody>
                <#list sharkList as shark>
                <tr>
                    <td>${shark.sharkId?c}</td>
                    <td>${shark.name}</td>
                    <td>
                        <div class="chip species-chip blue darken-3 white-text">
                            ${shark.species}
                        </div>
                    </td>
                    <td class="right-align">
                        <a href="/sharks/${shark.sharkId?c}" class="btn-small blue darken-3">
                            <i class="material-icons">visibility</i>
                        </a>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</main>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</body>
</html>