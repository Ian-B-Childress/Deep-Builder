import axios from 'axios';
import { createUser as apiCreateUser } from '../../services/APIService.js';
import authService from '../../services/AuthService.js';

export default {
  state: () => ({
    users: [],
  }),

  mutations: {
    ADD_USER(state, user) {
      state.users.push(user);
    },
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
    },
    SET_USER(state, user) {
      state.user = user;
    },
  },

  actions: {
    async createUser({ commit }, payload) {
      console.log('Creating user with payload:', payload);
      try {
        const res = await apiCreateUser(payload);
        commit('ADD_USER', res.data);
      } catch (err) {
        console.error('Error creating user:', err);
        throw err;
      }
    },

    async login({ commit }, payload) {
      console.log('Logging in with payload:', payload);
      try {
        const response = await authService.login(payload);

        if (response.status === 200) {
          commit('SET_AUTH_TOKEN', response.data.token);
          commit('SET_USER', response.data.user);
        }
      } catch (err) {
        console.error('Error logging in:', err);
        throw err;
      }
    },
  },
};