import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

//import views vv
import HelloWorld from '../components/HelloWorld.vue'




//routes
const routes = [
    {
        path: '/',
        redirect: () => 'login'
    },
    {
        path: '/login',
        name: 'login',
        component: HelloWorld,
        meta:{
            requiresAuth: false
        }
    },

]

//create router
const router = createRouter({
    history: createWebHistory(),
    routes: routes
});
router.beforeEach((to) => {
    //pulls store
    const store = useStore();
    //does it require auth?
    const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
    //if it does AND the user is not logged in, send user to login
    if(requiresAuth && store.state.token === ''){
        return {name: 'login'};
    }
    //otherwise, do nothing
});

export default router;