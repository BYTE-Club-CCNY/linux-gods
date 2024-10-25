# Set Up an API Server!
- the basics of an API server are as follows:
	- the application listens on a port
	- takes in a range of requests, such as `post`, `get`, `delete`, `update` (we will work with `post` and `get` for now)

# TODO
- [ ] create a branch on this repository with your name
- [ ] research the difference between NodeJS and Bun run times
	- [ ] both are installed on our system, you must chose one to work with
- [ ] using your preferred javascript runtime, set up a project (hint: read quickstart guides)
- [ ] download express
- [ ] create a server to server two endpoints:
	- [ ] `/` -> returns "hello world"
	- [ ] `/get/` returns some json file 
		- [ ] this is a get request
	- [ ] `/post/` returns the a modified version of an integer the user passes as a param
		- [ ] the body parameters should be `number`, which is of `number` type
		- [ ] return the number modified - [`+`, `-`, `*`, `/`, `//`, `%`] - whatever you want
- [ ] run the server on port 5000
- [ ] test the api via `curl` or your browser or `postman`

# Goal
- understand how a javascript server works
- understand how a server works
- what is a post request
- what is a get request
- how to call an api