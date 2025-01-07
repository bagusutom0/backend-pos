export default function ProductCard(props) {
  return (
    <div class="transition delay-200 ease-in-out hover:scale-105">
      <img src={props.image} alt="ring" class="w-full h-[200px] rounded-md" />
      <div class="flex justify-between lg:px-2 md:px-0 md:mt-1">
        <p class="lg:text-xl md:text-xs">{props.name}</p>
        <p class="lg:text-xl md:text-xs font-bold">$ {props.price}</p>
      </div>
    </div>
  );
}
