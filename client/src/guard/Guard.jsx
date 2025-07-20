import { Navigate } from "react-router-dom";

const AuthRoute = ({ children }) => {
  const isAuthenticated = localStorage.getItem("token");

  if (!isAuthenticated) {
    return <Navigate to="/login" replace />;
  }

  return children;
};

export default AuthRoute; 
