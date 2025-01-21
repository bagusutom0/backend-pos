import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  token: '',
  user: {
    name: '',
    role: '',
  },
};

const authSlice = createSlice({
  name: 'cart',
  initialState,
  reducers: {
    setToken(state, action) {
      const token = action.payload;
      if (token) {
        state.token = token;
        localStorage.setItem('token', token);
      }
    },
    setUser(state, action) {
      const { name, role } = action.payload;
      if (name && role) {
        state.user.name = name;
        state.user.role = role;
        localStorage.setItem('user', JSON.stringify({ name, role }));
      }
    },
    resetAuthData() {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      return { ...initialState };
    },
  },
});

export const { setToken, setUser, resetAuthData } = authSlice.actions;

export default authSlice.reducer;
