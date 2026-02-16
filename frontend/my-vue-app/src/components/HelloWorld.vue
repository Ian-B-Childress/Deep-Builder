<!-- TODO REFACTOR THIS TO CREATEUSER-VIEW -->

<script setup>
import { useStore } from 'vuex';
import { reactive } from 'vue';
import { useRouter } from 'vue-router';
const router = useRouter();
 
const store = useStore();
const form = reactive({
  username: '',
  password: '',
});

const error = reactive({
  show: false,
  message: 'Username is taken',
});

const submit = async () => {
  try{
    await store.dispatch('createUser', form);
    
  } catch (err){
    console.log(err);
    if(err.response?.status === 409){
      error.show = true;
      return;
    }
    alert('Cannot create user');
  }
};

</script>

<template>

 <router-view/>

 <div class="bg-red-500 text-white p-4 max-w-sm mx-auto">
    <h1 class="text-center">Create a User</h1>
  </div>
  
  <div class="mx-auto flex items-center m-4">
    <form @submit.prevent="submit" name="createUser" action="submit" class="mx-auto flex items-center gap-2 flex-row">

      <label>Username: </label> <input v-model="form.username" type="text" name="username" class="bg-gray-200 rounded-md px-2 py-1">
      <label>Password: </label> <input v-model="form.password" type="text" name="password" class="bg-gray-200 rounded-md px-2 py-1">

     
      <input type="submit" value="submit" class="bg-green-700 rounded-md px-2 py-0.5">
      <button type="button" @click="router.push('/')" class="bg-gray-600 rounded-md px-2 py-0.5 text-white">Login</button>

      <p v-if="error.show" class="text-red-500">Sorry, {{ error.message }}</p>
    </form>
  </div>




</template>
