import { useState } from "react"
import {useNavigate} from "react-router-dom";
export default LoginComponent;
function LoginComponent() {
    const [username,setUsername] =useState('rachit');
    const [password,setPassword] =useState('');
    const [showSuccessMessage,setShowSuccessMessage] =useState(false);
    const [showErrorMessage,setShowErrorMessage] =useState(false);
    const navigate = useNavigate();
    function handleUserNameChange(event){
        setUsername(event.target.value);
    }
    function handlePasswordChange(event){
        setPassword(event.target.value);
    }
    function handleSubmit(){
        if(username==='rachit' && password==='rachit'){
            setShowSuccessMessage(true);
            setShowErrorMessage(false);
            navigate(`/welcome/${username}`);
        }
        else {
            setShowSuccessMessage(false);
            setShowErrorMessage(true);
        }
    }
    return(
        <div className="Login">
            <h1>Login Page</h1>
            {showSuccessMessage && <div className="successMessage">Authenticated Successfully.</div> }
            {showErrorMessage && <div className="errorMessage">Authenticatation Failed. Please ckeck your credentials.</div> }
            <div className="LoginForm">
                <div>
                    <label>User Name</label>
                    <input type="text" name="username" value={username} onChange={handleUserNameChange}/>
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange}/>
                </div>
                <div>
                    <button type="button" name="login" onClick={handleSubmit}>Login</button>
                </div>
            </div>
        </div>
    )
}