import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
  faArrowLeft,
  faArrowRight,
  faMagnifyingGlass,
  faSliders,
} from '@fortawesome/free-solid-svg-icons';
// import jewelries from '../data/jewelries';
import ProductCard from './ProductCard';
import { Link } from 'react-router';
import useSWR from 'swr';
import fetcher from '../data/api';

export default function ListProduct(props) {
  const path = '/product/all';
  const method = 'get';
  const { data, error, isLoading } = useSWR(
    () => [method, path],
    ([method, path]) => fetcher(method, path)
  );

  if (isLoading) return <div>Loading...</div>;
  if (error) return <div>Error: {error.message}</div>;

  function showAction(properties) {
    if (properties.showAction1) {
      return (
        <div className="flex gap-2 items-end">
          <div className="border border-black rounded-md flex gap-2 p-2 h-8 items-center">
            <FontAwesomeIcon icon={faMagnifyingGlass} />
            <input
              className="w-[200px] h-4 focus:outline-none"
              type="text"
              placeholder="Search..."
            />
          </div>

          <button className="border border-black rounded-md flex gap-2 p-2 h-8 items-center hover:bg-gray-100">
            <FontAwesomeIcon icon={faSliders} />
            Filter
          </button>
        </div>
      );
    } else if (properties.showAction2) {
      return (
        <button className="border border-black rounded-md lg:w-52 lg:h-10 lg:text-xl text-xs w-32 h-7 hover:bg-gray-100">
          View All Collection
        </button>
      );
    } else {
      null;
    }
  }

  return (
    <div className="p-16 mt-4">
      <div className="flex justify-between">
        <div>
          <h1 className="text-3xl font-bold font-serif">{props.title}</h1>
          <h2>{props.subtitle}</h2>
        </div>

        {showAction(props)}
      </div>

      <div className="grid grid-cols-2 md:grid-cols-4 grid-rows-4 md:grid-rows-2 gap-4 lg:mt-10 mt-4">
        {data.map((jewelry) => (
          <Link to={`/detail/${jewelry.id}`} key={jewelry.id}>
            <ProductCard
              image={jewelry.image}
              name={jewelry.name}
              price={jewelry.price}
            />
          </Link>
        ))}
      </div>

      <div className="mt-10 flex justify-center gap-4">
        <button className="px-8 py-2 border border-black rounded-md hover:bg-gray-100">
          <FontAwesomeIcon className="fa-lg" icon={faArrowLeft} />
        </button>
        <button className="px-8 py-2 border border-black rounded-md hover:bg-gray-100">
          <FontAwesomeIcon className="fa-lg" icon={faArrowRight} />
        </button>
      </div>
    </div>
  );
}
