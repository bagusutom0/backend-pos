import { useForm } from 'react-hook-form';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';

export default function AddProduct() {
  const scheme = yup.object().shape({
    name: yup.string().required('Name is required'),
    image: yup
      .string()
      .required('Image is required')
      .matches(/^[^,]+(,[^,]+)*$/, 'Separate items with commas ( , )'),
    price: yup.string().required('Price is required'),
    review: yup
      .string()
      .required('Review is required')
      .matches(/^[^,]+(,[^,]+)*$/, 'Separate items with commas ( , )'),
    description: yup.string().required('Description is required'),
    colour: yup
      .string()
      .required('Colour is required')
      .matches(/^[^,]+(,[^,]+)*$/, 'Separate items with commas ( , )'),
    size: yup
      .string()
      .required('Size is required')
      .matches(/^[^,]+(,[^,]+)*$/, 'Separate items with commas ( , )'),
    length: yup
      .string()
      .required('Length is required')
      .matches(/^[^,]+(,[^,]+)*$/, 'Separate items with commas ( , )'),
    stock: yup.string().required('Stock is required'),
    category: yup.string().required('Category is required'),
  });

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm({ resolver: yupResolver(scheme) });

  const onSubmitForm = (data) => {
    data.image = data.image
      .split(',')
      .map((item) => item.trim())
      .filter((item) => item !== '');

    data.review = data.review
      .split(',')
      .map((item) => item.trim())
      .filter((item) => item !== '');

    data.colour = data.colour
      .split(',')
      .map((item) => item.trim())
      .filter((item) => item !== '');

    data.size = data.size
      .split(',')
      .map((item) => item.trim())
      .filter((item) => item !== '');

    data.length = data.length
      .split(',')
      .map((item) => item.trim())
      .filter((item) => item !== '');

    data.price = Number(data.price);
    data.stock = Number(data.stock);

    console.log(data);
    console.log('ayam');
  };

  return (
    <div className="flex flex-col p-4">
      <h1 className="text-xl font-bold text-center">Add Product</h1>
      <form
        className="mt-4 gap-4 flex flex-col items-center p-4"
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
          <input
            placeholder="Category"
            className="w-full rounded-md border border-gray-300 p-4 pe-12 focus:outline-gray-300"
            id="category"
            {...register('category')}
          />
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
            placeholder="Image"
            className="w-full rounded-md border border-gray-300 p-4 pe-12 focus:outline-gray-300"
            id="image"
            {...register('image')}
          />
          <p className="text-red-500">{errors.image?.message}</p>
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
          <label className="text-lg" htmlFor="review">
            Review
          </label>
          <input
            placeholder="Review"
            className="w-full rounded-md border border-gray-300 p-4 pe-12 focus:outline-gray-300"
            id="review"
            {...register('review')}
          />
          <p className="text-red-500">{errors.review?.message}</p>
        </div>

        <div className="w-full">
          <label className="text-lg" htmlFor="colour">
            Colour
          </label>
          <input
            placeholder="Colour"
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
            placeholder="Size"
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
            placeholder="Length"
            className="w-full rounded-md border border-gray-300 p-4 pe-12 focus:outline-gray-300"
            id="length"
            {...register('length')}
          />
          <p className="text-red-500">{errors.length?.message}</p>
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
    </div>
  );
}
