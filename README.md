# Set Up an API Server!
- the basics of an API server are as follows:
	- the application listens on a port
	- takes in a range of requests, such as `post`, `get`, `delete`, `update` (we will work with `post` and `get` for now)
	- these requests are mapped to certain endpoints, with `/` being the root basepoint
	- it's common to build these endpoints for pathing - creating endpoints like `/get/posts/132465/userid`
		- but i don't like that - I believe stuff like that can abstracted to query parameters and body parameters
	- speaking of body parameters, `post` requests take bodies
		- `post` requests are traditionally made to do CRUD actions - stuff that can alter the state of our application
		- `get` requests are traditionally made to do READ actions - nothing that can alter the state of an application
		- `post` requests' body parameters take in sensitive information - such as api keys, userids, etc.
		- `get` request query parameters are encoded on the url itsself - making it less secure
	- the best way to think about it is in the form of two computers sharing JSON files with each other
	- once the server authenticates the user (if necessary) - they perform the action the user requested
- i've attached links on more readings by smarter people below
- the server you'll be making is a simple javascript server - which won't be used in production
- you'll eventually dockerize this application and have it running in isolation
- track all of your changes with git - it's not professional to commit all of your project in one go
	- it's like a word document - you don't hit save once you finish writing everything 
	- you gotta commit your changes incrementally so you (the coder) can see what you did in the past and me (the reviewer) knows what you did without having to look through each individual line of code 
	- make sure to keep clear and concise commit messages
- whatever you do, DO NOT COMMIT NODE MODULES - look into `.gitignore` (resource attached)
- don't worry about running this on the linux server, after what you guys have done - it should be trivial
	- from now on, doing this on the server should be done in reservation - as all testing and development should be done locally 
	- because the server application is a shared computer - it's best practice to verify the integrity of your application seperately
	- if it comes to it - dockerize your application and test it on your machine to see if it works well on linux
	- but from now on you should only deploy your applications to the server once you're sure that it runs
	- no use wasting time and resources on the remote machine when you can test locally

# TODO
- [ ] create a branch on this repository with your name
- [ ] research the difference between NodeJS and Bun run times
	- [ ] both are installed on our system, you must chose one to work with
- [ ] using your preferred javascript runtime, set up a project (hint: read quickstart guides)
- [ ] download express
- [ ] create a server to server two endpoints:
	- [ ] `/` -> returns "hello world"
	- [ ] `/get/` returns some data - you can makeup whatever kinda data's on it
		- [ ] this is a get request
	- [ ] `/post/` returns the a modified version of an integer the user passes as a param
		- [ ] the body parameters should be `number`, which is of `number` type
		- [ ] return the number modified - [`+`, `-`, `*`, `/`, `//`, `%`] - whatever you want
		- [ ] this is a post request
- [ ] run the server on port 5000
- [ ] test the api via `curl` or your browser or `postman`

# Goal
- understand how a javascript server works
- understand how a server works
- what is a post request
- what is a get request
- how to call an api

# Resources
- [Bun vs Node](https://www.builder.io/blog/bun-vs-node-js)
- [.gitignore](https://git-scm.com/docs/gitmodules)
- [Getting started with git](https://rogerdudler.github.io/git-guide/)
- [Installing Express](https://expressjs.com/en/starter/installing.html)
- [Express Example](https://expressjs.com/en/starter/hello-world.html)
- [Understanding HTTP Requests](https://nodejs.org/en/learn/modules/anatomy-of-an-http-transaction)
	- this uses the javascript native HTTP library - you will be using express which is a wrapper for this
- [Types of HTTP Requests](https://rapidapi.com/blog/api-glossary/http-request-methods/)
- [Postman (for testing the api)](https://www.postman.com/downloads/)
