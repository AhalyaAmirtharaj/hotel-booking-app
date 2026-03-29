import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Register from './pages/Register';
import Login from './pages/Login';
import Home from './pages/Home';
import RestaurantList from './pages/RestaurantList';
import MenuPage from './pages/MenuPage';
import CartPage from './pages/CartPage';
import MyOrders from './pages/MyOrders';
import './styles/App.css';
export default function App() {
return (
<Router>
<nav>
<Link to='/home'>Home</Link>
<Link to='/restaurants'>Restaurants</Link>
<Link to='/register'>Register</Link>
<Link to='/login'>Login</Link>
<Link to='/my-orders'>My Orders</Link>
</nav>
<Routes>
<Route path='/' element={<Home />} />
<Route path='/home' element={<Home />} />
<Route path='/register' element={<Register />} />
<Route path='/login' element={<Login />} />
<Route path='/restaurants' element={<RestaurantList />} />
<Route path='/menu/:restaurantId' element={<MenuPage />} />
<Route path='/cart' element={<CartPage />} />
<Route path='/my-orders' element={<MyOrders />} />
</Routes>
</Router>
);
}