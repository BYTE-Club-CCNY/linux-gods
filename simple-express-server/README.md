# Ayesha's Simple Express Server

## Server Specs
**Base url** (for local testing): ``http://localhost:5000``

``GET /``
- Returns the text "hello world"

``GET /get/``
- Returns a json object representing a team
```json
{
    "organization": "byte",
    "team": "team 4",
    "lead": "Fahad",
    "members": [
        "Ayesha",
        "Divin",
        "Feras"
    ],
    "projectDescription": "self-host byte website backend on Fedora Linux machine"
}
```

``POST /post/``
- Request contains a json object with a ``number`` parameter of type ``number``
```json
{
  "number": 4
}
```
- Response is a json object containing the positive square root of the posted number
```json
{
  "sqrt": 2
}
```
