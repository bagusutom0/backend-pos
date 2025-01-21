import useSWR from 'swr';
import fetcher from '../fetcher';

const useCategory = () => {
  const { data, error, mutate } = useSWR('/category/all', fetcher, {
    fallbackData: [],
  });

  return {
    categories: data,
    isLoading: !data && !error,
    error: error,
    mutate,
  };
};

export default useCategory;
