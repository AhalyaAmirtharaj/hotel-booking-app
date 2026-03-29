import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api';

export const registerUser = (data) =>
axios.post(BASE_URL + '/auth/register', data);
export const loginUser = (data) =>
axios.post(BASE_URL + '/auth/login', data);

export const getAllRestaurants = () =>
axios.get(BASE_URL + '/restaurants');
export const searchRestaurants = (cuisine) =>
axios.get(BASE_URL + '/restaurants/search?cuisine=' + cuisine);
export const getMenu = (restaurantId) =>
axios.get(BASE_URL + '/menu/' + restaurantId);

export const placeOrder = (data) =>
axios.post(BASE_URL + '/orders', data);
export const getMyOrders = (userId) =>
axios.get(BASE_URL + '/orders/user/' + userId);
export const cancelOrder = (id) =>
axios.put(BASE_URL + '/orders/' + id + '/cancel');
