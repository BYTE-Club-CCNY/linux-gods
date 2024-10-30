# js-server1
This is a simpler server that runs on port: `5000` of localhost

## Run
- **Bash command**: `curl http://localhost:5000`
- **Result**:
```bash
  _   _      _ _         __        __         _     _ _ 
 | | | | ___| | | ___    \ \      / /__  _ __| | __| | |
 | |_| |/ _ \ | |/ _ \    \ \ /\ / / _ \| '__| |/ _` | |
 |  _  |  __/ | | (_) |    \ V  V / (_) | |  | | (_| |_|
 |_| |_|\___|_|_|\___( )    \_/\_/ \___/|_|  |_|\__,_(_)
                     |/
```

### GET `/get/`
- **Running**: `curl http://localhost:5000/get/`
- **Result**:
```javascript
{
  "player_name": "Divin",
  "games": [
    "Elden Ring",
    "Red Dead II",
    "God Of War",
    "FC 24"
  ],
  "play_time": "+100 hrs",
  "review": "Suffering",
  "comment": "Could've been coding"
}
```

### POST `/post/`
- **Description**: This will wait for a json object of `{'num': numerical_varaible}` and return wheter it's even or not.

- **Usage**: `curl curl -X POST http://localhost:5000/post/ -H "Content-Type: application/json" -d '{"number": numerical_varaible}'` Where *numerical_varaible* is the number to test. 

#### DEPENDECIES
- Figlet `bun add figlet`
- Express `bun add express`

This project was created using `bun init` in bun v1.1.33. [Bun](https://bun.sh) is a fast all-in-one JavaScript runtime.
