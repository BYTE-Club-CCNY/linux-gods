const express = require("express");
const app = express();
const PORT = 5000;

app.use(express.json());

app.get("/", (req, res) => {
  res.send("hello world");
});

app.get("/get/", (req, res) => {
  let teamInfo = {
    organization: "byte",
    team: "team 4",
    lead: "Fahad",
    members: ["Ayesha", "Divin", "Feras"],
    projectDescription:
      "self-host byte website backend on Fedora Linux machine",
  };
  res.json(teamInfo);
});

app.post("/post/", (req, res) => {
  let number = req.body.number;
  if (typeof number == "undefined") {
    const errorMsg = {
      error: "'number' parameter not found",
    };
    res.status(400).json(errorMsg);
  } else if (!(typeof number == "number")) {
    const errorMsg = {
      error: "incorrect type for 'number' parameter",
    };
    res.status(400).json(errorMsg);
  } else if (number < 0) {
    const errorMsg = {
      error: "cannot square root a negative number",
    };
    res.status(400).json(errorMsg);
  } else {
    let resNumber = {
      sqrt: Math.sqrt(number),
    };
    res.json(resNumber);
  }
});

app.listen(PORT);
