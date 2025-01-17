import { useEffect, useState } from 'react';
import useSWR from 'swr';
import fetcher from '../../data/api';
import ProductTable from '../../component/ProductTable';

export default function Admin(props) {
  const [activeTab, setActiveTab] = useState('product'); // Added useState for activeTab

  const renderContent = () => {
    switch (activeTab) {
      case 'category':
        return <div className="mt-4">category</div>;
      case 'product':
        return <ProductTable />;
      case 'transaction':
        return <div className="mt-4">Transaction</div>;
      default:
        return null;
    }
  };

  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);

  return (
    <div>
      <nav className="flex justify-center gap-4 mt-4">
        <button
          className={`text-xl hover:underline ${
            activeTab === 'category' ? 'underline' : 'no-underline'
          }`}
          onClick={() => setActiveTab('category')}
        >
          Category
        </button>
        <button
          className={`text-xl hover:underline ${
            activeTab === 'product' ? 'underline' : 'no-underline'
          }`}
          onClick={() => setActiveTab('product')}
        >
          Product
        </button>
        <button
          className={`text-xl hover:underline ${
            activeTab === 'transaction' ? 'underline' : 'no-underline'
          }`}
          onClick={() => setActiveTab('transaction')}
        >
          Transaction
        </button>
      </nav>

      <div>{renderContent()}</div>
    </div>
  );
}
