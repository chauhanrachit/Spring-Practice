import './ExpenseTracker.css';
import {BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from '../pages/Login';
import Expenses from '../pages/Expenses';

function ExpenseTracker() {
  return(
    <div className="ExpenseTracker">
      <Router>
        <Routes>
          <Route path='/'  element={<Login />} />
          <Route path='/expenses'  element={<Expenses />} />
        </Routes>
      </Router>
    </div>
  )
}

export default ExpenseTracker;