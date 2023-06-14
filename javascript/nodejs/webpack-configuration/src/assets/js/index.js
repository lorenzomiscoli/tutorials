import '../css/index.css'

$.get(`${window.location.origin}/message`, function (data) {
    $('.hello-title').text(data.message);
});