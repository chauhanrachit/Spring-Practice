import { useEffect , useState } from "react"
import { retriveAllTodosForUsernameApi, deleteTodoApi } from "./api/TodoApiService"
import {useAuth} from "./security/AuthContext"
import {useNavigate} from "react-router-dom";

export default ListTodosComponent;
function ListTodosComponent() {
    const [todos, setTodos] =  useState([])
    const [message, setMessage] =  useState(null)
    const authContext = useAuth()
    const username = authContext.username
    const navigate = useNavigate()
    useEffect(
        () => {refreshTodos()},[]
    )
    function refreshTodos(){
        retriveAllTodosForUsernameApi(username)
            .then( response => {
                setTodos(response.data)
            })
            .catch( (error) => console.log(error)  )
    }
    function deleteTodo(id){
        console.log(id);
        deleteTodoApi(username,id)
            .then(
                () => {
                    setMessage(`Delete of Todo with Id = ${id} is successful`);
                    refreshTodos()
                }
                //1. Display success message
                //2. Update Todos List
            )
            .catch( (error) => console.log(error)  )
    }
    function updateTodo(id){
        console.log(id);
        navigate(`/todo/${id}`)
    }
    function addNewTodo(){
        navigate('/todo/-1')
    }
    return(
        <div className="container">
            <h1>Things you want to Do!</h1>
            {message && <div className="alert alert-warning">{message}</div>}
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <th>Description</th>
                            <th>Is Done ?</th>
                            <th>Target Date</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        { 
                            todos.map(
                                todo => (
                                    <tr key = {todo.id} >
                                        <td>{todo.description}</td>
                                        <td>{todo.done.toString()}</td>
                                        {/* <td>{todo.targetDate.toDateString()}</td> */}
                                        <td>{todo.targetDate.toString()}</td>
                                        <td><button className="btn btn-warning" 
                                                onClick ={() => deleteTodo(todo.id)} >Delete</button></td>
                                        <td><button className="btn btn-success" 
                                                onClick ={() => updateTodo(todo.id)} >Update</button></td>
                                    </tr>
                                )
                            )
                        }
                    </tbody>
                </table>
            </div>
            <div className="btn btn-success m-5" onClick={addNewTodo}>Add New Todo</div>
        </div>
    )
}