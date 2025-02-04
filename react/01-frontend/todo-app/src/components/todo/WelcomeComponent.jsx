import {Link,useParams} from "react-router-dom";
export default WelcomeComponent;
function WelcomeComponent() {
    const {username} = useParams();
    return(
        <div className="WelcomeComponent">
            <h1>Welcome {username}</h1>
            <div>
                Manage Your Todos <Link to='/todos'>Go Here</Link>
            </div>
        </div>
    )
}