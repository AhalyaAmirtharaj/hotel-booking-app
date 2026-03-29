import { useEffect, useState } from 'react';
import { getMyOrders, cancelOrder } from '../services/api';
import '../styles/App.css';
export default function MyOrders() {
const [orders, setOrders] = useState([]);
const userId = localStorage.getItem('userId');
const loadOrders = () => {
if (userId) {
getMyOrders(userId).then(res => setOrders(res.data));
}
};
useEffect(() => { loadOrders(); }, []);
const handleCancel = async (orderId) => {
try {
await cancelOrder(orderId);
alert('Order cancelled!');
loadOrders(); // refresh list
} catch (err) {
alert('Cancel failed!');
}
};
return (
<div className='list-container'>
<h2>My Orders</h2>
{orders.length === 0 && <p>No orders yet! Go order some food!</p>}
{orders.map(order => (
<div key={order.id} className='card'>
<h3>{order.restaurant.name}</h3>
<p>Total: Rs.{order.totalAmount}</p>
<p>Deliver to: {order.deliveryAddress}</p>
<p>Status: <strong
style={{color: order.status === 'PLACED' ? 'green' : 'red'}}>
{order.status}
</strong></p>
{order.status === 'PLACED' && (
<button className='btn-danger'
onClick={() => handleCancel(order.id)}>
Cancel Order
</button>
)}
</div>
))}
</div>
);
}