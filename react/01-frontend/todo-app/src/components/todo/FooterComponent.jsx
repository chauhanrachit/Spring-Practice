import { useAuth } from "./security/AuthContext";

export default FooterComponent;
function FooterComponent() {

    // const authContext = useContext(AuthContext)
    const authContext = useAuth()
    console.log(`Footer Component - ${authContext.number}`)

    return (
        <footer className="footer">
            <div className="container">
                Your Footer
            </div>
        </footer>
    );
}