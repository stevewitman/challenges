var image1 = [
	[0,0,0,0,0,0,0],
	[0,0,0,0,0,0,0],
	[0,0,1,1,1,1,0],
	[0,0,1,1,1,1,0],
	[0,0,1,1,0,0,0],
	[0,0,0,0,0,0,0],
	[0,0,0,0,0,0,0],
	[0,0,0,0,0,0,0],
	[0,0,0,0,1,1,1],
	[0,0,1,1,1,1,1],
	[0,0,0,1,1,0,0],
	[0,0,0,0,0,0,0],
];

function pad(img) {
	var x = img[0].length; // column
	var y = img.length; // row
	var temp_img = [];
	var new_img = [];
	var new_row = [];
	// pad left and right
	for (var j=0; j<y; j++) {
		new_row = [];
		new_row.push(img[j][0])
		for (var i=0; i<x; i++) {
			new_row.push(img[j][i])
		}
		new_row.push(img[j][x-1])
		temp_img.push(new_row)
	}
	// pad top and bottom
	new_img[0] = temp_img[0];
	for (var j=0; j<y; j++) {
		new_img[j+1] = temp_img[j];
	}
	new_img[y+1] = temp_img[y-1];
	// return new image
	return new_img;
}


function edge_outer(image) {
	padded_image = pad(image);
	var x = image[0].length; // column
	var y = image.length; // row
	var new_image = [];
	for (var j=1; j<=y; j++) {
		var new_row = [];
		for (var i=1; i<=x; i++) {
			if  (padded_image[j][i] === 1) {
				new_row.push(0)
			} else if (
					padded_image[j-1][i-1] === 1 ||
					padded_image[j-1][i] === 1 ||
					padded_image[j-1][i+1] === 1 ||
					padded_image[j][i-1] === 1 ||
					padded_image[j][i+1] === 1 ||
					padded_image[j+1][i-1] === 1 ||
					padded_image[j+1][i] === 1 ||
					padded_image[j+1][i+1] === 1
				) {
				new_row.push(1);
			} else {
				new_row.push(0)
			}
		}
		new_image.push(new_row)
	}
	return new_image;
}

console.log(edge_outer(image1))
