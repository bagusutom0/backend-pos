import { useEffect, useState } from 'react';
import useSWR from 'swr';
import fetcher from '../data/api';

export default function Admin(props) {
  const [activeTab, setActiveTab] = useState('product'); // Added useState for activeTab
  const path = '/product/all';
  const method = 'get';
  const { data, error, isLoading } = useSWR(
    () => [method, path],
    ([method, path]) => fetcher(method, path)
  );

  const renderContent = () => {
    switch (activeTab) {
      case 'category':
        return <div className="mt-4">category</div>;
      case 'product':
        return (
          <div className="p-4">
            <table className="table table-auto border border-gray-200">
              <thead>
                <tr className="bg-gray-100">
                  <th className="border border-gray-300 px-4 py-2">ID</th>
                  <th className="border border-gray-300 px-4 py-2">Category</th>
                  <th className="border border-gray-300 px-4 py-2">Name</th>
                  <th className="border border-gray-300 px-4 py-2">
                    Description
                  </th>
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
                {data.map((jewelry) => (
                  <tr key={jewelry.id} className="hover:bg-gray-50">
                    <td className="border border-gray-300 px-4 py-2">
                      {jewelry.id}
                    </td>
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
                      <button className="bg-blue-500 text-white px-3 py-1 rounded hover:bg-blue-600">
                        Edit
                      </button>
                      <button className="bg-red-500 text-white px-3 py-1 rounded hover:bg-red-600">
                        Delete
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>

            <button className="mt-4 bg-green-500 text-white px-4 py-2 rounded hover:bg-green-600">
              Add Product
            </button>
          </div>
        );
      case 'transaction':
        return <div className="mt-4">Transaction</div>;
      default:
        return null;
    }
  };

  useEffect(() => {
    window.scrollTo(0, 0);

    if (data) {
      console.log(data);
    }
  }, [data]);

  if (isLoading) return <div>Loading...</div>;
  if (error) return <div>Error: {error.message}</div>;

  return (
    <div>
      <nav className="flex justify-center gap-4 mt-4">
        <button
          className="text-xl hover:underline"
          onClick={() => setActiveTab('category')}
        >
          Category
        </button>
        <button
          className="text-xl hover:underline"
          onClick={() => setActiveTab('product')}
        >
          Product
        </button>
        <button
          className="text-xl hover:underline"
          onClick={() => setActiveTab('transaction')}
        >
          Transaction
        </button>
      </nav>

      <div>{renderContent()}</div>
    </div>
  );
}
