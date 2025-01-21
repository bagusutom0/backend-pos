import axiosClient from '../axiosClient';

const productApi = {
  create(data) {
    return axiosClient.post('/product/add', data);
  },
  update(id, data) {
    return axiosClient.put(`/product/update/${id}`, data);
  },
  delete(id) {
    return axiosClient.delete(`/product/delete/${id}`);
  },
};

export default productApi;
