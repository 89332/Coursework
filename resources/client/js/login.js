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
        + '<input type="submit" value="homepage " id="homepage" <a href="/client/index.html"/>';
    document.getElementById("testDiv").innerHTML = myHTML;
    }


    if(window.location.search === '?logout') {
        document.getElementById('content').innerHTML = '<h1>Logging out, please wait...</h1>';
        logout();
    } else {
        document.getElementById("loginButton").addEventListener("click", login);


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

            window.location.href = '/client/index.html';
        }
    });
}
function logout() {

    fetch("/user/logout", {method: 'post'}
    ).then(response => response.json()
    ).then(responseData => {
        if (responseData.hasOwnProperty('error')) {

            alert(responseData.error);

        } else {

            Cookies.remove("username");
            Cookies.remove("token");

            window.location.href = '/client/index.html';

        }
    });

}
