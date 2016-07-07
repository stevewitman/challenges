# DIFF ALGORITHM

[[Back to Challenges]](https://github.com/stevewitman/challenges "Return to 'Challenges'")

### Write a function that takes two strings as inputs and determines which sections in the second have been added and which sections have been removed.

The function should return the second input string with  `<added>...</added>` and  `<removed>...</removed>` tags (or similar), inserted around the appropriate portions of the string.

Input string 1:

```html
<html>
  <head>
    <title>A Simple HTML Document</title>
  </head>
  <body>
    <p>This is a very simple HTML document with one paragraph</p>
  </body>
</html>
```

Input String 2:

```html
<html>
  <head>
    <title>Another Simple HTML Document</title>
  </head>
  <body>
    <p>This is a very simple HTML document</p>
    <p>Now it has has two paragraphs</p>
  </body>
</html>
```

Expected Output:

```html
<html>
  <head>
    <title>A<added>nother</added> Simple HTML Document</title>
  </head>
  <body>
    <p>This is a very simple HTML document<removed> with one paragraph</removed></p>
    <added><p>Now it has has two paragraphs</p></added>
  </body>
</html>
```


### Stretch Goal ... Attempt to identify blocks of code, enclosing element, whole words/sentences, etc. that have changed.
