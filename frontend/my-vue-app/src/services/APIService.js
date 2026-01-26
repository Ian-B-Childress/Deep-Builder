import axios from 'axios';

const builderAPI = axios.create({
    baseURL: 'http://localhost:9090/api',
    timeout: 5000,
});


export default builderAPI;