//resetting the sessionScore everytime the page is started
sessionStorage.setItem("sessionScore", 0);

document.getElementById("localStorageCount").innerHTML = localStorage.getItem("local");

function incrementLSCount() {
    console.log(localStorage.getItem("local"))
    localStorage.setItem("local", Number(localStorage.getItem("local")) + 1);
    document.getElementById("localStorageCount").innerHTML = localStorage.getItem("local");
}


document.getElementById("sessionStorageCount").innerHTML = sessionStorage.getItem("session");

function incrementSSCount() {
    sessionStorage.setItem("session", Number(sessionStorage.getItem("session")) + 1);
    document.getElementById("sessionStorageCount").innerHTML = sessionStorage.getItem("session");

}