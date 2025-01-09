import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import ListProduct from '../component/ListProduct';
import jewelries from '../data/jewelries';
import jewelry from '../assets/img/jewelry.png';
import { faArrowLeft, faArrowRight } from '@fortawesome/free-solid-svg-icons';
import SiteMap from '../component/SiteMap';
import { useEffect } from 'react';

export default function Home(props) {
  let dashboardImg = jewelry;

  useEffect(() => {
    window.scrollTo(0, 0);
  });

  return (
    <>
      {/* dashboard */}
      <div
        className="relative flex flex-col bg-black"
        style={{ height: 'calc(100vh - 84px' }}
      >
        <div className="flex justify-around backdrop-blur-sm bg-white/10 px-20 py-2 z-10">
          <a
            className="text-lg text-white font-serif hover:scale-105 transition delay-50 ease-in-out"
            href="#"
          >
            All Jewelry
          </a>
          <a
            className="text-lg text-white font-serif hover:scale-105 transition delay-50 ease-in-out"
            href="#"
          >
            New In
          </a>
          <a
            className="text-lg text-white font-serif hover:scale-105 transition delay-50 ease-in-out"
            href="#"
          >
            Best Sellers
          </a>
          <a
            className="text-lg text-white font-serif hover:scale-105 transition delay-50 ease-in-out"
            href="#"
          >
            Earings
          </a>
          <a
            className="text-lg text-white font-serif hover:scale-105 transition delay-50 ease-in-out"
            href="#"
          >
            Rings
          </a>
          <a
            className="text-lg text-white font-serif hover:scale-105 transition delay-50 ease-in-out"
            href="#"
          >
            Necklaces
          </a>
          <a
            className="text-lg text-white font-serif hover:scale-105 transition delay-50 ease-in-out"
            href="#"
          >
            Bracelets
          </a>
          <a
            className="text-lg text-white font-serif hover:scale-105 transition delay-50 ease-in-out"
            href="#"
          >
            Men's
          </a>
        </div>

        <img
          className="w-[60%] h-full absolute top-0 right-0 opacity-80"
          src={dashboardImg}
          alt="Diamond Ring"
        />

        <h1 className="text-white text-7xl font-serif w-[450px] z-10 absolute left-20 top-[35%]">
          Best Jewelry Collection
        </h1>

        <h2 className="text-white z-10 absolute left-20 bottom-[35%]">
          Explore unique jewely designed for the precious moments in your life.
        </h2>
      </div>

      {/* list product */}
      <ListProduct
        title="Best Sellers"
        subtitle="From price to occasion, find the jewelry that suits you."
        showAction1
      />

      {/* category */}
      <div className="flex gap-4 justify-center mt-10">
        <div className="relative flex flex-col justify-center">
          <img
            className="w-[650px]"
            style={{ height: '65vh' }}
            src={jewelry}
            alt="Engangement Ring"
          />
          <h1 className="text-white text-4xl font-serif w-[328px] py-1 text-center backdrop-blur-sm bg-white/10 absolute bottom-32 left-1/2 -translate-x-1/2 ">
            Engangement Rings
          </h1>
          <button className="text-xl p-2 bg-white absolute bottom-16 left-1/2 -translate-x-1/2 hover:bg-gray-100">
            Shop Now
          </button>
        </div>
        <div className="relative flex flex-col justify-center">
          <img
            className="w-[650px]"
            style={{ height: '65vh' }}
            src={jewelry}
            alt="Diamond Necklace"
          />
          <h1 className="text-white text-4xl font-serif w-[328px] py-1 text-center backdrop-blur-sm bg-white/10 absolute bottom-32 left-1/2 -translate-x-1/2 ">
            Diamond Necklaces
          </h1>
          <button className="text-xl p-2 bg-white absolute bottom-16 left-1/2 -translate-x-1/2 hover:bg-gray-100">
            Shop Now
          </button>
        </div>
      </div>

      {/* branding */}
      <div className="mt-16 relative">
        <img
          className="w-full object-cover"
          style={{ height: '80vh' }}
          src={jewelry}
          alt="Earing"
        />
        <div className="w-[56%] h-[36%] backdrop-blur-sm bg-white/10 absolute top-40 left-1/2 -translate-x-1/2 text-center">
          <h2 className="text-white">HUG FOR UNIVERSAL GOODNESS CREAM</h2>
          <h1 className="text-white text-6xl font-serif">
            Fostering Water Sustainability While Celebrating Global Beauty.
          </h1>
        </div>
        <button className="text-xl bg-white flex gap-4 justify-center items-center px-4 py-2 absolute bottom-32 left-1/2 -translate-x-1/2 hover:bg-gray-100">
          View Detail
          <FontAwesomeIcon icon={faArrowRight} className="fa-lg" />
        </button>
      </div>

      {/* sitemap */}
      <SiteMap />
    </>
  );
}
