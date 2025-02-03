import { useState } from "react"
import './TodoApp.css';
import { BrowserRouter, Route, Routes, useNavigate, useParams } from "react-router-dom";

export default function TodoApp() {
    return(
        <div className="TodoApp">
            <BrowserRouter>
                <Routes>
                    <Route path ='/' element={<LoginComponent />} ></Route>
                    <Route path ='/login' element={<LoginComponent />} ></Route>
                    <Route path ='/welcome/:username' element={<WelcomeComponent />} ></Route>
                    <Route path ='*' element={<ErrorComponent />} ></Route>
                </Routes>
            </BrowserRouter>
        </div>
    )
}
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
function WelcomeComponent() {

    // const params = useParams();
    // console.log(params.username);
    const {username} = useParams();
    console.log(username);

    return(
        <div className="WelcomeComponent">
            <h1>Welcome {username}</h1>
            <div>Welcome Component</div>
        </div>
    )
}
function ErrorComponent() {
    return(
        <div className="ErrorComponent">
            <h1>We are working really hard!</h1>
            <div>
                Apologies for the 404. Reach out to our team at ABC-DEF-_GHIJ.
            </div>
        </div>
    )
}