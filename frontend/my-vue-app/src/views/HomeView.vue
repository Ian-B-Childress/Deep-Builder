<script setup>
import Login from '../components/Login.vue';
</script>

<template>
    <router-view/>
<div class="flex flex-col pt-16 items-center h-screen bg-gray-900"> 
        <h1 class="text-4xl text-white mb-8 ">Welcome To DeepBuilder!</h1>
        <Login/>
    </div>
</template>

<style scoped> 

</style>