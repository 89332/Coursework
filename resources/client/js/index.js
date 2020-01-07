function pageLoad() {

    let now = new Date();

    let myHTML = '<div style="text-align:center;">'

        + '<div id="container">'
        + '<form>'
        + '<h1 font-size: 28px>Sign in</h1>'
        + '<label htmlFor="username"><b>Username</b></label>'
        + '<input type="text" id="username" placeholder="Enter Username" name= @FormDataParams("username") required/>'

        + '<label htmlFor="psw"><b>Password</b></label>'
        + '<input type="password" id="psw" placeholder="Enter Password" name= @FormDataParams("password") required/>'
        + '<div id="lower">'
        + '<input type="submit" value="Login" id="loginButton"/>'
        + '<p value ="createAccount">'
        + 'Need to create an account?<a href="/client/createAccount.html"/> Sign up here.<br></p>'
        + '</div>'
        + '</form>'
        + '</div>'
        + '<input type="button" value="homepage" id="homepage" <a/>';


    document.getElementById("testDiv").innerHTML = myHTML;
    document.getElementById("createAccount").addEventListener("click", createAccount);
    document.getElementById("loginButton").addEventListener("click", login);
    document.getElementById("button").addEventListener("click", homepage);

    if(window.location.search === '?logout') {
        document.getElementById('content').innerHTML = '<h1>Logging out, please wait...</h1>';
        logout();
    } else {
        document.getElementById("loginButton").addEventListener("click", login);
    }


    function homepage() {
    window.location.href = '/client/homepage.html';
        alert("hello")

}
    function createAccount(){
        window.location.href ='/client/createAccount.html';
    }



    function login(event) {

        event.preventDefault();

        const form = document.getElementById("loginForm");
        const formData = new FormData(form);

        fetch("/user/login", {method: 'post', body: formData}
        ).then(response => response.json()
        ).then(responseData => {

            if (responseData.hasOwnProperty('error')) {
                alert(responseData.error);
            } else {
                Cookies.set("username", responseData.username);
                Cookies.set("token", responseData.token);

                window.location.href = '/client/homepage.html';
            }
        });
    }
    function checkLogin() {

        let username = Cookies.get("username");

        let logInHTML = '';

        if (username === undefined) {

            let editButtons = document.getElementsByClassName("editButton");
            for (let button of editButtons) {
                button.style.visibility = "hidden";
            }

            let deleteButtons = document.getElementsByClassName("deleteButton");
            for (let button of deleteButtons) {
                button.style.visibility = "hidden";
            }

            logInHTML = "Not logged in. <a href='/client/index.html'>Log in</a>";
        } else {

            let editButtons = document.getElementsByClassName("editButton");
            for (let button of editButtons) {
                button.style.visibility = "visible";
            }

            let deleteButtons = document.getElementsByClassName("deleteButton");
            for (let button of deleteButtons) {
                button.style.visibility = "visible";
            }

            logInHTML = "Logged in as " + username + ". <a href='/client/login.html?logout'>Log out</a>";

        }

        document.getElementById("loggedInDetails").innerHTML = logInHTML;

    }









}



