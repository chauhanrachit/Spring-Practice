import React, { useState } from "react";
import { api } from "../services/api";

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [token, setToken] = useState('');

  const handleLogin = async () => {
    try {
      const response = await api.post("/auth/login", { username, password });
      console.log(response);
      setToken(response.data);
    //   localStorage.setItem("token", response.data);
      console.log('username - >'+ username,', password - > '+ password);
      alert("Login Successful!");
    } catch (error) {
        console.log('username - >'+ username,', password - > '+ password);
        setToken('');
        alert("Login Failed!");
    }
  };

  return (
    <div>
      <h2>Login</h2>
      <input type="text" placeholder="Username" onChange={(e) => setUsername(e.target.value)} />
      <input type="password" placeholder="Password" onChange={(e) => setPassword(e.target.value)} />
      <button onClick={handleLogin}>Login</button>
    </div>
  );
}

export default Login;