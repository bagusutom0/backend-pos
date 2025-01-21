import axios from 'axios';

const baseUrl = import.meta.env.VITE_BASE_URL;

const axiosClient = axios.create({ baseURL: baseUrl });

axios.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('token');
    if (token) {
      console.log('token', token);
      config.headers.Authorization = `Bearer ${token}`;
    }

    return config;
  },
  (error) => {
    Promise.reject(error);
  }
);

export default axiosClient;
