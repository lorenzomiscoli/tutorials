const express = require('express')
const app = express()
const port = 3000

app.use(express.static(__dirname + '/dist'))

app.get('/message', (req, res) => {
    res.send({ message: "Hello World" })
})

app.listen(port, () => {
    console.log(`Webpack tutorial app listening at http://localhost:${port}`)
})