import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { registerUser } from '../services/api';
import '../styles/App.css';
export default function Register() {
const navigate = useNavigate();
// stores what user types in the form
const [form, setForm] = useState({
name: '', email: '', password: '', phone: '', address: ''
});
// called every time user types in any input
const handleChange = (e) => {
setForm({ ...form, [e.target.name]: e.target.value });
};
// called when user clicks Register button
const handleSubmit = async (e) => {
e.preventDefault();
try {
const res = await registerUser(form);
// save userId to browser so we can use it later
localStorage.setItem('userId', res.data.id);
localStorage.setItem('userName', res.data.name);
localStorage.setItem('userAddress', res.data.address);
alert('Welcome ' + res.data.name + '! Account created!');
navigate('/home');
} catch (err) {
alert('Error: ' + err.response?.data?.message);
}
};
return (
<div className='form-container'>
<h2>Create Account</h2>
<form onSubmit={handleSubmit}>
<input name='name' placeholder='Your Name'
value={form.name} onChange={handleChange} required />
<input name='email' type='email' placeholder='Email'
value={form.email} onChange={handleChange} required />
<input name='password' type='password' placeholder='Password'/>
value={form.password} onChange={handleChange} required 
<input name='phone' placeholder='Phone Number'
value={form.phone} onChange={handleChange} required />
<input name='address' placeholder='Delivery Address'
value={form.address} onChange={handleChange} required />
<button type='submit' className='btn-primary'>Register</button>
</form>
<p>Already have account? <a href='/login'>Login here</a></p>
</div>
);
}
