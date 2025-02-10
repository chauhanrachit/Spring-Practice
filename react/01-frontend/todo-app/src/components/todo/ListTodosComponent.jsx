import { useEffect , useState } from "react"
import { retriveAllTodosForUsernameApi, deleteTodoApi } from "./api/TodoApiService"

export default ListTodosComponent;
function ListTodosComponent() {
    const [todos, setTodos] =  useState([])
    const [message, setMessage] =  useState(null)
    useEffect(
        () => {refreshTodos()},[]
    )
    function refreshTodos(){
        retriveAllTodosForUsernameApi('Rachit')
            .then( response => {
                setTodos(response.data)
            })
            .catch( (error) => console.log(error)  )
    }
    function deleteTodo(id){
        console.log(id);
        deleteTodoApi('Rachit',id)
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
                                    </tr>
                                )
                            )
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}