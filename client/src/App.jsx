import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import Navbar from "./common/Navbar";
import Footer from "./common/Footer"; 
import Register from "./pages/Register";
import Login from "./pages/Login";
import TasksPage from "./pages/TasksPage";
import AuthRoute from "./guard/Guard";  
import TaskFormPage from "./pages/TaskFormPage";

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />

        {/* ✅ Protected Routes Using Proper Pattern */}
        <Route path="/tasks" element={
          <AuthRoute>
            <TasksPage />
          </AuthRoute>
        } />
        <Route path="/tasks/add" element={
          <AuthRoute>
            <TaskFormPage />
          </AuthRoute>
        } />
        <Route path="/tasks/edit/:id" element={
          <AuthRoute>
            <TaskFormPage />
          </AuthRoute>
        } />

        {/* Fallback route for unknown pages */}
        <Route path="*" element={<Navigate to="/tasks" />} />
      </Routes>

      <Footer />
    </BrowserRouter>
  );
}

export default App;
