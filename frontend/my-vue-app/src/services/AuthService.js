import axios from "axios";

const http = axios.create({
  baseURL: import.meta.env.VITE_REMOTE_API,
});

http.interceptors.request.use(config => {
  const token = localStorage.getItem('token');
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export { http };

export default {

  login(user) {
    return http.post("/login", user);
  },

  register(user) {
    return http.post("/register", user);
  },

  getUser(user) {
    return http.get("/user");
  },
};
