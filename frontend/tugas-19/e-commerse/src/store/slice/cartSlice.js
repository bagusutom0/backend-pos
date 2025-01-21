import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  dataCart: [],
};

const cartSlice = createSlice({
  name: 'cart',
  initialState,
  reducers: {
    addItem: (state, action) => {
      const id = action.payload.id;
      const existingItem = state.dataCart.find((item) => item.id === id);

      if (existingItem) {
        state.dataCart.find((item) => {
          if (item.id === id) {
            item.quantity += 1;
            item.price = existingItem.product.price * item.quantity;
          }
        });
      } else {
        state.dataCart.push({
          product: action.payload,
          quantity: 1,
          price: action.payload.price,
        });
      }
    },
    increaseQuantity(state, action) {
      const id = action.payload.id;
      const existingItem = state.dataCart.find((item) => item.id === id);

      if (existingItem) {
        state.dataCart.find((item) => {
          if (item.id === id) {
            item.quantity += 1;
            item.price = item.product.price * item.quantity;
          }
        });
      }
    },
    decreaseQuantity(state, action) {
      const id = action.payload.id;
      const existingItem = state.dataCart.find((item) => item.id === id);

      if (existingItem) {
        state.dataCart.find((item) => {
          if (item.id === id) {
            if (item.quantity - 1 === 0) {
              state.dataCart = state.dataCart.filter((item) => item.id !== id);
            } else {
              item.quantity -= 1;
              item.price = item.product.price * item.quantity;
            }
          }
        });
      }
    },
    deleteItem(state, action) {
      const id = action.payload.id;
      state.dataCart = state.dataCart.filter((item) => item.id !== id);
    },
  },
});

export const { addItem, increaseQuantity, decreaseQuantity, deleteItem } =
  cartSlice.actions;

export default cartSlice.reducer;
