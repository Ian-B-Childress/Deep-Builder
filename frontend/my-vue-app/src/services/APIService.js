import axios from 'axios';

const builderAPI = axios.create({
    baseURL: 'http://localhost:9090/api',
    timeout: 5000,
});


export const getUsers = () => builderAPI.get('/users');

export const createUser = (user) => builderAPI.post('register', user);

export default builderAPI;