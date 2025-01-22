import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
  faMagnifyingGlass,
  faCartShopping,
  faUser,
  faRightFromBracket,
} from '@fortawesome/free-solid-svg-icons';
import { Link } from 'react-router';
import { useState } from 'react';
import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { resetAuthData } from '../store/slice/authSlice';

export default function Header(props) {
  const dispatch = useDispatch();
  const { token } = useSelector((state) => state.auth);

  const onLogOut = () => {
    dispatch(resetAuthData());
    setIsLogin(false);
  };

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

        <div className="flex items-center gap-4">
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
          {token !== '' ? (
            <FontAwesomeIcon
              className="hover:scale-110 transition delay-50 ease-in-out"
              icon={faRightFromBracket}
              onClick={onLogOut}
            />
          ) : (
            <Link to="/login">
              <FontAwesomeIcon
                className="hover:scale-110 transition delay-50 ease-in-out"
                icon={faUser}
              />
            </Link>
          )}
        </div>
      </div>

      <hr />
    </>
  );
}
