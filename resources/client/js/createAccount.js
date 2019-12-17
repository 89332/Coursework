function createAccount(){
    let myHTML = '<div style="text-align:center;">'
        + '<div id="container">'
            +   '<form>'
                +'<h1>Create account </h1>'
                +'<label htmlFor="fname"><b>Firstname</b></label>'
            +'<input type="text" id="uname" placeholder="Enter your firstname" name="fname" required/><br>'
                +'<label htmlFor="lname"><b>Surname</b></label>'
            +'<input type="text" id="psw" placeholder="Enter your surname" name="lname" required/><br>'
                +'<label htmlFor="email"><b>Email-Address</b></label>'
            +'<input type="text" id="psw" placeholder="Enter your e-mail address" name="email" required/><br>'
                +'<label htmlFor="cemail"><b>Confirm Email-Address</b></label>'
            +'<input type="text" id="psw" placeholder="Confirm your e-mail address" name="cemail" required/><br>'
                +'<label htmlFor="uname"><b>Username</b></label>'
            +'<input type="text" id="uname" placeholder="Enter your username" name="uname" required/><br>'
                +'<label htmlFor="psw"><b>Password</b></label>'
            +'<input type="password" id="psw" placeholder="Enter your password" name="psw" required/><br>'
                +'<label htmlFor="cpsw"><b>Confirm Password</b></label>'
            +'<input type="password" id="cpsw" placeholder="Confirm your password" name="cpsw" required/><br>'
                        +'<div id="lower">'
                            +'<input type="submit" value="Create account" id="createAccount"/>'
                            +'<button type="button" onclick="document.getElementById(\'container\').style.display=\'none\'" class="cancelbtn">Cancel</button>'
                        +'</div>'
             +'</form>'
        +'</div>';
    document.getElementById("testDiv").innerHTML = myHTML;
    document.getElementById("createAccount").addEventListener("click", create);

}
function create(){
    window.location.href = "/client/index.html";
}