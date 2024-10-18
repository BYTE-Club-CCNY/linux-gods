# What is this?
- This is a .NET (ASP.NET) console application that runs a very basic, simple server
- The server has one endpoint, /weatherforecase
- It has it's own self-signed certificate (so ignore any warning associated with that)
- Runs on port 5001 (HTTPS) and 5000 (HTTP)

# How to run application?
- In order to run this application, you have to install and run the `dotnet` cli
- The application is written in the `dotnet` framework cause I can't download Java on my work computer lol
- The application was built for the linux framework - so it should have no trouble running on any linux machine
	- I've tested it in WSL/Github Bash
- Supply the `dotnet` command with the path to the `.dll` file and it will run
- Install the .NET runtime with `sudo dnf install aspnetcore-runtime-3.0`
	- I'm stuck on 3.0 at work so you gotta install the legacy runtime :(
## Additional Resouces
- [Installing .NET runtime](https://learn.microsoft.com/en-us/dotnet/core/install/linux-fedora)
- [Using dotnet CLI](https://learn.microsoft.com/en-us/dotnet/core/tools/dotnet-build)
