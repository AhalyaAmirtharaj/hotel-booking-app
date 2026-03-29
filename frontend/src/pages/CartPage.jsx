import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { placeOrder } from '../services/api';
import '../styles/App.css';
export default function CartPage() {
const navigate = useNavigate();
// get cart data from localStorage
const cart = JSON.parse(localStorage.getItem('cart') || '[]');
const restaurantId = localStorage.getItem('restaurantId');
const userId = localStorage.getItem('userId');
const userAddress = localStorage.getItem('userAddress');
// calculate total
const total = cart.reduce((sum, item) => sum + (item.price * item.quantity), 0);
const handleOrder = async () => {
if (!userId) {
alert('Please login first!');
navigate('/login');
return;
}
try {
const orderData = {
userId: userId,
restaurantId: restaurantId,
deliveryAddress: userAddress,
items: cart.map(item => ({
menuItemId: item.menuItemId,
quantity: item.quantity
}))
};
await placeOrder(orderData);
localStorage.removeItem('cart'); // clear cart
alert('Order placed successfully!');
navigate('/my-orders');
} catch (err) {
alert('Order failed! ' + err.response?.data?.message);
}
};
return (
<div className='list-container'>
<h2>Your Cart</h2>
{cart.length === 0 && <p>Cart is empty!</p>}
{cart.map((item, i) => (
<div key={i} className='card'>
<p><strong>{item.name}</strong></p>
<p>Quantity: {item.quantity}</p>
<p>Price: Rs.{item.price * item.quantity}</p>
</div>
))}
{cart.length > 0 && (
<div>
<h3>Total: Rs.{total}</h3>
<p>Deliver to: {userAddress}</p>
<button className='btn-primary' onClick={handleOrder}>
Place Order
</button>
</div>
)}
</div>
);
}
