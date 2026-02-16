import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

//import views vv
import HelloWorld from '../components/HelloWorld.vue'
import Home from '../views/HomeView.vue'
import User from '../views/UserView.vue'





//routes
const routes = [
    {
        path: '/',
        name: 'home',
        component: Home,
        meta:{
            requiresAuth: false
        }
    },
    
    {
        path: '/user',
        name: 'user',
        component: User,
        meta:{
            requiresAuth: true
        }
    },
    {
        path: '/register',
        name: 'register',
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