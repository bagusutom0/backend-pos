import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  user: {
    email: '',
    name: '',
  },
};

const userSlice = createSlice({
  name: 'user',
  initialState: { ...initialState },
  reducers: {
    setUser(state, action) {
      // lengkapi code disini
      const { name, email } = action.payload;

      if (name && email) {
        // console.log('name', name, '\nemail', email);
        state.user.name = name;
        state.user.email = email;
      }
    },
  },
});

export const { setUser } = userSlice.actions;
export default userSlice.reducer;
