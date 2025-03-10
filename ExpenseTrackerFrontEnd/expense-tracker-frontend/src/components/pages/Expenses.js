import React, { useEffect, useState } from "react";
import { api } from "../services/api";

function Expenses() {
  const [expenses, setExpenses] = useState([]);

  useEffect(() => {
    const fetchExpenses = async () => {
      try {
        const response = await api.get("/expenses", {
          headers: { Authorization: `Bearer ${localStorage.getItem("token")}` },
        });
        setExpenses(response.data);
      } catch (error) {
        alert("Failed to load expenses!");
      }
    };

    fetchExpenses();
  }, []);

  return (
    <div>
      <h2>Expenses</h2>
      <ul>
        {expenses.map((expense) => (
          <li key={expense.id}>{expense.description} - ₹{expense.amount}</li>
        ))}
      </ul>
    </div>
  );
}

export default Expenses;