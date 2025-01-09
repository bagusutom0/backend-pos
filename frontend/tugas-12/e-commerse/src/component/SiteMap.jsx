import { faArrowRight } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

export default function SiteMap(props) {
  return (
    <div className="flex justify-between p-16">
      <h1 className="font-serif text-2xl italic mr-52">Zahabiya</h1>

      <div className="flex flex-col gap-2">
        <h3 className="font-serif text-xl">My Pages</h3>
        <a className="hover:scale-105 transition delay-50 ease-in-out" href="#">
          Earings
        </a>
        <a className="hover:scale-105 transition delay-50 ease-in-out" href="#">
          Rings
        </a>
        <a className="hover:scale-105 transition delay-50 ease-in-out" href="#">
          Necklaces
        </a>
        <a className="hover:scale-105 transition delay-50 ease-in-out" href="#">
          Bracelets
        </a>
        <a className="hover:scale-105 transition delay-50 ease-in-out" href="#">
          Men's
        </a>
      </div>
      <div className="flex flex-col gap-2">
        <h3 className="font-serif text-xl">Company</h3>
        <a className="hover:scale-105 transition delay-50 ease-in-out" href="#">
          Our Story
        </a>
        <a className="hover:scale-105 transition delay-50 ease-in-out" href="#">
          Certified Organic
        </a>
        <a className="hover:scale-105 transition delay-50 ease-in-out" href="#">
          Sustainability
        </a>
        <a className="hover:scale-105 transition delay-50 ease-in-out" href="#">
          Blog
        </a>
        <a className="hover:scale-105 transition delay-50 ease-in-out" href="#">
          Careers
        </a>
        <a className="hover:scale-105 transition delay-50 ease-in-out" href="#">
          Affiliates
        </a>
      </div>
      <div className="flex flex-col gap-2">
        <h3 className="font-serif text-xl">Customer Care</h3>
        <a className="hover:scale-105 transition delay-50 ease-in-out" href="#">
          Shop
        </a>
        <a className="hover:scale-105 transition delay-50 ease-in-out" href="#">
          FAQ
        </a>
        <a className="hover:scale-105 transition delay-50 ease-in-out" href="#">
          Order Tracking
        </a>
        <a className="hover:scale-105 transition delay-50 ease-in-out" href="#">
          Promotions
        </a>
        <a className="hover:scale-105 transition delay-50 ease-in-out" href="#">
          Shipping
        </a>
        <a className="hover:scale-105 transition delay-50 ease-in-out" href="#">
          Reviews
        </a>
      </div>
      <div className="flex flex-col gap-2">
        <h3 className="font-serif text-xl">Join Our Newslatter</h3>
        <button className="flex gap-8 p-2 items-center border border-black rounded-md hover:bg-gray-100">
          Enter Your Email Address
          <FontAwesomeIcon icon={faArrowRight} className="fa-lg" />
        </button>
      </div>
    </div>
  );
}
