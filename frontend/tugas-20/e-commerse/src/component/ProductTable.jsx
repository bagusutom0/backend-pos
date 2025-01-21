import { useState } from 'react';
import { Link, useNavigate } from 'react-router';
import productApi from '../data/product/productApi';
import useProducts from '../data/product/useProducts';

export default function ProductTable() {
  const navigate = useNavigate();
  const [shouldDelete, setShouldDelete] = useState(false);
  const [requestPath, setRequestPath] = useState('');

  const { products, error, isLoading, mutate } = useProducts();

  if (isLoading)
    return (
      <div className="flex justify-center items-center h-screen">
        <div className="w-16 h-16 border-4 border-dashed rounded-full animate-spin border-black"></div>
      </div>
    );

  if (error) return <div>Error: {error.message}</div>;

  const onDelete = (id) => {
    const deleteData = async () => {
      try {
        const response = await productApi.delete(id);
        mutate();
      } catch (error) {
        console.error('Error deleting data:', error);
      } finally {
      }
    };

    deleteData();
  };

  return (
    <div className="w-full p-4 mt-8 flex flex-col items-end bg-black/5 shadow-black relative">
      <p className="absolute left-1/2 -translate-x-1/2 text-xl font-semibold">
        List Product
      </p>

      <Link to="/admin/product/add">
        <button className=" bg-green-500 text-white px-4 py-2 rounded hover:bg-green-600">
          Add Product
        </button>
      </Link>

      <table className="table table-auto border border-gray-200 mt-4 w-full">
        <thead>
          <tr className="bg-gray-300">
            <th className="border border-gray-300 px-4 py-2">ID</th>
            <th className="border border-gray-300 px-4 py-2">Category</th>
            <th className="border border-gray-300 px-4 py-2">Name</th>
            <th className="border border-gray-300 px-4 py-2">Description</th>
            <th className="border border-gray-300 px-4 py-2">Review</th>
            <th className="border border-gray-300 px-4 py-2">Stock</th>
            <th className="border border-gray-300 px-4 py-2">Price</th>
            <th className="border border-gray-300 px-4 py-2">Colour</th>
            <th className="border border-gray-300 px-4 py-2">Image</th>
            <th className="border border-gray-300 px-4 py-2">Length</th>
            <th className="border border-gray-300 px-4 py-2">Size</th>
            <th className="border border-gray-300 px-4 py-2">Action</th>
          </tr>
        </thead>
        <tbody>
          {products.map((jewelry) => (
            <tr key={jewelry.id} className="hover:bg-gray-50">
              <td className="border border-gray-300 px-4 py-2">{jewelry.id}</td>
              <td className="border border-gray-300 px-4 py-2">
                {jewelry.category.name}
              </td>
              <td className="border border-gray-300 px-4 py-2">
                {jewelry.name}
              </td>
              <td className="border border-gray-300 px-4 py-2">
                {jewelry.description}
              </td>
              <td className="border border-gray-300 px-4 py-2">
                {jewelry.review.join('★, ')}
              </td>
              <td className="border border-gray-300 px-4 py-2">
                {jewelry.stock}
              </td>
              <td className="border border-gray-300 px-4 py-2">
                ${jewelry.price}
              </td>
              <td className="border border-gray-300 px-4 py-2">
                {jewelry.colour.map((color) => (
                  <span
                    key={color}
                    className="inline-block w-4 h-4 mr-2"
                    style={{ backgroundColor: color }}
                  />
                ))}
              </td>
              <td className="border border-gray-300 px-4 py-2">
                <div className="flex gap-2 flex-wrap justify-center">
                  {jewelry.image.map((img, index) => (
                    <img
                      key={index}
                      src={img}
                      alt="jewelry"
                      className="w-8 h-8 object-cover rounded"
                    />
                  ))}
                </div>
              </td>
              <td className="border border-gray-300 px-4 py-2">
                {jewelry.length.join(', ')}
              </td>
              <td className="border border-gray-300 px-4 py-2">
                {jewelry.size.join(', ')}
              </td>
              <td className="border border-gray-200 px-4 py-2 gap-2 flex flex-col">
                <Link to={`/admin/product/edit/${jewelry.id}`}>
                  <button className="bg-blue-500 text-white px-3 py-1 rounded hover:bg-blue-600 w-full">
                    Edit
                  </button>
                </Link>
                <button
                  className="bg-red-500 text-white px-3 py-1 rounded hover:bg-red-600"
                  onClick={() => onDelete(jewelry.id)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
