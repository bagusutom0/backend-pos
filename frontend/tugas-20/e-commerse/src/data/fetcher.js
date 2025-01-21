import axiosClient from './axiosClient';

const fetcher = (url) => axiosClient.get(url).then((res) => res.data);

export default fetcher;
