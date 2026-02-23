<script setup>
import { useStore } from 'vuex';
import { reactive } from 'vue';

const user = reactive({
    name: '',
});
const store = useStore();
user.name = store.state.user.username;  
</script>

<template >
    <div class="flex flex-col items-center h-screen bg-gray-900 text-white">
    <div>
        <input type="text" placeholder="Search User" class=" bg-gray-800 rounded-md px-2 py-1 m-4">
        <button class="bg-blue-600 rounded-md px-2 py-0.5">Search</button>      
    </div>

    <div class="flex flex-col items-center p-4 ">
        <h1 class="">Hi, {{ user.name }}</h1>
         <p class="text-gray-400">This is your dashboard, where you can manage your builds and settings.</p>
    </div>

    <div class="flex-3 flex flex-auto gap-4 p-4 w-full">
        <div class="flex-1 bg-gray-800 rounded-md p-4">
            <h2 class="text-xl mb-2">Your Builds</h2>
            <p class="text-gray-400">You have no builds yet. Start creating your first build!</p>
        </div>

        <div class="flex-1 bg-gray-800 rounded-md p-4">
            <h2 class="text-xl mb-2">Liked Builds</h2>
            <p class="text-gray-400">Manage your liked builds here.</p>
            </div>
    </div>
</div>

</template>


<style scoped></style>