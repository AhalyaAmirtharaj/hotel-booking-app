import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { loginUser } from '../services/api';
import '../styles/App.css';
export default function Login() {
const navigate = useNavigate();
const [form, setForm] = useState({ email: '', password: '' });
const handleChange = (e) => {
setForm({ ...form, [e.target.name]: e.target.value });
};
const handleSubmit = async (e) => {
e.preventDefault();
try {
const res = await loginUser(form);
localStorage.setItem('userId', res.data.id);
localStorage.setItem('userName', res.data.name);
localStorage.setItem('userAddress', res.data.address);
alert('Welcome back ' + res.data.name + '!');
navigate('/home');
} catch (err) {
alert('Login failed: ' + err.response?.data?.message);
}
};
return (
<div className='form-container'>
<h2>Login</h2>
<form onSubmit={handleSubmit}>
<input name='email' type='email' placeholder='Email'
value={form.email} onChange={handleChange} required />
<input name='password' type='password' placeholder='Password'
value={form.password} onChange={handleChange} required />
<button type='submit' className='btn-primary'>Login</button>
</form>
<p>No account? <a href='/register'>Register here</a></p>
</div>
);
}