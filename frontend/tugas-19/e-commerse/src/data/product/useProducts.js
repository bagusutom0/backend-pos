import useSWR from 'swr';
import fetcher from '../fetcher';

const useProducts = (id = null) => {
  if (id === null) {
    const { data, error, mutate } = useSWR('/product/all', fetcher, {
      fallbackData: [],
    });

    return {
      products: data,
      isLoading: !data && !error,
      error: error,
      mutate,
    };
  } else {
    const { data, error, mutate } = useSWR(`/product/${id}`, fetcher, {
      fallbackData: { image: [], review: [], colour: [], size: [], length: [] },
    });

    return {
      product: data,
      isLoading: !data && !error,
      error: error,
      mutate,
    };
  }
};

export default useProducts;
