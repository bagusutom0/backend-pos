import Layout from './layout/Layout';
import Home from './pages/user/Home';
import DetailProduct from './pages/user/DetailProduct';
import { Routes, Route, Navigate } from 'react-router';
import Admin from './pages/admin/Admin';
import AddProduct from './pages/admin/AddProduct';
import EditProduct from './pages/admin/EditProduct';
import Cart from './pages/user/Cart';
import Login from './pages/auth/Login';
import GuestRoute from './component/route/GuestRoute';
import PrivateRoute from './component/route/PrivateRoute';

export default function App() {
  return (
    <Layout>
      <Routes>
        <Route element={<GuestRoute />}>
          <Route path="/" element={<Navigate to="/home" />} />
          <Route path="/home" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/detail/:id" element={<DetailProduct />} />
          <Route path="/cart" element={<Cart />} />
        </Route>
        <Route element={<PrivateRoute />}>
          <Route path="/admin" element={<Admin />} />
          <Route path="/admin/product/add" element={<AddProduct />} />
          <Route path="/admin/product/edit/:id" element={<EditProduct />} />
        </Route>
      </Routes>
    </Layout>
  );
}
