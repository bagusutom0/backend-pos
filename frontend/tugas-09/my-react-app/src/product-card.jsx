function ProductCard(props) {
  return (
    <div className="flex flex-col gap-1 hover:scale-105">
      <img
        src={props.img}
        alt={props.name}
        className="w-full h-[200px] drop-shadow rounded-md"
      />
      <div className="flex justify-between">
        <p className="text-xl">{props.name}</p>
        <p className="text-xl font-bold">${props.price}</p>
      </div>
    </div>
  );
}

export default ProductCard;
