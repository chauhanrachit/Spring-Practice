import React, { useEffect, useState } from "react";
import { apiClient } from "../api/ApiClient";
// import { retriveAllTodosForUsernameApi, deleteTodoApi } from "../api/TodoApiService"
import { retriveAllExpenses } from "../api/ExpenseApiService"
import { useAuth } from "../security/AuthContext"
import { useNavigate } from "react-router-dom";

function ListExpensesComponent() {
  const [expenses, setExpenses] = useState([])
  const [message, setMessage] = useState(null)
  const authContext = useAuth()
  const username = authContext.username
  const navigate = useNavigate()
  useEffect(
    () => { refreshExpenses() }, []
  )
  function refreshExpenses() {
    //retriveAllTodosForUsernameApi(username)
    retriveAllExpenses()
      .then(response => {
        setExpenses(response.data)
      })
      .catch((error) => console.log(error))
  }
  // most probably I will not use delete
  // function deleteExpenses(id) {
  //   console.log(id);
  //   deleteExpensesApi(username, id)
  //     .then(
  //       () => {
  //         setMessage(`Delete of Expense with Id = ${id} is successful`);
  //         refreshTodos()
  //       }
  //       //1. Display success message
  //       //2. Update Todos List
  //     )
  //     .catch((error) => console.log(error))
  // }

  // function updateExpense(id) {
  //   console.log(id);
  //   //navigate(`/todo/${id}`)
  // }
  function addNewExpense() {
    navigate('/expenses/-1')
  }

  // useEffect(() => {
  //   const fetchExpenses = async () => {
  //     try {
  //       const response = await apiClient.get("/expenses", {
  //         headers: { Authorization: `Bearer ${localStorage.getItem("token")}` },
  //       });
  //       setExpenses(response.data);
  //     } catch (error) {
  //       alert("Failed to load expenses!");
  //     }
  //   };

  //   fetchExpenses();
  // }, []);

  return (
    <div className="container">
      <h1>Your Expenses!</h1>
      {/* {message && <div className="alert alert-warning">{message}</div>} */}
      <div>
        <table className="table">
          <thead>
            <tr>
              <th>Title</th>
              <th>Category</th>
              <th>Date</th>
              <th>Amount</th>
              {/* <th>Update</th> */}
            </tr>
          </thead>
          <tbody>
            {
              expenses.map(
                expense => (
                  <tr key={expense.id} >
                    <td>{expense.title}</td>
                    <td>{expense.category}</td>
                    {/* <td>{todo.targetDate.toDateString()}</td> */}
                    <td>{expense.date.toString()}</td>
                    <td>{expense.amount}</td>
                    {/* <td><button className="btn btn-warning"
                      onClick={() => deleteTodo(todo.id)} >Delete</button></td>
                    <td><button className="btn btn-success"
                      onClick={() => updateTodo(todo.id)} >Update</button></td> */}
                  </tr>
                )
              )
            }
          </tbody>
        </table>
      </div>
      <div className="btn btn-success m-5" onClick={addNewExpense}>Add New Expense</div>
    </div>
  )
  // return (
  //   <div>
  //     <h2>Expenses</h2>
  //     <ul>
  //       {expenses.map((expense) => (
  //         <li key={expense.id}>{expense.description} - ₹{expense.amount}</li>
  //       ))}
  //     </ul>
  //   </div>
  // );
}

export default ListExpensesComponent;