import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
  faArrowLeft,
  faArrowRight,
  faMagnifyingGlass,
  faSliders,
} from '@fortawesome/free-solid-svg-icons';
import jewelries from '../data/jewelries';
import ProductCard from './ProductCard';

export default function ListProduct(props) {
  return (
    <div className="p-16 mt-4">
      <div className="flex justify-between">
        <div className="">
          <h1 className="text-3xl font-bold font-serif">{props.title}</h1>
          <h2>{props.subtitle}</h2>
        </div>

        {props.showAction ? (
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
        ) : null}
      </div>

      <div class="grid grid-cols-2 md:grid-cols-4 grid-rows-4 md:grid-rows-2 gap-4 lg:mt-10 mt-4">
        {jewelries.map((jewelry) => (
          <ProductCard
            image={jewelry.image}
            name={jewelry.name}
            price={jewelry.price}
          />
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
