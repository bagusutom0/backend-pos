export default function ProductCard(props) {
  return (
    <div className="transition delay-50 ease-in-out hover:scale-105">
      <img
        src={props.image}
        alt="ring"
        className="w-full h-[200px] rounded-md drop-shadow"
      />
      <div className="flex justify-between lg:px-2 md:px-0 md:mt-1">
        <p className="lg:text-base md:text-xs">{props.name}</p>
        <p className="lg:text-base md:text-xs font-bold">$ {props.price}</p>
      </div>
    </div>
  );
}
