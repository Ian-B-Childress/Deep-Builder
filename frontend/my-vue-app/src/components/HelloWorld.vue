<script setup>
import { useStore } from 'vuex';
import { reactive } from 'vue';
 
const store = useStore();
const form = reactive({
  username: '',
  password: '',
});

const submit = async () => {
  try{
    await store.dispatch('createUser', form);
    
  } catch (err){
    console.log(err);
    alert('Cannot create user');
  }
};

</script>

<template>

 

  <div class="mx-auto flex items-center m-4">
    <form @submit.prevent="submit" name="createUser" action="submit" class="mx-auto flex items-center gap-2 flex-row">

      <label>Username: </label> <input v-model="form.username" type="text" name="username" class="bg-gray-200 rounded-md px-2 py-1">
      <label>Password: </label> <input v-model="form.password" type="text" name="password" class="bg-gray-200 rounded-md px-2 py-1">

     
      <input type="submit" value="submit" class="bg-green-700 rounded-md px-2 py-0.5">
    </form>
  </div>




</template>
