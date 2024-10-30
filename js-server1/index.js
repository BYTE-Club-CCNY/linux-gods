import express from "express";

const app = express();
const port = 5000;

app.use(express.json());

app.get("/", (req, res) => {
	res.send("Hello, World!");
});

app.get("/get/", (req, res) => {
	let text = {
		player_name: "Divin",
		games: ["Elden Ring","Red Dead II","God Of War","FC 24"],
		play_time: "+100 hrs",
		review: "Suffering",
		comment: "Could've been coding"
	};
	res.json(text);
});

app.post("/post/", (req, res) => {
	let num = req.body.num;
	if (typeof num === "undefined") {
		res.status(400).json({error: "'num' parameter is undefined"});
	} else if (typeof num !== "number"){
		res.status(400).json({error: "'num' must be a number"});
	} else {
		const isEven = num % 2 === 0;
		res.json({number: num, isEven: isEven});
	};
});

app.listen(port, () => {
	console.log(`Server running at http://localhost:${port}`);
});
