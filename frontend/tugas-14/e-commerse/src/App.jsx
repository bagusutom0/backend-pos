import Layout from './layout/Layout';
import Home from './pages/Home';
import DetailProduct from './pages/DetailProduct';
import { Routes, Route, Navigate } from 'react-router';

export default function App() {
  return (
    <Layout>
      <Routes>
        <Route path="/" element={<Navigate to="/home" />} />
        <Route path="/home" element={<Home />} />
        <Route path="/detail/:id" element={<DetailProduct />} />
      </Routes>
    </Layout>
  );
}
