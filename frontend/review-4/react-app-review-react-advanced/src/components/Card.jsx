function Card({ title, image, onClick }) {
    return (
      <div
        className="p-4 flex flex-col justify-center items-center max-w-sm rounded shadow-lg cursor-pointer"
        onClick={onClick}
      >
        <img className="w-48" src={image} alt={title} />
        <p className="font-bold py-4 text-center">{title}</p>
      </div>
    );
  }
  
  export default Card;