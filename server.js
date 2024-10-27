const express = require('express');
const app = express();
const port = 5000;

app.get('/', (req, res) => {
	res.send('Hello world!');
});

app.get('/get/', (req, res) => {
	res.json({ message: 'This is in fact working!' });
});

app.post('/post/', (req, res) => {
	const { number } = req.body;

const modifiedNum = number * 2;

res.json({ modifiedNum });
});

app.listen(port, () => {
	console.log('my-server is running on port ${port}');
});
