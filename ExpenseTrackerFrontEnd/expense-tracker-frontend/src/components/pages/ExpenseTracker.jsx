import './ExpenseTracker.css';
import LoginComponent from './LoginComponent';
import LogoutComponent from './LogoutComponent';
import WelcomeComponent from './WelcomeComponent';
import ExpensesComponent from './ExpenseComponent';
import ErrorComponent from './ErrorComponent';
import AuthProvider, { useAuth } from '../security/AuthContext';
import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import ListExpensesComponent from './ListExpensesComponent';

export default function ExpenseTracker() {

  function AuthenticatedRoute({ children }) {
    const authContext = useAuth()
    if (authContext.isAuthenticated)
      return children

    return <Navigate to="/" />
  }

  return (
    <div className="ExpenseTracker">
      <AuthProvider>
        <BrowserRouter>
          <Routes>
            <Route path='/' element={<LoginComponent />} />
            <Route path='/login' element={<LoginComponent />} />
            <Route path='/welcome/:username' element={
              <AuthenticatedRoute>
                <WelcomeComponent />
              </AuthenticatedRoute>} />

            <Route path='/expenses' element={<ListExpensesComponent />} />
            <Route path='/expenses/:id' element={
              <AuthenticatedRoute>
                <ExpensesComponent />
              </AuthenticatedRoute>} />

            <Route path='/logout' element={
              <AuthenticatedRoute>
                <LogoutComponent />
              </AuthenticatedRoute>} />

            <Route path='*' element={<ErrorComponent />} />
          </Routes>
        </BrowserRouter>
      </AuthProvider>
    </div>
  )
}

