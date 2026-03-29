import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { getAllRestaurants } from '../services/api';
import '../styles/App.css';
export default function RestaurantList() {
const [restaurants, setRestaurants] = useState([]);
const navigate = useNavigate();
// when page loads, fetch all restaurants
useEffect(() => {
getAllRestaurants().then(res => setRestaurants(res.data));
}, []);
return (
<div className='list-container'>
<h2>All Restaurants</h2>
{restaurants.length === 0 && <p>No restaurants found!</p>}
{restaurants.map(r => (
<div key={r.id} className='card'>
<h3>{r.name}</h3>
<p>Cuisine: {r.cuisine}</p>
<p>Location: {r.location}</p>
<p>Rating: {r.rating} stars</p>
<p>Delivery: {r.deliveryTime}</p>
<button className='btn-primary'
onClick={() => navigate('/menu/' + r.id)}>
View Menu
</button>
</div>
))}
</div>
);
}
