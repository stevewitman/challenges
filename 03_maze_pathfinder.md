# PATH FINDING / MAZE SOLVING

[[Back to Challenges]](https://github.com/stevewitman/challenges "Return to 'Challenges'")

### Find the path from start to finish.

```
Maze

    |                     1 1
    | 0 1 2 3 4 5 6 7 8 9 0 1
----|------------------------
  0 | X X X X X X X X X X X X
  1 | X      (S). . X   X   X
  2 | X   X X X X . .   X   X
  3 | X     X   X X . X X   X
  4 | X X   X       . . . . X
  5 | X     X   X X X X X . X
  6 | X X X X X X   X . . . X
  7 | X             X . X   X
  8 | X   X X   X X X . X X X
  9 | X   X X         . X(F)X
 10 | X     X   X X X . . . X
 11 | X X X X X X X X X X X X
```

start = 1,4 and finish = 9,10

path from start to finish ...

`[ [1,4], [1,5], [1,6], [2,6], [2,7], [3,7], [4,7], [4,8], [4,9], [4,10], [5,10],[6,10], [6,9], [6,8], [7,8], [8,8], [9,8], [10,8], [10,9], [10,10], [9,10] ]`



### Other variations to consider ...

```
Maze with 4-way intersections

      X X X X X X X X X X X X
      X      (S)    X   X   X
      X   X X X X       X   X
      X     X   X X   X X   X
      X X   X               X
      X     X   X X X X X   X
      X X X X   X   X       X
      X             X   X   X
      X   X X   X X X   X X X
      X   X X     X     X(F)X
      X     X   X X X       X
      X X X X X X X X X X X X
```

```
Maze with multiple routes

      X X X X X X X X X X X X
      X      (S)    X   X   X
      X   X X X X       X   X
      X     X   X X   X X   X
      X X   X               X
      X     X   X X X X X   X
      X X   X X X   X       X
      X             X   X   X
      X   X X   X X X   X X X
      X X X X           X(F)X
      X         X X X       X
      X X X X X X X X X X X X
```

```
Maze with no solution
      X X X X X X X X X X X X
      X      (S)    X   X   X
      X   X X X X       X   X
      X     X   X X   X X   X
      X X   X               X
      X     X   X X X X X   X
      X X X X X X   X       X
      X             X   X   X
      X   X X   X X X   X X X
      X   X X           X(F)X
      X     X   X X X   X   X
      X X X X X X X X X X X X
```

### Copy and paste mazes ...

```javascript
var start = a[1][4];
var finish = a[9][10];

var a = [
    [0,0,0,0,0,0,0,0,0,0,0,0],
    [0,1,1,1,1,1,1,0,1,0,1,0],
    [0,1,0,0,0,0,1,1,1,0,1,0],
    [0,1,1,0,1,0,0,1,0,0,1,0],
    [0,0,1,0,1,1,1,1,1,1,1,0],
    [0,1,1,0,1,0,0,0,0,0,1,0],
    [0,0,0,0,0,0,1,0,1,1,1,0],
    [0,1,1,1,1,1,1,0,1,0,1,0],
    [0,1,0,0,1,0,0,0,1,0,0,0],
    [0,1,0,0,1,1,1,1,1,0,1,0],
    [0,1,1,0,1,0,0,0,1,1,1,0],
    [0,0,0,0,0,0,0,0,0,0,0,0],
  ];

// Maze with 4-way intersection
var b = [
    [0,0,0,0,0,0,0,0,0,0,0,0],
    [0,1,1,1,1,1,1,0,1,0,1,0],
    [0,1,0,0,0,0,1,1,1,0,1,0],
    [0,1,1,0,1,0,0,1,0,0,1,0],
    [0,0,1,0,1,1,1,1,1,1,1,0],
    [0,1,1,0,1,0,0,0,0,0,1,0],
    [0,0,0,0,1,0,1,0,1,1,1,0],
    [0,1,1,1,1,1,1,0,1,0,1,0],
    [0,1,0,0,1,0,0,0,1,0,0,0],
    [0,1,0,0,1,1,0,1,1,0,1,0],
    [0,1,1,0,1,0,0,0,1,1,1,0],
    [0,0,0,0,0,0,0,0,0,0,0,0]
  ];

// Maze with multiple routes
var c = [
    [0,0,0,0,0,0,0,0,0,0,0,0],
    [0,1,1,1,1,1,1,0,1,0,1,0],
    [0,1,0,0,0,0,1,1,1,0,1,0],
    [0,1,1,0,1,0,0,1,0,0,1,0],
    [0,0,1,0,1,1,1,1,1,1,1,0],
    [0,1,1,0,1,0,0,0,0,0,1,0],
    [0,0,1,0,0,0,1,0,1,1,1,0],
    [0,1,1,1,1,1,1,0,1,0,1,0],
    [0,1,0,0,1,0,0,0,1,0,0,0],
    [0,0,0,0,1,1,1,1,1,0,1,0],
    [0,1,1,1,1,0,0,0,1,1,1,0],
    [0,0,0,0,0,0,0,0,0,0,0,0]
  ];

// Maze with no solution
var d = [
    [0,0,0,0,0,0,0,0,0,0,0,0],
    [0,1,1,1,1,1,1,0,1,0,1,0],
    [0,1,0,0,0,0,1,1,1,0,1,0],
    [0,1,1,0,1,0,0,1,0,0,1,0],
    [0,0,1,0,1,1,1,1,1,1,1,0],
    [0,1,1,0,1,0,0,0,0,0,1,0],
    [0,0,0,0,0,0,1,0,1,1,1,0],
    [0,1,1,1,1,1,1,0,1,0,1,0],
    [0,1,0,0,1,0,0,0,1,0,0,0],
    [0,1,0,0,1,1,1,1,1,0,1,0],
    [0,1,1,0,1,0,0,0,1,0,1,0],
    [0,0,0,0,0,0,0,0,0,0,0,0]
  ];
```
