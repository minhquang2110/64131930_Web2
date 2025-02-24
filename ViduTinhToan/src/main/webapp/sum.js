var a = document.querySelector(".annouce");
function getCookie(name) {
  let cookieArr = document.cookie.split(";");
  for (let i = 0; i < cookieArr.length; i++) {
    let cookie = cookieArr[i].trim();
    if (cookie.indexOf(name + "=") === 0) {
      let cookieValue = cookie.substring(name.length + 1);
      return cookieValue.replace(/_/g, " ");
    }
  }
  return null;
}
a.innerText = getCookie("annouce");
