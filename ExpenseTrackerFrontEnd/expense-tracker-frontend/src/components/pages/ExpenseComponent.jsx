import { useNavigate, useParams } from "react-router-dom";
// import { createTodoApi, retrieveTodoApi, updateTodoApi } from "./api/TodoApiService";
import { createExpenseApi,retriveAllExpenses } from "../api/ExpenseApiService";
import { useAuth } from "../security/AuthContext";
import { useEffect, useState } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import moment from "moment";
export default function ExpenseComponent() {
    const { id } = useParams()
    const [title, setTitle] = useState('')
    const [date, setDate] = useState('')
    const [category, setCategory] = useState('')
    const [amount, setAmount] = useState('')
    const authContext = useAuth()
    const username = authContext.username
    const navigate = useNavigate()
    useEffect(
        () => retrieveTodos(), [id]
    )
    function retrieveTodos() {
        if (id != -1) {
            // retrieveTodoApi(username, id)
            retriveAllExpenses()
                .then(response => {
                    setTitle(response.data.title)
                    setDate(response.data.date)
                    setCategory(response.data.category)
                    setAmount(response.data.amount)

                })
                .catch(error => console.log(error))
        }
    }

    function onSubmit(values) {
        const expense = {
            // id: id,
            // username: username,
            title: values.title,
            date: values.date,
            category: values.category,
            amount: values.amount
        }
        if (id == -1) {
            // createExpenseApi(username,todo)
            createExpenseApi(expense)
                .then(response => {
                    console.log(response)
                    navigate('/expenses')
                })
                .catch(error => console.log(error))
        }
        else {
            // updateExpenseApi(username,id,todo)
            //     .then(response => {
            //         console.log(response)
            //         navigate('/todos')
            //     })
            //     .catch(error => console.log(error))
        }
    }

    function validate(values) {
        let errors = {
            // description:'Enter a valid description',
            // targetDate:'Enter a valid target date'
        }
        if (values.title.length < 3) {
            errors.title = 'Enter atleast 3 characters'
        }
        if (values.date == null || values.date == '' || !moment(values.date).isValid) {
            errors.date = 'Enter Date'
        }
        console.log(values)
        return errors
    }

    return (
        <div className="container">
            <h1>Enter Expense Details</h1>
            <div>
                <Formik initialValues={{ title, date, amount, category }}
                    enableReinitialize={true}
                    onSubmit={onSubmit}
                    validate={validate}
                    validateOnChange={false}
                    validateOnBlur={false}
                >
                    {
                        (props) => (
                            <Form>
                                <ErrorMessage
                                    name="title"
                                    component="div"
                                    className="alert alert-warning"
                                />

                                <ErrorMessage
                                    name="date"
                                    component="div"
                                    className="alert alert-warning"
                                />

                                <ErrorMessage
                                    name="category"
                                    component="div"
                                    className="alert alert-warning"
                                />

                                <ErrorMessage
                                    name="amount"
                                    component="div"
                                    className="alert alert-warning"
                                />

                                <fieldset className="form-group">
                                    <label>Title</label>
                                    <Field type="text" className="form-control m-1" name="title" />
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Date</label>
                                    <Field type="date" className="form-control m-1" name="date" />
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Category</label>
                                    <Field type="text" className="form-control m-1" name="category" />
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Amount</label>
                                    <Field type="text" className="form-control m-1" name="amount" />
                                </fieldset>

                                <div>
                                    <button className="btn btn-success m-5" type="submit">Save</button>
                                </div>
                            </Form>
                        )
                    }
                </Formik>
            </div>
        </div>
    )
}