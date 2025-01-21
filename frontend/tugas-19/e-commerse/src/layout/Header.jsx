import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
  faMagnifyingGlass,
  faCartShopping,
  faUser,
} from '@fortawesome/free-solid-svg-icons';
import { Link } from 'react-router';

export default function Header(props) {
  return (
    <>
      <h1 className="w-full bg-black text-white text-center">
        The World's Richest Source Of Vitamin C, Bottled.
      </h1>

      <div className="flex justify-between p-4">
        <Link to="/">
          <h1 className="text-xl font-serif italic">Zahabiya</h1>
        </Link>
        <div className="flex justify-between gap-4">
          <a
            className="transition delay-50 ease-in-out hover:scale-105"
            href="#"
          >
            Product
          </a>
          <span>-</span>
          <a
            className="transition delay-50 ease-in-out hover:scale-105"
            href="#"
          >
            Collection
          </a>
          <span>-</span>
          <a
            className="transition delay-50 ease-in-out hover:scale-105"
            href="#"
          >
            Services
          </a>
          <span>-</span>
          <a
            className="transition delay-50 ease-in-out hover:scale-105"
            href="#"
          >
            Stores
          </a>
          <span>-</span>
          <a
            className="transition delay-50 ease-in-out hover:scale-105"
            href="#"
          >
            About Us
          </a>
        </div>

        <div className="flex gap-4">
          <FontAwesomeIcon
            className="hover:scale-110"
            icon={faMagnifyingGlass}
          />
          <Link to={'/cart'}>
            <FontAwesomeIcon
              className="hover:scale-110 transition delay-50 ease-in-out"
              icon={faCartShopping}
            />
          </Link>
          <FontAwesomeIcon
            className="hover:scale-110 transition delay-50 ease-in-out"
            icon={faUser}
          />
        </div>
      </div>

      <hr />
    </>
  );
}
