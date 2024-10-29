import express from "express";

const app = express();
const port = 5000;

app.get("/", (req, res) => {
	res.send("Hello from Express on Bun!");
});

app.listen(port, () => {
	console.log(`Server running at http://localhost:${port}`);
});
