import axios from 'axios';

const baseUrl = import.meta.env.VITE_BASE_URL;
const token = import.meta.env.VITE_TOKEN;

const fetcher = async (method, path, body) => {
  const url = `${baseUrl}${path}`;
  const config = {
    headers: {
      Authorization: `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
  };

  if (method === 'get') {
    const response = await axios.get(url, config);
    return response.data;
  }

  if (method === 'put') {
    const response = await axios.put(url, body, config);
    return response.data;
  }

  if (method === 'delete') {
    const response = await axios.delete(url, config);
    return response.data;
  }

  const response = await axios.post(url, body, config);
  console.log('response post:', response);
  return response.data;
};

export default fetcher;
