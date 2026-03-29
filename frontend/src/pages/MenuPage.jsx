import { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { getMenu } from '../services/api';
import '../styles/App.css';
export default function MenuPage() {
const { restaurantId } = useParams(); // get restaurantId from URL
const navigate = useNavigate();
const [menuItems, setMenuItems] = useState([]);
const [cart, setCart] = useState([]); // cart is stored in state
useEffect(() => {
getMenu(restaurantId).then(res => setMenuItems(res.data));
}, []);
// add item to cart
const addToCart = (item) => {
const existing = cart.find(c => c.menuItemId === item.id);
if (existing) {
// item already in cart - increase quantity
setCart(cart.map(c =>
c.menuItemId === item.id
? { ...c, quantity: c.quantity + 1 }
: c
));
} else {
// add new item
setCart([...cart, {
menuItemId: item.id,
name: item.name,
price: item.price,
quantity: 1
}]);
}
alert(item.name + ' added to cart!');
};
const goToCart = () => {
// save cart to localStorage before going to cart page
localStorage.setItem('cart', JSON.stringify(cart));
localStorage.setItem('restaurantId', restaurantId);
navigate('/cart');
};
return (
<div className='list-container'>
<h2>Menu</h2>
{menuItems.map(item => (
<div key={item.id} className='card'>
<h3>{item.name}</h3>
<p>{item.description}</p>
<p>Category: {item.category}</p>
<p>Price: Rs.{item.price}</p>
<button className='btn-primary'
onClick={() => addToCart(item)}>
Add to Cart
</button>
</div>
))}
{cart.length > 0 && (
<button className='btn-success' onClick={goToCart}>
Go to Cart ({cart.length} items)
</button>
)}
</div>
);
}