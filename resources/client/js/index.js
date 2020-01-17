function pageLoad() {

    let now = new Date();

    let myHTML = '<div style="text-align:center;">'

        + '<div id="container">'
        + '<form>'
        + '</form>'
        + '</div>'
        + '<input type="button" value="homepage" id="homepage" <a/>';

    let songsHTML = '<table>' +
        '<tr>' +
        '<th>SongID</th>' +
        '<th>SongName</th>' +
        '<th>Artist</th>' +
        '<th>Genre</th>' +
        '<th>Length</th>' +
        '<th class="last">Options</th>' +
        '</tr>';

    fetch('/songs/list', {method: 'get'}
    ).then(response => response.json()
    ).then(songs => {
        for (let songs of songs) {

            songsHTML += `<tr>` +
                `<td>${songs.id}</td>` +
                `<td>${songs.name}</td>` +
                `<td>${songs.artist}</td>` +
                `<td>${songs.genre}</td>` +
                `<td>${songs.length}</td>` +
                `<td class="last">` +
                `<button class='playButton' data-id='${songs.id}'>Play Song</button>` +
                `<button class='addButton' data-id='${songs.id}'>Add to playlist</button>` +
                `</td>` +
                `</tr>`;
        }
            songsHTML += '</table>';

            document.getElementById("listDiv").innerHTML = songsHTML;

            let playButton = document.getElementsByClassName("playButton");
            for (let button of playButton) {
                button.addEventListener("click", playButton);
            }

            let addButton = document.getElementsByClassName("addButton");
            for (let button of addButton) {
                button.addEventListener("click", addButton);
            }
            checkLogin()

    });



        }




        function checkLogin() {

            let username = Cookies.get("username");

            let logInHTML = '';

            if (username === undefined) {

                let playButtons = document.getElementsByClassName("playButton  ");
                for (let button of playButtons) {
                    button.style.visibility = "hidden";
                }

                let addButtons = document.getElementsByClassName("addButton");
                for (let button of addButtons) {
                    button.style.visibility = "hidden";
                }

                logInHTML = "Not logged in. <a href='/client/login.html'>Log in</a>";
            } else {

                let playButtons = document.getElementsByClassName("playButton");
                for (let button of playButtons) {
                    button.style.visibility = "visible";
                }

                let addButtons = document.getElementsByClassName("addButton");
                for (let button of addButtons) {
                    button.style.visibility = "visible";
                }

                logInHTML = "Logged in as " + username + ". <a href='/client/login.html?logout'>Log out</a>";

            }

            document.getElementById("loggedInDetails").innerHTML = logInHTML;




}



