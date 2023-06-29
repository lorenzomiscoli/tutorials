document.getElementById("toggle-btn").addEventListener("click", () => {
	var http = new XMLHttpRequest();
	var url = 'piezo/status';
	http.open('POST', url, true);
	http.onreadystatechange = function() {
		if (http.readyState == 4 && http.status == 200) {
			console.log(http.responseText);
		}
	}
	http.send();
});