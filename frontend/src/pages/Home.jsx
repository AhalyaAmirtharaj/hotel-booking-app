import { useNavigate } from 'react-router-dom';
import '../styles/App.css';
export default function Home() {
const navigate = useNavigate();
const userName = localStorage.getItem('userName');
return (
<div className='home-container'>
<h1>Food Delivery App</h1>
{userName && <p>Welcome, {userName}!</p>}
<h3>What are you craving today?</h3>
<button className='btn-primary'
onClick={() => navigate('/restaurants')}>
Browse Restaurants
</button>
</div>
);
}