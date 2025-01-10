import axios from 'axios';

// product
const token =
  'eyJhbGciOiJIUzM4NCJ9.eyJyb2xlIjoiQ0FTSElFUiIsInN1YiI6ImNhc2hpZXIiLCJpYXQiOjE3MzY1MTIyMDMsImV4cCI6MTczNjU1NTQwM30.lCVfLgd5DURRQJXKXrqZaS_NWwBzZcknhlQINTCxFyGFLBRJoYzpqxsWjIdaGWhO';

const addProduct = async () => {
  try {
    const url = 'http://' + 'localhost:8080/api/v1/product/add';

    const body = {
      name: 'Tempe',
      stock: 20,
      price: 1000,
      description: 'Tempe Goreng',
      categoryId: 1,
    };
    const config = {
      headers: {
        Authorization: `Bearer ${token}`,
        'Content-Type': 'application/json',
      },
    };

    const res = await axios.post(url, body, config);

    console.log(res.data);
  } catch (error) {
    console.log(error);
  }
};

const getProduct = async () => {
  try {
    const url = 'http://' + 'localhost:8080/api/v1/product/all';
    const config = {
      headers: {
        Authorization: `Bearer ${token}`,
        'Content-Type': 'application/json',
      },
    };

    const res = await axios.get(url, config);

    console.log(res.data);
  } catch (error) {
    console.log(error);
  }
};

const updateProduct = async () => {
  try {
    const url = 'http://' + 'localhost:8080/api/v1/product/update/1';

    const body = {
      name: 'Ayam',
      stock: 30,
      price: 15000,
      description: 'Ayam Geprek',
      categoryId: 1,
    };
    const config = {
      headers: {
        Authorization: `Bearer ${token}`,
        'Content-Type': 'application/json',
      },
    };

    const res = await axios.put(url, body, config);

    console.log(res.data);
  } catch (error) {
    console.log(error);
  }
};

const deleteProduct = async () => {
  try {
    const url = 'http://' + 'localhost:8080/api/v1/product/delete/1';

    const config = {
      headers: {
        Authorization: `Bearer ${token}`,
        'Content-Type': 'application/json',
      },
    };

    const res = await axios.delete(url, config);

    console.log(res.data);
  } catch (error) {
    console.log(error);
  }
};

// harus satu per satu
// addProduct();
// getProduct();
// updateProduct();
// deleteProduct();
