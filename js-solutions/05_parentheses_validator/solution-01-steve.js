var paren_valid = function(input) {
	var result = false;
	var pairs = ['()', '[]', '{}'];
	var open = 0;
	var close = 1;
	var openers = [];
	var character = '';
	for (var i=0; i<input.length; i++) {
		character = input[i]
		for (var j=0; j<pairs.length; j++) {
			if (character === pairs[j][open]) {
				openers.push(character);
			}
			if (character === pairs[j][close]) {
				if (openers[openers.length-1] === pairs[j][open]) {
					openers.pop();
				} else {
					// console.log('parentheses valid failed at index: ', i);
					// console.log(input.slice(0, i+1))
					return false;
				}
			}
		}
	}
	if (openers.length === 0) {
		return true;
	} else {
		return false;
	}
}

var a = '{([()()])}{}'; // valid
var b = '([()()])}{}'; // invalid
var c = '{([()()])}{'; // invalid
var d = '{([()(]))}{}'; // invalid
var e = '{([())])}{}'; // invalid
var f = '{([()(])}{}'; // invalid

console.log(paren_valid(a));
console.log(paren_valid(b));
console.log(paren_valid(c));
console.log(paren_valid(d));
console.log(paren_valid(e));
console.log(paren_valid(f));
