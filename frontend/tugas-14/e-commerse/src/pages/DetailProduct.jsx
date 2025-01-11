import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { useState } from 'react';
import ListProduct from '../component/ListProduct';
import SiteMap from '../component/SiteMap';
import jewelries from '../data/jewelries';
import {
  faAngleDoubleDown,
  faAngleDown,
  faAngleUp,
  faArrowRight,
} from '@fortawesome/free-solid-svg-icons';
import { useEffect } from 'react';
import { useParams } from 'react-router';
import useSWR from 'swr';
import fetcher from '../data/api';

export default function DetailProduct(props) {
  const { id } = useParams();
  // const data = jewelries.find((item) => item.id === Number(id));
  const path = `/product/${id}`;
  const method = 'get';
  const { data, error, isLoading } = useSWR([method, path], ([method, path]) =>
    fetcher(method, path)
  );

  const [detailImage, setDetailImage] = useState(null);
  const [quantity, setQuantity] = useState(1);

  function changeDetailImage(urlImage) {
    setDetailImage(urlImage);
  }

  function increaseQuantity() {
    if (quantity + 1 <= data.stock) {
      setQuantity(quantity + 1);
    } else {
      alert('Out of stock!');
    }
  }

  function decreaseQuantity() {
    if (quantity - 1 === 0) {
      alert('Cannot have 0 in quantity!');
    } else {
      setQuantity(quantity - 1);
    }
  }

  function showRatings() {
    let result = '';
    for (let i = 0; i < Number(data.review[0]); i++) {
      result += '★';
    }

    if (result.length < 5) {
      result += '☆'.repeat(5 - result.length);
    }

    return result;
  }

  useEffect(() => {
    window.scrollTo(0, 0);

    if (data) {
      setDetailImage(data.image[0]);
    }
  }, [data]);

  if (isLoading) return <div>Loading...</div>;
  if (error) return <div>Error: {error.message}</div>;

  return (
    <>
      {/* product description */}
      <section className="flex justify-between flex-col items-center md:flex-row px-6 py-4">
        {/* product photo */}
        <div className="flex flex-col md:w-1/2 flex-nowrap">
          <img
            src={detailImage}
            alt="ing"
            className="w-full h-[530px] rounded-xl"
          />
          <div className="grid grid-cols-4 gap-4 mt-4 h-1/4">
            {data.image.map((tumbnailImage) => (
              <img
                key={`tumbnailImage ${data.image.indexOf(tumbnailImage)}`}
                src={tumbnailImage}
                alt="ring"
                className="rounded-xl transition delay-75 ease-in-out hover:scale-105"
                onClick={() => changeDetailImage(tumbnailImage)}
              />
            ))}
          </div>
        </div>

        {/* product description */}
        <div className="flex flex-col justify-between md:w-1/2 md:px-6 pb-10 mt-10 md:mt-0">
          <h3 className="lg:text-lg md:text-xs">MEN'S</h3>

          <h1 className="lg:text-4xl md:text-xl">{data.name}</h1>

          <span className="lg:text-xl md:text-xs">
            {showRatings()} {data.review[1]} Review
          </span>

          <p className="lg:text-2xl mt-2 md:text-lg">
            $ {data.price} <span className="text-sm">tax included.</span>
          </p>

          <br />
          <hr />

          <div className="mt-2">
            <div className="flex justify-between">
              <h2 className="lg:text-lg md:text-sm">DESCRIPTION</h2>
              <FontAwesomeIcon icon={faAngleUp} />
            </div>
            <p className="lg:text-sm text-justify mt-1 md:text-xs">
              {data.description}
            </p>
            <hr className="mt-2 lg:mt-4" />
          </div>

          <div className="mt-2">
            <div className="flex justify-between">
              <h2 className="lg:text-lg md:text-sm">Details</h2>
              <FontAwesomeIcon icon={faAngleDown} />
            </div>
            <hr className="mt-2 lg:mt-4" />
          </div>

          <div className="mt-2">
            <div className="flex justify-between">
              <h2 className="lg:text-lg md:text-sm">Materials</h2>
              <FontAwesomeIcon icon={faAngleDown} />
            </div>
            <hr className="mt-2 lg:mt-4" />
          </div>

          <div className="mt-4 lg:mt-8 md:mt-4">
            <h2 className="lg:text-xl md:text-sm">Colour:</h2>
            <div className="flex justify-between w-16 mt-1">
              <label className="flex items-center">
                <input type="radio" name="option" className="hidden peer" />
                <span
                  className="w-4 h-4 rounded-sm hover:border hover:border-black transition ease-in-out delay-75"
                  style={{ backgroundColor: data.colour[0] }}
                ></span>
              </label>
              <label className="flex items-center">
                <input type="radio" name="option" className="hidden peer" />
                <span
                  className="w-4 h-4  rounded-sm hover:border hover:border-black transition ease-in-out delay-75"
                  style={{ backgroundColor: data.colour[1] }}
                ></span>
              </label>
              <label className="flex items-center">
                <input type="radio" name="option" className="hidden peer" />
                <span
                  className="w-4 h-4  rounded-sm hover:border hover:border-black transition ease-in-out delay-75"
                  style={{ backgroundColor: data.colour[2] }}
                ></span>
              </label>
            </div>
          </div>

          <div className="lg:mt-8 mt-4 flex justify-between">
            <div>
              <h2 className="lg:text-xl md:text-sm">
                SIZE <span className="text-xs">(mm)</span> :
              </h2>
              <div className="flex justify-between gap-1 lg:gap-1 md:gap-0.5 md:mt-2">
                {data.size.map((size) => (
                  <label className="flex items-center" key={`size ${size}`}>
                    <input type="radio" name="option" className="hidden peer" />
                    <span className="w-10 text-center lg:w-14 md:w-10 lg:h-8 md:h-6 lg:text-sm md:text-[8px] rounded-md border border-black lg:p-1 md:p-0.5 flex justify-center items-center hover:bg-gray-100 transition ease-in-out delay-75">
                      {size}
                    </span>
                  </label>
                ))}
              </div>
            </div>

            <div>
              <h2 className="lg:text-xl md:text-sm">
                LENGTH :{' '}
                <span className="lg:text-xs md:text-[10px]">18" (SHORT)</span>
              </h2>
              <div className="flex justify-between gap-1 lg:gap-1 md:gap-0.5 md:mt-2">
                {data.length.map((length) => (
                  <label className="flex items-center" key={`length ${length}`}>
                    <input type="radio" name="option" className="hidden peer" />
                    <span className="lg:w-10 lg:h-8 w-7 md:w-6 md:h-6 lg:text-lg md:text-[8px] rounded-md border border-black lg:p-1 md:p-0.5 flex justify-center items-center hover:bg-gray-100 transition ease-in-out delay-75">
                      {length}
                    </span>
                  </label>
                ))}
              </div>
            </div>
          </div>

          <div className="lg:mt-8 mt-4 flex justify-start items-center gap-2">
            <h2 className="lg:text-xl md:text-sm">QUANTITY :</h2>
            <div className="flex justify-between items-center gap-2">
              <button
                className="lg:text-xl md:text-sm hover:scale-105 transition ease-in-out delay-75"
                onClick={decreaseQuantity}
              >
                -
              </button>
              <span className="lg:text-xl md:text-sm">{quantity}</span>
              <button
                className="lg:text-xl md:text-sm hover:scale-105 transition ease-in-out delay-75"
                onClick={increaseQuantity}
              >
                +
              </button>
            </div>
          </div>

          <div className="lg:mt-8 mt-4 grid grid-cols-2 gap-2">
            <button className="border border-black rounded-md lg:text-xl md:text-sm lg:p-2 md:p-1 hover:bg-gray-100">
              ADD TO CART
            </button>
            <button className="bg-black text-white rounded-md lg:text-xl md:text-sm lg:p-2 md:p-1 hover:bg-gray-100 hover:text-black hover:border hover:border-black">
              BUY NOW
            </button>
          </div>
        </div>
      </section>

      <ListProduct
        title="You may also Like"
        subtitle="Make every day special with alluring, high-quality data."
        showAction2
      />

      <section className="mt-10 px-12 flex flex-col md:flex-row justify-between gap-4">
        <div className="md:w-1/2 relative">
          <img
            src={jewelries[1].image}
            alt="data"
            className="w-full h-[500px]"
          />
          <h1 className="lg:text-4xl text-xl md:p-1 text-center text-white lg:p-2 bg-black opacity-50 absolute bottom-14 lg:bottom-40 md:bottom-20 left-1/2 -translate-x-1/2">
            Engangement Rings
          </h1>
          <button className="lg:text-2xl md:text-lg md:py-1 px-4 lg:py-2 bg-white absolute lg:bottom-20 bottom-4 md:bottom-7 left-1/2 -translate-x-1/2 hover:bg-gray-100 transition ease-in-out delay-75">
            Shop Now
          </button>
        </div>
        <div className="md:w-1/2 relative">
          <img
            src={jewelries[2].image}
            alt="data"
            className="w-full h-[500px]"
          />
          <h1 className="lg:text-4xl text-xl md:p-1 text-center text-white lg:p-2 bg-black opacity-50 absolute bottom-14 lg:bottom-40 md:bottom-20 left-1/2 -translate-x-1/2">
            Diamond Necklace
          </h1>
          <button className="lg:text-2xl md:text-lg md:py-1 px-4 lg:py-2 bg-white absolute lg:bottom-20 bottom-4 md:bottom-7 left-1/2 -translate-x-1/2 hover:bg-gray-100 transition ease-in-out delay-75">
            Shop Now
          </button>
        </div>
      </section>

      <section className="mt-20 relative">
        <img
          src={jewelries[2].image}
          alt="data"
          className="w-full h-[500px] md:h-[650px] object-cover"
        />
        <div className="p-4 flex flex-col justify-center w-3/4 items-center absolute top-32 lg:top-24 md:top-40 left-1/2 -translate-x-1/2 bg-black opacity-50 text-white">
          <h3 className="lg:text-lg text-xs text-center">
            HUG FOR UNIVERSAL GOODNESS CREAM
          </h3>
          <h1 className="lg:text-7xl text-xl md:text-5xl text-center">
            Fostering Water Sustainability While Celebrating Global Beauty.
          </h1>
        </div>
        <button className="absolute lg:bottom-28 bottom-40 md:bottom-32 lg:text-xl md:text-sm bg-white lg:p-4 p-3 left-1/2 -translate-x-1/2 flex gap-8 items-center hover:bg-gray-100 transition ease-in-out delay-75">
          View Detail
          <FontAwesomeIcon icon={faArrowRight} />
        </button>
      </section>

      <SiteMap />
    </>
  );
}
