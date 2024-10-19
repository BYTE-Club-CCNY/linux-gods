# What is this?
- This is a .NET (ASP.NET) console application that runs a very basic, simple server
- The server has one endpoint, /weatherforecast
- It has it's own self-signed certificate (so ignore any warning associated with that)
- Runs on port 5001 (HTTPS) and 5000 (HTTP)

# How to run the server application?
- In order to run this application, you have to install and run the `dotnet` cli
- The application is written in the `dotnet` framework cause I can't download Java on my work computer lol
- The application was built for the linux framework - so it should have no trouble running on any linux machine
	- I've tested it in WSL/Github Bash
- Supply the `dotnet` command with the path to the `.dll` file and it will run
- Install the .NET runtime with `sudo dnf install aspnetcore-runtime-3.0`
	- I'm stuck on 3.0 at work so you gotta install the legacy runtime :(

# How To "Dockerize" this app?
- [ ] Install Docker (duh) on the linux server
- [ ] Clone this repo and enter it's directory
- [ ] Write a dockerfile 
	- [ ] this dockerfile should contain steps to either compile or run the dll binary
		- *i've given you the doc to use the dotnet cli below*
		- *for production uses it makes sense to RECOMPILE rather than run off the old binary, no?*
- [ ] build said dockerfile to produce an image
- [ ] run said docker image

# And then?
- start testing!
- [ ] use curl, postman, or your web browser to check the localhost and port to verify that the endpoint i mentioned works and exists

## Additional Resouces
- [Installing .NET runtime](https://learn.microsoft.com/en-us/dotnet/core/install/linux-fedora)
- [Using dotnet CLI](https://learn.microsoft.com/en-us/dotnet/core/tools/dotnet-build)
- [DockerDocs](https://docs.docker.com/get-started/workshop/02_our_app/)
