import API from '../../services/APIService.js';
import { createUser as apiCreateUser } from '../../services/APIService.js';

export default {
  state: () => ({
    users: [],
  }),

  mutations: {
    //synchronous, state-only
    ADD_USER(state, user) {
      state.users.push(user);
    },
  },

  actions: {
    //async, side effects allowed
    async createUser({ commit }, payload) {
        console.log('Creating user with payload:', payload);
      try {
        const res = await apiCreateUser(payload)

        commit('ADD_USER', res.data);
      } catch (err) {
        console.error('Error creating user:', err);
        throw err;
      }
    },
  },
};