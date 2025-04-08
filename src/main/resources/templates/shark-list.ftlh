<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="/static/CSS/style.css">

</head>
<body>

<h1>${title!"Sharks!"}</h1>

<div class="tab">
    <a href="">Home</a>
    <a href="">About Us</a>
</div>

<div class="clickable-container">
    <#list sharks as shark>
        <div class="shark-card">
            <h3>${shark.name}</h3>
            <p class="species">${shark.species!"Unknown species"}</p>
            <p>${shark.description!"No description available"}</p>
            <div class="actions">
                <a href="/sharks/${shark.sharkId}" class="btn btn-view">View Details</a>
                <form action="/sharks/${shark.sharkId}" method="post" style="display: inline;">
                    <input type="hidden" name="_method" value="DELETE">
                    <button type="submit" class="btn btn-delete">Delete</button>
                </form>
            </div>
        </div>
    <#else>
    <p>No sharks found in the database.</p>
    </#list>
</div>

</body>
</html>
