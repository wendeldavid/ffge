import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import SignUp from '../views/SignUp.vue'
import Portal from '../views/Portal.vue'
import Register from '../views/Register.vue'
import firebase from 'firebase'

Vue.use(VueRouter)

const routes = [
  {
    path: '*',
    redirect: '/portal'
  },
  {
    path: '/',
    redirect: '/portal'
  },
  {
    path: '/portal',
    name: 'portal',
    component: Portal
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/logout',
    name: 'Logout',
    component: Logout
  },
  {
    path: '/sign-up',
    name: 'SignUp',
    component: SignUp
  }, 
  {
    path: '/register',
    name: 'Register',
    component: Register,
    meta: {
      requiresAuth: true
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  const currentUser = firebase.auth().currentUser;
  const requiresAuth = to.matched.some(record => record.meta.requiresAuth);

  if (requiresAuth && !currentUser) {
    next('login');
  // } else if (!requiresAuth && currentUser) {
  //   next();
  } else {
    next();
  }

})

export default router
