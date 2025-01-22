import { useDispatch } from 'react-redux';
import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import * as yup from 'yup';
import { useNavigate } from 'react-router-dom';
import { setUser } from '../store/slice/userSlice';

function Profile() {
  const dispatch = useDispatch();
  const navigate = useNavigate();

  // schema validation
  const schema = yup.object().shape({
    name: yup.string().required('Name is required'),
    email: yup.string().email().required('Email is required'),
  });

  const {
    register,
    handleSubmit,
    formState: { errors },
    reset,
  } = useForm({
    resolver: yupResolver(schema),
  });

  const onSubmitForm = (data) => {
    // lengkapi code disini
    dispatch(setUser(data));

    navigate('/home');
    reset();
  };

  return (
    <div className="flex flex-col justify-center items-center p-6">
      <h1 className="text-center font-bold text-2xl mb-4">Profile</h1>
      <form
        className="flex flex-col gap-4 w-1/3"
        onSubmit={handleSubmit(onSubmitForm)}
      >
        <div>
          <label htmlFor="name">Name</label>
          <input
            placeholder="Name"
            className="w-full rounded-lg border-[1px] border-gray-200 p-4 pe-12 text-sm focus:outline-sky-200"
            {...register('name')}
            id="name"
          />
          <p className="text-sm text-red-400">{errors.name?.message}</p>
        </div>

        <div>
          <label htmlFor="email">Email</label>
          <input
            placeholder="Email"
            className="w-full rounded-lg border-[1px] border-gray-200 p-4 pe-12 text-sm focus:outline-sky-200"
            {...register('email')}
            id="email"
          />
          <p className="text-sm text-red-400">{errors.email?.message}</p>
        </div>

        <button
          className="rounded-lg bg-sky-400 p-2 text-white w-full"
          type="submit"
        >
          Input User
        </button>
      </form>
    </div>
  );
}

export default Profile;
