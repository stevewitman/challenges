# PARENTHESES VALIDATOR

[[Back to Challenges]](https://github.com/stevewitman/challenges "Return to 'Challenges'")

### Write a function that takes a string as its input and returns true if all parentheses, square-brackets, and curly-brackets are properly nested and closed. Otherwise the function should return false

The following string should return `true`

```js
function htmlDoc(title, bodyContent) {
  return tag("html", [tag("head", [tag("title", [title])]), tag("body", bodyContent)]);
}
```
Each of the following strings should return `false`

```js
function htmlDoc(title, bodyContent) {
  return tag("html", [tag("head", [tag("title", [title])), tag("body", bodyContent)]);
}
```

```js
function htmlDoc(title, bodyContent) {
  return tag("html", [tag "head", [tag("title", [title])]), tag("body", bodyContent)]);
}
```

```js
function htmlDoc(title, bodyContent) {
  return tag("html", [tag("head", [tag("title", [title]])), tag("body", bodyContent)]);
}
```

### Stretch Goal - Write another function that identifies where the inconsistencies are.
