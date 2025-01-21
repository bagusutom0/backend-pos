import { useForm } from 'react-hook-form';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';
import useSWR, { mutate } from 'swr';
import fetcher from '../../data/axiosClient';
import { useNavigate } from 'react-router';
import { useState } from 'react';
import { Link } from 'react-router';
import axios from 'axios';
import productApi from '../../data/product/productApi';
import useCategory from '../../data/product/useCategory';

export default function AddProduct() {
  const navigate = useNavigate();

  // ambil list category
  const { categories } = useCategory();

  const addProduct = async (data) => {
    try {
      const response = await productApi.create(data);
    } catch (error) {
      console.error('Error adding data:', error.message);
    }
  };

  const scheme = yup.object().shape({
    name: yup.string().required('Name is required'),
    image: yup
      .string()
      .required('Image is required')
      .matches(/^[^,]+(,[^,]+)*$/, 'Separate items with commas ( , )'),
    price: yup
      .string()
      .required('Price is required')
      .matches(/^\d+$/, 'Price must be a number'),
    description: yup.string().required('Description is required'),
    colour: yup
      .string()
      .required('Colour is required')
      .matches(
        /^#[0-9A-Fa-f]{6}(\s*,\s*#[0-9A-Fa-f]{6})*$/,
        'Colors must be in hex format (e.g., #FFFFFF, #000000)'
      ),
    size: yup
      .string()
      .required('Size is required')
      .matches(
        /^\d+(\.\d+)?(\s*,\s*\d+(\.\d+)?)*$/,
        'Separate items with commas ( , )'
      ),
    length: yup
      .string()
      .required('Length is required')
      .matches(/^\d+(\s*,\s*\d+)*$/, 'Separate items with commas ( , )'),
    stock: yup
      .string()
      .required('Stock is required')
      .matches(/^\d+$/, 'Stock must be a number'),
    category: yup.string().required('Category is required'),
  });

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm({ resolver: yupResolver(scheme) });

  const onSubmitForm = (product) => {
    const category = categories.find(
      (category) => category.name === product.category
    );

    if (category) {
      product.image = product.image
        .split(',')
        .map((item) => item.trim())
        .filter((item) => item !== '');

      product.colour = product.colour
        .split(',')
        .map((item) => item.trim())
        .filter((item) => item !== '');

      product.size = product.size
        .split(',')
        .map((item) => item.trim())
        .filter((item) => item !== '');

      product.length = product.length
        .split(',')
        .map((item) => item.trim())
        .filter((item) => item !== '');

      product.price = Number(product.price);
      product.stock = Number(product.stock);

      let requestData = { ...product };
      delete requestData.category;
      requestData.categoryId = category.id;
      addProduct(requestData);

      navigate('/admin');
    }
  };

  return (
    <div className="flex flex-col p-4 items-center">
      <h1 className="text-xl font-bold text-center">Add Product</h1>
      <form
        className="mt-4 gap-4 flex flex-col items-center p-4 w-1/2"
        onSubmit={handleSubmit(onSubmitForm)}
      >
        <div className="w-full">
          <label className="text-lg" htmlFor="name">
            Name
          </label>
          <input
            placeholder="Name"
            className="w-full rounded-md border border-gray-300 p-4 pe-12 focus:outline-gray-300"
            id="name"
            {...register('name')}
          />
          <p className="text-red-500">{errors.name?.message}</p>
        </div>

        <div className="w-full">
          <label className="text-lg" htmlFor="category">
            Category
          </label>
          <select
            id="category"
            className="w-full rounded-md border border-gray-300 p-4 focus:outline-gray-300"
          >
            {categories.map((category) => (
              <option key={category.id} {...register('category')}>
                {category.name}
              </option>
            ))}
          </select>
          <p className="text-red-500">{errors.category?.message}</p>
        </div>

        <div className="w-full">
          <label className="text-lg" htmlFor="description">
            Description
          </label>
          <input
            placeholder="Description"
            className="w-full rounded-md border border-gray-300 p-4 pe-12 focus:outline-gray-300"
            id="description"
            {...register('description')}
          />
          <p className="text-red-500">{errors.description?.message}</p>
        </div>

        <div className="w-full">
          <label className="text-lg" htmlFor="image">
            Image
          </label>
          <input
            placeholder="Example: url1, url2, url3"
            className="w-full rounded-md border border-gray-300 p-4 pe-12 focus:outline-gray-300"
            id="image"
            {...register('image')}
          />
          <p className="text-red-500">{errors.image?.message}</p>
        </div>

        <div className="w-full">
          <label className="text-lg" htmlFor="colour">
            Colour <span className="text-sm">(colour in hexadecimal)</span>
          </label>
          <input
            placeholder="Example: #ffffff, #ff00ff, #ffff00"
            className="w-full rounded-md border border-gray-300 p-4 pe-12 focus:outline-gray-300"
            id="colour"
            {...register('colour')}
          />
          <p className="text-red-500">{errors.colour?.message}</p>
        </div>

        <div className="w-full">
          <label className="text-lg" htmlFor="size">
            Size
          </label>
          <input
            placeholder="Example: 2, 3.5, 4"
            className="w-full rounded-md border border-gray-300 p-4 pe-12 focus:outline-gray-300"
            id="size"
            {...register('size')}
          />
          <p className="text-red-500">{errors.size?.message}</p>
        </div>

        <div className="w-full">
          <label className="text-lg" htmlFor="length">
            Length
          </label>
          <input
            placeholder="Example: 18, 19, 20"
            className="w-full rounded-md border border-gray-300 p-4 pe-12 focus:outline-gray-300"
            id="length"
            {...register('length')}
          />
          <p className="text-red-500">{errors.length?.message}</p>
        </div>

        <div className="w-full">
          <label className="text-lg" htmlFor="price">
            Price
          </label>
          <input
            placeholder="Price"
            className="w-full rounded-md border border-gray-300 p-4 pe-12 focus:outline-gray-300"
            id="price"
            {...register('price')}
          />
          <p className="text-red-500">{errors.price?.message}</p>
        </div>

        <div className="w-full">
          <label className="text-lg" htmlFor="stock">
            Stock
          </label>
          <input
            placeholder="Stock"
            className="w-full rounded-md border border-gray-300 p-4 pe-12 focus:outline-gray-300"
            id="stock"
            {...register('stock')}
          />
          <p className="text-red-500">{errors.stock?.message}</p>
        </div>

        <button className="mt-4 w-32 bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">
          Add Product
        </button>
      </form>

      <Link to={'/admin'}>
        <button className="mt-4 w-32 bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">
          Back
        </button>
      </Link>
    </div>
  );
}
