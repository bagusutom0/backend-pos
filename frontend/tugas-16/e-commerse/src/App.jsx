import Layout from './layout/Layout';
import Home from './pages/user/Home';
import DetailProduct from './pages/user/DetailProduct';
import { Routes, Route, Navigate } from 'react-router';
import Admin from './pages/admin/Admin';
import AddProduct from './pages/admin/AddProduct';

export default function App() {
  return (
    <Layout>
      <Routes>
        <Route path="/" element={<Navigate to="/home" />} />
        <Route path="/home" element={<Home />} />
        <Route path="/admin" element={<Admin />} />
        <Route path="/admin/product/add" element={<AddProduct />} />
        <Route path="/detail/:id" element={<DetailProduct />} />
      </Routes>
    </Layout>
  );
}
