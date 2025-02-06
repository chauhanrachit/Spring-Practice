import axios from "axios";
import { useState } from "react";
import {Link,useParams} from "react-router-dom";


export default WelcomeComponent;
function WelcomeComponent() {

    const {username} = useParams();

    const [message, setMessage] = useState(null)

    function callHelloWorldRestApi(){
        axios.get('http://localhost:8080/hello-world')
            .then(  (response) => successfulResponse(response)  )
            .catch( (error) => errorResponse(error)  )
            .finally(   () => console.log('cleanup')  )
    }

    function callHelloWorldBean(){
        axios.get('http://localhost:8080/hello-world-bean')
            .then(  (response) => successfulResponse(response)  )
            .catch( (error) => errorResponse(error)  )
            .finally(   () => console.log('cleanup')  )
    }

    function successfulResponse(response){
        //setMessage(response.data)
        console.log(response)
        console.log(response.data)
        console.log(response.data.message)
    }

    function errorResponse(error){
        //setMessage(error)
        console.log(error)
    }

    return(
        <div className="WelcomeComponent">
            <h1>Welcome {username}</h1>
            <div>Manage Your Todos <Link to='/todos'>Go Here</Link></div>
            <div>
                <button className="btn btn-success m-5" onClick={callHelloWorldRestApi}>Call Hello World</button>
            </div>
            <div>
                <button className="btn btn-success m-5" onClick={callHelloWorldBean}>Call Hello World Bean</button>
            </div>
            <div className="text-info">{message}</div>
        </div>
    )
}