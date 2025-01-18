import React from 'react';
import { useState } from 'react';

export default function App() {
  const [products, setProducts] = useState([
    { id: 1, name: 'anggur', qty: 2 },
    { id: 2, name: 'mangga', qty: 1 },
  ]);

  const addProduct = () => {
    let currentId = products.length + 1;
    setProducts([...products, { id: currentId, name: 'jeruk', qty: 2 }]);
  };

  const editProductQty = (id, qty) => {
    setProducts(
      products.map((product) =>
        product.id === id ? { ...product, qty: qty } : product
      )
    );
  };

  const deleteProduct = (id) => {
    setProducts(products.filter((product) => product.id !== id));
  };

  return (
    <div>
      <ul>
        {products.map((product) => (
          <li key={product.id} style={{ listStyleType: 'none' }}>
            <span>{product.id}. </span>
            <span>{product.name}</span>
            <span> : </span>
            <span>{product.qty} </span>
            <button onClick={() => editProductQty(product.id, 1)}>edit</button>
            <button onClick={() => deleteProduct(product.id)}>delete</button>
          </li>
        ))}
      </ul>

      <button onClick={addProduct}>Tambah</button>
    </div>
  );
}
