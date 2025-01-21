import { useState } from 'react';
import { Link, useNavigate } from 'react-router';
import productApi from '../../data/product/productApi';
import useProducts from '../../data/product/useProducts';
import { useDispatch, useSelector } from 'react-redux';
import {
  decreaseQuantity,
  deleteItem,
  increaseQuantity,
} from '../../store/slice/cartSlice';
import { useEffect } from 'react';

export default function Cart() {
  const dispatch = useDispatch();
  const { dataCart } = useSelector((state) => state.cart);

  useEffect(() => {
    console.log(dataCart);
  }, []);

  return (
    <div className="w-full p-4 mt-8 flex flex-col items-end  shadow-black relative">
      <p className="absolute left-1/2 -translate-x-1/2 text-xl font-bold">
        YOUR SHOPPING LIST
      </p>

      <table className="table table-auto border border-gray-200 mt-12 w-full">
        <thead>
          <tr className="bg-gray-300">
            <th className="border border-gray-300 px-4 py-2">Item</th>
            <th className="border border-gray-300 px-4 py-2">Price</th>
            <th className="border border-gray-300 px-4 py-2">Quantity</th>
            <th className="border border-gray-300 px-4 py-2">Total</th>
          </tr>
        </thead>
        <tbody>
          {dataCart.map((item) => (
            <tr key={`cart ${item.id}`} className="hover:bg-gray-50">
              <td className="border border-gray-300 px-4 py-2">
                <div className=" flex gap-4 items-center">
                  <img
                    className="w-10 h-10"
                    src={item.product.image[0]}
                    alt={item.product.name}
                  />
                  <span>{item.product.name}</span>
                </div>
              </td>
              <td className="border border-gray-300 px-4 py-2">
                <span className=" flex justify-center">
                  ${item.product.price}
                </span>
              </td>
              <td className="border border-gray-300 px-4 py-2">
                <div className="flex justify-center items-center gap-4">
                  <button
                    className="p-2 bg-gray-200 font-bold rounded-full w-6 h-6 flex justify-center items-center"
                    onClick={() => dispatch(decreaseQuantity(item.product.id))}
                  >
                    -
                  </button>
                  <span>{item.quantity}</span>
                  <button
                    className="p-2 bg-gray-200 font-bold rounded-full w-6 h-6 flex justify-center items-center"
                    onClick={() => dispatch(increaseQuantity(item.product.id))}
                  >
                    +
                  </button>
                </div>
              </td>
              <td className="border border-gray-300 px-4 py-2">
                <div className="flex justify-center items-center gap-4">
                  <span>${item.price}</span>
                  <button
                    className="p-2 bg-gray-200 font-bold rounded-full w-6 h-6 flex justify-center items-center"
                    onClick={() => dispatch(deleteItem(item.product.id))}
                  >
                    X
                  </button>
                </div>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
