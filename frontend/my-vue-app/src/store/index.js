import { createStore as _createStore } from 'vuex';
import axios from 'axios';
import users from './modules/users.js';

export function createStore(currentToken, currentUser){
    let store = _createStore({
        state: {
            token: currentToken || '',
            user: currentUser || ''
        },

        mutations:{
            SET_AUTH_TOKEN(state, token) {
                state.token = token;
                localStorage.setItem('token', token);
                axios.defaults.header.common['Authorization'] = `Bearer ${token}`; 
            },
            SET_USER(state, user){
                state.user = user;
                localStorage.setItem('user', JSON.stringify(user));
            },
            LOGOUT(state){
                localStorage.removeItem('token');
                localStorage.removeItem('user');
                state.token = '';
                state.user = {};
                axios.defaults.header.common = {};
            }
        },
        modules: {
            users,
        },
    });
    return store;
}