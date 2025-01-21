import { Link } from 'react-router';
import { useDispatch } from 'react-redux';
import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import * as yup from 'yup';
import { useNavigate } from 'react-router-dom';
import authApi from '../../data/auth/authApi';
import { setToken, setUser } from '../../store/slice/authSlice';

export default function Login() {
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const schema = yup.object().shape({
    username: yup.string().min(5).max(32).required('Username is required'),
    password: yup.string().min(5).max(32).required('Password is required'),
  });

  const {
    register,
    handleSubmit,
    formState: { errors },
    reset,
  } = useForm({
    resolver: yupResolver(schema),
  });

  const onLogin = (data) => {
    // alert('login');

    console.log('data', data);

    authApi
      .authenticate(data)
      .then((res) => {
        const { name, role, token } = res.data;
        dispatch(setToken(token));
        dispatch(setUser({ name: name, role: role }));
        navigate('/admin');

        // console.log('name', name);
        // console.log('role', role);
        // console.log('token', token);
        reset();
      })
      .catch((error) => {
        console.log('Error authenticating user:', error.message);
      });
    reset();
  };

  return (
    <div className="flex flex-col justify-center items-center h-[78vh]">
      <h1 className="text-2xl font-semibold mb-10">LOGIN</h1>
      <form
        className="flex flex-col items-center gap-2"
        onSubmit={handleSubmit(onLogin)}
      >
        <div>
          <label className="text-lg" htmlFor="username">
            Username
          </label>
          <input
            placeholder="username"
            className="w-full rounded-md border border-gray-300 p-4 pe-12 focus:outline-gray-300"
            id="username"
            {...register('username')}
          />
          <p className="text-red-500">{errors.username?.message}</p>
        </div>

        <div>
          <label className="text-lg" htmlFor="name">
            Password
          </label>
          <input
            placeholder="password"
            className="w-full rounded-md border border-gray-300 p-4 pe-12 focus:outline-gray-300"
            id="password"
            type="password"
            {...register('password')}
          />
          <p className="text-red-500">{errors.password?.message}</p>
        </div>

        <button className="bg-blue-500 hover:bg-blue-600 w-32 h-10 rounded text-white mt-4">
          Login
        </button>
      </form>

      <Link to="/">
        <button className="bg-blue-500 hover:bg-blue-600 w-32 h-10 rounded text-white mt-4">
          Home
        </button>
      </Link>
    </div>
  );
}
