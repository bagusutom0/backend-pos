import { useSelector } from 'react-redux';
import { Navigate, Outlet } from 'react-router-dom';

export default function GuestRoute() {
  const isLogin = useSelector((state) => state.auth.token !== '');

  if (isLogin) {
    return <Navigate to="/admin" />;
  }

  return <Outlet />;
}
