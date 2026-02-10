<script setup>
import { useStore } from 'vuex';
import { reactive } from 'vue';
import { useRouter } from 'vue-router';
const store = useStore();
const router = useRouter();

const form = reactive({
  username: '',
  password: '',
});

const login = async () => {
  try{
    await store.dispatch('login', form);
    router.push('/user');
  } catch (err){
    console.log(err);
    alert('Cannot login');
  }
};
</script>

<template>
   
   <div class=" flex justify-center">
    <form @submit.prevent="login">
        <label for="username" class="block text-sm font-medium text-gray-200">Username</label>
        <input type="text" id="username" name="username" v-model="form.username" placeholder="Username" class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm">
        <p>III</p>
        <label for="password" class="block text-sm font-medium text-gray-200 mt-4" >Password</label>
        <input type="password" id="password" name="password" v-model="form.password" placeholder="Password" class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm">
        
        <button type="submit" class="mt-4 w-full bg-blue-600 text-white py-2 px-4 rounded-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2">Login</button>
    </form>
   </div>
    
</template>
<style scoped>
</style>