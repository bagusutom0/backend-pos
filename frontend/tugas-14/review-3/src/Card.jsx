export default function Card({ image, name }) {
  return (
    <div>
      <img
        src={image}
        alt={name}
        className="w-full h-[200px] rounded-md drop-shadow"
      />
      <p className="font-bold text-xl">{name}</p>
    </div>
  );
}
