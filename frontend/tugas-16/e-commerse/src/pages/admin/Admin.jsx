import { useEffect, useState } from 'react';
import useSWR from 'swr';
import fetcher from '../../data/api';
import ProductTable from '../../component/ProductTable';

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
        return <ProductTable data={data} />;
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

  if (isLoading)
    return (
      <div className="flex justify-center items-center h-screen">
        <div className="w-16 h-16 border-4 border-dashed rounded-full animate-spin border-black"></div>
      </div>
    );

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
