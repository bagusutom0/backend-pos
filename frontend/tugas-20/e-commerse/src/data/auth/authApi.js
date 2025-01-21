import axiosClient from '../axiosClient';

const authApi = {
  authenticate(data) {
    return axiosClient.post('/auth/authenticate', data);
  },
};

export default authApi;
