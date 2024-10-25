#See https://aka.ms/containerfastmode to understand how Visual Studio uses this Dockerfile to build your images for faster debugging.

FROM mcr.microsoft.com/dotnet/aspnet:8.0 AS base
WORKDIR /app
EXPOSE 5000

FROM mcr.microsoft.com/dotnet/sdk:8.0 AS build
WORKDIR /src
COPY ["BYTE-team3-example-server/BYTE-team3-example-server.csproj", "BYTE-team3-example-server/"]
RUN dotnet restore "BYTE-team3-example-server/BYTE-team3-example-server.csproj"
COPY . .
WORKDIR "/src/BYTE-team3-example-server"
RUN dotnet build "BYTE-team3-example-server.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "BYTE-team3-example-server.csproj" -c Release -o /app/publish

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "BYTE-team3-example-server.dll"]
