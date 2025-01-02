let imgMain = document.getElementById('img-product-main');
let img1 = document.getElementById('img-product-1');
let img2 = document.getElementById('img-product-2');
let img3 = document.getElementById('img-product-3');
let img4 = document.getElementById('img-product-4');

img1.addEventListener('click', function () {
  imgMain.src = img1.src;
});

img2.addEventListener('click', function () {
  imgMain.src = img2.src;
});

img3.addEventListener('click', function () {
  imgMain.src = img3.src;
});

img4.addEventListener('click', function () {
  imgMain.src = img4.src;
});
