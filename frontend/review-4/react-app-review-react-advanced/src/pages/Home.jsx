import { useSelector } from 'react-redux';

function Home() {
  // Buat code selector disini
  const { user } = useSelector((state) => state.user);

  return (
    <div className="h-screen flex flex-col justify-center items-center gap-4">
      <h1 className="font-bold text-xl">
        Hi, <span>{user.name}</span>
      </h1>
      <p>Congrats! You've solved the coding problem ✨</p>
      <img
        src="https://delavanlakesvet.com/wp-content/uploads/sites/195/2022/03/smiling-cat-for-web.jpg"
        alt="cat"
        className="w-64"
      />
    </div>
  );
}

export default Home;
