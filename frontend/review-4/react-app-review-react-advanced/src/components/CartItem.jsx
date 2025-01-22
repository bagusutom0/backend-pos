function CartItem({ name, image, price }) {
  return (
    <div className="flex gap-4 p-4 rounded-lg bg-gray-100">
      <div className="rounded-lg w-16 h-16">
        <img
          src={image}
          className="rounded-lg w-full h-full object-cover shadow-md"
        />
      </div>

      <div>
        <p className="font-bold text-sm">{name}</p>
        <span className="font-bold text-primary text-sm">{price}</span>
      </div>
    </div>
  );
}

export default CartItem;
