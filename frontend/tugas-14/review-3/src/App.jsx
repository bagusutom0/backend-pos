import { useState } from 'react';
import axios from 'axios';
import Card from './Card';
import { useEffect } from 'react';

function App() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await axios.get('https://dummyjson.com/products');
        setProducts(response.data.products);
      } catch (e) {
        console.log(`Error fetching data: ${e}`);
      }
    };

    fetchProducts();
  }, []);

  return (
    <div className="grid grid-cols-2 grid-rows-2">
      {products.map((product) => (
        <Card key={product.id} image={product.thumbnail} name={product.title} />
      ))}
    </div>
  );
}

export default App;
