<script setup>
import HelloWorld from './components/HelloWorld.vue'
</script>

<template>
  <div class="bg-red-500 text-white p-4 max-w-sm mx-auto">
    <h1 class="text-center">Create a User</h1>
  </div>
  <HelloWorld msg="create a user" />
</template>

<style>
@tailwind base;
@tailwind components;
@tailwind utilities;
</style>